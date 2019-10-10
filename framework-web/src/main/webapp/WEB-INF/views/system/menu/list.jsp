<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="menu.title" /></title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css" />
<%@ include file="/WEB-INF/views/shared/easyui.jsp"%>
<script src="${staticPath}/static/js/system/menu/list.js"></script>
<script src="${staticPath}/static/js/shared/jqueryTreeAdd.js"></script>
</head>
<body class="easyui-layout">
  <div data-options="border:false,region:'center',title:'<fmt:message key="menu.list" />',collapsible:true,iconCls:'icon-list'">
	<div class="easyui-layout" data-options="border:false,fit:true">   
        <div data-options="region:'north',border:false,collapsed:false" >    
		    <div id="tbmenu" style="padding: 5px; height: auto; background: #efefef;">
		      <c:if test="${currentUser.function['30301']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-plus',plain:true,disabled:true" id="btnNewmenu" onclick="newmenu();"><fmt:message key="new" /></a>
		      </c:if>
		      <c:if test="${currentUser.function['30302']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,disabled:true" id="btnEditmenu" onclick="editmenu();"><fmt:message key="edit" /></a>
		      </c:if>
		      <c:if test="${currentUser.function['30303']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true,disabled:true" id="btnRemovemenu" onclick="removemenu();"><fmt:message key="remove" /></a>
		      </c:if>
		      <c:if test="${currentUser.function['30304']}">
		        <a class="easyui-linkbutton" data-options="iconCls:'icon-file-alt',plain:true,disabled:true" id="btnShowmenu" onclick="showmenu();"><fmt:message key="detail" /></a>
		      </c:if>
		      <a class="easyui-linkbutton" data-options="iconCls:'icon-folder-open',plain:true" id="btnExpand" onclick="expand('menu')"><fmt:message key="expand" /></a>
		      <a class="easyui-linkbutton" data-options="iconCls:'icon-folder-close',plain:true" id="btnCollapse" onclick="collapse('menu')"><fmt:message key="collapse" /></a>
		    </div>
		    <div id="dlgShowmenuButtons"  style="display:none;">
			  <c:if test="${currentUser.function['30302']}">
			    <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="editmenuFromDetail();"><fmt:message key="edit" /></a>
			  </c:if>
			  <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="closemenuDetailDialog();"><fmt:message key="cancel" /></a>
			</div>
		</div>	
    	<div data-options="region:'center',border:false">
			<ul id="menu" />
        </div>
     </div>      
  </div>
</body>
</html>