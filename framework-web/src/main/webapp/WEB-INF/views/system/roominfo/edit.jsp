<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no, width=device-width">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="roominfo.list"/></title>
    <meta charset="utf-8"/>
</head>
<body>

<div id="mapContainer_edit"></div>
<div id="tip_edit">
    <input type="text" id="keyword_edit" name="keyword_edit" value="请输入关键字：(选定后搜索)" onfocus='this.value=""'/>
</div>
<form   id="uploadForm_edit" enctype="multipart/form-data"  class="form-grid">
    <div style="Overflow-y:scroll;height: 407px;">
    <div class="title">
        房源编辑
    </div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="roomName"><fmt:message key="roominfo.roomName" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <input style="width: 112%;" id="roomName_edit" class="easyui-validatebox form-control" maxlength="32"
                       data-options="required:true,validType:['roomName'],novalidate:true"
                       name="roomName" />
            </div>
            <div class="col-1">
            </div>

            <div class="col-2 control-label">
                <label for="community"><fmt:message key="roominfo.community" /><fmt:message key="colon" />
                </label>
            </div>
            <div class="col-2">
                <input style="width: 112%;" id="community_edit" class="easyui-validatebox form-control" maxlength="32"
                       data-options="required:true,validType:['community'],novalidate:true"
                       name="community" />
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="rent"><fmt:message key="roominfo.rent" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <input style="width: 112%;" class="easyui-validatebox form-control" maxlength="32"
                       data-options="required:true,validType:'number',novalidate:true"
                       name="rent"  />
            </div>
            <div class="col-1">
            </div>
            <div class="col-2 control-label">
                <label for="houseType"><fmt:message key="roominfo.houseType" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        name="houseType" style="width: 82px;"
                        data-options="required:true,editable:true,validType:['houseType'],panelHeight:'auto'">
                    <option value="1室0厅1卫">1室0厅1卫</option>
                    <option value="1室1厅1卫">1室1厅1卫</option>
                    <option value="2室1厅1卫">2室1厅1卫</option>
                    <option value="2室2厅1卫">2室2厅1卫</option>
                    <option value="3室1厅1卫">3室1厅1卫</option>
                    <option value="3室2厅1卫">3室2厅1卫</option>
                    <option value="3室3厅1卫">3室3厅1卫</option>
                    <option value="3室2厅2卫">3室2厅2卫</option>
                    <option value="3室3厅2卫">3室3厅2卫</option>
                    <option value="4室1厅1卫">4室1厅1卫</option>
                    <option value="4室2厅1卫">4室2厅1卫</option>
                    <option value="4室3厅1卫">4室3厅1卫</option>
                    <option value="4室3厅2卫">4室3厅2卫</option>
                    <option value="4室4厅3卫">4室4厅3卫</option>
                </select>
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="oriented"><fmt:message key="roominfo.oriented" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        name="oriented" style="width: 82px;"
                        data-options="editable:false,validType:['oriented'],required:true,panelHeight:'auto'">
                    <option value="东">东</option>
                    <option value="南">南</option>
                    <option value="西">西</option>
                    <option value="北">北</option>
                    <option value="东南">东南</option>
                    <option value="西南">西南</option>
                    <option value="东北">东北</option>
                    <option value="西北">西北</option>
                </select>
            </div>
            <div class="col-1"></div>

            <div class="col-2 control-label">
                <label for="rentType"><fmt:message key="roominfo.rentType" /></span><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        name="rentType" style="width: 82px;"
                        data-options="editable:false,validType:['rentType'],required:true,panelHeight:'auto'">
                    <option value="整租">整租</option>
                    <option value="合租">合租</option>
                </select>
            </div>
        </div>
        <div style="height: 20px;"></div>


        <div class="form-group">
            <div class="col-2 control-label">
                <label for="roomSize"><fmt:message key="roominfo.roomSize" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <input style="width: 112%;" class="easyui-validatebox form-control" maxlength="32"
                       data-options="required:false,validType:'number',novalidate:true"
                       name="roomSize"  value="0.00"/>
            </div>
            <div class="col-1"></div>

            <div class="col-2 control-label">
                <label for="buildingType"><fmt:message key="roominfo.buildingType" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        name="buildingType" style="width: 82px;"
                        data-options="editable:false,validType:['buildingType'],required:true,panelHeight:'auto'">
                    <option value="低层住宅">低层住宅</option>
                    <option value="多层住宅">多层住宅</option>
                    <option value="小高层住宅">小高层住宅</option>
                    <option value="高层住宅">高层住宅</option>
                </select>
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="paymentMethod"><fmt:message key="roominfo.paymentMethod" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        name="paymentMethod" style="width: 82px;"
                        data-options="editable:false,validType:['buildingType'],required:true,panelHeight:'auto'">
                    <option value="无抵押 月付">无抵押 月付</option>
                    <option value="押一付一(月付)">押一付一(月付)</option>
                    <option value="押一付三(季付)">押一付三(季付)</option>
                    <option value="押一付六(半年付)">押一付六(半年付)</option>
                    <option value="无抵押 年付">无抵押 年付</option>
                </select>
            </div>
            <div class="col-1"></div>

            <div class="col-2 control-label">
                <label for="indoorStructure"><fmt:message key="roominfo.indoorStructure" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        name="indoorStructure" style="width: 82px;"
                        data-options="required:true,editable:true,validType:['indoorStructure'],panelHeight:'auto'">
                    <option value="平层">平层</option>
                    <option value="复式">复式</option>
                    <option value="跃层">跃层</option>
                </select>
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="address"><fmt:message key="roominfo.address" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-7" style="width: 60.3%;">
                <input id="address_edit" class="easyui-validatebox form-control"  maxlength="32"  name="address" ></input>
            </div>
        </div>
        <div style="height: 20px;"></div>


        <div class="form-group">
            <div class="col-2 control-label">
                <label for="detailedIntroduction"><fmt:message key="roominfo.detailedIntroduction" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-6">
                <textarea rows="5" cols="35"  name="detailedIntroduction" />
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">

                <label for="colour"><fmt:message key="roominfo.colour" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-1">
                <select class="easyui-combobox myeasyui-searchParams"
                        id="colour" name="colour" style="width: 152px;"
                        data-options="editable:false,validType:['colour'],required:true,panelHeight:'auto'">
                    <option value="1">橘黄色</option>
                    <option value="2">深蓝色</option>
                    <option value="3">粉红色</option>
                    <option value="4">浅蓝色</option>
                    <option value="5">深绿色</option>
                    <option value="6">浅绿色</option>
                </select>
            </div>
        </div>
        <div style="height: 20px;"></div>
        <div class="form-group">
            <div class="col-2 control-label">
                <label for="indoorFacilities"><fmt:message key="roominfo.indoorFacilities" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-9" id="indoor_div_edit">

            </div>
            <div class="col-1"></div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="outdoorFacilities"><fmt:message key="roominfo.outdoorFacilities" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-9" id="outdoor_div_edit">

            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="houseAdvantage"><fmt:message key="roominfo.houseAdvantage" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-9" id="house_div_edit">

            </div>
            <div class="col-1"></div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group" >
            <div class="col-2 control-label">
                <label for="images"><fmt:message key="roominfo.images" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-10" id="img_upload" style="width: 78%">

                <input  style="width: 73px;position:relative;margin-left: 100px;" onchange="previewImage_edit(this)" type="file" id="file1_edit"  name="file1_edit"   multiple="multiple" accept="image/png, image/jpeg, image/gif, image/jpg"/>
                <div id="upload_name"></div>
                <input  type="hidden" class="easyui-textbox form-control"  name="images" id="images_edit">
                <div id="list_images"></div>
                <div id="add_img" style="float: left"></div>
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group" style="height: 90px;">
            <div class="col-2 control-label"style="line-height: 90px;">
                <label for="qrcode"><fmt:message key="roominfo.qrcode" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2" id="qrcode_upload">

                <input style="position: relative;margin-left: 100px;" onchange="previewQrcode_edit(this)" type="file" name="file2_edit" id="file2_edit"   accept="image/png, image/jpeg, image/gif, image/jpg/">

                <input type="hidden" class="easyui-textbox form-control"  name="qrcode" id="qrcode_edit">
            </div>
        </div>
        <div style="height: 20px;"></div>


        <div class="form-group">
            <div class="col-2 control-label">
                <label for="visitTime"><fmt:message key="roominfo.visitTime" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        name="visitTime" style="width: 82px;"
                        data-options="editable:false,validType:['length[1,32]'],required:false,panelHeight:'auto'">
                    <option value="随时">随时</option>
                    <option value="周一至周五">周一至周五</option>
                    <option value="周末">周末</option>
                </select>
            </div>
            <div class="col-1"></div>
            <div class="col-2 control-label">
                <label for="windowNum"><fmt:message key="roominfo.windowNum" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input style="width: 112%;" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="windowNum"  value="0"/>
            </div>
            <div class="col-1"></div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="floor"><fmt:message key="roominfo.floor" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        name="floor" style="width: 82px;"
                        data-options="editable:false,validType:['length[1,32]'],required:false,panelHeight:'auto'">
                    <option value="6层以下">6层以下</option>
                    <option value="6-12层">6-12层</option>
                    <option value="12层以上">12层以上</option>
                </select>
            </div>
            <div class="col-1"></div>
            <div class="col-2 control-label">
                <label for="publishingMethod"><fmt:message key="roominfo.publishingMethod" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        name="publishingMethod" style="width: 82px;"
                        data-options="editable:true,validType:['length[1,32]'],panelHeight:'auto'">
                    <option value="个人房源">个人房源</option>
                    <option value="经济人房源">经济人房源</option>
                </select>

            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="parkSpace"><fmt:message key="roominfo.parkSpace" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        name="parkSpace" style="width: 82px;"
                        data-options="editable:false,validType:['length[1,32]'],required:false,panelHeight:'auto'">
                    <option value="地上停车位">地上停车位</option>
                    <option value="无约定的地下停车位">无约定的地下停车位</option>
                    <option value="已被公摊的地下车位">已被公摊的地下车位</option>
                    <option value="人防工程">人防工程</option>
                    <option value="产权车位">产权车位</option>
                </select>
            </div>
            <div class="col-1"></div>
            <div class="col-2 control-label">
                <label for="buildYear"><fmt:message key="roominfo.buildYear" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input style="width: 112%;" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="buildYear"  value="0" />
            </div>
        </div>
        <div style="height: 20px;"></div>


        <div class="form-group">
            <div class="col-2 control-label">
                <label for="decoration"><fmt:message key="roominfo.decoration" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        name="decoration" style="width: 82px;"
                        data-options="editable:false,validType:['length[1,32]'],required:false,panelHeight:'auto'">
                    <option value="毛坯">毛坯</option>
                    <option value="普通装修">普通装修</option>
                    <option value="豪华装修">豪华装修</option>
                    <option value="精装修">精装修</option>
                </select>
            </div>
            <div class="col-1"></div>
            <div class="col-2 control-label">
                <label for="roomType">房源类型：</label>
            </div>

            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        id="roomType" name="roomType" style="width: 82px;"
                        data-options="editable:false,validType:['length[1,32]'],required:true,panelHeight:'auto'">
                    <option value="共享房源">共享房源</option>
                    <option value="优质品牌房源">优质品牌房源</option>
                    <option value="老年公寓">老年公寓</option>
                </select>
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="houseID"><fmt:message key="roominfo.houseID" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">

                <input style="width: 112%;" class="easyui-textbox form-control"  name="houseID" />
            </div>
            <div class="col-1"></div>
            <div class="col-2 control-label">
                <label for="administrativeArea"><fmt:message key="roominfo.administrativeArea" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input style="width: 112%;" id="administrativeArea_edit" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['administrativeArea'],novalidate:true" name="administrativeArea" />
            </div>
            <div class="col-1"></div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="communityLongitude"><fmt:message key="roominfo.communityLongitude" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input style="width: 112%;" id="communityLongitude_edit" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="communityLongitude" />
            </div>
            <div class="col-1"></div>
            <div class="col-2 control-label">
                <label for="communityDimension"><fmt:message key="roominfo.communityDimension" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input style="width: 112%;" id="communityDimension_edit" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="communityDimension" />
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="roomLongitude"><fmt:message key="roominfo.roomLongitude" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input style="width: 112%;" id="roomLongitude_edit" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="roomLongitude" />
            </div>
            <div class="col-1"></div>
            <div class="col-2 control-label">
                <label for="roomDimension">房源维度：</label>
            </div>
            <div class="col-2">
                <input style="width: 112%;" id="roomDimension_edit" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="roomDimension" />
            </div>
        </div>
        <div style="height: 20px;"></div>
    </div>
    <input name="roomStatus" type="hidden">
    <input name="roomCheck" type="hidden">
    <input name="roomCause" type="hidden">

    <input name="roomID" type="hidden" id="roomID_edit">
    <input name="delete_img" type="hidden" id="delete_img">
    <input type="hidden" class="easyui-validatebox form-control" maxlength="32"  name="indoorFacilities" id="indoorFacilities_edit"/>
    <input type="hidden" class="easyui-validatebox form-control" maxlength="32"  name="outdoorFacilities" id="outdoorFacilities_edit"/>
    <input type="hidden" class="easyui-validatebox form-control" maxlength="32" name="houseAdvantage" id="houseAdvantage_edit"/>
