<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
<!DOCTYPE html>
<html>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<head>
</head>
<body>
<div id="mapContainer_new"></div>
<div id="tip_new">
    <input type="text" id="keyword_new" name="keyword_new" value="请输入关键字：(选定后搜索)" onfocus='this.value=""'/>
</div>
<form  id="uploadForm_new" enctype="multipart/form-data" class="form-grid"  >
<div  style="Overflow-y:scroll;height: 407px;" >
        <div class="title">
            <fmt:message key="roominfo.info" />
        </div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="roomName"><fmt:message key="roominfo.roomName" /><fmt:message key="colon" />
                </label>
            </div>
            <div class="col-2">
                <input style="width: 112%;" id="roomName_new"
                       class="easyui-validatebox form-control" maxlength="32"
                       data-options="required:true,validType:[roomName]"
                       name="roomName" />
            </div>
            <div class="col-1"></div>

            <div class="col-2 control-label">
                <label for="community"><fmt:message key="roominfo.community" /><fmt:message key="colon" />
                </label>
            </div>
            <div class="col-2">
                <input  style="width: 112%;" id="community_new" class="easyui-validatebox form-control" maxlength="32"
                       data-options="required:true,validType:['community']"
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
                   name="rent" />
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
                        data-options="required:true,editable:true,validType:['oriented'],panelHeight:'auto'">
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
                <label for="rentType"><fmt:message key="roominfo.rentType" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <select class="easyui-combobox myeasyui-searchParams"
                        name="rentType" style="width: 82px;"
                        data-options="required:true,editable:true,validType:['rentType'],panelHeight:'auto'">
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
                   data-options="required:true,validType:'number',novalidate:true"
                   name="roomSize" type="number" />
        </div>
        <div class="col-1"></div>

        <div class="col-2 control-label">
            <label for="buildingType"><fmt:message key="roominfo.buildingType" /><fmt:message key="colon" /></label>
        </div>

        <div class="col-2">
            <select class="easyui-combobox myeasyui-searchParams"
                    name="buildingType" style="width: 82px;"
                    data-options="required:true,editable:true,validType:['buildingType'],panelHeight:'auto'">
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
                        data-options="required:true,editable:true,validType:['paymentMethod'],panelHeight:'auto'">
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

            <div class="col-7" style="width: 61%;">
                <input  style="width: 100%;" id="address_new" class="required:true,validType:['address_new'],novalidate:true"  maxlength="32"  name="address" >
            </div>
        </div>
    <div style="height: 20px;"></div>


        <div class="form-group">
            <div class="col-2 control-label">
                <label for="detailedIntroduction"><fmt:message key="roominfo.detailedIntroduction" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-6" style="width: 62%">
                <textarea class="easyui-validatebox form-control" rows="5" cols="61" data-options="required:false,validType:['length[1,64]']" name="detailedIntroduction" />
            </div>
            <div class="col-1" style="width: 9.5%;"></div>
        </div>
    <div style="height: 20px;"></div>

    <div class="form-group">
        <div class="col-2 control-label">

            <label for="colour"><fmt:message key="roominfo.colour" /><fmt:message key="colon" /></label>
        </div>

        <div class="col-2 control-label">
            <select class="easyui-combobox myeasyui-searchParams"
                    id="colour" name="colour" style="width: 152px;"
                    data-options="required:true,editable:true,validType:['colour'],panelHeight:'auto'">
                <option value="橘黄色">橘黄色</option>
                <option value="深蓝色">深蓝色</option>
                <option value="粉红色">粉红色</option>
                <option value="浅蓝色">浅蓝色</option>
                <option value="深绿色">深绿色</option>
                <option value="浅绿色">浅绿色</option>
            </select>
        </div>
    </div>
    <div style="height: 20px;"></div>

    <div class="form-group">

            <div class="col-2 control-label">
                <label for="indoorFacilities"><fmt:message key="roominfo.indoorFacilities" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-9" id="indoor_div_new">


            </div>
            <div class="col-1"></div>
    </div>
    <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="outdoorFacilities"><fmt:message key="roominfo.outdoorFacilities" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-9" id="outdoor_div_new">

            </div>
        </div>
    <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="houseAdvantage"><fmt:message key="roominfo.houseAdvantage" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-9" id="house_div_new">

            </div>
            <div class="col-1"></div>
        </div>
    <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="images"><fmt:message key="roominfo.images" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-6" id="img_file">
                <input  onchange="previewImage_new(this)" type="file" id="file1_new"  name="file1_new"   multiple="multiple" accept="image/png, image/jpeg, image/gif, image/jpg"/>
            </div>
        </div>
    <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="qrcode"><fmt:message key="roominfo.qrcode" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-2" id="qrcode_file">
                <input onchange="previewQrcode_new(this)" type="file" name="file2_new" id="file2_new"   accept="image/png, image/jpeg, image/gif, image/jpg/">
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
                    data-options="editable:true,validType:['length[1,32]'],panelHeight:'auto'">
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
            <input style="width: 112%;" class="easyui-validatebox form-control" maxlength="32"  name="windowNum" type="number" value="0"/>
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
                        data-options="editable:true,validType:['length[1,32]'],panelHeight:'auto'">
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
                        data-options="editable:true,validType:['length[1,32]'],panelHeight:'auto'">
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
                <input style="width: 112%;" class="easyui-validatebox form-control" maxlength="32" name="buildYear" type="number" value="0" />
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
                        data-options="editable:true,validType:['length[1,32]'],panelHeight:'auto'">
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
                        name="roomType" style="width: 82px;"
                        data-options="required:true,editable:true,validType:['length[1,32]'],panelHeight:'auto'">
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
            <input style="width: 112%;" id="administrativeArea_new" class="easyui-validatebox form-control" maxlength="32" data-options="required:true,validType:['administrativeArea'],novalidate:true" name="administrativeArea" />
        </div>
        <div class="col-1"></div>
    </div>
    <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="communityLongitude"><fmt:message key="roominfo.communityLongitude" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-2">
                <input  style="width: 112%;" id="communityLongitude_new" class="easyui-validatebox form-control" maxlength="32"  name="communityLongitude" />
            </div>
            <div class="col-1"></div>

            <div class="col-2 control-label">
                <label for="communityDimension"><fmt:message key="roominfo.communityDimension" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-2">
                <input style="width: 112%;" id="communityDimension_new" class="easyui-validatebox form-control" maxlength="32"  name="communityDimension" />
            </div>
        </div>
    <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-2 control-label">
                <label for="roomLongitude"><fmt:message key="roominfo.roomLongitude" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-2">
                <input style="width: 112%;" id="roomLongitude_new" class="easyui-validatebox form-control" maxlength="32"  name="roomLongitude" />
            </div>
            <div class="col-1"></div>

            <div class="col-2 control-label">
                <label for="roomDimension">房源维度：</label>
            </div>

            <div class="col-2">
                <input style="width: 112%;" id="roomDimension_new" class="easyui-validatebox form-control" maxlength="32"  name="roomDimension" />
            </div>
        </div>
    <input type="hidden" class="easyui-validatebox form-control" maxlength="32"  name="indoorFacilities" id="indoorFacilities_new"/>
    <input  type="hidden" class="easyui-validatebox form-control" maxlength="32"  name="outdoorFacilities" id="outdoorFacilities_new"/>
    <input  type="hidden" class="easyui-validatebox form-control" maxlength="32"  name="houseAdvantage" id="houseAdvantage_new"/>
