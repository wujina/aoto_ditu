<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
<script src="${staticPath}/static/js/system/url/select.js"></script> 
  <div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west'" style="width: 460px">											    
      <table class="easyui-datagrid" data-options="idField:'urlId',title:'<fmt:message key="unselected" />',url:'${contextPath}/system/urls/excepted',method:'get',pageSize:10,fit:true,fitColumns:true,border:false,rownumbers:true,pagination:true,singleSelect:false,toolbar:'#tbUnselectedUser'" id="dgUnselectedUser">
        <thead>
          <tr>
           	<th data-options="checkbox:true,field:'ck'",></th>
			<th data-options="field:'urlName',width:80,sortable:true"><fmt:message key="url.urlName" /></th>
			<th data-options="field:'urlPattern',width:110,sortable:true"><fmt:message key="url.urlPattern" /></th>
			<th data-options="field:'httpMethod',width:60,sortable:true"><fmt:message key="url.httpMethod" /></th>
            
          </tr>
        </thead>
      </table>
      <div id="tbUnselectedUser" style="padding: 5px; height: auto">
        <form class="form-inline" style="margin: 5px;">          
          <div class="form-group">
	        <label for="surlName"><fmt:message key="url.urlName" /></label><fmt:message key="colon" /><input class="form-control" id="surlName" type="text" name="surlName" />
	      </div>      
	      <div class="form-group">
	        <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchUrls();"><fmt:message key="query" /></a>
	      </div>
        </form>
      </div>
    </div>
    <div data-options="region:'center',border:false">
      <div style="padding-top: 150px; text-align: center;">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-arrow-right',plain:'true'" onclick="moveRight();"></a>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-arrow-left',plain:'true'" onclick="moveLeft();"></a>
      </div>
    </div>
    <div data-options="region:'east'" style="width: 440px">
      <table class="easyui-datagrid" data-options="idField:'urlId',title:'<fmt:message key="selected" />',fit:true,fitColumns:true,border:false,rownumbers:true,pagination:false,singleSelect:false" id="dgSelectedUser">
        <thead>
          <tr>
            <th data-options="checkbox:true,field:'ck'",></th>
			<th data-options="field:'urlName',width:80,sortable:true"><fmt:message key="url.urlName" /></th>
			<th data-options="field:'urlPattern',width:110,sortable:true"><fmt:message key="url.urlPattern" /></th>
			<th data-options="field:'httpMethod',width:60,sortable:true"><fmt:message key="url.httpMethod" /></th>
          </tr>
        </thead>
      </table>
    </div>
  </div>