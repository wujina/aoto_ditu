<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="dic.list" /></title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css" />
<%@ include file="/WEB-INF/views/shared/easyui.jsp"%>
<script src="${staticPath}/static/js/system/dic/list.js"></script>
</head>
<body class="easyui-layout">
  <div data-options="border:false,region:'north',collapsible:true,title:'<fmt:message key="query.condition" />',iconCls:'icon-filter'" style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none; height: 85px;">
    <form class="form-inline" style="margin: 15px;">
       <div class="form-group">
        <label for="queryDicName"><fmt:message key="dic.dicName" /></label>
        <fmt:message key="colon" />
		<input style="width:150px;" id="queryDicName" name="queryDicName"/>
      </div>
      <div class="form-group">
        <label for="queryDicType"><fmt:message key="dic.dicType" /></label>
        <fmt:message key="colon" />
		<input style="width:150px;" id="queryDicType" name="queryDicType"/>
      </div>
      <div class="form-group">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchDic();"><fmt:message key="query" /></a>
      </div>
    </form>
  </div>
   <div data-options="border:false,region:'center',title:'<fmt:message key="dic.list" />',collapsible:true,iconCls:'icon-list'" style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none;">
    <table data-options="pageSize:20,fit:true,fitColumns:true,border:false,rownumbers:true,pagination:true,singleSelect:false,url:'${contextPath}/system/dics/list', method:'get',queryParams:{dicName:$('#queryDicName').val(),dicType:$('#queryDicType').val()},toolbar:'#tbDic'" id="dgDic">
      <thead>
        <tr>
          <th data-options="checkbox:true,field:'dicId'"></th>
          <th data-options="field:'dicName',sortable:true"><fmt:message key="dic.dicName" /></th>
          <th data-options="field:'dicType',sortable:true"><fmt:message key="dic.dicType" /></th>
          <th data-options="field:'lastUpdatedByName',width:100"><fmt:message key="lastUpdatedBy" /></th>
          <th data-options="field:'lastUpdatedDate',width:140,formatter:formatDate"><fmt:message key="lastUpdatedDate" /></th>
        </tr>
      </thead>
    </table>
    <div id="tbDic" style="padding: 5px;">
       <c:if test="${currentUser.function['40101']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-plus',plain:true" id="btnNewDic" onclick="newDic();"><fmt:message key="new" /></a>
       </c:if>
       <c:if test="${currentUser.function['40102']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,disabled:true" id="btnEditDic" onclick="editDic();"><fmt:message key="edit" /></a>
       </c:if>
       <c:if test="${currentUser.function['40103']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true,disabled:true" id="btnRemoveDic" onclick="removeDic();"><fmt:message key="remove" /></a>
       </c:if>
       <c:if test="${currentUser.function['40104']}">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-file-alt',plain:true,disabled:true" id="btnShowDic" onclick="showDic();"><fmt:message key="detail" /></a>
       </c:if>
    </div>
	<div id="dlgShowDicButtons" style="display:none;">
		<c:if test="${currentUser.function['40102']}">
		    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="editDicFromDetail();"><fmt:message key="edit" /></a>
		</c:if>  
		<a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="closeDicDetailDialog();"><fmt:message key="cancel" /></a>	
	</div>  
   </div>
</body>
</html>