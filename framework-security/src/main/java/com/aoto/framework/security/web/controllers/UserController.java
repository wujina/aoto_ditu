package com.aoto.framework.security.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.aoto.framework.commons.beans.JsonResult;
import com.aoto.framework.commons.constant.ErrorCodeEnum;
import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.constant.BeanProperty.User;
import com.aoto.framework.commons.lang.StringUtils4Aoto;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.commons.userdetails.CurrentUserHolder;
import com.aoto.framework.logging.service.inf.LogService;
import com.aoto.framework.security.models.ResetPasswordModel;
import com.aoto.framework.security.models.UserLockedModel;
import com.aoto.framework.security.models.UserModel;
import com.aoto.framework.security.models.UserQuery;
import com.aoto.framework.security.models.UserSelectorQuery;
import com.aoto.framework.security.service.inf.RoleService;
import com.aoto.framework.security.service.inf.UserService;

/**
 * UserController 接受客户端的请求访问，基于rest url 风格 rest url约定 :
 * http://microformats.org/wiki/rest/urls *
 * 
 * @author jiangp
 * @see
 * @since 1.0
 */
@Controller
public class UserController
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected SessionRegistry sessionRegistry;

    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected UserService userService;

    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected RoleService roleService;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected LogService logService;

    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected MessageSource messageSource;

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/users/new", method = RequestMethod.GET)
    public ModelAndView newUser()
    {
        return new ModelAndView("system/user/new");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/users/edit", method = RequestMethod.GET)
    public ModelAndView editUser()
    {
        return new ModelAndView("system/user/edit");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/users/show", method = RequestMethod.GET)
    public ModelAndView showUser()
    {
        return new ModelAndView("system/user/show");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/users/select", method = RequestMethod.GET)
    public ModelAndView selectUser()
    {
        return new ModelAndView("system/user/select");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/users/select4commrole", method = RequestMethod.GET)
    public ModelAndView selectUser4commrole()
    {
        return new ModelAndView("system/user/select4commrole");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/users/online", method = RequestMethod.GET)
    public ModelAndView showOnlineUsers()
    {
        return new ModelAndView("system/user/online");
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return JsonResult
     */
    @RequestMapping(value = "/system/users/online", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public JsonResult getOnlineUsers()
    {
        List<Object> list = sessionRegistry.getAllPrincipals();
        return JsonResult.json(list, list.size());
    }
    
//    @RequestMapping(value = "/system/users/online", method = RequestMethod.DELETE)
//    @ResponseBody
//    public void removeOnlineUser(@RequestBody List<Integer> list)
//    {
//        List<Object> principals = sessionRegistry.getAllPrincipals();
//        CurrentUser currentUser = null;
//        
//        for (Object o : principals)
//        {
//            currentUser = (CurrentUser) o;
//            
//            for (int userId : list)
//            {
//                if (userId == currentUser.getUserId())
//                {
//                    List<SessionInformation> sessions = sessionRegistry.getAllSessions(o, false);
//                    
//                    for (SessionInformation s : sessions)
//                    {
//                        s.expireNow();
//                    }
//                }
//            }
//        }
//    }
    
    /**
     * [简要描述]:获取所有用户列表，rest url : /system/users， method : GET，
     * [详细描述]:把用户list添加到视图中，在WEB-INF/views/account/user/list.jsp中绑定
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/users/list", method = RequestMethod.GET)
    public ModelAndView showUsers()
    {
        return new ModelAndView("system/user/list");
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UserQuery
     * @return JsonResult
     */
    @RequestMapping(value = "/system/users/list", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public JsonResult getUsers(UserQuery model)
    {
        PagingCriteria pagingCriteria = new PagingCriteria(model.getPage() - 1, model.getRows(), model.getSort(),
                model.getOrder());
        List<Map<String, Object>> list = userService.getUsersByPage(pagingCriteria, model);

        return JsonResult.json(pagingCriteria.getTotal(), list);
    }

    /**
     * [简要描述]:新增一个用户，rest url : /system/users， method : POST，
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model 用户信息实体，表单html标签的name值必须和user属性名一一对应
     * @return JsonResult
     */
    @RequestMapping(value = "/system/users", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newUser(UserModel model)
    {
        String errorCode = userService.createUser(model);
        return JsonResult.json(errorCode);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param oldPassword String
     * @param newPassword String
     * @return JsonResult
     */
    @RequestMapping(value = "/system/users/{userId}/password", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult editUserPassword(String oldPassword, String newPassword)
    {
        String errorCode = userService.changePassword(oldPassword, newPassword);
        return JsonResult.json(errorCode);
    }

    /**
     * [简要描述]:编辑一个用户信息，rest url : /system/users， method : PUT
     * [详细描述]:由于method:PUT并不是所有浏览器和web容器都支持， 采用POST /system/users/1?_method=PUT来代替，
     * 提交的form必须包含一个hidden，hidden name="_method" value="PUT"
     * 
     * @author zongwj
     * @param model 用户信息实体，表单html标签的name值必须和user属性名一一对应
     * @return JsonResult
     */
    @RequestMapping(value = "/system/users/{userId}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult editUser(UserModel model)
    {
        userService.editUser(model);
        return JsonResult.json();
    }

//    @RequestMapping(value = "/system/users/{userId}", method = RequestMethod.GET)
//    public ModelAndView showUser(@PathVariable("userId") int userId)
//    {
//        Map<String, Object> user = userService.getUserForShow(userId);
//        List<Map<String, Object>> roles = roleService.getRolesByUserId(userId);
//
//        ModelAndView view = new ModelAndView("system/user/show");
//        view.addObject("user", user);
//        view.addObject("roles", roles);
//
//        return view;
//    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param list List<Integer>
     * @return JsonResult
     */
    @RequestMapping(value = "/system/users", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult removeUsers(@RequestBody List<Integer> list)
    {
        userService.removeUsers(list);
        return JsonResult.json();
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param list List<ResetPasswordModel>
     * @return JsonResult
     */
    @RequestMapping(value = "/system/users/password", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult resetPassword(@RequestBody List<ResetPasswordModel> list)
    {
        userService.resetPassword(list);
        return JsonResult.json();
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UserLockedModel
     * @return JsonResult
     */
    @RequestMapping(value = "/system/users/locked", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult lockUsers(@RequestBody UserLockedModel model)
    {
        userService.lockUsers(model);
        return JsonResult.json();
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UserLockedModel
     * @return JsonResult
     */
    @RequestMapping(value = "/system/users/unlocked", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult unlockUsers(@RequestBody UserLockedModel model)
    {
        userService.lockUsers(model);
        return JsonResult.json();
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model UserSelectorQuery
     * @return JsonResult
     */
    @RequestMapping(value = "/system/users/excepted", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getUsersExcepted(UserSelectorQuery model)
    {
        PagingCriteria pagingCriteria = new PagingCriteria(model.getPage() - 1, model.getRows(), model.getSort(),
                model.getOrder());
        List<Map<String, Object>> list = userService.getUsersExceptByPage(pagingCriteria, model);

        return JsonResult.json(pagingCriteria.getTotal(), list);
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param request HttpServletRequest
     * @param response HttpServletResponse
     * @return ModelAndView
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response)
    {        
        String ajax = request.getHeader("X-Requested-With");

        if (!StringUtils4Aoto.isEmpty(ajax))
        {
            response.setStatus(ErrorCodeEnum.NO_ERROR.getCode());
            return null;
        }
        
        if (null == request.getUserPrincipal())
        {
            return new ModelAndView("shared/login");
        }
        else
        {
            return new ModelAndView("redirect:/index");
        }
    }

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param request HttpServletRequest
     * @return ModelAndView
     */
    @RequestMapping(value = "/login/error", method = RequestMethod.GET)
    public ModelAndView loginError(HttpServletRequest request)
    {
        Object ex = WebUtils.getSessionAttribute(request, WebAttributes.AUTHENTICATION_EXCEPTION);
        String message = StringUtils4Aoto.EMPTY;

        if (null != ex)
        {
            Locale locale = request.getLocale();

            if (ex instanceof LockedException)
            {
                message = messageSource.getMessage("login.error1", null, locale);
            }
            else
            {
                message = messageSource.getMessage("login.error2", null, locale);
            }
        }

        return new ModelAndView("shared/login").addObject("errorMessage", message);
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/commuser/edit", method = RequestMethod.GET)
    public ModelAndView editCurrentUser()
    {
        return new ModelAndView("system/user/profile");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param base64Data String
     * @param userId String
     * @return JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "/system/commuser/upload", method = RequestMethod.POST)
    public JsonResult upload(String base64Data, String userId)
    {
        Map<String, Object> map = new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        map.put(User.USER_ID, userId);
        String dataPrix;
        String data;
        if (base64Data == null || "".equals(base64Data)) {
            return JsonResult.json("user.setting.upload.failed.message1");
        }
        else {
            String[] d = base64Data.split("base64,");
            if (d != null && d.length == 2) {
                dataPrix = d[0];
                map.put(User.USER_PIC_SUFFIX, dataPrix);
                data = d[1];
                map.put(User.USER_PIC_DATA, Base64Utils.decodeFromString(data));
            }
            else {
                return JsonResult.json("user.setting.upload.failed.message2");
            }
        }
        userService.updateUserPic(map);
        CurrentUserHolder.getCurrentUser().setUserPicDataStr(base64Data);
        return JsonResult.json();        
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param user UserModel
     * @return JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "/system/commuser/realname", method = RequestMethod.POST)
    public JsonResult updateRealName(UserModel user)
    {       
        userService.updateRealName(user);
        CurrentUserHolder.getCurrentUser().setRealName(user.getRealName());
        return JsonResult.json();        
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param user UserModel
     * @return JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "/system/commuser/age", method = RequestMethod.POST)
    public JsonResult updateAge(UserModel user)
    {       
        userService.updateAge(user);
        CurrentUserHolder.getCurrentUser().setAge(user.getAge());
        return JsonResult.json();        
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param user UserModel
     * @return JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "/system/commuser/birthday", method = RequestMethod.POST)
    public JsonResult updateBirthday(UserModel user)
    {       
        userService.updateBirthday(user);
        CurrentUserHolder.getCurrentUser().setBirthday(user.getBirthday());
        return JsonResult.json();        
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param user UserModel
     * @return JsonResult
     */
    @ResponseBody
    @RequestMapping(value = "/system/commuser/about", method = RequestMethod.POST)
    public JsonResult updateAbout(UserModel user)
    {       
        userService.updateAbout(user);
        CurrentUserHolder.getCurrentUser().setAbout(user.getAbout());
        return JsonResult.json();        
    }
}