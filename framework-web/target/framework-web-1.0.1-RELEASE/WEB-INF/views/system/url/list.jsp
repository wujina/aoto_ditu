<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="url.title" /></title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css" />
<%@ include file="/WEB-INF/views/shared/easyui.jsp"%>
<script src="${staticPath}/static/js/system/url/list.js"></script>
<script src="${staticPath}/static/js/system/org/select.js"></script>
</head>
<body class="easyui-layout">
  <div data-options="border:false,region:'north',collapsible:true,title:'<fmt:message key="query.condition" />',iconCls:'icon-filter'" style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none; height: 85px;">
    <form class="form-inline" style="margin: 15px;">
      <div class="form-group">
        <label for="urlName"><fmt:message key="url.urlName" /></label>
        <fmt:message key="colon" />
        <input class="form-control" id="surlName" type="text" name="surlName" />
      </div>
      <div class="form-group">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchUrls();"><fmt:message key="query" /></a>
      </div>
    </form>
  </div>
  <div data-options="border:false,region:'center',title:'<fmt:message key="url.list" />',collapsible:true,iconCls:'icon-list'" style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none;">
    <table data-options="idField : 'urlId',pageSize : 20,fit : true,fitColumns : true,border : false,rownumbers : true,pagination : true,singleSelect : false,url : '${contextPath}/system/urls/list', method : 'get',queryParams:{urlName:$('#urlName').val()},toolbar:'#tbUrl'" id="dgUrl">
      <thead>
        <tr>
          <th data-options="checkbox:true,field:'urlId'"></th>
          <th data-options="field:'urlName',width:80,sortable:true"><fmt:message key="url.urlName" /></th>
          <th data-options="field:'urlPattern',sortable:true"><fmt:message key="url.urlPattern" /></th>
          <th data-options="field:'httpMethod',width:40,sortable:true"><fmt:message key="url.httpMethod" /></th>
          <th data-options="field:'lastUpdatedByName',width:80"><fmt:message key="lastUpdatedBy" /></th>
          <th data-options="field:'lastUpdatedDate',width:80,formatter:formatDate"><fmt:message key="lastUpdatedDate" /></th>
        </tr>
      </thead>
    </table>
    <div id="tbUrl" style="padding: 5px;">
      <c:if test="${currentUser.function['30702']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-plus',plain:true" onclick="newUrl();"><fmt:message key="new" /></a>
      </c:if>
      <c:if test="${currentUser.function['30703']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,disabled:true" id="btnEditUrl" onclick="editUrl();"><fmt:message key="edit" /></a>
      </c:if>
      <c:if test="${currentUser.function['30704']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true,disabled:true" id="btnRemoveUrl" onclick="removeUrls();"><fmt:message key="remove" /></a>
      </c:if>
      <c:if test="${currentUser.function['30705']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-file-alt',plain:true,disabled:true" id="btnShowUrl" onclick="showUrl();"><fmt:message key="detail" /></a>
      </c:if>
    </div>
    <div id="dlgShowUrlButtons" style="display: none;">
      <c:if test="${currentUser.function['30703']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="editUrlFromDetail();"><fmt:message key="edit" /></a>
      </c:if>
      <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="closeUrlDetailDialog();"><fmt:message key="cancel" /></a>
    </div>
  </div>
</body>
</html>