</div>
</form>
<script type="text/javascript">
    var windowsArr = [];
    var marker = [];
    var map = new AMap.Map("mapContainer_new", {
        resizeEnable: true,
        center: [116.397428, 39.90923],//地图中心点
        zoom: 13,//地图显示的缩放级别
        keyboardEnable: false
    });
    AMap.plugin(['AMap.Autocomplete','AMap.PlaceSearch'],function(){

        var autoOptions = {
            city: "北京", //城市，默认全国
            input: "keyword_new"//使用联想输入的input的id
        };
        autocomplete= new AMap.Autocomplete(autoOptions);
        var placeSearch = new AMap.PlaceSearch({
            city:'北京',
            map:map
        })
        AMap.event.addListener(autocomplete, "select", function(e){
            //TODO 针对选中的poi实现自己的功能
            console.log(e);
            document.getElementById("communityLongitude_new").value = e.poi.location.lng;
            document.getElementById("communityDimension_new").value = e.poi.location.lat;
            document.getElementById("community_new").value = e.poi.name;


            placeSearch.setCity(e.poi.adcode);
            placeSearch.search(e.poi.name);

        });
        AMap.event.addListener(placeSearch, "markerClick", function(e){
                 console.log(e);
                var address=e.data.pname+e.data.cityname+e.data.adname+e.data.address+e.data.name;
                 var adminstra=e.data.cityname+e.data.adname;
                 console.log(adminstra);
                document.getElementById("roomName_new").value = e.data.name;
                document.getElementById("address_new").value = address;
                document.getElementById("administrativeArea_new").value = adminstra;
                document.getElementById("roomLongitude_new").value = e.data.location.lng;
                document.getElementById("roomDimension_new").value = e.data.location.lat;

            }
        );
    });
