$(function()
{
	$administrativeArea = $("#administrativeArea");
	$roomName = $("#roomName");

	
    $btnNewDic = $("#btnNewDic");
    $btnEditDic = $("#btnEditDic");
    $btnRemoveDic = $("#btnRemoveDic");
    $btnShowDic = $("#btnShowDic");
    
    //FOR IE8
    $btnEditDic.attr("disabled","disabled");
    $btnRemoveDic.attr("disabled","disabled");
    $btnShowDic.attr("disabled","disabled");
		
	$dgDic = $("#dgDic").datagrid({
        onSelect : function(rowIndex, rowData)
        {
            enableToolbar();
        },
        onUnselect : function(rowIndex, rowData)
        {
            enableToolbar();
        },
        onSelectAll : function(rows)
        {
            enableToolbar();
        },
        onUnselectAll : function(rows)
        {
            enableToolbar();
        }
    });
});

function enableToolbar()
{
    var length = $dgDic.datagrid("getSelections").length;;
    if (1 == length)
    {
        $btnEditDic.linkbutton("enable");
        $btnRemoveDic.linkbutton("enable");
        $btnShowDic.linkbutton("enable");
        //FOR IE8
        $btnEditDic.removeAttr("disabled");
        $btnRemoveDic.removeAttr("disabled");
        $btnShowDic.removeAttr("disabled");
    }
    else if(1 > length)
    {
    	$btnEditDic.linkbutton("disable");
    	$btnRemoveDic.linkbutton("disable");
        $btnShowDic.linkbutton("disable");
        //FOR IE8
        $btnEditDic.attr("disabled","disabled");
        $btnRemoveDic.attr("disabled","disabled");
        $btnShowDic.attr("disabled","disabled");
    }
    else if(1 < length){
    	$btnEditDic.linkbutton("disable");
    	$btnRemoveDic.linkbutton("enable");
        $btnShowDic.linkbutton("disable");
        //FOR IE8
        $btnEditDic.attr("disabled","disabled");
        $btnRemoveDic.removeAttr("disabled");
        $btnShowDic.attr("disabled","disabled");
    }
}

function searchDic()
{
    logBehavior("log.behavior.page.query", ["roominfo.title","roominfo.list"]);
    loadDic();
}

function loadDic()
{
	$dgDic.datagrid("clearSelections");
    var param = {};
    param.roomType=$('#roomType').combobox('getValue');
	param.roomName =$('#roomName').val();
	param.administrativeArea =$('#administrativeArea').val();
    $dgDic.datagrid("load", param);
}



//---------------------------new dic ---------------------------------------
var $dlgNewRoominfo;
var count_c = -1;
function newRoominfo()
{
	count_c++;
	logBehavior("log.behavior.dialog.open", ["roominfo.list", "new"]);
	if (!$dlgNewRoominfo)
	{
		$dlgNewRoominfo = $("<div style='overflow: hidden;' id='dlgNewRoominfo' />");
		$dlgNewRoominfo.dialog(
			{
				closed : true,
				modal : true,
				cache : true,
				title : $.i18n.prop("roominfo.new"),
				width: 960,
				height: 480,
				// href : contextPath + "/system/housing/import",
				href : contextPath + "/system/roominfo/new",
				buttons : [
					{
						text : $.i18n.prop("submit"),
						iconCls : "icon-ok",
						handler : function()
						{
							var indoorFacilities=document.getElementById("indoorFacilities_new");
							var outdoorFacilities=document.getElementById("outdoorFacilities_new");
							var houseAdvantage=document.getElementById("houseAdvantage_new");
							var indoor_array=[];
							var outdoor_array=[];
							var house_array=[];
							indoor_array=document.getElementsByName("indoor_new");
							outdoor_array=document.getElementsByName("outdoor_new");
							house_array=document.getElementsByName("houseAd_new");
							console.log(indoor_array);
							console.log(outdoor_array);
							console.log(house_array);
							var indoor="";
							var outdoor="";
							var house="";
							for (var i=0;i<indoor_array.length;i++){
								if(indoor_array[i].checked){
									indoor+=indoor_array[i].value+',';
								}
							}
							for (var i=0;i<outdoor_array.length;i++){

								if(outdoor_array[i].checked){

									outdoor+=outdoor_array[i].value+',';
								}
							}
							for (var i=0;i<house_array.length;i++){
								if(house_array[i].checked){
									house+=house_array[i].value+',';
								}
							}
							indoorFacilities.value=indoor.substring(0, indoor.length - 1);
							outdoorFacilities.value=outdoor.substring(0, outdoor.length - 1);
							houseAdvantage.value=house.substring(0, house.length - 1);

							$dlgNewRoominfo.form("enableValidation");
							if (!$dlgNewRoominfo.form("validate"))
							{
								logBehavior("log.behavior.dialog.invaild", ["roominfo.new"]);
								return;
							}

							var url = contextPath + '/system/roominfo';
							$.ajax({
								url: url,
								type: 'POST',
								cache: false,
								data: new FormData($('#uploadForm_new')[0]),
								processData: false,
								contentType: false
							}).done(function(res) {
								console.log(res);
								$.messager.alert($.i18n.prop("messager.info"), "上传成功", "info");
								$dlgNewRoominfo.dialog("close");
								loadDic();
								initadministrativeArea();
							}).fail(function(res) {
								$(".datagrid-mask").hide();
								$(".datagrid-mask-msg").hide();
								$.messager.alert("温馨提示",res.responseJSON.msg,"warning");
								return false;
							});
						}
					},
					{
						text : $.i18n.prop("cancel"),
						iconCls : "icon-remove",
						handler : function()
						{
							logBehavior("log.behavior.dialog.close", ["roominfo.new"]);
							$dlgNewRoominfo.dialog("close");
						}
					}],
				onLoad: function()
				{
					initNewRoomForm();
					!count_c && initNewRoominf();
					!count_c && initLabel();
				},

				onOpen : function()
				{
					if (null != document.getElementById("dlgNewRoominfo")){
						initNewRoomForm();
						count_c &&initNewRoominf();
						count_c &&initLabel();

					}
				}
			});

		$(".panel-tool-close", $dlgNewRoominfo.dialog("header")).on("click", function()
		{
			logBehavior("log.behavior.dialog.close", ["roominfo.new"]);
		});
	}
	$dlgNewRoominfo.dialog("open");
}

