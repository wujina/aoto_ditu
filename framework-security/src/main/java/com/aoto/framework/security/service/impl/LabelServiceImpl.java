package com.aoto.framework.security.service.impl;

import com.aoto.framework.commons.constant.BeanProperty.Bean;
import com.aoto.framework.commons.constant.NumberEnum;
import com.aoto.framework.commons.pagination.PagingCriteria;
import com.aoto.framework.security.models.LabelModel;
import com.aoto.framework.security.models.LabelQuery;
import com.aoto.framework.security.persistence.inf.FunctionMapper;
import com.aoto.framework.security.persistence.inf.LabelMapper;
import com.aoto.framework.security.service.inf.LabelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 */
@Service
public class LabelServiceImpl implements LabelService {

    /**
     *
     */
    @Autowired
    protected LabelMapper labelMapper;

    @Override
    /**
    * @Param: [pagingCriteria, model]
    * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
    * @Author: Mr.Wuj
    * @Date: 2019/8/29
    */
    public List<Map<String, Object>> getUrlByPage(PagingCriteria pagingCriteria, LabelQuery model) {
        String string=model.getLabelName();
        Map<String, Object>map=new HashMap<String, Object>(NumberEnum.NUMBER_4.getNum());
        map.put(Bean.PAGING, pagingCriteria);
        if (string.equals("houseAdvantage")){
            map.put("labelName", StringUtils.trim(model.getLabelName()));
        }
        else if (string.equals("indoorFacilities"))
        {
            map.put("labelName", StringUtils.trim(model.getLabelName()));
        }
        else if (string.equals("outdoorFacilities"))
        {
            map.put("labelName", StringUtils.trim(model.getLabelName()));
        }
        else {
            map.put("labelName", StringUtils.trim(null));
        }

        return labelMapper.selectUrlByPage(map);
    }

    @Override
    /**
    * @Param: [model]
    * @return: java.lang.String
    * @Author: Mr.Wuj
    * @Date: 2019/8/29
    */
    public String createLabel(LabelModel model) {
        Map<String, Object>map=new HashMap<>();
        if (model.getLabelName().equals("房屋优势标签")){
            map.put("labelName", "houseAdvantage");
        }
        else if (model.getLabelName().equals("室内设置标签")){
            map.put("labelName", "indoorFacilities");
        }
        else if (model.getLabelName().equals("室外设置标签")){
            map.put("labelName", "outdoorFacilities");
        }
        map.put("labelValue",model.getLabelValue());
        labelMapper.insertLabel(map);
        return null;
    }

    @Override
    /**
    * @Param: [list]
    * @return: void
    * @Author: Mr.Wuj
    * @Date: 2019/8/29
    */
    public void deleteLabel(List<Integer> list) {
        for (Integer houseID:list){
            labelMapper.deleteLabel(houseID);
        }

    }

    @Override
    public List<Map<String, Object>> getAllLabel() {
        List<Map<String, Object>>map=labelMapper.getAllLabel();

        return map;
    }


}
