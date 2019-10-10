<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="${staticPath}/static/lib/ajaxfileupload.js"></script>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="roominfo.list"/></title>
    <meta charset="utf-8"/>
</head>
<body>
<div class="datagrid-mask" style="display: none;"></div>
<div class="datagrid-mask-msg" style="display: none;height: 45px;" >正在处理，请稍候...</div>
<form class="form-grid" id="uploadEditForm" enctype="multipart/form-data">
    <div class="title">
        房源导入
    </div>
    <div class="form-group">
        <div class="col-3 control-label">
            <label for="file1"><fmt:message key="file" /><span class="required">*</span> <fmt:message key="colon" /></label>
        </div>
        <div class="col-1"></div>
        <div class="col-6">
            <input id="file1_excel" type="file" name="file1_excel" >
        </div>
        <div class="col-2"></div>
    </div>

    <div class="form-group">
        <div class="col-3 control-label">
            <label for="file2_zip">图片<span class="required">*</span><fmt:message key="colon" /></label>
        </div>
        <div class="col-1"></div>
        <div class="col-6">
            <input id="file2_zip" type="file" name="file2_zip">
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
<script>

</script>

</body>