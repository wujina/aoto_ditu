package com.aoto.framework.security.service.inf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.aoto.framework.security.models.OrgExportModel;
import com.aoto.framework.security.models.OrgModel;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public interface OrgService
{   
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model OrgModel
     * @return String
     */
    String createOrg(OrgModel model);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model OrgModel
     * @return String
     */
    String editOrg(OrgModel model);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param orgId int
     */
    void removeOrg(int orgId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param orgId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getOrgs(int orgId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getOrgs();

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return String
     */
    String exportOrg();

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param file MultipartFile
     * @return String
     * @throws IOException IOException
     */
    String importOrg(MultipartFile file) throws IOException;

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param list List<Map<String, Object>>
     * @param resList List<OrgExportModel>
     */
    void getChild(List<Map<String, Object>> list, List<OrgExportModel> resList);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param orgId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getOrgs4Export(int orgId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param code String
     * @return Map<String, Object>
     */
    Map<String, Object> getOrgByCode(String code);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param orgId int
     * @param parentId int
     * @param parentLevelNum int
     * @param pMap Map<String,Object>
     */
    void moveOrg(int orgId, int parentId, int parentLevelNum, Map<String, Object> pMap);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author hongxz
     * @param orgId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getOrgsForZtree(int orgId);
}
