<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="user.title" /></title>
<meta charset="utf-8"/>
<link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css" />
<%@ include file="/WEB-INF/views/shared/easyui.jsp"%>
<script>
/*
    function removeUsers()
    {
        var rows = $("#dgOnlineUser").datagrid("getSelections");

        if (0 == rows.length)
        {
            $.messager.alert("<fmt:message key='messager.warning' />", "<fmt:message key='row.selectRowToDelete' />", "warning");
            return;
        }
        
        var list = [];
        
        if (null != rows)
        {
            $.each(rows, function(index, item)
            {
                list.push(item.userId);
            });
        }

        $.messager.confirm("<fmt:message key='messager.warning' />", "确定要踢出系统吗？", function(r)
        {
            if (r)
            {
                url = "<c:url value='/system/users/online?_method=delete' />";

                $.ajax(
                {
                    url : url,
                    type : "POST",
                    datatype : "json",
                    contentType : "application/json; charset=utf-8",
                    data : $.toJSON(list),
                    success : function(result)
                    {
                        $.messager.alert("<fmt:message key='messager.info' />", "<fmt:message key='submit.success' />", "info");
                    }
                });
            }
        });
    }
*/
</script>
</head>
<body class="easyui-layout">
<%--   <div data-options="border:false,region:'north',collapsible:true,title:'查询条件',iconCls:'icon-filter'" style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none; height: 80px;">
    <div style="padding: 10px; background: #F4F4F4;">
      <label for='uname'>用户名：</label><input id="uname" type="text" name="uname" /> 
      <label for='oname'>组织：</label><input id='oname' name='oname' value='${currentUser.orgName}' readonly='true' onclick="javascript:selectOrg('oid','oname');" /><input id='oid' name='oid' type='hidden' value='${currentUser.orgId}' />
      <a onclick="javascript:searchUser();" class="easyui-linkbutton" iconCls="icon-search">查询</a>
    </div>
  </div> --%>
  <div data-options="border:false,region:'center',title:'<fmt:message key="user.online.list" />',collapsible:true,iconCls:'icon-list'" style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none;">
    <table id="dgOnlineUser" class="easyui-datagrid" data-options="pageSize:20,fit:true,fitColumns:true,border:false,rownumbers:true,pagination:true,singleSelect:false,url : '${contextPath}/system/users/online', method : 'get'">
      <thead>
        <tr>
          <th data-options="field:'username',width:100,sortable:true"><fmt:message key="user.username" /></th>
          <th data-options="field:'realName',width:100"><fmt:message key="user.realName" /></th>
          <th data-options="field:'inheritedName',width:150"><fmt:message key="org.orgName" /></th>
          <th data-options="field:'lastLoginDate',width:140,formatter:formatDate"><fmt:message key="user.lastLoginDate" /></th>
          <th data-options="field:'lastLoginIp',width:100"><fmt:message key="user.lastLoginIp" /></th>
        </tr>
      </thead>
    </table>
<%--     <div id="tbUser" style="padding: 5px; height: auto">
      <div style="margin-bottom: 5px">
        <a onclick="javascript:removeUsers();" class="easyui-linkbutton" title="踢出用户" iconCls="icon-remove" plain="true">踢出</a> 
      </div>
    </div> --%>
  </div>
</body>
</html>