</script>
<style type="text/css">
    body {
        font-size: 12px;
    }
    #tip_new {
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
    #tip_new input[type="text"] {
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
    #mapContainer_new{
        width: 500px;
        height: 500px;
        z-index: 99;
        left: -15px;
        top: -15px;
        float: left;
    }
    #uploadForm_new{
        width: 450px;
        position: absolute;
        left: 501px;
    }

</style>
<script>
    $.extend($.fn.validatebox.defaults.rules,{
        number:{// 验证数字
            validator : function(value) {
                return /^[0-9]{1,9}$/gi.test(value);
            },
            message : '只允许1-9位的正整数'
        }
    });
   function initLabel() {
        var url=contextPath + "/system/label/all";
        $.ajax({
            url: url,
            type : "POST",
            dataType : "json",
            contentType : "application/json",
            success : function(datas)
            {
                $("#indoor_div_new").empty();
                $("#outdoor_div_new").empty();
                $("#house_div_new").empty();
                var indoor_input = "";
                console.log(datas);
                for (var i=0;i<datas.length;i++){
                    if(datas[i].labelName=="indoorFacilities"){
                        indoor_input="<div style='width:100%;float:left'><input  name='indoor_new' type=\"checkbox\"  value=\""+ datas[i].labelValue+"\">"+datas[i].labelValue+"</div>"
                        $("#indoor_div_new").append(indoor_input);
                    }
                    if (datas[i].labelName=="outdoorFacilities"){
                        indoor_input ="<div style='width:100%;float:left'><input name='outdoor_new' type=\"checkbox\"  value=\""+ datas[i].labelValue+"\">"+datas[i].labelValue+"</div>";
                        $("#outdoor_div_new").append(indoor_input);
                    }
                    if (datas[i].labelName=="houseAdvantage"){
                        indoor_input ="<div style='width:100%;float:left'><input name='houseAd_new' type=\"checkbox\"  value=\""+ datas[i].labelValue+"\">"+datas[i].labelValue+"</div>";
                        $("#house_div_new").append(indoor_input);
                    }
                }
            },
            error: function (msg) {
                console.log('数据出错了!!');
            }
        });
    }

    function initNewRoominf(){
        $('#img_file img').remove();
        $('#qrcode_file img').remove();
        $("p").remove(".text_images_name_new");
    }
    function previewImage_new(file)
    {
        $('#img_file img').remove();
        $("p").remove(".text_images_name_new");
        var file_name="";
        $.each($(file1_new.files), function(index, val) {
            file_name+=val.name;
            var format_img = val.name.substring(val.name.length - 3);
            var format_temp_img = format_img.toLowerCase();
            if (format_temp_img == img_jpg || format_temp_img == img_png || format_temp_img == img_gif) {
                var reader = new FileReader();
                reader.readAsDataURL(val);
                reader.onload = function(){
                    var images_div=document.getElementById("img_file");
                    var images_input=document.getElementById("file1_new");
                    images_input.style.width="72px";
                    var img=document.createElement("img");
                    img.src=this.result;
                    img.width=60;
                    img.height=60;
                    img.style.marginLeft="10px";
                    images_div.appendChild(img);
                }
            }
        })
        var add_img=document.getElementById("img_file");
        var text_node=document.createElement("p");
        text_node.style.width ="100%";
        text_node.setAttribute("class","text_images_name_new");
        text_node.innerHTML=file_name;
        add_img.appendChild(text_node);
    }

    function previewQrcode_new(file) {
        $('#qrcode_file img').remove();
        var rd = new FileReader();//创建文件读取对象
        var files = file.files[0];
        if (files != null) {
            var format_img = files.name.substring(files.name.length - 3);
            var format_temp_img = format_img.toLowerCase();
            if (format_temp_img == img_jpg || format_temp_img == img_png || format_temp_img == img_gif) {
                rd.readAsDataURL(files);//文件读取装换为base64类型
                rd.onloadend = function (e) {
                    var qrcode_div = document.getElementById("qrcode_file");
                    var img = document.createElement("img");
                    var images_input = document.getElementById("file2_new");
                    images_input.style.width="150px";
                    img.src = this.result;
                    img.width = 60;
                    img.height = 60;
                    img.style.marginLeft = "10px";
                    qrcode_div.appendChild(img);
                }
            }
        }
    }

    //在input file内容改变的时候触发事件
</script>
<script type="text/javascript" src="https://webapi.amap.com/demos/js/liteToolbar.js"></script>
</body>
</html>
