package com.aoto.framework.security.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.aoto.framework.commons.beans.Model;
import com.aoto.framework.commons.pagination.PaginationQuery;

/**
 * [简要描述]:<br/>
 * [详细描述]:<br/>
 *
 * @author zongwj
 * @version 1.0, 2017年6月2日
 */
public class DicQueryModel extends PaginationQuery implements Model{
    
    private static final long serialVersionUID = -3151757937529893587L;

    /**
     * [简要描述]:
     * @author zongwj
     */
    public int dicId;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    public String dicName;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    public String dicType;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    public String dicKey;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    public String dicValue;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    public String dicSymbol;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int createdBy;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private boolean byPage;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    private int lastUpdatedBy;
    
    /**
     * [简要描述]:
     * @author zongwj
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateDate;

    public boolean getByPage() {
        return byPage;
    }
    public void setByPage(boolean byPage) {
        this.byPage = byPage;
    }
    public int getDicId() {
        return dicId;
    }
    public void setDicId(int dicId) {
        this.dicId = dicId;
    }
    public String getDicName() {
        return dicName;
    }
    public void setDicName(String dicName) {
        this.dicName = dicName;
    }
    public String getDicType() {
        return dicType;
    }
    public void setDicType(String dicType) {
        this.dicType = dicType;
    }
    public String getDicKey() {
        return dicKey;
    }
    public void setDicKey(String dicKey) {
        this.dicKey = dicKey;
    }
    public String getDicValue() {
        return dicValue;
    }
    public void setDicValue(String dicValue) {
        this.dicValue = dicValue;
    }
    public String getDicSymbol() {
        return dicSymbol;
    }
    public void setDicSymbol(String dicSymbol) {
        this.dicSymbol = dicSymbol;
    }
    public int getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public int getLastUpdatedBy() {
        return lastUpdatedBy;
    }
    public void setLastUpdatedBy(int lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
