<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title><fmt:message key="roominfo.list"/></title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="${staticPath}/static/themes/default/css/main.css"/>
    <%@ include file="/WEB-INF/views/shared/easyui.jsp" %>
    <script src="${staticPath}/static/js/system/roomaudit/list.js"></script>
    <link rel="stylesheet" href="https://cache.amap.com/lbs/static/main.css"/>

</head>
<body class="easyui-layout">
<div data-options="border:false,region:'north',collapsible:true,title:'<fmt:message key="query.condition" />',iconCls:'icon-filter'"
     style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none; height: 85px;">
    <form class="form-inline" style="margin: 15px;">
        <div class="form-group">
            <label for="roomStatus">资料审核</label>
            <fmt:message key="colon"/>
            <select class="easyui-combobox myeasyui-searchParams"
                    id="roomStatus" name="roomStatus" style="width: 70px;"
                    data-options="editable:false,validType:['length[1,32]'],required:true,panelHeight:'auto'">
                <option>全部</option>
                <option>待审核</option>
                <option>已通过</option>
                <option>未通过</option>
            </select>
        </div>

        <div class="form-group">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchDic();"><fmt:message
                    key="query"/></a>
        </div>
    </form>
</div>
<div data-options="border:false,region:'center',title:'<fmt:message key="roominfo.list" />',collapsible:true,iconCls:'icon-list'"
     style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none;">
    <table data-options="pageSize:20,fit:true,fitColumns:true,border:false,rownumbers:true,pagination:true,singleSelect:false,url:'${contextPath}/system/roominfo/list', method:'get',queryParams:{dicName:$('#queryDicName').val(),dicType:$('#queryDicType').val()},toolbar:'#tbDic'"
           id="dgDic">
        <thead>
        <tr>
            <th data-options="checkbox:true,field:'dicId'"></th>
            <th data-options="field:'roomName'"><fmt:message key="roominfo.roomName"/></th>
            <th data-options="field:'roomStatus'">状态</th>
            <th data-options="field:'roomType'">房源类型</th>
            <th data-options="field:'rent'"><fmt:message key="roominfo.rent"/></th>
            <th data-options="field:'houseType'"><fmt:message key="roominfo.houseType"/></th>
            <th data-options="field:'oriented'"><fmt:message key="roominfo.oriented"/></th>
            <th data-options="field:'rentType'"><fmt:message key="roominfo.rentType"/></th>
            <th data-options="field:'roomSize'"><fmt:message key="roominfo.roomSize"/></th>
            <th data-options="field:'address'"><fmt:message key="roominfo.address"/></th>
            <th data-options="field:'images',formatter:imgFormatter"><fmt:message key="roominfo.images"/></th>
            <th data-options="field:'qrcode',formatter:qrcodeFormatter"><fmt:message key="roominfo.qrcode"/></th>
            <th data-options="hidden:'hidde',field:'indoorStructure'"><fmt:message key="roominfo.indoorStructure"/></th>
            <th data-options="hidden:'hidde',field:'colour'"><fmt:message key="roominfo.colour"/></th>
            <th data-options="hidden:'hidde',field:'detailedIntroduction'"><fmt:message key="roominfo.detailedIntroduction"/></th>
            <th data-options="hidden:'hidde',field:'paymentMethod'"><fmt:message key="roominfo.paymentMethod"/></th>
            <th data-options="hidden:'hidde',field:'buildingType'"><fmt:message key="roominfo.buildingType"/></th>
            <th data-options="hidden:'hidde',field:'administrativeArea'"><fmt:message key="roominfo.administrativeArea"/></th>
            <th data-options="hidden:'hidde',field:'indoorFacilities'"><fmt:message key="roominfo.indoorFacilities"/></th>
            <th data-options="hidden:'hidde',field:'outdoorFacilities'"><fmt:message key="roominfo.outdoorFacilities"/></th>
            <th data-options="hidden:'hidde',field:'houseAdvantage'"><fmt:message key="roominfo.houseAdvantage"/></th>
            <th data-options="hidden:'hidde',field:'visitTime'"><fmt:message key="roominfo.visitTime"/></th>
            <th data-options="hidden:'hidde',field:'floor'"><fmt:message key="roominfo.floor"/></th>
            <th data-options="hidden:'hidde',field:'publishingMethod'"><fmt:message key="roominfo.publishingMethod"/></th>
            <th data-options="hidden:'hidde',field:'windowNum'"><fmt:message key="roominfo.windowNum"/></th>
            <th data-options="hidden:'hidde',field:'parkSpace'"><fmt:message key="roominfo.parkSpace"/></th>
            <th data-options="hidden:'hidde',field:'buildYear'"><fmt:message key="roominfo.buildYear"/></th>
            <th data-options="hidden:'hidde',field:'decoration'"><fmt:message key="roominfo.decoration"/></th>
            <th data-options="hidden:'hidde',field:'publicDate'"><fmt:message key="roominfo.publicDate"/></th>
            <th data-options="hidden:'hidde',field:'updateDate'"><fmt:message key="roominfo.updateDate"/></th>
            <th data-options="hidden:'hidde',field:'communityLongitude'"><fmt:message key="roominfo.communityLongitude"/></th>
            <th data-options="hidden:'hidde',field:'communityDimension'"><fmt:message key="roominfo.communityDimension"/></th>
            <th data-options="hidden:'hidde',field:'roomLongitude'"><fmt:message key="roominfo.roomLongitude"/></th>
            <th data-options="hidden:'hidde',field:'roomDimension'"><fmt:message key="roominfo.roomDimension"/></th>
            <th data-options="hidden:'hidde',field:'houseID'"><fmt:message key="roominfo.houseID"/></th>
            <th data-options="hidden:'hidde',field:'roomID'"><fmt:message key="roominfo.houseID"/></th>

            <th data-options="hidden:'hidde',field:'roomCheck'">是否审核</th>
            <th data-options="hidden:'hidde',field:'roomCause'">原因</th>
        </tr>
        </thead>
    </table>
    <div id="tbDic" style="padding: 5px;">
        <c:if test="${currentUser.function['190902']}">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,disabled:true" id="btnEditDic"
               onclick="editDic();">审核</a>
        </c:if>
    </div>
    <div id="dlgShowDicButtons" style="display:none;">

        <c:if test="${currentUser.function['40104']}">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-file-alt',plain:true,disabled:true" id="btnShowDic"
               onclick="showDic();"><fmt:message key="detail"/></a>
        </c:if>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="closeDicDetailDialog();"><fmt:message
                key="cancel"/></a>
    </div>
