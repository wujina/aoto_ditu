<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="${staticPath}/static/lib/ajaxfileupload.js"></script>
<div class="datagrid-mask" style="display: none;"></div>
<div class="datagrid-mask-msg" style="display: none;">正在处理，请稍候...</div>
<form class="form-grid">
    <div class="title">
      <fmt:message key="org.import" />
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="files"><fmt:message key="file" /><span class="required">*</span> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <input id="fileupload" type="file" name="files">
      </div>
      <div class="col-2"></div>
    </div>
    <div class="form-group">
      <div class="col-3 control-label">
        <label for="remark"><fmt:message key="user.remark" /> <fmt:message key="colon" /></label>
      </div>
      <div class="col-1"></div>
      <div class="col-6">
        <textarea class="easyui-validatebox form-control" data-options="validType:['text','length[1,128]'],novalidate:true" id="remarks" name="remarks" style="height:55px;"></textarea>
      </div>
      <div class="col-2"></div>
    </div>
  </form>