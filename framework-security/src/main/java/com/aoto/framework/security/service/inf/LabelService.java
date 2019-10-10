package com.aoto.framework.security.service.inf;

import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.security.models.LabelModel;
import com.aoto.framework.security.models.LabelQuery;
import com.aoto.framework.security.models.RoominfoQuery;

import java.util.List;
import java.util.Map;

public interface LabelService {

    /**
     * 分页获取
     * @param pagingCriteria
     * @param model
     * @return
     */
    List<Map<String, Object>> getUrlByPage(PagingCriteria pagingCriteria, LabelQuery model);

    String createLabel(LabelModel model);

    /**
     * 删除房源信息
     * @param list
     */
    void deleteLabel(List<Integer> list);

    List<Map<String, Object>>getAllLabel();

}
