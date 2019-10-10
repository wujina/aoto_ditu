<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>房源审核</title>
    <meta charset="utf-8"/>
</head>
<body>
<form  id="uploadEditForm" enctype="multipart/form-data" >
    <div  id="dialog-edit" style="Overflow-y:scroll;height: 374px;">

        <div class="form-group">
            <div class="col-1 ">
                <label for="roomName"><fmt:message key="roominfo.roomName" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <input readonly="true" readonly="true" class="easyui-validatebox form-control" maxlength="32"
                       name="roomName" />
            </div>
            <div class="col-1">
            </div>

            <div class="col-1 ">
                <label for="community"><fmt:message key="roominfo.community" /><fmt:message key="colon" />
                </label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32"
                       name="community" />
            </div>
            <div class="col-1">
            </div>

            <div class="col-1 ">
                <label for="rent"><fmt:message key="roominfo.rent" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32"
                       data-options="required:false,validType:['rent'],novalidate:true"
                       name="rent" value="0" type="number"/>
            </div>
        </div>

        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-1 ">
                <label for="houseType"><fmt:message key="roominfo.houseType" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32"
                       data-options="required:false,validType:['houseType'],novalidate:true"
                       name="houseType" />
            </div>
            <div class="col-1"></div>

            <div class="col-1 ">
                <label for="oriented"><fmt:message key="roominfo.oriented" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32"
                       data-options="required:false,validType:['oriented'],novalidate:true"
                       name="oriented" />
            </div>
            <div class="col-1"></div>

            <div class="col-1 ">
                <label for="rentType"><fmt:message key="roominfo.rentType" /></span><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32"
                       data-options="required:false,validType:['length[1,64]'],novalidate:true"
                       name="rentType" />
            </div>
        </div>

        <div style="height: 20px;"></div>


        <div class="form-group">
            <div class="col-1 ">
                <label for="roomSize"><fmt:message key="roominfo.roomSize" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32"
                       data-options="required:false,validType:['length[1,64]'],novalidate:true"
                       name="roomSize" type="number" value="0.00"/>
            </div>
            <div class="col-1"></div>

            <div class="col-1 ">
                <label for="paymentMethod"><fmt:message key="roominfo.paymentMethod" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="paymentMethod" />
            </div>
            <div class="col-1"></div>

            <div class="col-1 ">
                <label for="indoorStructure"><fmt:message key="roominfo.indoorStructure" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="indoorStructure" />
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-1 ">
                <label for="address"><fmt:message key="roominfo.address" /><fmt:message key="colon" />
                </label>
            </div>

            <div class="col-7" style="width: 51.3%;">
                <input readonly="true"  class="easyui-validatebox form-control"  maxlength="32"  name="address" ></input>
            </div>
            <div class="col-1"></div>

            <div class="col-1 ">
                <label for="buildingType"><fmt:message key="roominfo.buildingType" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="buildingType" />
            </div>
        </div>
        <div style="height: 20px;"></div>


        <div class="form-group">
            <div class="col-1 ">
                <label for="detailedIntroduction"><fmt:message key="roominfo.detailedIntroduction" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-6">
                <textarea readonly="true" rows="5" cols="61" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="detailedIntroduction" />
            </div>
            <div class="col-1" style="width: 9.5%;"></div>

            <div class="col-1 ">

                <label for="colour"><fmt:message key="roominfo.colour" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-1">
                <input readonly="true"  class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="colour" />
            </div>
        </div>
        <div style="height: 20px;"></div>


        <div class="form-group">
            <div class="col-1 ">
                <label for="indoorFacilities"><fmt:message key="roominfo.indoorFacilities" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2" id="indoor_div">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="indoorFacilities" />
            </div>
            <div class="col-1"></div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-1 ">
                <label for="outdoorFacilities"><fmt:message key="roominfo.outdoorFacilities" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-2" id="outdoor_div">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="outdoorFacilities" />
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-1 ">
                <label for="houseAdvantage"><fmt:message key="roominfo.houseAdvantage" /><fmt:message key="colon" /></label>
            </div>

            <div class="col-2" id="house_div">
                <input readonly="true"  class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="houseAdvantage" />
            </div>
            <div class="col-1"></div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-1 ">
                <label for="images"><fmt:message key="roominfo.images" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-10" id="img_upload">

                <input readonly="true"  type="hidden" class="easyui-textbox form-control" data-options="required:true,validType:['name','length[1,32]'],novalidate:true"  name="images" id="images">
                <div id="add_img" style="float: left"></div>
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-1">
                <label for="qrcode"><fmt:message key="roominfo.qrcode" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2" id="qrcode_upload">


                <input readonly="true" type="hidden" class="easyui-textbox form-control" data-options="hidden:'hidde',required:true,validType:['name','length[1,32]'],novalidate:true" name="qrcode" >
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-1 ">
                <label for="visitTime"><fmt:message key="roominfo.visitTime" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="visitTime" />
            </div>
            <div class="col-1"></div>
            <div class="col-1 ">
                <label for="floor"><fmt:message key="roominfo.floor" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="floor" />
            </div>
            <div class="col-1"></div>
            <div class="col-1 ">
                <label for="publishingMethod"><fmt:message key="roominfo.publishingMethod" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="publishingMethod" />
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-1 ">
                <label for="windowNum"><fmt:message key="roominfo.windowNum" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="windowNum" type="number" value="0"/>
            </div>
            <div class="col-1"></div>
            <div class="col-1 ">
                <label for="parkSpace"><fmt:message key="roominfo.parkSpace" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="parkSpace" />
            </div>
            <div class="col-1"></div>
            <div class="col-1 ">
                <label for="buildYear"><fmt:message key="roominfo.buildYear" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="buildYear" type="number" value="0" />
            </div>
        </div>
        <div style="height: 20px;"></div>


        <div class="form-group">
            <div class="col-1 ">
                <label for="decoration"><fmt:message key="roominfo.decoration" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="decoration" />
            </div>
            <div class="col-1"></div>

        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-1 ">
                <label for="houseID"><fmt:message key="roominfo.houseID" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">

                <input readonly="true" id="qwer" class="easyui-textbox form-control" data-options="required:true,validType:['name','length[1,32]'],novalidate:true" name="houseID" />
            </div>
            <div class="col-1"></div>
            <div class="col-1 ">
                <label for="communityLongitude"><fmt:message key="roominfo.communityLongitude" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="communityLongitude" />
            </div>
            <div class="col-1"></div>
            <div class="col-1 ">
                <label for="communityDimension"><fmt:message key="roominfo.communityDimension" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="communityDimension" />
            </div>
        </div>
        <div style="height: 20px;"></div>

        <div class="form-group">
            <div class="col-1 ">
                <label for="administrativeArea"><fmt:message key="roominfo.administrativeArea" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="administrativeArea" />
            </div>
            <div class="col-1"></div>
            <div class="col-1 ">
                <label for="roomLongitude"><fmt:message key="roominfo.roomLongitude" /><fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="roomLongitude" />
            </div>
            <div class="col-1"></div>
            <div class="col-1 ">
                <label for="roomDimension"><fmt:message key="roominfo.roomDimension"/>
                    <fmt:message key="colon" /></label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="roomDimension" />
            </div>
        </div>

        <div class="form-group">
            <div class="col-1 ">
                <label for="roomType">房源状态</label>
            </div>
            <div class="col-2">
                <input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="roomType" />
            </div>
        </div>
        <div style="height: 20px;"></div>
        <div class="form-group">
            <div class="col-2">
                <input type="radio"  onchange="preview_nopass(this)" id="status_nopass" value="未通过" >未通过
                <input type="radio"   onchange="preview_pass(this)" id="status_pass" value="通过">通过
            </div>
        </div>
        <div style="height: 20px;"></div>
        <div class="form-group" id="roomCause_div">
            <div class="col-1">
                <label for="roomCause">未通过原因:</label>
            </div>
            <div class="col-6" id="textarea_div">

            </div>
        </div>
    </div>
    <input readonly="true" name="roomID" type="hidden" >
    <input readonly="true" name="roomCause" type="hidden">
    <input type="hidden" readonly="true" name="roomStatus" class="easyui-validatebox form-control" maxlength="32"  id="status_val">
