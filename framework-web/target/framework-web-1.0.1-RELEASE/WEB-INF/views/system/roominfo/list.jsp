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
    <script src="${staticPath}/static/js/system/roominfo/list.js"></script>

    <link rel="stylesheet" href="https://cache.amap.com/lbs/static/main.css"/>
    <script type="text/javascript"
            src="https://webapi.amap.com/maps?v=1.4.15&key=1534b46bfef450bfc9227a82b85da13e"></script>

    <link rel="stylesheet" href="${staticPath}/static/js/system/roominfo/css/plat.css"/>
    <link href="${staticPath}/static/js/system/roominfo/css/common.css" type="text/css" rel="stylesheet"/>
    <link href="${staticPath}/static/js/system/roominfo/css/index.css" type="text/css" rel="stylesheet"/>
</head>
<body class="easyui-layout">
<div data-options="border:false,region:'north',collapsible:true,title:'<fmt:message key="query.condition" />',iconCls:'icon-filter'"
     style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none; height: 85px;">
    <form class="form-inline" style="margin: 15px;">
        <div class="form-group">
            <label for="administrativeArea"><fmt:message key="roominfo.administrativeArea" /></label>
            <fmt:message key="colon"/>
            <div class="form-group" test="${currentUser.function['190708']}">
                <select id="administrativeArea" >
                <option value="请选择">请选择</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="roomType">小区：</label>
            <div class="form-group" test="${currentUser.function['190709']}">
                <select id="community" style="width: 200px;">
                    <option value="请选择">请选择</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="roomType">房源类型：</label>
                <select id="roomType" style="width: 100px;" class="easyui-combobox myeasyui-searchParams"
                        data-options="editable:false,validType:['length[1,32]'],required:true,panelHeight:'auto'">
                    <option value="请选择">请选择</option>
                    <option value="共享房源">共享房源</option>
                    <option value="优质品牌房源">优质品牌房源</option>
                    <option value="老年公寓">老年公寓</option>
                </select>
        </div>

        <div class="form-group">
            <label for="roomName"><fmt:message key="roominfo.name" /></label>
            <fmt:message key="colon"/>

            <input style="width:150px;" id="roomName" name="roomName"/>
        </div>

        <div class="form-group">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="searchDic();"><fmt:message
                    key="query"/></a>
        </div>
    </form>
</div>
<div data-options="border:false,region:'center',title:'<fmt:message key="roominfo.list" />',collapsible:true,iconCls:'icon-list'"
     style="border: 1px solid #95B8E7; background: #F4F4F4; border-left: none; border-right: none; border-top: none;">

    <table data-options="pageSize:20,fit:true,fitColumns:true,border:false,rownumbers:true,pagination:true,singleSelect:false,url:'${contextPath}/system/roominfo/list', method:'get',queryParams:{administrativeArea:$('#administrativeArea').val(),roomType:$('#roomType').val(),roomName:$('#roomName').val()},toolbar:'#tbDic'"
           id="dgDic">
        <thead>
        <tr id="roomlist_tr">
            <th data-options="checkbox:true,field:'roomID'"></th>
            <th data-options="field:'roomName'"><fmt:message key="roominfo.roomName"/></th>
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
            <th data-options="hidden:'hidde',field:'roomStatus'"></th>
            <th data-options="hidden:'hidde',field:'roomCheck'"></th>
            <th data-options="hidden:'hidde',field:'roomCause'"></th>
            <th data-options="hidden:'hidde',field:'houseID'"></th>
        </tr>
        </thead>
    </table>
    <div id="tbDic" style="padding: 5px;">
        <c:if test="${currentUser.function['190704']}">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-plus',plain:true" id="btnNewDic"
               onclick="newRoominfo();"><fmt:message key="new"/></a>
        </c:if>
        <c:if test="${currentUser.function['190703']}">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,disabled:true" id="btnEditDic"
               onclick="editDic();"><fmt:message key="edit"/></a>
        </c:if>
        <c:if test="${currentUser.function['190702']}">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true,disabled:true" id="btnRemoveDic"
               onclick="removeDic();"><fmt:message key="remove"/></a>
        </c:if>
        <c:if test="${currentUser.function['190707']}">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-file-alt',plain:true,disabled:true" id="btnShowDic"
               onclick="showDic();"><fmt:message key="detail"/></a>
        </c:if>
        <c:if test="${currentUser.function['190705']}">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-signin',plain:true" id="btnImportOrg" onclick="importExcel();"><fmt:message key="import" /></a>
        </c:if>

        <c:if test="${currentUser.function['190706']}">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-signout',plain:true" id="btnExportOrg" onclick="exportExcel()">下载模板</a>
        </c:if>

    </div>
    <div id="dlgShowDicButtons" style="display:none;">
        <c:if test="${currentUser.function['40102']}">
            <a class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="editDicFromDetail();"><fmt:message
                    key="edit"/></a>
        </c:if>
        <a class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onclick="closeDicDetailDialog();"><fmt:message
                key="cancel"/></a>
    </div>
