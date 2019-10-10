/*
 * Nanjing Aoto 2017, All rights reserved.
 * 文件名  :ErrorCodeEnum.java
 * 创建人  :zongwj
 * 创建时间:2017年6月2日
*/

package com.aoto.framework.commons.constant;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public enum ErrorCodeEnum {
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    ERROR_500(500),
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    ERROR_801(801),
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    NO_ERROR(901);
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int code;
    
    /**
     * [简要描述]:<br/>
     * [详细描述]:<br/>
     *
     * @author zongwj
     * @param code int
     */
    ErrorCodeEnum(int code) {
        this.code = code;
    }
    
    public int getCode() {
        return code;
    }
}
