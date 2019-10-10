package com.aoto.framework.security.service.inf;

import java.util.List;
import java.util.Map;

import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.security.models.DicModel;
import com.aoto.framework.security.models.DicQueryModel;


/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public interface DicService {
    /**
     * 分页查询
     * @param pagingCriteria PagingCriteria
     * @param model DicQueryModel
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDicsByPageMap(PagingCriteria pagingCriteria, DicQueryModel model);
    
    /**
     * 新增数据字典
     * @param list List<DicModel>
     * @return String
     */
    String newDic(List<DicModel> list);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDics();
    
    /**
     * 编辑数据字典
     * @param list List<DicModel>
     * @return String
     */
    String editDic(List<DicModel> list);

    /**
     * [简要描述]:删除数据字典信息
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param list List<String>
     * @return String
     */
    String deleteDic(List<String> list);
    
    /**
     * 根据dicType查询数据字典详细信息
     * @param model DicQueryModel
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDicByDicType(DicQueryModel model);
    
    /**
     * [简要描述]:根据dicType查询数据字典详细信息  加分页
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param pagingCriteria PagingCriteria
     * @param model DicQueryModel
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDicByDicTypeByPage(PagingCriteria pagingCriteria, DicQueryModel model);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param dicType String
     * @param dicKey String
     * @return String
     */
    String getDicValue(String dicType, String dicKey);
}
