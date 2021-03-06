package com.aoto.framework.security.service.inf;

import java.util.List;
import java.util.Map;

import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.security.models.ResetPasswordModel;
import com.aoto.framework.security.models.UserLockedModel;
import com.aoto.framework.security.models.UserModel;
import com.aoto.framework.security.models.UserQuery;
import com.aoto.framework.security.models.UserSelectorQuery;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public interface UserService
{   
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UserModel
     * @return String
     */
    String createUser(UserModel model);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UserModel
     */
    void editUser(UserModel model);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param list List<Integer>
     */
    void removeUsers(List<Integer> list);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param list List<ResetPasswordModel>
     */
    void resetPassword(List<ResetPasswordModel> list);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param oldPassword String
     * @param newPassword String
     * @return String
     */
    String changePassword(String oldPassword, String newPassword);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UserLockedModel
     */
    void lockUsers(UserLockedModel model);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getUsersByRoleId(int roleId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId int
     * @param orgId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getUsersByCommRoleId(int roleId, int orgId);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param pagingCriteria PagingCriteria
     * @param model UserSelectorQuery
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getUsersExceptByPage(PagingCriteria pagingCriteria, UserSelectorQuery model);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param pagingCriteria PagingCriteria
     * @param model UserQuery
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getUsersByPage(PagingCriteria pagingCriteria, UserQuery model);
    
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
     * @param model UserModel
     */
    void updateRealName(UserModel model);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UserModel
     */
    void updateAge(UserModel model);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UserModel
     */
    void updateBirthday(UserModel model);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UserModel
     */
    void updateAbout(UserModel model);

    Map<String,Object>checkToken(String token);
}
