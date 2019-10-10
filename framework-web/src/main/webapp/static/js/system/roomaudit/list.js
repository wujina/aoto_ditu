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
	param.roomStatus =$('#roomStatus').combobox('getValue');
	// param.administrativeArea =$('#administrativeArea').combobox('getValue');
    $dgDic.datagrid("load", param);
}


//-----------------------------------edit dic ------------------------------------

function initEditDicForm()
{
	var row_qwr = $('#dgDic').datagrid('getSelected');
	$frmEditDic = $("#dlgEditDic form");
    $frmEditDic.form("clear");
    $frmEditDic.form("disableValidation");
    var row = $dgDic.datagrid("getSelections")[0];
	var param = {};
	param.byPage = false;
    param.dicType = row.dicType;

    console.log(row);
	$frmEditDic.form("load", row);

	$("input[name='roomName']", $frmEditDic).focus();
    $("input[name='roomStatus']", $frmEditDic).focus();

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
    	$dlgEditDic = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgEditDic' />");
		$dlgEditDic.dialog(
	    {
	        closed:true,
            modal:true,
            cache:true,
            title: $.i18n.prop("roominfo.edit"),
            width: 960,
            height: 480,
            href: contextPath + "/system/roomaudit/edit",
	    	buttons : [
	        {
	            text : $.i18n.prop("submit"),
	            iconCls : "icon-ok",
	            handler : function()
	            {

                    $dlgEditDic.form("enableValidation");

                    if (!$dlgEditDic.form("validate"))
                    {
                        logBehavior("log.behavior.dialog.invaild", ["roominfo.edit"]);
                        return;
                    }
                    var url = contextPath + '/system/roomaudit/edit';

                    var roomValue = $("#roomValue").val();

                    var cc=$("input[name^='roomCause']");
                    cc.val(roomValue);

                    $.ajax({
                        url: url,
                        type: 'POST',
                        cache: false,
                        data: new FormData($('#uploadEditForm')[0]),
                        processData: false,
                        contentType: false
                    }).done(function(res) {
                        console.log(res);
                        $.messager.alert($.i18n.prop("messager.info"), res.msg, "info");
                        $dlgEditDic.dialog("close");
                        loadDic();
                    }).fail(function(res) {
                        $(".datagrid-mask").hide();
                        $(".datagrid-mask-msg").hide();
                        $.messager.alert("温馨提示",res,"warning");
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
					 loadDic();
	            }
	        }],
            onLoad : function()
            {
                initEditDicForm();
				!count && initShow();
            },
            onOpen : function()
            {
            	if (null != document.getElementById("dlgEditDic")){
                	initEditDicForm();
					count &&initShow();

            	}

            }
	    });
	
	    $(".panel-tool-close", $dlgEditDic.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["roominfo.edit"]);
            $dlgEditDic.dialog("close");
            loadDic();
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
            	console.log(item);
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
                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                        $("#dgDic").datagrid("reload");
                        $("#dgDic").datagrid("clearSelections");
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


// export org
function exportExcel()
{
	window.location.href = contextPath + "/system/roominfo/export";
}

function hasError(file) {
	var acceptFileTypes = /(\.|\/)(xls|xlsx)$/i;
	if (!(acceptFileTypes.test(file))) {
		return "acceptFileTypes";
	}
	return "OK";
}

var err = { "acceptFileTypes": "只能上传excel文档，支持文件类型(.xls或.xlsx)",
	"maxFileSize": "上传文件大小超出范围60M"
};











