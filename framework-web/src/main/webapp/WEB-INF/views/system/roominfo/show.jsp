<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authentication property="principal" var="currentUser" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><fmt:message key="roominfo.list"/></title>
	<meta charset="utf-8"/>
</head>
<body>
<form  id="uploadEditForm" enctype="multipart/form-data" >
	<div  id="dialog-edit" style="Overflow-y:scroll;height: 380px;">

		<div class="form-group">
			<div class="col-1 ">
				<label for="roomName"><fmt:message key="roominfo.roomName" /><fmt:message key="colon" />
				</label>
			</div>

			<div class="col-2">
				<input readonly="true" readonly="true" class="easyui-validatebox form-control" maxlength="32"
					   data-options="required:false,validType:['name','length[1,64]'],novalidate:true"
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
					   data-options="required:false,validType:['length[1,64]'],novalidate:true"
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
					   data-options="required:false,validType:['length[1,64]'],novalidate:true"
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
					   data-options="required:false,validType:['length[1,64]'],novalidate:true"
					   name="houseType" />
			</div>
			<div class="col-1"></div>

			<div class="col-1 ">
				<label for="oriented"><fmt:message key="roominfo.oriented" /><fmt:message key="colon" />
				</label>
			</div>

			<div class="col-2">
				<input readonly="true" class="easyui-validatebox form-control" maxlength="32"
					   data-options="required:false,validType:['length[1,64]'],novalidate:true"
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
				<textarea readonly="true"  rows="5" cols="61" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="detailedIntroduction" />
			</div>
			<div class="col-1" style="width: 9.5%;"></div>

			<div class="col-1 ">

				<label for="colour"><fmt:message key="roominfo.colour" /><fmt:message key="colon" /></label>
			</div>

			<div class="col-1">
				<input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="colour" />
			</div>
		</div>
		<div style="height: 20px;"></div>


		<div class="form-group">
			<div class="col-1 ">
				<label for="indoorFacilities"><fmt:message key="roominfo.indoorFacilities" /><fmt:message key="colon" /></label>
			</div>
			<div class="col-6" id="indoor_div">
				<input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="indoorFacilities" />
			</div>
			<div class="col-1"></div>
		</div>
		<div style="height: 20px;"></div>

		<div class="form-group">
			<div class="col-1 ">
				<label for="outdoorFacilities"><fmt:message key="roominfo.outdoorFacilities" /><fmt:message key="colon" /></label>
			</div>

			<div class="col-6" id="outdoor_div">
				<input readonly="true" class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="outdoorFacilities" />
			</div>
		</div>
		<div style="height: 20px;"></div>

		<div class="form-group">
			<div class="col-1 ">
				<label for="houseAdvantage"><fmt:message key="roominfo.houseAdvantage" /><fmt:message key="colon" /></label>
			</div>

			<div class="col-6" id="house_div">
				<input readonly="true"  class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="houseAdvantage" />
			</div>
			<div class="col-1"></div>
		</div>
		<div style="height: 20px;"></div>

		<div class="form-group">
			<div class="col-1 ">
				<label for="images"><fmt:message key="roominfo.images" /><fmt:message key="colon" /></label>
			</div>
			<div class="col-10" id="img_upload_show">

				<input   type="hidden" class="easyui-textbox form-control" data-options="required:true,validType:['name','length[1,32]'],novalidate:true"  name="images" id="images_show">
				<div id="add_img" style="float: left"></div>
			</div>
		</div>
		<div style="height: 20px;"></div>

		<div class="form-group">
			<div class="col-1">
				<label for="qrcode"><fmt:message key="roominfo.qrcode" /><fmt:message key="colon" /></label>
			</div>
			<div class="col-2" id="qrcode_upload_show">


				<input  type="hidden" class="easyui-textbox form-control" data-options="hidden:'hidde',required:true,validType:['name','length[1,32]'],novalidate:true" name="qrcode" id="qrcode_show">
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

			<div class="col-1 ">
				<label for="roomType">房源类型：</label>
			</div>
			<div class="col-2">
				<input  class="easyui-validatebox form-control" maxlength="32" data-options="required:false,validType:['length[1,64]'],novalidate:true" name="roomType" />
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
		<div style="height: 20px;"></div>
	</div>
	<input  name="roomID" type="hidden" id="roomID_show">
	<input name="roomStatus" type="hidden">
	<input name="roomCheck" type="hidden">
	<input name="roomCause" type="hidden">

</form>

<script>

	function initRoomShow(){
		setTimeout(function(){

			$('#img_upload_show img').remove();
			$('#qrcode_upload_show img').remove();
			var img_str=document.getElementById("images_show").value;
			var roomID=document.getElementById("roomID_show").value;

			var qrcode_str=document.getElementById("qrcode_show").value;

			var qrcode_div=document.getElementById("qrcode_upload_show");
			var format_qrcode = qrcode_str.substring(qrcode_str.length - 3);
			var format_temp_qrcode=format_qrcode.toLowerCase();

			console.log(img_str);
			console.log(qrcode_str);
			if (format_temp_qrcode==img_jpg||format_temp_qrcode==img_png||format_temp_qrcode==img_gif) {
				var qrcode=document.createElement("img");
				qrcode.src= 'http://119.3.191.53/maphouse/qrcode/' +roomID+ '/'+qrcode_str+'';
				qrcode.width=60;
				qrcode.height=60;
				qrcode.style.marginLeft="10px";
				qrcode.setAttribute("id","qrcode_temp");
				qrcode_div.appendChild(qrcode);
			}
			var d1=document.getElementById("img_upload_show");
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


