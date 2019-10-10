package com.aoto.framework.security.models;

import com.aoto.framework.commons.pagination.PaginationQuery;

/**
 *
 */
public class LabelQuery extends PaginationQuery {
    /**
     * @Author: Mr.Wuj
     */
    private static final long serialVersionUID = -721133815397442896L;

    /**
     * @Author: Mr.Wuj
     */
    private String labelName  ;


    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}
