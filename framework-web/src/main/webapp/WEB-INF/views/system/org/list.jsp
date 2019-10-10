<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title><fmt:message key="org.title" /></title>
  <meta charset="utf-8"/>
  <link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css" />
  <%@ include file="/WEB-INF/views/shared/easyui.jsp"%>
  <script src="${staticPath}/static/js/system/org/list.js"></script>
  <script src="${staticPath}/static/js/shared/jqueryTreeAdd.js"></script>
</head>
<body class="easyui-layout">
  <div data-options="border:false,region:'north',collapsible:true,title:'<fmt:message key="query.condition" />',iconCls:'icon-filter'" style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none; height: 85px;">
    <form class="form-inline" style="margin: 15px;">
       <div class="form-group">
        <label for="sOrgName"><fmt:message key="org.orgName" /></label>
        <fmt:message key="colon" />
		<input class="form-control" id="sOrgName" name="sOrgName"/>
      </div>
      <div class="form-group">
        <label for="sOrgCode"><fmt:message key="org.orgCode" /></label>
        <fmt:message key="colon" />
		<input class="form-control" id="sOrgCode" name="sOrgCode"/>
      </div>
      <div class="form-group">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchOrgs();"><fmt:message key="query" /></a>
      </div>
    </form>
  </div>
  <div data-options="border:false,region:'center',title:'<fmt:message key="org.list" />',collapsible:true,iconCls:'icon-list'">
  	<div class="easyui-layout" data-options="border:false,fit:true">   
        <div data-options="region:'north',border:false,collapsed:false" >
	        <div id="tbOrg" style="padding: 5px;background: #efefef;">
		      <c:if test="${currentUser.function['30602']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-plus',plain:true,disabled:true" id="btnNewOrg" onclick="newOrg();"><fmt:message key="new" /></a>
		      </c:if>
		      <c:if test="${currentUser.function['30603']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,disabled:true" id="btnEditOrg" onclick="editOrg();"><fmt:message key="edit" /></a>
		      </c:if>
		      <c:if test="${currentUser.function['30604']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true,disabled:true" id="btnRemoveOrg" onclick="removeOrg();"><fmt:message key="remove" /></a>
		      </c:if>
		      <c:if test="${currentUser.function['30605']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-file-alt',plain:true,disabled:true" id="btnShowOrg" onclick="showOrg();"><fmt:message key="detail" /></a>
		      </c:if>
		      <c:if test="${currentUser.function['30606']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-signout',plain:true" id="btnExportOrg" onclick="exportExcel()"><fmt:message key="export" /></a>
		      </c:if>
		      <c:if test="${currentUser.function['30607']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-signin',plain:true" id="btnImportOrg" onclick="importExcel();"><fmt:message key="import" /></a>
		      </c:if>
		      <a class="easyui-linkbutton" data-options="iconCls:'icon-folder-open',plain:true" id="btnExpand" onclick="expand('org')"><fmt:message key="expand" /></a>
		      <a class="easyui-linkbutton" data-options="iconCls:'icon-folder-close',plain:true" id="btnCollapse" onclick="collapse('org')"><fmt:message key="collapse" /></a>
		    </div>
		    <div id="dlgShowOrgButtons" style="display:none;">
		      <c:if test="${currentUser.function['30603']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="editOrgFromDetail();"><fmt:message key="edit" /></a>
		      </c:if>
		      <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="closeOrgDetailDialog();"><fmt:message key="cancel" /></a>
		    </div>
        </div>   
        <div data-options="region:'center',border:false">
			<ul id="org" />
        </div>   
    </div>       
  </div>
</body>
</html>