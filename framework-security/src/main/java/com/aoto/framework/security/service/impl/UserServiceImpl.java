/*
 * 版权信息：Copyright (c) 2013, Aoto. All rights reserved.
 * 文件编号：UserServiceImpl.java
 * 文件名称：UserServiceImpl.java
 * 系统编号：framework
 * 系统名称：framework
 * 模块编号：
 * 模块名称：
 * 作          者：jiangp
 * 完成日期：2013年10月8日
 * 设计文档：<列出相关设计文档的编号、名称。>
 * 内容摘要：<说明文件包含的类、类的性质/版型、类的状态说明、主要功能、系统相关界面、包含的区段、关键词及其一般说明、文件调用等。>
 */
package com.aoto.framework.security.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aoto.framework.security.web.Util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.constant.BeanProperty.Bean;
import com.aoto.framework.commons.constant.BeanProperty.Org;
import com.aoto.framework.commons.constant.BeanProperty.Role;
import com.aoto.framework.commons.constant.BeanProperty.User;
import com.aoto.framework.commons.lang.StringUtils4Aoto;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.commons.userdetails.CurrentUser;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.security.models.ResetPasswordModel;
import com.aoto.framework.security.models.UserLockedModel;
import com.aoto.framework.security.models.UserModel;
import com.aoto.framework.security.models.UserQuery;
import com.aoto.framework.security.models.UserSelectorQuery;
import com.aoto.framework.security.persistence.inf.RoleMapper;
import com.aoto.framework.security.persistence.inf.UserMapper;
import com.aoto.framework.security.service.inf.FunctionService;
import com.aoto.framework.security.service.inf.MenuService;
import com.aoto.framework.security.service.inf.UserService;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Value("${user.defaultPassword}")
    protected String defaultPassword;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected MessageDigestPasswordEncoder passwordEncoder;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected UserMapper userMapper;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected RoleMapper roleMapper;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected FunctionService functionService;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected MenuService menuService;

    @Override
    public List<Map<String, Object>> getUsersByPage(PagingCriteria pagingCriteria, UserQuery model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());

        map.put(Bean.PAGING, pagingCriteria);
        map.put(User.USERNAME, StringUtils4Aoto.trim(model.getUsername()));
        map.put(User.ORG_ID, model.getOrgId());
        map.put(Org.CONTAIN_SUB, model.isContainSub());
        return userMapper.selectUsersByPage(map);
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param model UserModel
     * @return String
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    @Transactional
    public String createUser(UserModel model)
    {
        String username = StringUtils4Aoto.trim(model.getUsername());
        if (null != userMapper.selectUserByName(username))
        {
            return "user.validation.message12";
        }
        String password = model.getPwd();
        if (StringUtils4Aoto.isEmpty(password))
        {
            password = defaultPassword;
        }
        String token = TokenUtil.getInstance().makeToken();
        String md5 = passwordEncoder.encodePassword(password, model.getUsername());
        Date now = new Date();
        int currentUserId = CurrentUserHolder.getCurrentUser().getUserId();
        
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_16.getNum());
        map.put(User.PRIMARY_KEY, 0);
        map.put(User.USERNAME, username);
        map.put(User.REAL_NAME, StringUtils4Aoto.trim(model.getRealName()));
        map.put(User.PWD, md5);
        map.put(Org.ORG_ID, model.getOrgId());
        map.put(User.PHONE, StringUtils4Aoto.trim(model.getPhone()));
        map.put(User.MOBILE, StringUtils4Aoto.trim(model.getMobile()));
        map.put(User.EMAIL, StringUtils4Aoto.trim(model.getEmail()));
        map.put(User.ADDRESS, StringUtils4Aoto.trim(model.getAddress()));
        map.put(User.REMARK, StringUtils4Aoto.trim(model.getRemark()));
        map.put(User.LOCKED, false);
        map.put(Bean.DELETED, false);
        map.put(Bean.CREATED_BY, currentUserId);
        map.put(Bean.CREATED_DATE, now);
        map.put(Bean.LAST_UPDATED_BY, currentUserId);
        map.put(Bean.LAST_UPDATED_DATE, now);
        map.put("TOKEN",token);

        userMapper.insertUser(map);
        return null;
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param model UserModel
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    @Transactional
    public void editUser(UserModel model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_16.getNum());

        map.put(User.PRIMARY_KEY, model.getUserId());
        map.put(User.REAL_NAME, StringUtils4Aoto.trim(model.getRealName()));
        map.put(User.PHONE, StringUtils4Aoto.trim(model.getPhone()));
        map.put(Org.ORG_ID, model.getOrgId());
        map.put(User.MOBILE, StringUtils4Aoto.trim(model.getMobile()));
        map.put(User.EMAIL, StringUtils4Aoto.trim(model.getEmail()));
        map.put(User.ADDRESS, StringUtils4Aoto.trim(model.getAddress()));
        map.put(User.REMARK, StringUtils4Aoto.trim(model.getRemark()));
        map.put(Bean.LAST_UPDATED_BY, CurrentUserHolder.getCurrentUser().getUserId());
        map.put(Bean.LAST_UPDATED_DATE, new Date());

        userMapper.updateUser(map);
    }
    
    /**
     * [简要描述]:批量删除操作
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param list List<Integer>
     * @exception 
     * @see com.aoto.framework.security.service.inf.UserService#removeUsers(java.util.List)
     */
    @Override
    @Transactional
    public void removeUsers(List<Integer> list)
    {
        CurrentUser currentUser = CurrentUserHolder.getCurrentUser();
        int currentUserId = currentUser.getUserId();
        String hex = Integer.toHexString(Long.valueOf(System.currentTimeMillis()).hashCode());
        Map<String, Object> map = null;
        String username = null;

        for (int userId : list)
        {
            map = userMapper.selectUser(userId);
            username = (String)map.get(User.USERNAME) + "[" + hex + "]";
            
            map.put(User.PRIMARY_KEY, userId);
            map.put(User.USERNAME, username);
            map.put(Bean.DELETED, true);
            map.put(Bean.LAST_UPDATED_BY, currentUserId);
            map.put(Bean.LAST_UPDATED_DATE, new Date());

            userMapper.deleteUser(map);
        }
    }

    @Override
    public String changePassword(String oldPassword, String newPassword)
    {
        CurrentUser currentUser = CurrentUserHolder.getCurrentUser();
        String username = currentUser.getUsername();
        int userId = currentUser.getUserId();
        Map<String, Object> map = userMapper.selectUserByName(username);
        String md5 = passwordEncoder.encodePassword(oldPassword, username);
        
        if (!StringUtils4Aoto.equals(md5, (String)map.get(User.PWD)))
        {
            return "user.validation.message13";
        }
        
        md5 = passwordEncoder.encodePassword(newPassword, username);
        
        map.clear();
        map.put(User.PRIMARY_KEY, userId);
        map.put(User.PWD, md5);
        map.put(Bean.LAST_UPDATED_BY, userId);
        map.put(Bean.LAST_UPDATED_DATE, new Date());
        
        userMapper.updateUserPassword(map);

        return null;
    }

    @Override
    @Transactional
    public void resetPassword(List<ResetPasswordModel> list)
    {
        CurrentUser currentUser = CurrentUserHolder.getCurrentUser();
        int currentUserId = currentUser.getUserId();
        String md5 = null;
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        String username = null;

        for (ResetPasswordModel model : list)
        {
            username = StringUtils4Aoto.trim(model.getUsername());
            md5 = passwordEncoder.encodePassword(defaultPassword, username);

            map.put(User.PRIMARY_KEY, model.getUserId());
            map.put(User.PWD, md5);
            map.put(Bean.LAST_UPDATED_BY, currentUserId);
            map.put(Bean.LAST_UPDATED_DATE, new Date());

            userMapper.updateUserPassword(map);
        }
    }

    @Override
    @Transactional
    public void lockUsers(UserLockedModel model)
    {
        Map<String, Object> map = null;
        boolean locked = model.isLocked();

        for (int userId : model.getList())
        {
            map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());

            map.put(User.PRIMARY_KEY, userId);
            map.put(User.LOCKED, locked);
            map.put(Bean.LAST_UPDATED_BY, CurrentUserHolder.getCurrentUser().getUserId());
            map.put(Bean.LAST_UPDATED_DATE, new Date());

            userMapper.updateUserLocked(map);
        }
    }

    /**
     * 〈一句话功能简述〉
     * 
     * @author jiangp
     * @param username String
     * @return UserDetails
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        String token = TokenUtil.getInstance().makeToken();
        Map<String, Object> user = userMapper.selectUserByName(username);

        if (user == null)
        {
            throw new UsernameNotFoundException("user not found");
        }

        boolean locked = (Boolean) user.get(User.LOCKED);
        String pwd = (String) user.get(User.PWD);
        int userId = (Integer) user.get(User.USER_ID);
        int orgId = (Integer) user.get(User.ORG_ID);
        String realName = (String) user.get(User.REAL_NAME);
        String orgCode = (String) user.get(Org.ORG_CODE);
        String orgName = (String) user.get(Org.ORG_NAME);
        String inheritedName = (String) user.get(Org.INHERITED_NAME);
        String userPicSuffix = (String)user.get(User.USER_PIC_SUFFIX);
        Byte[] userPicData = (Byte[])user.get(User.USER_PIC_DATA);
        Integer age = (Integer) user.get(User.AGE);
        Date birthday = (Date)user.get(User.BIRTHDAY);
        String about = (String)user.get(User.ABOUT);
        List<Map<String, Object>> menus = menuService.getMenusByParentId(userId, 1);
        Map<String, Boolean> map = functionService.getFunctionsByUserId(userId);

        if (locked)
        {
            return new CurrentUser(username, pwd, true, true, true, false, new HashSet<GrantedAuthority>(), userId,
                    realName, orgId, orgCode, orgName, inheritedName, menus, map, userPicSuffix, userPicData, age, 
                    birthday, about);
        }

        boolean enabled = true; // 是否可用
        boolean accountNonExpired = true; // 是否过期
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        if (userId > 0)
        {
            // 如果你使用资源和权限配置在xml文件中，如：<intercept-url pattern="/user/admin"
            // access="hasRole('ROLE_ADMIN')"/>；
            // 并且也不想用数据库存储，所有用户都具有相同的权限的话，你可以手动保存角色(如：预订网站)。
            authorities.add(new SimpleGrantedAuthority("user"));

            List<Map<String, Object>> list = roleMapper.selectRolesByUserId(userId);

            for (Map<String, Object> m : list)
            {
                authorities.add(new SimpleGrantedAuthority(String.valueOf(m.get(Role.ROLE_ID))));
            }
        }

        UserDetails userDetails = new CurrentUser(username, pwd, enabled, accountNonExpired, credentialsNonExpired,
                accountNonLocked, authorities, userId, realName, orgId, orgCode, orgName, inheritedName, menus, map,
                userPicSuffix, userPicData, age, birthday, about);

        return userDetails;
    }

    /**
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     * @author jiangp
     * @param pagingCriteria PagingCriteria
     * @param model UserSelectorQuery
     * @return List<Map<String, Object>>
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see   [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public List<Map<String, Object>> getUsersExceptByPage(PagingCriteria pagingCriteria, UserSelectorQuery model)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_8.getNum());
        map.put(Bean.PAGING, pagingCriteria);
        map.put("excepted", model.getNotIn());
        map.put(User.USERNAME, StringUtils4Aoto.trim(model.getUsername()));
        map.put(User.ORG_ID, model.getOrgId());
        map.put(Org.CONTAIN_SUB, model.isContainSub());    
        
        return userMapper.selectUsersExceptByPage(map);
    }

    /**
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     * @author jiangp
     * @param roleId  int
     * @return List<Map<String, Object>>
     * @exception/throws [异常类型] [异常说明]（可选）
     * @see   [类、类#方法、类#成员]（可选）
     * @since [起始版本]（可选）
     */
    @Override
    public List<Map<String, Object>> getUsersByRoleId(int roleId)
    {
        return userMapper.selectUsersByRoleId(roleId);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param roleId
     * @param orgId
     * @return
     * @exception 
     * @see com.aoto.framework.security.service.inf.UserService#getUsersByCommRoleId(int, int)
     */
    @Override
    public List<Map<String, Object>> getUsersByCommRoleId(int roleId, int orgId) {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        map.put(Role.ROLE_ID, roleId);
        map.put(Org.ORG_ID, orgId);
        return userMapper.selectUsersByCommRoleId(map);
    }
    
    @Override    
    public void updateUserPic(Map<String, Object> map) {
        userMapper.updateUserPic(map);
    }
    
    @Override
    public void updateRealName(UserModel model) {
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put(User.USER_ID, model.getUserId());
        map.put(User.REAL_NAME, model.getRealName());
        userMapper.updateRealName(map);
    }
    
    @Override
    public void updateAge(UserModel model) {
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put(User.USER_ID, model.getUserId());
        map.put(User.AGE, model.getAge());
        userMapper.updateAge(map);
    }
    
    @Override
    public void updateBirthday(UserModel model) {
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put(User.USER_ID, model.getUserId());
        map.put(User.BIRTHDAY, model.getBirthday());
        userMapper.updateBirthday(map);
    }
    
    @Override
    public void updateAbout(UserModel model) {
        Map<String, Object> map = new HashMap<String, Object>(2);
        map.put(User.USER_ID, model.getUserId());
        map.put(User.ABOUT, model.getAbout());
        userMapper.updateAbout(map);
    }

    @Override
    public Map<String, Object> checkToken(String token) {
        return userMapper.checkToken(token);
    }
}
