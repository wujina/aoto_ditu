<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
<script src="${staticPath}/static/js/system/user/select.js"></script>
  <div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west'" style="width: 540px">
      <table class="easyui-datagrid" data-options="idField:'userId',title:'<fmt:message key="unselected" />',url:'${contextPath}/system/users/excepted',method:'get',pageSize:10,fit:true,fitColumns:true,border:false,rownumbers:true,pagination:true,singleSelect:false,toolbar:'#tbUnselectedUser'" id="dgUnselectedUser">
        <thead>
          <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'username'"><fmt:message key="user.username" /></th>
            <th data-options="field:'realName',width:80"><fmt:message key="user.realName" /></th>
            <th data-options="field:'orgName',width:100"><fmt:message key="org.orgName" /></th>
          </tr>
        </thead>
      </table>
      <div id="tbUnselectedUser" style="padding: 5px; height: auto">
        <form class="form-inline" style="margin: 5px;">
          <div class="form-group">
            <label for="uname"><fmt:message key="user.username" /></label>
            <fmt:message key="colon" />
            <input class="form-control" id="suname" type="text" name="suname" style="width: 80px" />
          </div>
          <div class="form-group">
            <label for="oname"><fmt:message key="org.orgName" /></label>
            <fmt:message key="colon" />
            <input class="form-control" id="soname" name="soname" value="${currentUser.inheritedName}" readonly onclick="selectOrg(this);" style="width: 80px" /> <input id="soid" name="soid" type="hidden" value="${currentUser.orgId}" /> <label class="control-label"> <input class="checkbox" type="checkbox" id="scontainSub" name="scontainSub" checked /> <fmt:message key="org.containSub" />
            </label> <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchUsers();"><fmt:message key="query" /></a>
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
    <div data-options="region:'east'" style="width: 320px">
      <table class="easyui-datagrid" data-options="idField:'userId',title:'<fmt:message key="selected" />',fit:true,fitColumns:true,border:false,rownumbers:true,pagination:false,singleSelect:false" id="dgSelectedUser">
        <thead>
          <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'realName',width:80"><fmt:message key="user.realName" /></th>
            <th data-options="field:'orgName',width:100"><fmt:message key="org.orgName" /></th>
          </tr>
        </thead>
      </table>
    </div>
  </div>