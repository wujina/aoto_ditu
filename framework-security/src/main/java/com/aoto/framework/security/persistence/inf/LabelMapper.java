package com.aoto.framework.security.persistence.inf;

import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.security.models.LabelModel;
import com.aoto.framework.security.models.LabelQuery;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface LabelMapper {

    /**
     *
     * @param labelInfo label
     */
    void insertLabel(Map<String, Object> labelInfo);

    /**
     *
     * @param labelInfo babel
     * @return map
     */
    Map<String,Object> selectLabel(Map<String, Object> labelInfo);

    /**
     *
     * @param map map
     * @return list
     */
    List<Map<String, Object>> selectUrlByPage(Map<String, Object> map);


    /**
     *
     * @param houseID  id
     */
    void deleteLabel(Integer houseID);

    List<Map<String, Object>> getAllLabel();
}