function initNewRoomForm()
{
	$frmNewRoominfo = $("form", $dlgNewRoominfo);
	$frmNewRoominfo.form("clear");
	$frmNewRoominfo.form("disableValidation");
}

var $dlgImportOrg;
function importExcel()
{
	logBehavior("log.behavior.dialog.open", ["roominfo.list", "import"]);
	if (!$dlgImportOrg)
	{
		$dlgImportOrg = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgImportOrg' />");
		$dlgImportOrg.dialog(
			{
				closed : true,
				modal : true,
				cache : true,
				title : $.i18n.prop("roominfo.import"),
				width : 400,
				height : 250,
				href : contextPath + "/system/roominfo/import",
				buttons : [
					{

						text : $.i18n.prop("submit"),
						iconCls : "icon-ok",
						handler : function()
						{

							var filepath=$("input[name='file1_excel']").val();
							if(filepath == "" || filepath == "undefined" || filepath == null){
								$.messager.alert("温馨提示","上传失败,文件为空","warning");
								return false;
							}
							else {
								if(hasError_excel(filepath) != "OK"){
									$.messager.alert("温馨提示",err[hasError_excel(filepath)],"warning");
									return false;
								}
							}
							var filepath2=$("input[name='file2_zip']").val();
							if(filepath2 == "" || filepath2 == "undefined" || filepath2 == null){
								$.messager.alert("温馨提示","上传失败,文件为空","warning");
								return false;
							}
							else {
								if(hasError_zip(filepath2) != "OK"){
									$.messager.alert("温馨提示",err_zip[hasError_zip(filepath2)],"warning");
									return false;
								}
							}
							var url = contextPath + '/system/roominfo/import';
                            $(".datagrid-mask").css({display:"block",width:"100%",height:$(window).height()});
                            $(".datagrid-mask-msg").css({display:"block",left:($dlgImportOrg.outerWidth(true) - 190) / 2,top:($(window).height() - 280) / 2});

							$.ajax({
								url: url,
								type: 'POST',
								cache: false,
								data: new FormData($('#uploadEditForm')[0]),
								processData: false,
								contentType: false
							}).done(function(res) {
                                $(".datagrid-mask").hide();
                                $(".datagrid-mask-msg").hide();
								$.messager.alert($.i18n.prop("messager.info"), "上传成功", "info");
								$dlgImportOrg.dialog("close");
								initadministrativeArea();
								loadDic();
							}).fail(function(data, status, e) {
                                $(".datagrid-mask").hide();
                                $(".datagrid-mask-msg").hide();
								$.messager.alert("温馨提示",data.responseJSON.msg,"warning");
								return false;
							});
						}
					},
					{
						text : $.i18n.prop("cancel"),
						iconCls : "icon-remove",
						handler : function()
						{
							logBehavior("log.behavior.dialog.close", ["org.import"]);
							$dlgImportOrg.dialog("close");
						}
					}],
				onOpen : function()
				{

					$frmNewResFile = $("form", $dlgImportOrg);
					var $fileName = $("input[name='fileName']", $frmNewResFile);
					$frmNewResFile.form("clear");
					$frmNewResFile.form("disableValidation");
					$fileName.focus();
				},
				onLoad: function()
				{
					$frmNewResFile = $("form", $dlgImportOrg);
					var $fileName = $("input[name='fileName']", $frmNewResFile);
					$frmNewResFile.form("clear");
					$frmNewResFile.form("disableValidation");
					$fileName.focus();
				}
			});

		$(".panel-tool-close", $dlgImportOrg.dialog("header")).on("click", function()
		{
			logBehavior("log.behavior.dialog.close", ["org.import"]);
		});
	}
	$dlgImportOrg.dialog("open");
}

