<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css" />
<%@ include file="/WEB-INF/views/shared/easyui.jsp"%>
<script src="${staticPath}/static/js/system/org/select.js"></script>
<script src="${staticPath}/static/js/system/log/behavior.js"></script>
</head>
<body class="easyui-layout">
  <div data-options="border:false,region:'north',collapsible:true,title:'<fmt:message key="query.condition" />',iconCls:'icon-filter'" style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none; height: 85px;">
    <form class="form-inline" style="margin: 15px;" id="seachFrom">
      <div class="form-group">
        <label for="uname"><fmt:message key="user.username" /> <fmt:message key="colon" /></label> <input class="form-control" id="uname" type="text" name="uname" />
      </div>
      <div class="form-group">
        <label for="oname"><fmt:message key="org.orgName" /> <fmt:message key="colon" /></label> <input class="form-control" id="oname" name="oname" value="${currentUser.orgName}" readonly onclick="selectOrg(this);" /> <input id="oid" name="oid" type="hidden" value="${currentUser.orgId}" /> <label class="control-label"> <input class="checkbox" type="checkbox" id="containSub" name="containSub" checked /> <fmt:message key="org.containSub" /></label>
      </div>
      <div class="form-group">
        <label class="control-label"><input class="checkbox" type="checkbox" id="dataChanged" name="dataChanged" /> <fmt:message key="log.data.onlyDataChanged" /></label>
      </div>
      <div class="form-group">
        <label><fmt:message key="log.behavior.loggedDate" /> <fmt:message key="colon" /></label> 
        <input class="easyui-datebox" data-options="width:100,editable:false,value:'${beginDate}',validType:{date:null}" id="beginDate" name="beginDate" type="text" />
        <fmt:message key="to" />
        <input class="easyui-datebox" data-options="width:100,editable:false,value:'${endDate}',validType:{date:null,compareDate:['beginDate','endDate']}" id="endDate" name="endDate" type="text" />
      </div>
      <div class="form-group">
        <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchBehaviorLogs();"><fmt:message key="query" /></a>
      </div>
    </form>
  </div>
  <div data-options="border:false,region:'center',title:'<fmt:message key="log.behavior.list" />',collapsible:true,iconCls:'icon-list'" style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none;">
    <table id="dgBehaviorLog" data-options="toolbar:'#tbBehaviorLog',pageSize:20,fit:true,fitColumns:true,border:false,rownumbers:true,pagination:true,singleSelect:true,url : '${contextPath}/system/logs/behavior', method : 'get',queryParams:{username:$('#uname').val(),orgId:$('#oid').val(),containSub:$('#containSub').is(':checked'),dataChanged:$('#dataChanged').is(':checked'),beginDate:$('#beginDate').datebox('getValue'),endDate:$('#endDate').datebox('getValue')}">
      <thead>
        <tr>
          <th data-options="field:'dataChanged',width:20,formatter:formatDataChanged"></th>
          <th data-options="field:'username',width:80"><fmt:message key="user.username" /></th>
          <th data-options="field:'realName',width:80"><fmt:message key="user.realName" /></th>
          <th data-options="field:'inheritedName',width:150"><fmt:message key="org.orgName" /></th>
          <th data-options="field:'ip'"><fmt:message key="log.login.ip" /></th>
          <th data-options="field:'loggedDate',width:100,formatter:formatDate"><fmt:message key="log.behavior.loggedDate" /></th>
          <th data-options="field:'action',width:400"><fmt:message key="log.behavior.action" /></th>    
        </tr>
      </thead>
    </table>
    <div id="tbBehaviorLog" style="padding: 5px;">
      <a class="easyui-linkbutton" data-options="iconCls:'icon-detail',plain:true,disabled:true" id="btnShowDataLog" onclick="showDataLog();"><fmt:message key="log.behavior.showDataChanged" /></a>
    </div>
  </div>
</body>
</html>