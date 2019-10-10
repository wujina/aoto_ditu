package com.aoto.framework.security.models;

import java.util.Queue;

/**
 *
 */
public class LabelModel {

/** 
* @Param:  
* @return:  
* @Author: Mr.Wuj
* @Date: 2019/8/29 
*/ 
    private String labelName;
    /**
     * @Author: Mr.Wuj
     */
    private String labelValue;

    /**
     *
     * @return label
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     *
     * @param labelName laberlName
     */
    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    /**
     *
     * @return label
     */
    public String getLabelValue() {
        return labelValue;
    }

    /**
     *
     * @param labelValue  label
     */
    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }
}