</div>
<script>
    $('#cc').combobox({
        groupFormatter: function(group){
            return '<span style="color:red">' + group + '</span>';
        }
    });

    var img_jpg="jpg".toLocaleLowerCase();
    var img_png="png".toLocaleLowerCase();
    var img_gif="gif".toLocaleLowerCase();
    function imgFormatter(value,row,index){
        var url="";
        if(value.indexOf(",")!=-1){
            var str=[];
            str=value.split(",");
            for(var i=0;i<str.length;i++){
                var format=str[i].substring(str[i].length-3);
                var format_temp=format.toLocaleLowerCase();
                if(format_temp==img_jpg||format_temp==img_png||format_temp==img_gif){
                    url += '<img style="margin-left: 10px;width:60px; height:60px" src="http://119.3.191.53/maphouse/images/' +row.roomID+ '/' + str[i] + '">'
                }
            }
        }
        else {
            var format=value.substring(value.length-3);
            console.log(format);
            if(format==1){
                url += '<input style="height: 60px;width: 0px;border: none;">'
            }
            var format_temp=format.toLocaleLowerCase();
            if(format_temp==img_jpg||format_temp==img_png||format_temp==img_gif){
                url += '<img style="width:60px; height:60px;margin-left: 10px;" src="http://119.3.191.53/maphouse/images/' +row.roomID+ '/' + value + '">'
            }
        }
        return  url;
    }
    function qrcodeFormatter (value,row,index) {
        var url = "";
        var format = value.substring(value.length - 3);
        var format_temp=format.toLowerCase();
        if (format_temp==img_jpg||format_temp==img_png||format_temp==img_gif) {
            url = '<img style="width:60px; height:60px" src="http://119.3.191.53/maphouse/qrcode/' + row.roomID + '/' + value + '">'
        }
        return  url;
    }

</script>
</body>
</html>