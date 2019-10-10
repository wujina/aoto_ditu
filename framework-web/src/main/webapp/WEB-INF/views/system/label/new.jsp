<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
<form class="form-grid">
    <div class="title">
        标签新增
    </div>

    <div class="form-group">
        <div class="col-3 control-label">
            <label for="labelName">标签分类<span class="required">*</span> <fmt:message key="colon" /></label>
        </div>
        <div class="col-1"></div>
        <div class="col-6">
            <select class="easyui-combobox myeasyui-searchParams" name="labelName"  style="width:185px;" data-options="editable:false,validType:['length[1,32]'],required:true,panelHeight:'auto'">
                <option>房屋优势标签</option>
                <option>室内设置标签</option>
                <option>室外设置标签</option>
            </select>
        </div>
        <div class="col-2"></div>
    </div>

    <div class="form-group">
        <div class="col-3 control-label">
            <label for="labelValue">标签名称<span class="required">*</span> <fmt:message key="colon" /></label>
        </div>
        <div class="col-1"></div>
        <div class="col-6">
            <input class="easyui-validatebox form-control" maxlength="32" data-options="required:true,validType:['length[1,32]'],novalidate:true" name="labelValue" />
        </div>
        <div class="col-2"></div>
    </div>
</form>