</div>

<script>
    //select 的change事件用了获取下拉列表的值
    $(document).on("change","#administrativeArea",function(){
        //获取选择的值
        var condition = $(this).val();
        //其他操作
    });

    $(document).on("change","#community",function(){
        //获取选择的值
        var condition = $(this).val();
        //其他操作
    });

    function initCommunity() {
        console.log("123");
        var url=contextPath + "/system/roominfo/community";
        $.ajax({
            url: url,
            type : "POST",
            dataType : "json",
            contentType : "application/json",
            success : function(datas)
            {
                var optionstring = "";
                $("#community").empty();
                var temp="<option >请选择</option>";
                $("#community").append(temp);
                for (var i=0;i<datas.length;i++){
                    optionstring = "<option value=\"" + datas[i] + "\" >" +datas[i]+" " + "</option>";

                    $("#community").append(optionstring);
                }
            },
            error: function (msg) {
                console.log('数据出错了!!');
            }
        });
    }

    function initadministrativeArea () {
        console.log("123");
        var url=contextPath + "/system/roominfo/istrative";
        $.ajax({
            url: url,
            type : "POST",
            dataType : "json",
            contentType : "application/json",
            success : function(datas)
            {
                var optionstring = "";
                $("#administrativeArea").empty();
                var temp="<option >请选择</option>";
                $("#administrativeArea").append(temp);
                for (var i=0;i<datas.length;i++){
                    optionstring = "<option value=\"" + datas[i] + "\" >" +datas[i]+" " + "</option>";

                    $("#administrativeArea").append(optionstring);
                }
            },
            error: function (msg) {
                console.log('数据出错了!!');
            }
        });
    }

    $(function() {
        initadministrativeArea();
        initCommunity();
    })

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
                if(i>4){
                    if(format_temp==img_jpg||format_temp==img_png||format_temp==img_gif){
                        url += '<img style="margin-left: 10px;width:60px; height:60px;display: none" src="http://119.3.191.53/maphouse/images/' +row.roomID+ '/' + str[i] + '">'
                    }
                }
                else {
                    if(format_temp==img_jpg||format_temp==img_png||format_temp==img_gif){
                        url += '<img style="margin-left: 10px;width:60px; height:60px" src="http://119.3.191.53/maphouse/images/' +row.roomID+ '/' + str[i] + '">'
                    }
                }
            }
        }
        else {

            var format=value.substring(value.length-3);

            if(format==1||format==null||format==0){
                url += '<input style="height: 60px;width: 0px;border: none;">'
            }
            var format_temp=format.toLocaleLowerCase();
            if(format_temp==img_jpg||format_temp==img_png||format_temp==img_gif){
                url += '<img style="margin-left: 10px;width:60px; height:60px" src="http://119.3.191.53/maphouse/images/' +row.roomID+ '/' + value + '">'
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
<style type="text/css">

    #roomlist_tr{
        height: 60px;
    }
</style>
</body>
</html>