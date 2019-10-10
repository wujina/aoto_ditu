package com.aoto.framework.security.web.controllers;

import com.aoto.framework.commons.beans.JsonResult;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.security.models.LabelModel;
import com.aoto.framework.security.models.LabelQuery;
import com.aoto.framework.security.models.RoominfoQuery;
import com.aoto.framework.security.service.inf.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class LabelController {

    @Autowired
    protected LabelService labelService;

    @RequestMapping(value = "/system/label/list", method = RequestMethod.GET)
    public ModelAndView getlabelHtml()
    {
        return new ModelAndView("system/label/list");
    }


    @RequestMapping(value = "/system/label/new", method = RequestMethod.GET)
    public ModelAndView newlabelHtml()
    {
        return new ModelAndView("system/label/new");
    }
    /**
     * 分页获取
     * @param model
     * @return
     */
    @RequestMapping(value = "/system/label/list", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public JsonResult getLabel(LabelQuery model)
    {
        PagingCriteria pagingCriteria = new PagingCriteria(model.getPage() - 1, model.getRows(), model.getSort(),
                model.getOrder());
        List<Map<String, Object>> list = labelService.getUrlByPage(pagingCriteria, model);

        return JsonResult.json(pagingCriteria.getTotal(), list);
    }

    /**
     * 新增菜单
     * @param model
     * @return
     */
    @RequestMapping(value = "/system/label", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult newUrl(LabelModel model)
    {
        String errorCode = labelService.createLabel(model);
        return JsonResult.json(errorCode);
    }

    /**
     * 删除
     * @param list
     * @return
     */
    @RequestMapping(value = "/system/label", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResult deleteRoominfo(@RequestBody List<Integer>list)
    {
        labelService.deleteLabel(list);
        return JsonResult.json();
    }

    @RequestMapping(value = "/system/label/all", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> getRAdministrativeArea(
    ) {

        return labelService.getAllLabel();
    }


}
