<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table class="easyui-datagrid" data-options="fit:true,fitColumns:true,border:true,rownumbers:true,pagination:false,singleSelect:false" id="dgShowDataLog">
  <thead>
    <tr>
      <th data-options="field:'tableName', width:100"><fmt:message key="log.data.tableName" /></th>
      <th data-options="field:'keyValue',width:50"><fmt:message key="log.data.keyValue" /></th>
      <th data-options="field:'columnName',width:150"><fmt:message key="log.data.columnName" /></th>
      <th data-options="field:'oldValue',width:150"><fmt:message key="log.data.oldValue" /></th>
      <th data-options="field:'newValue',width:150"><fmt:message key="log.data.newValue" /></th>
    </tr>
  <tbody>
    <c:forEach items="${logs}" var="l">
      <tr>
        <td>${l.tableName}</td>
        <td>${l.keyValue}</td>
        <td>${l.columnName}</td>
        <td>${l.oldValue}</td>
        <td>${l.newValue}</td>
      </tr>
    </c:forEach>
  </tbody>
  </thead>
</table>
