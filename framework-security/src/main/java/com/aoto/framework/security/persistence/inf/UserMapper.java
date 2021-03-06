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
public interface UserMapper
{
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void insertUser(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateUser(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateUserPassword(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateUserLocked(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void deleteUser(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param userId int
     * @return Map<String, Object>
     */
    Map<String, Object> selectUser(int userId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param username String
     * @return Map<String, Object>
     */
    Map<String, Object> selectUserByName(String username);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectUsersByRoleId(int roleId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectUsersByCommRoleId(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectUsersExceptByPage(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> selectUsersByPage(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateUserPic(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateRealName(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateAge(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateBirthday(Map<String, Object> map);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     */
    void updateAbout(Map<String, Object> map);

    void updateToken(Map<String,Object>map);

    /**
     *
     * @param token
     * @return
     */
     Map<String,Object>checkToken(String token);
}