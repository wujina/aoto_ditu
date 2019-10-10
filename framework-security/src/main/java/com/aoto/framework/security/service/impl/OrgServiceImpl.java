/*
 * 版权信息：Copyright (c) 2009, Aoto. All rights reserved.
 * 文件编号：
 * 文件名称：
 * 系统编号：
 * 系统名称：
 * 模块编号：
 * 模块名称：
 * 作          者：
 * 完成日期：
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.aoto.framework.commons.constant.DBTypeEnum;
import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.constant.BeanProperty.Bean;
import com.aoto.framework.commons.constant.BeanProperty.Cache;
import com.aoto.framework.commons.constant.BeanProperty.Menu;
import com.aoto.framework.commons.constant.BeanProperty.Org;
import com.aoto.framework.commons.lang.StringUtils4Aoto;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.commons.util.ExcelUtils;
import com.aoto.framework.exception.ApplicationException;
import com.aoto.framework.security.models.OrgExportModel;
import com.aoto.framework.security.models.OrgModel;
import com.aoto.framework.security.persistence.inf.OrgMapper;
import com.aoto.framework.security.service.inf.OrgService;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
@Service
public class OrgServiceImpl implements OrgService
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OrgServiceImpl.class);
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Value("${file.root}")
    protected String fileRoot;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private @Value("${db.type}") String dbType;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    protected static final long MAXSIZE = 62914560;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected OrgMapper orgMapper;
    
    @SuppressWarnings("unchecked")
    @Override
    public void getChild(List<Map<String, Object>> list, List<OrgExportModel> resList)
    {
        OrgExportModel orgExportModel = null;
        for (Map<String, Object> map : list) {
            orgExportModel = new OrgExportModel();
            orgExportModel.setOrgCode(map.get("orgCode")==null ? "":(String)map.get("orgCode"));
            orgExportModel.setOrgName(map.get("orgName")==null ? "":(String)map.get("orgName"));
            orgExportModel.setParentOrgCode(map.get("pOrgCode")==null ? "":(String)map.get("pOrgCode"));
            orgExportModel.setAddress(map.get("address")==null ? "":(String)map.get("address"));
            orgExportModel.setTel(map.get("tel")==null ? "":(String)map.get("tel"));
            resList.add(orgExportModel);
            
            List<Map<String, Object>> childList = (List<Map<String, Object>>) map.get("children");
            if (childList != null && childList.size() > 0) {
                getChild(childList, resList);
            }
        }
    }
    
    @Override
    @CacheEvict(value = Cache.ORG_CACHE, allEntries = true)
    @Transactional
    public String importOrg(MultipartFile file) throws IOException
    {
        String errorCode = "";
        
        if (file != null)
        {
            long fileSize = file.getSize();
            String ext = FilenameUtils.getExtension(StringUtils4Aoto.trim(file.getOriginalFilename()));
            
            // 最大60M
            if (fileSize > MAXSIZE)
            {
                errorCode = "overSize";
            }
            else if (!"xls".equals(ext) && !"xlsx".equals(ext))
            {
                errorCode = "传入附件类型错误";
            }
            else if (file.isEmpty())
            {
                errorCode =  "传入附件为空";
            }
        }
        else
        {
            errorCode = "未传入附件";
        }
        
        if (!StringUtils4Aoto.isEmpty(errorCode))
        {
            return errorCode;
        }
        
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Date now = new Date();
        String date = DateFormatUtils.format(now, "yyyyMMddHHmmss");
        String path = FilenameUtils.concat(fileRoot, "excel");
        path = FilenameUtils.concat(path, "import");
        path = FilenameUtils.concat(path, "orgs" + date + ".xls");
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(path));
        
        /*
         *  上传excel文件,并读取excel 存放到指定的 tmpList中
         */
        List<List<? extends Object>> tmpList = new ArrayList<List<? extends Object>>();
        String[] headers = { "机构代码", "机构名称", "父机构代码", "地址", "联系电话", "备注" };
        errorCode = ExcelUtils.importExcel(tmpList, headers, path);
        
        if (!StringUtils4Aoto.isEmpty(errorCode))
        {
            return errorCode;
        }
        
        /*
         * 取到根节点code
         */
        String rootOrgCode = "";
        Map<String, Object> rootOrg = orgMapper.selectRootOrg();
        if (rootOrg != null) {
            rootOrgCode = StringUtils4Aoto.trim((String) rootOrg.get(Org.ORG_CODE));
        }
        
        /*
         * 较验  tmpList 并组装成指定格式的list
         */
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Set<String> orgCodeSet = new HashSet<String>();
        Set<String> orgNameSet = new HashSet<String>();
        int parentCodeCount = 0;
        int count=0;
        for (List<? extends Object> rowList : tmpList) {
            count++;
            Map<String, Object> orgMap = new HashMap<String, Object>();
            
            String orgCode = (String) rowList.get(0);
            if ("".equals(orgCode)) {   
                return "第"+(count+1)+"行"+headers[0]+"未填写";                
            }        
            if (orgCodeSet.contains(orgCode)) {
                return "第"+(count+1)+"行"+headers[0]+"存在重复";    
            }
            orgCodeSet.add(orgCode);
            orgMap.put(Org.ORG_CODE, orgCode);
            
            //机构名称 
            String orgName = (String) rowList.get(1);          
            if ("".equals(orgName)) {      
                return "第"+(count+1)+"行"+headers[1]+"未填写";  
            }   
            if (orgNameSet.contains(orgName)) {
                return "第"+(count+1)+"行"+headers[1]+"存在重复";    
            }
            orgNameSet.add(orgName);
            orgMap.put(Org.ORG_NAME, orgName);
            //父机构代码     只能有一个根节点  即只能有一个没有父节点的
            String parentOrgCode = (String) rowList.get(2);      
            if ("".equals(parentOrgCode)) {      
                parentCodeCount++;
                
                if (!"".equals(rootOrgCode) && !rootOrgCode.equals(orgCode)) {
                    return "第"+(count+1)+"行总机构已存在";  
                }
                if (parentCodeCount > 1) {
                    return "第"+(count+1)+"行"+headers[2]+"未填写,只能有一个总机构";  
                }
            }   
            orgMap.put(Org.PARENT_CODE, parentOrgCode);
            //地址                  
            String address = (String)rowList.get(NumberEnum.NUMBER_3.getNum());
            orgMap.put(Org.ADDRESS, address);
            //联系电话              
            String tel = (String)rowList.get(NumberEnum.NUMBER_4.getNum());
            orgMap.put(Org.TEL, tel);
            //备注              
            String remark = (String)rowList.get(NumberEnum.NUMBER_5.getNum());
            orgMap.put(Org.REMARK, remark);
            list.add(orgMap);    
        }
        
        
        /*
         *  根据list 更新数据库
         */
        //Boolean flagBoolean = true; 
        Map<String, Object> org = null;
        Map<String, Object> pOrg = null;
        if (list != null && list.size() > 0) {
            count=0;
            for (Map<String, Object> orgMap : list) {
                count++;
                //机构
                org = orgMapper.selectOrgByOrgCode(StringUtils4Aoto.trim((String) orgMap.get(Org.ORG_CODE)));
                //父机构
                pOrg = null;
                if (!StringUtils4Aoto.isEmpty((String)orgMap.get(Org.PARENT_CODE))) {
                    pOrg = orgMapper.selectOrgByOrgCode(StringUtils4Aoto.trim((String) orgMap.get(Org.PARENT_CODE)));
                    if (pOrg == null){
                        throw new ApplicationException("第"+(count+1)+"行"+headers[2]+"不存在");
                        //return "第"+(count+1)+"行"+headers[2]+"不存在 "; 
                    }
                }
                
                if (org == null) {
                    //insert
                    if (pOrg == null) {
                        
                        orgMap.put(Org.INHERITED_ID, "");
                        orgMap.put(Org.PARENT_INHERITED_ID, "");
                        orgMap.put(Org.INHERITED_NAME, orgMap.get(Org.ORG_NAME));
                        
                        orgMap.put(Org.LEVEL_NUM, 1);
                        orgMap.put(Org.SORT_NUM, 1);
                        orgMap.put(Org.PARENT_ID, 0);
                    }
                    else {
                        //orgModel.setInheritedId(pOrg.getInheritedId());
                        orgMap.put(Org.PARENT_INHERITED_ID, pOrg.get(Org.INHERITED_ID));
                        orgMap.put(Org.INHERITED_NAME, pOrg.get(Org.INHERITED_NAME) + "/" + orgMap.get(Org.ORG_NAME));
                        orgMap.put(Org.LEVEL_NUM, (Integer)pOrg.get(Org.LEVEL_NUM) + 1);
                        
                        //取父节点的子节点的最大排序号+1
                        Integer maxSortNum = orgMapper.selectMaxSortNumByParentId((Integer) pOrg.get(Org.ORG_ID));
                        maxSortNum = maxSortNum==null ? 0:maxSortNum;
                        orgMap.put(Org.SORT_NUM, maxSortNum + 1);
                        orgMap.put(Org.PARENT_ID, pOrg.get(Org.ORG_ID));
                    }
                    
                    orgMap.remove(Org.ORG_ID);
                    orgMap.put(Org.PRIMARY_KEY, 0);
                    orgMap.put(Bean.DELETED, false);
                    orgMap.put(Bean.CREATED_BY, currentUserId);
                    orgMap.put(Bean.CREATED_DATE, now);
                    orgMap.put(Bean.LAST_UPDATED_BY, currentUserId);
                    orgMap.put(Bean.LAST_UPDATED_DATE, now);
                    
                    orgMapper.insertOrg(orgMap);
                    
                }
                else {
                    /*
                    //update  excel中记录存在父节点    并且   子节点与父节点的
                    if((pOrg!=null&&org.get(Org.PARENT_ID)!=pOrg.get(Org.ORG_ID))){
                        flagBoolean = false;
                    }
                    
                    
                    //更新本节点内容
                    org.put(Org.ADDRESS, orgMap.get(Org.ADDRESS));
                    org.put(Org.ORG_NAME, orgMap.get(Org.ORG_NAME));
                    if(pOrg!=null){
                        org.put(Org.INHERITED_NAME, pOrg.get(Org.INHERITED_NAME)+"/"+org.get(Org.ORG_NAME));
                        org.put(Org.PARENT_ID, (Integer)pOrg.get(Org.ORG_ID));
                        org.put(Org.INHERITED_ID, pOrg.get(Org.INHERITED_ID)+"/"+org.get(Org.ORG_ID));
                    }else{
                        org.put(Org.INHERITED_NAME, org.get(Org.ORG_NAME));
                        org.put(Org.PARENT_ID, new Integer(0));
                        org.put(Org.INHERITED_ID, org.get(Org.ORG_ID));
                    }
                    
                    org.put(Bean.LAST_UPDATED_BY, CurrentUserHolder.getCurrentUser().getUserId());
                    org.put(Bean.LAST_UPDATED_DATE, now);
                    orgMapper.updateOrg(org);
                    
                    if(!flagBoolean){
                        //org.put(Org.PRIMARY_KEY, (Integer)org.get(Org.ORG_ID));
                        orgMapper.updateOrgParent(org);
                    }
                    */
                    
                    
                    String oldInheritedIdString = (String)org.get(Org.INHERITED_ID);
                    /*if (pOrg != null && org.get(Org.PARENT_ID) != pOrg.get(Org.ORG_ID)) {
                        flagBoolean = true;
                    }*/
                    
                    //更新本节点内容
                    //org.put(Org.PRIMARY_KEY, (Integer)org.get(Org.ORG_ID));
                    org.put(Org.ORG_ID, (Integer)org.get(Org.ORG_ID));
                    org.put(Org.ADDRESS, orgMap.get(Org.ADDRESS));
                    org.put(Org.TEL, orgMap.get(Org.TEL));
                    org.put(Org.ORG_NAME, orgMap.get(Org.ORG_NAME));
                    if (pOrg != null) {
                        org.put(Org.INHERITED_NAME, pOrg.get(Org.INHERITED_NAME)+"/"+org.get(Org.ORG_NAME));
                        org.put(Org.PARENT_ID, (Integer)pOrg.get(Org.ORG_ID));
                        org.put(Org.INHERITED_ID, pOrg.get(Org.INHERITED_ID)+"/"+org.get(Org.ORG_ID));
                    }
                    else {
                        org.put(Org.INHERITED_NAME, org.get(Org.ORG_NAME));
                        org.put(Org.PARENT_ID, new Integer(0));
                        org.put(Org.INHERITED_ID, org.get(Org.ORG_ID).toString());
                    }
                    
                    org.put(Bean.LAST_UPDATED_BY, CurrentUserHolder.getCurrentUser().getUserId());
                    org.put(Bean.LAST_UPDATED_DATE, now);
                    orgMapper.updateOrg4Import(org);
                    //update 子节点
                    if (!oldInheritedIdString.equals((String)org.get(Org.INHERITED_ID))) {
                        List<Map<String, Object>> l = orgMapper.selectOrgsByParentId((Integer)org.get(Org.ORG_ID));
                        updateChildren(l, org, currentUserId, now);
                    }
                }
                
            }
        }
        return null;   
        
    }


    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param model OrgModel
     * @return String
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    @CacheEvict(value = Cache.ORG_CACHE, allEntries = true)
    public String createOrg(OrgModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_8.getNum());
        String errorCode = validateOrg(model, map);
        
        if (!StringUtils4Aoto.isEmpty(errorCode))
        {
            return errorCode;
        }

        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Date now = new Date();
        
        map.put(Org.PARENT_INHERITED_ID, StringUtils4Aoto.trim(model.getParentInheritedId()));
        map.put(Org.INHERITED_NAME, StringUtils4Aoto.trim(model.getInheritedName()));
        map.put(Org.LEVEL_NUM, model.getLevelNum());
        map.put(Bean.DELETED, false);
        map.put(Bean.CREATED_BY, currentUserId);
        map.put(Bean.CREATED_DATE, now);
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);
        
        orgMapper.insertOrg(map);
        
        int dbTypeInteger = DBTypeEnum.ORACLE.getCode();
        try {
            dbTypeInteger = Integer.parseInt(dbType);
        }
        catch (NumberFormatException e) {
            LOGGER.error("paramters.properties文件中配置的db.type为非整型，请修改！", e);
        }
        
        if (dbTypeInteger == DBTypeEnum.MYSQL.getCode()) {
            orgMapper.updateOrgInheritedId(map);
        }

        return null;
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param model OrgModel
     * @return [返回类型说明]
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    @CacheEvict(value = Cache.ORG_CACHE, allEntries = true)
    public String editOrg(OrgModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_8.getNum());
        String errorCode = validateOrg(model, map);
        
        if (!StringUtils4Aoto.isEmpty(errorCode))
        {
            return errorCode;
        }
        
        map.put(Org.INHERITED_NAME, StringUtils4Aoto.trim(model.getInheritedName()));
        map.put(Bean.LAST_UPDATED_BY, CurrentUserHolder.getCurrentUser().getUserId());
        map.put(Bean.LAST_UPDATED_DATE, new Date());
        orgMapper.updateOrg(map);

        return null;
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param orgId int
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    @CacheEvict(value = Cache.ORG_CACHE, allEntries = true)
    public void removeOrg(int orgId)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());

        map.put(Org.PRIMARY_KEY, orgId);
        map.put(Bean.DELETED, true);
        map.put(Bean.LAST_UPDATED_BY, CurrentUserHolder.getCurrentUser().getUserId());
        map.put(Bean.LAST_UPDATED_DATE, new Date());

        orgMapper.deleteOrg(map);
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    @CacheEvict(value = Cache.ORG_CACHE, allEntries = true)
    public void moveOrg(int orgId, int parentId, int parentLevelNum, Map<String, Object> pMap)
    {
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        Date now = new Date();
        // 更新排序号 更新其父节点的所有儿子的排序号 由前端传过来 map <String id,int sortNum>
        List<Map<String, Object>> list = (List<Map<String, Object>>)pMap.get("list");
        for (Map<String, Object> modelMap : list) {
            orgMapper.updateOrgSortNum(modelMap);
        }
         
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        int levelNum = parentLevelNum + 1;
        map.put(Org.PRIMARY_KEY, orgId);
        map.put(Org.ORG_ID, orgId);
        map.put(Org.PARENT_ID, parentId);
        map.put(Org.INHERITED_ID, StringUtils4Aoto.trim((String)pMap.get("inheritedId")));
        map.put(Org.INHERITED_NAME, StringUtils4Aoto.trim((String)pMap.get("inheritedName")));
        map.put(Org.LEVEL_NUM, parentLevelNum);
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);
        map.put(Menu.LEVEL_NUM, levelNum);
        orgMapper.updateOrgParent(map);
         
