<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="role.title" /></title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css" />
<%@ include file="/WEB-INF/views/shared/easyui.jsp"%>
<script src="${staticPath}/static/js/system/commrole/list.js"></script>
<script src="${staticPath}/static/js/system/org/select.js"></script>
</head>
<body class="easyui-layout">
  <div data-options="border:false,region:'north',collapsible:true,title:'<fmt:message key="query.condition" />',iconCls:'icon-filter'" style="height: 85px; background: #F4F4F4;">
    <form class="form-inline" style="margin: 15px;">
      <div class="form-group">
        <label for="rname"><fmt:message key="role.roleName" /></label>
        <fmt:message key="colon" />
        <input class="form-control" id="rname" type="text" name="rname" />
      </div>
      <div class="form-group">
        <label for="oname"><fmt:message key="org.orgName" /></label>
        <fmt:message key="colon" />
        <input class="form-control" id="oname" name="oname" value="${currentUser.orgName}" readonly onclick="selectOrg(this);" /> <input id="oid" name="oid" type="hidden" value="${currentUser.orgId}" /> <label class="control-label"> <input class="checkbox" type="checkbox" id="containSub" name="containSub" checked /> <fmt:message key="org.containSub" />
        </label>
      </div>
      <div class="form-group">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchRoles();"><fmt:message key="query" /></a>
      </div>
    </form>
  </div>
  <div data-options="border:false,region:'center',title:'<fmt:message key="role.list" />',collapsible:true,iconCls:'icon-list'">
    <table data-options="idField:'roleId',pageSize:20,fit:true,fitColumns:true,border:false,rownumbers:true,pagination:true,singleSelect:false,url : '${contextPath}/system/commroles/list', method : 'get',queryParams:{roleName:$('#rname').val(),orgId:$('#oid').val(),containSub:$('#containSub').is(':checked')},toolbar:'#tbRole'" id="dgRole">
      <thead>
        <tr>
          <th data-options="checkbox:true,field:'roleId'"></th>
          <th data-options="field:'roleName',width:100,sortable:true"><fmt:message key="role.roleName" /></th>          
          <th data-options="field:'remark',width:200"><fmt:message key="role.remark" /></th>
          <th data-options="field:'createdByName',width:100"><fmt:message key="createdBy" /></th>
          <th data-options="field:'createdDate',width:100,formatter:formatDate"><fmt:message key="createdDate" /></th>
          <th data-options="field:'lastUpdatedByName',width:100"><fmt:message key="lastUpdatedBy" /></th>
          <th data-options="field:'lastUpdatedDate',width:100,formatter:formatDate"><fmt:message key="lastUpdatedDate" /></th>
        </tr>
      </thead>
    </table>
    <div id="tbRole" style="padding: 5px;">
      <c:if test="${currentUser.userId < 0}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-plus',plain:true" onclick="newRole();"><fmt:message key="new" /></a>
      </c:if>
      <c:if test="${currentUser.userId < 0}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,disabled:true" id="btnEditRole" onclick="editRole();"><fmt:message key="edit" /></a>
      </c:if>
      <c:if test="${currentUser.userId < 0}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true,disabled:true" id="btnRemoveRole" onclick="removeRoles();"><fmt:message key="remove" /></a>
      </c:if>
      <c:if test="${currentUser.userId < 0}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-key',plain:true,disabled:true" id="btnAuthorization" onclick="authorize();"><fmt:message key="authorization" /></a>
      </c:if>
      <c:if test="${currentUser.function['30502']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-group',plain:true,disabled:true" id="btnSetMembership" onclick="setMembership();"><fmt:message key="role.setMembership" /></a>
      </c:if>
    </div>
  </div>
</body>
</html>