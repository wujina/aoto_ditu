/*
 * Nanjing Aoto 2017, All rights reserved.
 * 文件名  :DBTypeEnum.java
 * 创建人  :zongwj
 * 创建时间:2017年6月13日
*/

package com.aoto.framework.commons.constant;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月13日
 */
public enum DBTypeEnum {
    /**
     * [简要描述]:
     * @author zongwj
     */
    ORACLE(1), 
    /**
     * [简要描述]:
     * @author zongwj
     */
    MYSQL(2);
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param code int
     */
    DBTypeEnum(int code){
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