//         Map<String, Integer> m = new HashMap<String, Integer>(2);
//         m.put("userId", -1);
//         m.put("parentId", orgId);
        List<Map<String, Object>> l = orgMapper.selectOrgsByParentId(orgId);
        updateChildren(l, map, currentUserId, now);
    }
     
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param list List<Map<String, Object>>
     * @param parentOrgMap Map<String, Object>
     * @param currentUserId int
     * @param now Date
     */
    @SuppressWarnings("unchecked")
    private void updateChildren(List<Map<String, Object>> list, Map<String, Object> parentOrgMap, int currentUserId,
            Date now) {
        int levelNum = (Integer)parentOrgMap.get(Org.LEVEL_NUM) + 1;
        int orgId = 0;
        String orgName = "";
        List<Map<String, Object>> children = null;
         
        for (Map<String, Object> m : list)
        {
            if (null != m.get("children"))
            {
                children = (List<Map<String, Object>>)m.get("children");
            }
             
            orgId = (Integer)m.get("id");
            orgName = (String)m.get("text");
             
            m.clear();
            m.put(Org.PRIMARY_KEY, orgId);
            m.put(Org.LEVEL_NUM, levelNum);
            m.put(Org.INHERITED_ID, StringUtils4Aoto.trim((String)parentOrgMap.get("inheritedId"))+"/"+orgId);
            m.put(Org.INHERITED_NAME, StringUtils4Aoto.trim((String)parentOrgMap.get("inheritedName"))+"/"+orgName);
            m.put(Bean.LAST_UPDATED_BY, currentUserId);
            m.put(Bean.LAST_UPDATED_DATE, now);
             
            // 更新所有子节点   层次,inheritedId,inheritedName
            orgMapper.updateOrgLevel(m);
             
            if (null != children && children.size() > 0)
            {
                updateChildren(children, m, currentUserId, now);
            }
        }
    }
    
    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param orgId int
     * @return List<Map<String, Object>>
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    @Cacheable(value = Cache.ORG_CACHE, key = "#root.targetClass + #root.methodName + #orgId")
    public List<Map<String, Object>> getOrgs(int orgId)
    {
        Map<String, Object> map = orgMapper.selectOrgsForTree(orgId);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(1);
        list.add(map);
        
        return list;
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model OrgModel
     * @param map Map<String, Object>
     * @return String
     */
    private String validateOrg(OrgModel model, Map<String, Object> map)
    {
        map.put(Org.ORG_ID, model.getOrgId());
        map.put(Org.ORG_NAME, StringUtils4Aoto.trim(model.getOrgName()));
        map.put(Org.PARENT_ID, model.getParentId());
        map.put(Org.ORG_CODE, StringUtils4Aoto.trim(model.getOrgCode()));

        int count = orgMapper.selectCountByOrgNameAndParentId(map);

        if (count > 0)
        {
            return "org.validation.message5";
        }
        
        count = orgMapper.selectCount2ByOrgNameAndParentId(map);
        if (count > 0)
        {
            return "org.validation.message8";
        }
        
        map.remove(Org.ORG_ID);
        map.put(Org.PRIMARY_KEY, model.getOrgId());
        map.put(Org.SORT_NUM, model.getSortNum());
        map.put(Org.ADDRESS, StringUtils4Aoto.trim(model.getAddress()));
        map.put(Org.TEL, StringUtils4Aoto.trim(model.getTel()));
        map.put(Org.REMARK, StringUtils4Aoto.trim(model.getRemark()));
 
        return null;
    }
    
    @Override
    public List<Map<String, Object>> getOrgs()
    {
        return orgMapper.selectOrgs4Export();
    }
    
    
    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param orgId int
     * @return List<Map<String, Object>>
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public List<Map<String, Object>> getOrgs4Export(int orgId)
    {
        Map<String, Object> map = orgMapper.selectOrgsForTree4Export(orgId);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(1);
        list.add(map);
        
        return list;
    }
    
    @Override
    public String exportOrg()
    {
        int orgId = CurrentUserHolder.getCurrentUser().getOrgId();
        List<Map<String, Object>> list = getOrgs4Export(orgId);
        List<OrgExportModel> resList = new ArrayList<OrgExportModel>();
        getChild(list, resList);

        String[] headers = { "机构代码", "机构名称", "父机构代码", "地址", "联系电话", "备注"};
        String date = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss");
        String path = FilenameUtils.concat(fileRoot, "excel");
        path = FilenameUtils.concat(path, "export");
        path = FilenameUtils.concat(path, "orgs" + date + ".xls");
        
        File file = new File(path);
        
        if (!file.getParentFile().exists())
        {
            file.getParentFile().mkdirs();
        }

        ExcelUtils.exportExcel("组织机构", headers, resList, path);
        return path;
    }
    
    @Override
    public Map<String, Object> getOrgByCode(String code)
    {
        return orgMapper.selectOrgByOrgCode(code);
    }
    
    /**
     * 〈一句话功能简述〉
     * 
     * @author hongxz
     * @param orgId int  机构id
     * @return List<Map<String, Object>>
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    //@Cacheable(value = Cache.ORG_CACHE, key = "#root.targetClass + #root.methodName + #orgId")
    public List<Map<String, Object>> getOrgsForZtree(int orgId)
    {
        List<Map<String, Object>> list = orgMapper.selectOrgsForZtree(orgId);
        return list;
    }
}