</form>

<script type="text/javascript">
    var windowsArr = [];
    var marker = [];
    var map = new AMap.Map("mapContainer_edit", {
        resizeEnable: true,
        center: [116.397428, 39.90923],//地图中心点
        zoom: 13,//地图显示的缩放级别
        keyboardEnable: false
    });
    AMap.plugin(['AMap.Autocomplete','AMap.PlaceSearch'],function(){
        var autoOptions = {
            city: "北京", //城市，默认全国
            input: "keyword_edit"//使用联想输入的input的id
        };
        autocomplete= new AMap.Autocomplete(autoOptions);
        var placeSearch = new AMap.PlaceSearch({
            city:'北京',
            map:map
        })
        AMap.event.addListener(autocomplete, "select", function(e){
            //TODO 针对选中的poi实现自己的功能
            console.log(e);
            document.getElementById("communityLongitude_edit").value = e.poi.location.lng;
            document.getElementById("communityDimension_edit").value = e.poi.location.lat;
            document.getElementById("community_edit").value = e.poi.name;


            placeSearch.setCity(e.poi.adcode);
            placeSearch.search(e.poi.name);

        });
        AMap.event.addListener(placeSearch, "markerClick", function(e){
            console.log(e);
            var address=e.data.pname+e.data.cityname+e.data.adname+e.data.address+e.data.name;

            document.getElementById("roomName_edit").value = e.data.name;
            document.getElementById("address_edit").value = address;
            document.getElementById("administrativeArea_edit").value = e.data.adname;
            document.getElementById("roomLongitude_edit").value = e.data.location.lng;
            document.getElementById("roomDimension_edit").value = e.data.location.lat;
            }
        );
    });
