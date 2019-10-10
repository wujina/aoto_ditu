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
public interface DicMapper
{
    /**
     * 分页查询
     * 
     * @param map Map<String, Object>
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDicsByPage(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDics();

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @param map Map<String, Object>
     */
    void insertDic(Map<String, Object> map);

    /**
     * 查询出dictype是否重复
     * 
     * @return Integer
     */
    Integer getMaxDicType();

    /**
     * 根据ddType查找字典表详细信息 加分页
     * 
     * @param map Map<String, Object>
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDicByDicTypeByPage(Map<String, Object> map);

    /**
     * 根据ddType查找字典表详细信息
     * 
     * @param map Map<String, Object>
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> getDicByDicType(Map<String, Object> map);

    /**
     * 根据receiptDevDdId删除数据字典子信息
     * 
     * @param map Map<String, Object>
     */
    void deleteDic(Map<String, Object> map);

    /**
     * 修改数据字典信息
     * 
     * @param map Map<String, Object>
     */
    void updateDic(Map<String, Object> map);

    /**
     * 根据ddType删除数据字典
     * 
     * @param dicType String
     */
    void deleteDicByDicType(String dicType);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return int
     */
    int selectDicNumListDicTypeForInsert(Map<String, Object> map);

    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     * 
     * @author zongwj
     * @param map Map<String, Object>
     * @return int
     */
    int selectDicNumListDicNameForInsert(Map<String, Object> map);
}