//-----------------------------------edit dic ------------------------------------

function initEditDicForm()
{

	$frmEditDic = $("#dlgEditDic form");
    $frmEditDic.form("clear");
    $frmEditDic.form("disableValidation");
    var row = $dgDic.datagrid("getSelections")[0];
	var param = {};
	param.byPage = false;
    param.dicType = row.dicType;

	$frmEditDic.form("load", row);

	$("input[name='roomName']", $frmEditDic).focus();

	$dlgEditDic.find("[name='dicName']").val(row.dicName);
	$dlgEditDic.find("[name='dicType']").val(row.dicType);
}

var $dlgEditDic;
var count = -1;
function editDic()
{
	count++;
    logBehavior("log.behavior.dialog.open", ["roominfo.list", "edit"]);
	if (!$dlgEditDic)
    {
    	$dlgEditDic = $("<div style='overflow: hidden;' id='dlgEditDic' class='digEdit'></div>");
		$dlgEditDic.dialog(
	    {
	        closed:true,
            modal:true,
            cache:true,
            title: $.i18n.prop("roominfo.edit"),
            width: 960,
            height: 480,
			stack:false,
            href: contextPath + "/system/roominfo/edit",
	    	buttons : [
	        {
	            text : $.i18n.prop("submit"),
	            iconCls : "icon-ok",
	            handler : function()
	            {
					var delete_img=document.getElementById("delete_img");
					console.log(delete_img);

					var indoorFacilities=document.getElementById("indoorFacilities_edit");
					var outdoorFacilities=document.getElementById("outdoorFacilities_edit");
					var houseAdvantage=document.getElementById("houseAdvantage_edit");
					var indoor_array=[];
					var outdoor_array=[];
					var house_array=[];
					indoor_array=document.getElementsByName("indoor_edit");
					outdoor_array=document.getElementsByName("outdoor_edit");
					house_array=document.getElementsByName("houseAd_edit");

					var indoor="";
					var outdoor="";
					var house="";
					for (var i=0;i<indoor_array.length;i++){
						if(indoor_array[i].checked){
							indoor+=indoor_array[i].value+',';
						}
					}
					for (var i=0;i<outdoor_array.length;i++){
						if(outdoor_array[i].checked){
							outdoor+=outdoor_array[i].value+',';
						}
					}
					for (var i=0;i<house_array.length;i++){
						if(house_array[i].checked){
							house+=house_array[i].value+',';
						}
					}
					indoorFacilities.value=indoor.substring(0, indoor.length - 1);
					outdoorFacilities.value=outdoor.substring(0, outdoor.length - 1);
					houseAdvantage.value=house.substring(0, house.length - 1);
					$dlgEditDic.form("enableValidation");
					if (!$dlgEditDic.form("validate"))
					{
						logBehavior("log.behavior.dialog.invaild", ["roominfo.edit"]);
						return;
					}
					var url = contextPath + '/system/roominfo/edit';
					$.ajax({
						url: url,
						type: 'POST',
						cache: false,
						data: new FormData($('#uploadForm_edit')[0]),
						processData: false,
						contentType: false
					}).done(function(res) {
						$.messager.alert($.i18n.prop("messager.info"), "修改成功", "info");
						$dlgEditDic.dialog("close");
						loadDic();
						initadministrativeArea();
					}).fail(function(res) {

						$(".datagrid-mask").hide();
						$(".datagrid-mask-msg").hide();
						$.messager.alert("温馨提示",res.responseJSON.msg,"warning");
						return false;
					});

	            }
	        },
	        {
	            text : $.i18n.prop("cancel"),
	            iconCls : "icon-remove",
	            handler : function()
	            {
	                logBehavior("log.behavior.dialog.close", ["roominfo.edit"]);
	                $dlgEditDic.dialog("close");

	            }
	        }],
            onLoad : function()
            {
                initEditDicForm();
				!count && initEdit();
				!count && initLabelEdit();
            },
            onOpen : function()
            {
            	if (null != document.getElementById("dlgEditDic")){
                	initEditDicForm();
					count &&initEdit();
					count &&initLabelEdit();
            	}

            }
	    });
	
	    $(".panel-tool-close", $dlgEditDic.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["roominfo.edit"]);
	    });
    }
    $dlgEditDic.dialog("open");
}
//-----------------------------------delete dic--------------------------------
function removeDic()
{
	$dgDic = $("#dgDic");
	
    logBehavior("log.behavior.dialog.open", ["roominfo.list", "remove"]);

    var messager = $.messager.confirm($.i18n.prop("roominfo.remove"), $.i18n.prop("row.confirmDelete"), function(r)
    {
        if (r)
        {
            var rows = $dgDic.datagrid("getSelections");
            var list = [];
//            alert(rows.length);
            $.each(rows, function(index, item)
            {

                list.push(item.roomID);
            });

            $.ajax(
            {
                url : contextPath + "/system/roominfo?_method=DELETE",
                type : "post",
                dataType : "json",
                contentType : "application/json",
                data : $.toJSON(list),
                success : function(result)
                {
                	if ($.string(result.errorCode).blank())
                    {
						$.messager.alert($.i18n.prop("messager.info"), "删除成功", "info");
                        $("#dgDic").datagrid("reload");
                        $("#dgDic").datagrid("clearSelections");
						initadministrativeArea();
                    }
                    else
                    {
                    	$.messager.alert($.i18n.prop("messager.info"), result.errorCode, "info");
                    }
                }
            });
        }
        else
        {
            logBehavior("log.behavior.dialog.close", ["roominfo.remove"]);
        }
    });

    $(".panel-tool-close", messager.window("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["roominfo.remove"]);
    });
}
//-----------------------------------------show dic-----------------------------
var $dlgShowDic;
var count_show=-1;
function showDic()
{
	count_show++;
    logBehavior("log.behavior.dialog.open", ["roominfo.list", "show"]);
	if (!$dlgShowDic)
    {
        $dlgShowDic = $("<div style='overflow: hidden;' id='dlgShowDic' />");
        $dlgShowDic.dialog(
        {
            closed:true,
            modal:true,
            cache:true,
            title: $.i18n.prop("roominfo.detail"),
            width: 960,
            height: 480,
            href: contextPath + "/system/roominfo/show",
            buttons: "#dlgShowDicButtons",
            onLoad: function()
            {
				initShowDicForm();
				!count_show && initRoomShow();

            },
            onOpen: function()
            {
                if (null != document.getElementById("dlgShowDic")){
					initShowDicForm();
					count_show &&initRoomShow();
            	}
            }
        });
        $("#dlgShowDicButtons").show();

	    $(".panel-tool-close", $dlgShowDic.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["roominfo.detail"]);
	    });
	}    
    $dlgShowDic.dialog("open");
}

