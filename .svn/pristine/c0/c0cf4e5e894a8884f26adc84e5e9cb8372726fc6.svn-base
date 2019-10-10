package com.aoto.framework.security.service.inf;

import java.util.List;
import java.util.Map;
import com.aoto.framework.security.models.MenuModel;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public interface MenuService
{   
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param userId int
     * @param parentId int
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getMenusByParentId(int userId, int parentId);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model MenuModel
     * @return String
     */
    String createMenu(MenuModel model);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param model MenuModel
     * @return String
     */
    String editMenu(MenuModel model);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param id int
     */
    void removeMenu(int id);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param id int
     * @param parentId int
     * @param parentLevelNum int
     * @param list List<MenuModel>
     */
    void moveMenu(int id, int parentId, int parentLevelNum, List<MenuModel> list);
}
