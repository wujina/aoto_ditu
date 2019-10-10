package com.aoto.framework.security.web.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aoto.framework.commons.beans.JsonResult;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.security.models.DicModel;
import com.aoto.framework.security.models.DicQueryModel;
import com.aoto.framework.security.service.inf.DicService;

/**
 * UserController 接受客户端的请求访问，基于rest url 风格 rest url约定 :
 * http://microformats.org/wiki/rest/urls *
 * 
 * @author jiangp
 * @see
 * @since 1.0
 */
@Controller
public class DicController
{
    /**
     * [简要描述]:
     * @author zongwj
     */
    @Autowired
    protected DicService dicService;

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/dics/new", method = RequestMethod.GET)
    public ModelAndView newDic()
    {
        return new ModelAndView("system/dic/new");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/dics/edit", method = RequestMethod.GET)
    public ModelAndView editDic()
    {
        return new ModelAndView("system/dic/edit");
    }
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/dics/show", method = RequestMethod.GET)
    public ModelAndView showDic()
    {
        return new ModelAndView("system/dic/show");
    }
    
    /**
     * [简要描述]:返回jsp页面
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return ModelAndView
     */
    @RequestMapping(value = "/system/dics/list", method = RequestMethod.GET)
    public ModelAndView showDics()
    {
        return new ModelAndView("system/dic/list");
    }

    /**
     * 条件分页查询
     * 
     * @param model DicQueryModel
     * @return JsonResult
     */
    @RequestMapping(value = "/system/dics/list", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public JsonResult getDics(DicQueryModel model)
    {
        PagingCriteria pagingCriteria = new PagingCriteria(model.getPage() - 1, model.getRows(), model.getSort(),
                model.getOrder());
        List<Map<String, Object>> list = dicService.getDicsByPageMap(pagingCriteria, model);
        return JsonResult.json(pagingCriteria.getTotal(), list);
    }

    /**
     * 新增
     * 
     * @param list List<DicModel>
     * @return JsonResult
     */
    @RequestMapping(value = "/system/dics", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newDic(@RequestBody List<DicModel> list)
    {
        String errorCode = dicService.newDic(list);
        return JsonResult.json(errorCode);
    }

    /**
     * 根据ddType查找字典表详细信息
     * 
     * @param model DicQueryModel
     * @return JsonResult
     */
    @RequestMapping(value = "/system/dics/{dicType}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public JsonResult getDicByDicType(DicQueryModel model)
    {
        List<Map<String, Object>> list = null;
        if (model.getByPage())
        {
            PagingCriteria pagingCriteria = new PagingCriteria(model.getPage() - 1, model.getRows(), model.getSort(),
                    model.getOrder());
            list = dicService.getDicByDicTypeByPage(pagingCriteria, model);
            return JsonResult.json(pagingCriteria.getTotal(), list);
        }
        else
        {
            list = dicService.getDicByDicType(model);
            return JsonResult.json(list.size(), list);
        }

    }

    /**
     * 编辑数据字典
     * 
     * @param list List<DicModel>
     * @return JsonResult
     */
    @RequestMapping(value = "/system/dics", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResult editDic(@RequestBody List<DicModel> list)
    {
        String errorCode = dicService.editDic(list);
        return JsonResult.json(errorCode);
    }

    /**
     * 删除数据字典信息
     * 
     * @param list List<String>
     * @return JsonResult
     */
    @RequestMapping(value = "/system/dics", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult deleteDic(@RequestBody List<String> list)
    {
        String errorCode = dicService.deleteDic(list);
        return JsonResult.json(errorCode);
    }

}