function initShowDicForm()
{
	var $frmShowDic = $("form", $dlgShowDic);
    $frmShowDic.form("clear");

	var row = $dgDic.datagrid("getSelections")[0];
	$frmShowDic.form("load", row);

}


function searchDicDetail()
{
    logBehavior("log.behavior.page.query", ["roominfo.title","roominfo.list"]);
    loadDicDetail();
}

function loadDicDetail(){
	var row = $dgDic.datagrid("getSelections")[0];
	$dlgShowDic.find("[name='dicName']").val(row.dicName);
	$dlgShowDic.find("[name='dicType']").val(row.dicType);
	var param = {};
    param.dicType = row.dicType;
    param.byPage = true;
    param.dicKey = $queryDicKey.val();
    param.dicValue = $queryDicValue.val();
    param.dicSymbol = $queryDicSymbol.val();
    
    //alert($.toJSON(param));
	$dicDgShow.datagrid(
    {
        url : contextPath + "/system/roominfo/"+row.dicType,
        method : "get",
        queryParams:param
    });
}

function editDicFromDetail()
{
    logBehavior("log.behavior.foominfo.action2");
    $dlgShowDic.dialog("close");
    editDic();
}

function closeDicDetailDialog()
{
    logBehavior("log.behavior.dialog.close", ["foominfo.detail"]);
    $dlgShowDic.dialog("close");
}

function exportExcel()
{
	window.location.href = contextPath + "/system/roominfo/export";
}


var err = { "acceptFileTypes": "只能上传excel文档，支持文件类型(.xls或.xlsx)",
	"maxFileSize": "上传文件大小超出范围60M"
};
var err_zip = { "acceptFileTypes_Zip": "只能上传zip文件",
	"maxFileSize": "上传文件大小超出范围60M"
};
function hasError_excel(file) {
	var acceptFileTypes = /(\.|\/)(xls|xlsx)$/i;

	if (!(acceptFileTypes.test(file))) {
		return "acceptFileTypes";
	}
	return "OK";
}
function hasError_zip(file) {

	var acceptFileTypes = /(\.|\/)(zip)$/i;

	if (!(acceptFileTypes.test(file))) {
		return "acceptFileTypes_Zip";
	}
	return "OK";

}











