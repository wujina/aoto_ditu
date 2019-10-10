package com.aoto.framework.security.persistence.inf;

import java.util.List;
import java.util.Map;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public interface OrgMapper
{
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void insertOrg(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateOrgInheritedId(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateOrg(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateOrgParent(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void deleteOrg(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param orgId int
     * @return Map<String, Object>
     */
    Map<String, Object> selectOrgsForTree(int orgId);
 
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return int
     */
    int selectCountByOrgNameAndParentId(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return int
     */
    int selectCount2ByOrgNameAndParentId(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectOrgs4Export();

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param string String
     * @return Map<String, Object>
     */
    Map<String, Object> selectOrgByOrgCode(String string);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param orgId int
     * @return Integer
     */
    Integer selectMaxSortNumByParentId(int orgId);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param orgId int
     * @return Map<String, Object>
     */
    Map<String, Object> selectOrgsForTree4Export(int orgId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return Map<String, Object>
     */
    Map<String, Object> selectRootOrg();

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param parentOrgId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectOrgsByParentId4Move(int parentOrgId);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param orgMap Map<String, Object>
     */
    void updateOrgsByParent(Map<String, Object> orgMap);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param org Map<String, Object>
     */
    void updateOrg4Import(Map<String, Object> org);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateOrgSortNum(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param orgId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectOrgsByParentId(int orgId);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param m Map<String, Object>
     */
    void updateOrgLevel(Map<String, Object> m);
    
    /**
     * [简要描述]:<br/>  根据id查询机构及其子机构
     * [详细描述]:<br/>
     * 
     * @author hongxz 
     * @param orgId int   当前机构id
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectOrgsForZtree(int orgId);
}
