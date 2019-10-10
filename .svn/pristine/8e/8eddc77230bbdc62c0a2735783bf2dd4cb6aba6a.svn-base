<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="fun.title" /></title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css" />
<%@ include file="/WEB-INF/views/shared/easyui.jsp"%>
<script src="${staticPath}/static/js/system/function/list.js"></script>
<script src="${staticPath}/static/js/shared/jqueryTreeAdd.js"></script>
</head>
<body class="easyui-layout">
  <div data-options="border:false,region:'center',title:'<fmt:message key="fun.list" />',collapsible:true,iconCls:'icon-list'">
    <div class="easyui-layout" data-options="border:false,fit:true">   
        <div data-options="region:'north',border:false,collapsed:false" >
		    <div id="tbfun" style="padding: 5px; height: auto; background: #efefef;">
		      <c:if test="${currentUser.function['30201']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-plus',plain:true,disabled:true" id="btnNewfun" onclick="newfun();"><fmt:message key="new" /></a>
		      </c:if>
		      <c:if test="${currentUser.function['30202']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,disabled:true" id="btnEditfun" onclick="editfun();"><fmt:message key="edit" /></a>
		      </c:if>
		      <c:if test="${currentUser.function['30203']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true,disabled:true" id="btnRemovefun" onclick="removefun();"><fmt:message key="remove" /></a>
		      </c:if>
		      <c:if test="${currentUser.function['30204']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-file-alt',plain:true,disabled:true" id="btnShowfun" onclick="showfun();"><fmt:message key="detail" /></a>
		      </c:if>
		      <c:if test="${currentUser.function['30205']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,disabled:true" id="btnSetUrl" onclick="setUrl();"><fmt:message key="fun.setUrl" /></a>
		      </c:if>
		      <a class="easyui-linkbutton" data-options="iconCls:'icon-folder-open',plain:true" id="btnExpand" onclick="expand('fun')"><fmt:message key="expand" /></a>
		      <a class="easyui-linkbutton" data-options="iconCls:'icon-folder-close',plain:true" id="btnCollapse" onclick="collapse('fun')"><fmt:message key="collapse" /></a>
		    </div>
		    <div id="dlgShowfunButtons"  style="display:none;">
			  <c:if test="${currentUser.function['30202']}">
			    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="editfunFromDetail();"><fmt:message key="edit" /></a>
			  </c:if>
			  <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="closefunDetailDialog();"><fmt:message key="cancel" /></a>
			</div>
		</div>	
    	<div data-options="region:'center',border:false">
			<ul id="fun" />
        </div>  
     </div>    
  </div>
</body>
</html>