/*
 * Nanjing Aoto 2017, All rights reserved.
 * 文件名  :RoleTypeEnum.java
 * 创建人  :zongwj
 * 创建时间:2017年5月11日
*/

package com.aoto.framework.commons.constant;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年5月11日
 */
public enum RoleTypeEnum {
    /**
     * [简要描述]:
     * @author zongwj
     */
    GENERAL_ROLE(1), 
    /**
     * [简要描述]:
     * @author zongwj
     */
    COMM_BUSINESS_ROLE(2);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param code int
     */
    RoleTypeEnum(int code){
        this.code = code;
    }
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int code;

    public int getCode() {
        return code;
    }
}
