<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="${staticPath}/static/js/system/function/select.js"></script>
  <form class="form-grid">
    <div class="title">
      <fmt:message key="menu.info" />
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="parentName"><fmt:message key="menu.parentName" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="form-control" name="parentName" disabled /> <input name="parentId" type="hidden" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="menuName"><fmt:message key="menu.menuName" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" maxlength="32" data-options="required:true,validType:['name','length[1,32]'],novalidate:true" name="menuName" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="menuUrl"><fmt:message key="menu.menuUrl" /><fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,32]'],novalidate:true" name="menuUrl" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="icon"><fmt:message key="menu.icon" /><fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control" maxlength="16" data-options="required:false,validType:['length[1,16]'],novalidate:true" name="icon" />
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="funId"><fmt:message key="menu.funId" /><fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
      	<input class="form-control" name="funName" readonly onclick="selectFun(this);" />
        <input name="funId" type="hidden"/>
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="sortNum"><fmt:message key="menu.sortNum" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input class="easyui-validatebox form-control"  maxlength="3" data-options="required:true,validType:['integer[3]'],novalidate:true" name="sortNum" />
      </div>
      <div class="col-2"></div>
    </div>
  </form>