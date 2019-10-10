<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="label.list"/></title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css"/>
    <%@ include file="/WEB-INF/views/shared/easyui.jsp" %>
    <script src="${staticPath}/static/js/system/label/list.js"></script>
</head>
<body class="easyui-layout">
<div data-options="border:false,region:'north',collapsible:true,title:'<fmt:message key="query.condition" />',iconCls:'icon-filter'"
     style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none; height: 85px;">
    <form class="form-inline" style="margin: 15px;">
        <div class="form-group">
            <label for="labelName">标签分类</label>
            <fmt:message key="colon"/>
            <select class="easyui-combobox myeasyui-searchParams"
                    id="labelName" name="labelName" style="width: 185px;"
                    data-options="editable:false,validType:['length[1,32]'],required:true,panelHeight:'auto'">
                <option>全部</option>
                <option>房屋优势标签</option>
                <option>室内设置标签</option>
                <option>室外设置标签</option>
            </select>
        </div>

        <div class="form-group">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchDic();"><fmt:message
                    key="query"/></a>
        </div>
    </form>
</div>
<div data-options="border:false,region:'center',title:'<fmt:message key="label.list" />',collapsible:true,iconCls:'icon-list'"
     style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none;">
    <table data-options="idField : 'id',pageSize:20,fit:true,fitColumns:true,border:false,rownumbers:true,pagination:true,singleSelect:false,url:'${contextPath}/system/label/list', method:'get',queryParams:{labelName:$('#labelName').val()},toolbar:'#tbDic'"
           id="dgDic">
        <thead>
        <tr>
            <th data-options="checkbox:true,field:'id'"></th>
            <th data-options="field:'labelName',
            formatter : function(value,row,index){
                    if(value=='houseAdvantage')
                    {return '房屋优势'}
                    else if(value=='indoorFacilities')
                    {return '室内标签'}
                    else if(value=='outdoorFacilities')
                    {return '室外标签'}
                  } ">标签类型</th>
            <th data-options="field:'labelValue'">标签名称</th>
        </tr>
        </thead>
    </table>
    <div id="tbDic" style="padding: 5px;">
        <c:if test="${currentUser.function['190801']}">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-plus',plain:true" id="btnNewDic"
               onclick="newUrl();"><fmt:message key="new"/></a>
        </c:if>
        <c:if test="${currentUser.function['190802']}">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true,disabled:true" id="btnRemoveDic"
               onclick="removeDic();"><fmt:message key="remove"/></a>
        </c:if>
    </div>
    <div id="dlgShowDicButtons" style="display:none;">
        <c:if test="${currentUser.function['190803']}">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="editDicFromDetail();"><fmt:message
                    key="edit"/></a>
        </c:if>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="closeDicDetailDialog();"><fmt:message
                key="cancel"/></a>
    </div>
</div>

</body>
</html>