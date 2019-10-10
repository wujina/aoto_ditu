<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="user.title" /></title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css" />
<%@ include file="/WEB-INF/views/shared/easyui.jsp"%>
<script src="${staticPath}/static/js/system/user/list.js"></script>
<script src="${staticPath}/static/js/system/org/select.js"></script>
</head>
<body class="easyui-layout">
  <div data-options="border:false,region:'north',collapsible:true,title:'<fmt:message key="query.condition" />',iconCls:'icon-filter'" style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none; height: 85px;">
    <form class="form-inline" style="margin: 15px;">
      <div class="form-group">
        <label for="uname"><fmt:message key="user.username" /></label>
        <fmt:message key="colon" />
        <input class="form-control" id="uname" type="text" name="uname" />
      </div>
      <div class="form-group">
        <label for="oname"><fmt:message key="org.orgName" /></label>
        <fmt:message key="colon" />
        <input class="form-control" id="oname" name="oname" value="${currentUser.orgName}" readonly onclick="selectOrg(this);" />
        <input id="oid" name="oid" type="hidden" value="${currentUser.orgId}" /> <label class="control-label"> <input class="checkbox" type="checkbox" id="containSub" name="containSub" checked /> <fmt:message key="org.containSub" />
        </label>
      </div>
      <div class="form-group">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchUsers();"><fmt:message key="query" /></a>
      </div>
    </form>
  </div>
  <div data-options="border:false,region:'center',title:'<fmt:message key="user.list" />',collapsible:true,iconCls:'icon-list'" style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none;">
    <table data-options="idField:'userId',pageSize:20,fit:true,fitColumns:true,border:false,rownumbers:true,pagination:true,singleSelect:false,url:'${contextPath}/system/users/list', method:'get',queryParams:{username:$('#uname').val(),orgId:$('#oid').val(),containSub:$('#containSub').is(':checked')},toolbar:'#tbUser'" id="dgUser">
      <thead>
        <tr>
          <th data-options="checkbox:true,field:'userId'"></th>
          <th data-options="field:'username',width:100,sortable:true"><fmt:message key="user.username" /></th>
          <th data-options="field:'realName',width:100,sortable:true"><fmt:message key="user.realName" /></th>
          <th data-options="field:'inheritedName',width:200"><fmt:message key="org.orgName" /></th>
          <th data-options="field:'locked',width:50,formatter:formatLocked,sortable:true"><fmt:message key="user.status" /></th>
          <th data-options="field:'lastLoginDate',width:140,formatter:formatDate,sortable:true"><fmt:message key="user.lastLoginDate" /></th>
          <th data-options="field:'lastLoginIp',width:100,sortable:true"><fmt:message key="user.lastLoginIp" /></th>
          <th data-options="field:'lastUpdatedByName',width:100"><fmt:message key="lastUpdatedBy" /></th>
          <th data-options="field:'lastUpdatedDate',width:140,formatter:formatDate"><fmt:message key="lastUpdatedDate" /></th>
        </tr>
      </thead>
    </table>
    <div id="tbUser" style="padding: 5px;">
      <c:if test="${currentUser.function['30102']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-plus',plain:true" id="btnNewUser" onclick="newUser();"><fmt:message key="new" /></a>
      </c:if>
      <c:if test="${currentUser.function['30103']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,disabled:true" id="btnEditUser" onclick="editUser();"><fmt:message key="edit" /></a>
      </c:if>
      <c:if test="${currentUser.function['30104']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true,disabled:true" id="btnRemoveUser" onclick="removeUsers();"><fmt:message key="remove" /></a>
      </c:if>
      <c:if test="${currentUser.function['30106']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-file-alt',plain:true,disabled:true" id="btnShowUser" onclick="showUser();"><fmt:message key="detail" /></a>
      </c:if>
      <c:if test="${currentUser.function['30105']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-key',plain:true,disabled:true" id="btnResetPassword" onclick="resetPassword();"><fmt:message key="user.reset" /></a>
      </c:if>
      <c:if test="${currentUser.function['30107']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-lock',plain:true,disabled:true" id="btnLockUser" onclick="lockUsers();"><fmt:message key="user.lock" /></a>
      </c:if>
      <c:if test="${currentUser.function['30108']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-unlock',plain:true,disabled:true" id="btnUnlockUser" onclick="unlockUsers();"><fmt:message key="user.unlock" /></a>
      </c:if>
    </div>
    <div id="dlgShowUserButtons" style="display:none;">
      <c:if test="${currentUser.function['30103']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="editUserFromDetail();"><fmt:message key="edit" /></a>
      </c:if>
      <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="closeUserDetailDialog();"><fmt:message key="cancel" /></a>
    </div>
  </div>
</body>
</html>