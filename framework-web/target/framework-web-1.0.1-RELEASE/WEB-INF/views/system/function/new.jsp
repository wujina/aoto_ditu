<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <form class="form-grid">
    <div class="title">
      <fmt:message key="fun.info" />
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="parentName"><fmt:message key="fun.parentName" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="form-control" name="parentName" disabled /> <input name="parentId" type="hidden" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="funId"><fmt:message key="fun.funId" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" maxlength="7" data-options="required:true,validType:['positiveInteger[6]'],novalidate:true" name="funId" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="funName"><fmt:message key="fun.funName" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" maxlength="32" data-options="required:true,validType:['name','length[1,32]'],novalidate:true" name="funName" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="sortNum"><fmt:message key="fun.sortNum" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control"  maxlength="3" data-options="required:true,validType:['integer[3]'],novalidate:true" name="sortNum" />
      </div>
      <div class="col-2"></div>
    </div>
  </form>