</form>

<script>

    function preview_pass() {
        $('#textarea_div textarea').remove();
        $('#roomCause_div').hide();
        var roomStatus =document.getElementById("status_val");
        roomStatus.value="通过";
        var status_nopass =document.getElementById("status_nopass");
        status_nopass.checked=false;

    }
    function preview_nopass() {
        var  textarea_div= document.getElementById("textarea_div")
        var  textarea=document.createElement("textarea");
        textarea.class="easyui-validatebox form-control";
        textarea.rows=5;
        textarea.cols=61;
        textarea.name="roomCause_value";
        textarea.setAttribute("id","roomValue");
        textarea.setAttribute("data-options","required:true,validType:['length[1,64]'],novalidate:true");
        textarea_div.appendChild(textarea);
        $('#roomCause_div').show();
        var roomStatus =document.getElementById("status_val");
        roomStatus.value="未通过";
        var status_pass =document.getElementById("status_pass");
        status_pass.checked=false;
    }
    
    
    function initShow(){
        setTimeout(function(){
            if (document.getElementById("qrcode_upload") != null) {
                $('#qrcode_upload img').remove();
            }
            if (document.getElementById("img_upload") != null) {
                $('#img_upload img').remove();
            }
            $('#textarea_div textarea').remove();

            var roomStatus =document.getElementById("status_val").value;

            var roomCause = $("input[name='roomCause']").val();
            if(roomStatus=='未通过'){
                var  textarea_div= document.getElementById("textarea_div");
                var textarea=document.createElement("textarea");
                textarea.class="easyui-validatebox form-control";
                textarea.rows=5;
                textarea.cols=61;
                textarea.value=roomCause;
                textarea.name="roomCause_value";
                textarea.setAttribute("id","roomValue");
                textarea.setAttribute("data-options","required:true,validType:['length[1,64]'],novalidate:true");
                textarea_div.appendChild(textarea);
                $('#roomCause_div').show();
                var roomStatus=document.getElementById("status_nopass");
                roomStatus.checked="true";
            }
            else if(roomStatus=='已通过'){
                $('#roomCause_div').hide();
                var roomStatus=document.getElementById("status_pass");
                roomStatus.checked="true";
            }
            else if (roomStatus=="待审核") {
                var  textarea_div= document.getElementById("textarea_div");
                var textarea=document.createElement("textarea");
                var roomStatus_val =document.getElementById("status_val");
                roomStatus_val.value="未通过";
                textarea.class="easyui-validatebox form-control";
                textarea.rows=5;
                textarea.cols=61;
                textarea.name="roomCause_value";
                textarea.setAttribute("data-options","required:true,validType:['length[1,64]'],novalidate:true");
                textarea_div.appendChild(textarea);
                $('#roomCause_div').show();
                var roomStatus=document.getElementById("status_nopass");
                roomStatus.checked="true";

            }

            var img_str=$("input[name='images']").val();
            var roomID=$("input[name='roomID']").val();
            var qrcode_str=$("input[name='qrcode']").val();
            var qrcode_div=document.getElementById("qrcode_upload");
            var format_qrcode = qrcode_str.substring(qrcode_str.length - 3);
            var format_temp_qrcode=format_qrcode.toLowerCase();

            if (format_temp_qrcode==img_jpg||format_temp_qrcode==img_png||format_temp_qrcode==img_gif) {
                var qrcode=document.createElement("img");
                qrcode.src= 'http://119.3.191.53/maphouse/qrcode/' +roomID+ '/'+qrcode_str+'';
                qrcode.width=60;
                qrcode.height=60;
                qrcode.setAttribute("id","qrcode_temp");
                qrcode_div.appendChild(qrcode);
            }
            var d1=document.getElementById("img_upload");
            if(img_str.indexOf(",")!=-1)
            {

                var str=[];
                str=img_str.split(",");
                for(var i=0;i<str.length;i++){
                    var format=str[i].substring(str[i].length-3);
                    var format_temp=format.toLocaleLowerCase();
                    if(format_temp==img_jpg||format_temp==img_png||format_temp==img_gif){
                        var img=document.createElement("img");
                        var div=document.createElement("div");
                        img.src= 'http://119.3.191.53/maphouse/images/' +roomID+ '/'+str[i]+'';
                        img.width=60;
                        img.height=60;
                        div.setAttribute("id",str[i]);
                        div.style.width="90px";
                        div.style.float="left";
                        div.style.marginLeft="10px";
                        d1.appendChild(div);
                        div.appendChild(img);

                    }
                }
            }
            else {
                var format=img_str.substring(img_str.length-3);
                var format_temp=format.toLocaleLowerCase();
                if(format_temp==img_jpg||format_temp==img_png||format_temp==img_gif){
                    var img=document.createElement("img");
                    var div=document.createElement("div");
                    img.src= 'http://119.3.191.53/maphouse/images/' +roomID+ '/'+img_str+'';
                    img.width=60;
                    img.height=60;
                    div.setAttribute("id",img_str);
                    div.style.width="90px";
                    div.style.float="left";
                    div.style.marginLeft="10px";
                    d1.appendChild(div);
                    div.appendChild(img);

                }
            }
        },200)
    }

</script>
</body>
</html>