</script>
<style type="text/css">
    body {
        font-size: 12px;
    }
    #tip_edit {
        z-index: 99;
        background-color: #ddf;
        color: #333;
        border: 1px solid silver;
        box-shadow: 3px 4px 3px 0px silver;
        position: absolute;
        right: 480px;
        top:40px;
        border-radius: 5px;
        overflow: hidden;
        line-height: 20px;
        width: 172px;
    }
    #tip_edit input[type="text"] {
        height: 25px;
        border: 0;
        padding-left: 5px;
        width: 165px;
        border-radius: 3px;
        outline: none;
        margin-left: 7px;
    }
    .amap-sug-result{
        z-index: 99999;
    }
    #mapContainer_edit{
        width: 500px;
        height: 500px;
        z-index: 99;
        left: -15px;
        top: -15px;
        float: left;
    }
    #uploadForm_edit{
        width: 457px;
        position: absolute;
        left: 495px;
    }
</style>
<script type="text/javascript" src="https://webapi.amap.com/demos/js/liteToolbar.js"></script>
<script>
    $.extend($.fn.validatebox.defaults.rules,{
        number:{// 验证数字
            validator : function(value) {
                return /^[0-9]{1,9}$/gi.test(value);
            },
            message : '只允许1-9位的正整数'
        }
    });
    function initLabelEdit() {
        $("input").remove(".indoor_edit");
        $("p").remove(".indoor_edit");
        $("input").remove(".outdoor_edit");
        $("p").remove(".outdoor_edit");
        $("input").remove(".houseAd_edit");
        $("span").remove(".houseAd_edit");

        var indoorFacilities_var = document.getElementById("indoorFacilities_edit").value;
        var outdoorFacilities_var = document.getElementById("outdoorFacilities_edit").value;
        var houseAdvantage_var = document.getElementById("houseAdvantage_edit").value;
        var url=contextPath + "/system/label/all";

        $.ajax({
            url: url,
            type : "POST",
            dataType : "json",
            contentType : "application/json",
            success : function(datas)
            {
                var indoorFacilities_array=[];
                var outdoorFacilities_array=[];
                var houseAdvantage_array=[];

                indoorFacilities_array=indoorFacilities_var.split(",");
                outdoorFacilities_array=outdoorFacilities_var.split(",");
                houseAdvantage_array=houseAdvantage_var.split(",");

                var indoor=document.getElementById("indoor_div_edit");
                var outdoor=document.getElementById("outdoor_div_edit");
                var house_div=document.getElementById("house_div_edit");

                var indoor_input = "";

                for (var i=0;i<datas.length;i++){
                    if(datas[i].labelName=="indoorFacilities"){
                        var label=document.createElement("div");
                        var input_add=document.createElement("input");
                        var text_node=document.createElement("p");
                        label.style.width="100%";
                        label.style.float="left";
                        input_add.name="indoor_edit";
                        input_add.type="checkbox";
                        input_add.setAttribute("class","indoor_edit");
                        input_add.value=datas[i].labelValue;
                        input_add.style.float = "left";
                        text_node.style.float = "left";
                        text_node.setAttribute("class","indoor_edit");
                        text_node.innerHTML=datas[i].labelValue;
                        for (var j=0;j<indoorFacilities_array.length;j++)
                        {
                            if(datas[i].labelValue==indoorFacilities_array[j]){
                                input_add.checked="true";
                            }
                        }
                        indoor.appendChild(label);
                        label.appendChild(input_add);
                        label.appendChild(text_node);
                    }
                     if(datas[i].labelName=="outdoorFacilities"){
                         var label=document.createElement("div");
                         var input_add=document.createElement("input");
                         var text_node=document.createElement("p");
                         label.style.width="100%";
                         label.style.float="left";
                         input_add.name="outdoor_edit";
                         input_add.type="checkbox";
                         input_add.class="outdoor";
                         input_add.setAttribute("class","outdoor_edit");
                         input_add.style.float = "left";
                         text_node.style.float = "left";
                         text_node.setAttribute("class","outdoor_edit");
                         input_add.value=datas[i].labelValue;
                         text_node.innerHTML=datas[i].labelValue;
                         for (var j=0;j<outdoorFacilities_array.length;j++){
                             if(datas[i].labelValue==outdoorFacilities_array[j]){
                                 input_add.checked="true";
                             }
                         }
                         outdoor.appendChild(label);
                         label.appendChild(input_add);
                         label.appendChild(text_node);
                     }
                     if(datas[i].labelName=="houseAdvantage"){
                         var label=document.createElement("div");
                         var input_add=document.createElement("input");
                         var text_node=document.createElement("span");
                         label.style.width="100%";
                         label.style.float="left";
                         input_add.setAttribute("class","houseAd_edit");
                         input_add.style.float = "left";
                         text_node.style.float = "left";
                         text_node.setAttribute("class","houseAd_edit");
                         text_node.innerHTML=datas[i].labelValue;
                         input_add.name="houseAd_edit";
                         input_add.type="checkbox";
                         input_add.class="houseAd";
                         input_add.value=datas[i].labelValue;
                         for (var j=0;j<houseAdvantage_array.length;j++){
                             console.log(houseAdvantage_array[j]);
                             if(datas[i].labelValue==houseAdvantage_array[j]){
                                 input_add.checked="true";
                             }
                         }
                         house_div.appendChild(label);
                         label.appendChild(input_add);
                         label.appendChild(text_node);
                     }
                }
            },
            error: function (msg) {
                console.log('数据出错了!!');
            }
        });
    }



    function previewImage_edit(file)
    {
        var file_name="";
        $("p").remove(".text_images_name");
        $('#add_img img').remove();
        $.each($(file1_edit.files), function(index, val) {
            file_name+=val.name;
            var format_img = val.name.substring(val.name.length - 3);
            var format_temp_img = format_img.toLowerCase();
            if (format_temp_img == img_jpg || format_temp_img == img_png || format_temp_img == img_gif) {
                var reader = new FileReader();
                reader.readAsDataURL(val);
                reader.onload = function(){
                    var add_img=document.getElementById("add_img");
                    var img=document.createElement("img");
                    img.src=this.result;
                    img.width=60;
                    img.height=60;
                    img.style.float="left";
                    img.style.marginLeft="10px";
                    img.style.marginTop="15px";
                    add_img.appendChild(img);
                }
            }
        })
        var add_img=document.getElementById("upload_name");
        var text_node=document.createElement("p");
        text_node.style.float = "left";
        text_node.style.width ="100%";
        text_node.setAttribute("class","text_images_name");
        text_node.innerHTML=file_name;
        add_img.appendChild(text_node);
    }

    function previewQrcode_edit(file) {
        if(document.getElementById("qrcode_img_src")!=null){
            $('#qrcode_upload img').remove();
        }
        var rd = new FileReader();//创建文件读取对象
        var files = file.files[0];
        if (files != null) {
            var format_img = files.name.substring(files.name.length - 3);
            var format_temp_img = format_img.toLowerCase();
            if (format_temp_img == img_jpg || format_temp_img == img_png || format_temp_img == img_gif) {
                rd.readAsDataURL(files);//文件读取装换为base64类型
                rd.onloadend = function (e) {
                    var div=document.getElementById("qrcode_upload");
                    var qrcode_div=document.createElement("img");
                    qrcode_div.setAttribute("id","qrcode_img_src");
                    qrcode_div.style.marginLeft="10px";
                    qrcode_div.style.width="60px";
                    qrcode_div.style.height="60px";
                    qrcode_div.src = this.result;
                    div.appendChild(qrcode_div);

                }
            }
        }
    }

    function initEdit() {
            setTimeout(function () {
                if (document.getElementById("qrcode_upload") != null) {
                    $('#qrcode_upload img').remove();
                }
                if (document.getElementById("img_upload") != null) {
                    $('#img_upload img').remove();
                }
                $('#list_images div').remove();
                $("p").remove(".text_images_name_new");

                var delete_img=document.getElementById("delete_img");
            delete_img.value="";
                $("p").remove(".text_images_name");

            var img_str = document.getElementById("images_edit").value;
            var roomID = document.getElementById("roomID_edit").value;
            var qrcode_str = document.getElementById("qrcode_edit").value;
            var qrcode_div = document.getElementById("qrcode_upload");
            var format_qrcode = qrcode_str.substring(qrcode_str.length - 3);
            var format_temp_qrcode = format_qrcode.toLowerCase();
            var delete_img = document.getElementById("delete_img");

            delete_img.value = img_str;
            if (format_temp_qrcode == img_jpg || format_temp_qrcode == img_png || format_temp_qrcode == img_gif) {
                if (qrcode_str != null && qrcode_str != "") {
                    var qrcode_upload = document.getElementById("qrcode_upload")
                    var qrcode_div = document.createElement("img");
                    qrcode_div.setAttribute("id", "qrcode_img_src");
                    qrcode_div.style.width = "60px";
                    qrcode_div.style.marginLeft = "10px";
                    qrcode_div.style.height = "60px";
                    qrcode_div.src = 'http://119.3.191.53/maphouse/qrcode/' + roomID + '/' + qrcode_str + '';
                    qrcode_upload.appendChild(qrcode_div);
                }
            }

            if (img_str.indexOf(",") != -1) {
                var str = [];
                str = img_str.split(",");
                for (var i = 0; i < str.length; i++) {
                    var format = str[i].substring(str[i].length - 3);
                    var format_temp = format.toLocaleLowerCase();
                    if (format_temp == img_jpg || format_temp == img_png || format_temp == img_gif) {
                        var list_images=document.getElementById("list_images");
                        var img = document.createElement("img");
                        var cencel = document.createElement("img");
                        var div = document.createElement("div");
                        cencel.src = "http://119.3.191.53/maphouse/tool/close.png";
                        img.src = 'http://119.3.191.53/maphouse/images/' + roomID + '/' + str[i] + '';
                        img.width = 60;
                        img.height = 60;
                        img.style.marginTop="25px";
                        div.setAttribute("id", str[i]);
                        div.style.float = "left";
                        div.style.marginLeft = "10px";
                        cencel.width = 30;
                        cencel.height = 30;
                        cencel.style.position = "relative";
                        cencel.style.top = "-47px";
                        cencel.value = str[i];
                        cencel.addEventListener("click", function (e) {
                            showIntroduce(this.value);//这是我点击时需要运行的函数
                        });
                        list_images.appendChild(div);
                        div.appendChild(img);
                        div.appendChild(cencel);
                    }
                }
            }else {

                var format = img_str.substring(img_str.length - 3);
                var format_temp = format.toLocaleLowerCase();
                if (format_temp == img_jpg || format_temp == img_png || format_temp == img_gif) {
                    var list_images=document.getElementById("list_images");
                    var img = document.createElement("img");
                    var cencel = document.createElement("img");
                    var div = document.createElement("div");
                    cencel.src = "http://119.3.191.53/maphouse/tool/close.png";
                    img.src = 'http://119.3.191.53/maphouse/images/' + roomID + '/' + img_str + '';
                    img.width = 60;
                    img.height = 60;
                    div.setAttribute("id", img_str);
                    div.style.width = "90px";
                    div.style.float = "left";
                    div.style.marginLeft = "10px";
                    cencel.width = 30;
                    cencel.height = 30;
                    cencel.style.position = "relative";
                    cencel.style.top = "-47px";
                    cencel.value = img_str;
                    cencel.addEventListener("click", function (e) {
                        showIntroduce(this.value);//这是我点击时需要运行的函数
                    });
                    list_images.appendChild(div);
                    div.appendChild(img);
                    div.appendChild(cencel);
                }
            }
        }, 200)
    }
    function showIntroduce(value) {
        var delete_img=document.getElementById("delete_img");
        var message = document.getElementById(value);
        var strleng_array=[];
        strleng_array=delete_img.value.split(",");
        while(message.hasChildNodes()) //当div下还存在子节点时 循环继续
        {
            message.removeChild(message.firstChild);
        }

        if(strleng_array[strleng_array.length-1]==(value)){
            delete_img.value=(delete_img.value.toString().replace(value,""));
        }
        else if(delete_img.value.indexOf(',')!=-1){
            delete_img.value=delete_img.value.toString().replace(value+',',"");
        }
        else {
            delete_img.value=(delete_img.value.toString().replace(value,""));
        }

    }

    function ajaxEditUpload() {
        var url = contextPath + '/system/roominfo/edit';
        console.log(delete_img.value);
        console.log($('#uploadForm_edit')[0]);
        $.ajax({
            url: url,
            type: 'POST',
            cache: false,
            data: new FormData($('#uploadForm_edit')[0]),
            processData: false,
            contentType: false
        }).done(function(res) {

        }).fail(function(res) {});
    }
</script>

</body>
</html>