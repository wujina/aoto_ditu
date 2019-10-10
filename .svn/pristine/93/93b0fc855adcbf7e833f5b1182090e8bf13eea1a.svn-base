$(function()
{
    $surlName = $("#surlName");
    $btnEditUrl = $("#btnEditUrl");
    $btnRemoveUrl = $("#btnRemoveUrl");
    $btnShowUrl= $("#btnShowUrl");
    //FOR IE8
    $btnEditUrl.attr("disabled","disabled");
    $btnRemoveUrl.attr("disabled","disabled");
    $btnShowUrl.attr("disabled","disabled"); 
    
    $dgUrl = $("#dgUrl").datagrid({
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
    var length = $dgUrl.datagrid("getSelections").length;;
    if (1 == length)
    {

        $btnEditUrl.linkbutton("enable");
        $btnRemoveUrl.linkbutton("enable");
        $btnShowUrl.linkbutton("enable");
        //FOR IE8
        $btnShowUrl.removeAttr("disabled");
        $btnEditUrl.removeAttr("disabled");
        $btnRemoveUrl.removeAttr("disabled");
    }
    else if(1 < length)
    {
    	$btnEditUrl.linkbutton("disable");
    	$btnRemoveUrl.linkbutton("enable");
        $btnShowUrl.linkbutton("disable");
        //FOR IE8
        $btnShowUrl.attr("disabled","disabled");
        $btnEditUrl.attr("disabled","disabled");
        $btnRemoveUrl.removeAttr("disabled");
    }
    else if(1 > length){
    	$btnEditUrl.linkbutton("disable");
    	$btnRemoveUrl.linkbutton("disable");
        $btnShowUrl.linkbutton("disable");
        //FOR IE8
        $btnShowUrl.attr("disabled","disabled");
        $btnEditUrl.attr("disabled","disabled");
        $btnRemoveUrl.attr("disabled","disabled");
    }

}

function searchUrls()
{
    logBehavior("log.behavior.page.query", ["url.title","url.list"]);
    loadUrls();
}

function loadUrls()
{
    $dgUrl.datagrid("clearSelections");
    var param = {};
    param.urlName = $surlName.val();
    $dgUrl.datagrid("load", param);
}
//------------------------------------------------------------------new ------------------------------------------------
var $dlgNewUrl;
function newUrl()
{
    logBehavior("log.behavior.dialog.open", ["url.list", "new"]);
    if (!$dlgNewUrl)
    {
    	$dlgNewUrl = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgNewUrl' />");
	    $dlgNewUrl.dialog(
	    {
	    	closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("url.new"),
            width : 400,
            height : 350,
            href : contextPath + "/system/urls/new",
	        buttons : [
	        {
	            text : $.i18n.prop("submit"),
	            iconCls : "icon-ok",
	            handler : function()
	            {
	                $frmNewUrl.form("enableValidation");
	
	                if (!$frmNewUrl.form("validate"))
	                {
	                    logBehavior("log.behavior.dialog.invaild", ["url.new"]);
	                    return;
	                }
	                var url = contextPath + "/system/urls";
	                $.post(url, $frmNewUrl.serialize(), function(result)
	               	{
	                    if ($.string(result.errorCode).blank())
	                    {
	                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
	                        $dlgNewUrl.dialog("close");
	                        loadUrls();
	                   	}
	                    else 
	                    { 
	                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop(result.errorCode), "info", function()
	                        { 
	                            $urlName.focus();
	                          
	                        });
	                    }
	                }, "json");
	            }
	        },
	        
	        {
	            text : $.i18n.prop("cancel"),
	            iconCls : "icon-remove",
	          
	            handler : function()
	            { 
	            	
	                logBehavior("log.behavior.dialog.close", ["url.new"]);
	                $dlgNewUrl.dialog("close");
	            }
	        }],
	        onLoad : function()
	        {
	            initNewUrlForm();
	        },
	        onOpen : function()
	        {
	            if (null != document.getElementById("dlgNewUrl"))
	        	{
	            	initNewUrlForm();
	        	}	
	        }
	    });
	    
	    $(".panel-tool-close", $dlgNewUrl.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["url.new"]);
	    });

	}

    $dlgNewUrl.dialog("open");
}
	            
function initNewUrlForm()
{
	$frmNewUrl = $("form", $dlgNewUrl);
    $funName = $("#funName");
    $urlName = $("input[name='urlName']", $frmNewUrl);
    $frmNewUrl.form("clear");
    $frmNewUrl.form("disableValidation");
    $urlName.focus();
}
//------------------------------------------------------------------edit ------------------------------------------------
var $dlgEditUrl;
function editUrl()
{
    logBehavior("log.behavior.dialog.open", ["url.list", "edit"]);
    if (!$dlgEditUrl)
    {
    	$dlgEditUrl = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgEditUrl' />");
	    $dlgEditUrl.dialog(
	    {
	    	closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("url.edit"),
            width : 400,
            height : 350,
            href : contextPath + "/system/urls/edit",
	        buttons : [
	        {
	            text : $.i18n.prop("submit"),
	            iconCls : "icon-ok",
	            handler : function()
	            {
	                $frmEditUrl.form("enableValidation");
	
	                if (!$frmEditUrl.form("validate"))
	                {
	                    logBehavior("log.behavior.dialog.invaild", ["url.edit"]);
	                    return;
	                }
	                var row = $dgUrl.datagrid("getSelections")[0];
	                var url = contextPath + "/system/urls/" + row.urlId + "?_method=put";
					//var param = "urlId=" + row.urlId + "&" + $frmEditUrl.serialize();
	                //alert("edit编辑 "+$.toJSON($frmEditUrl.serialize()));
	                $.post(url, $frmEditUrl.serialize(), function(result)
	                {
	                    if ($.string(result.errorCode).blank())
	                    {
	                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
	                        $dlgEditUrl.dialog("close");
	                        loadUrls();
	                    }
	                    else
	                    {
	                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop(result.errorCode), "info", function()
	                        {
	                            $("#urlName").focus();
	                        });
	                    }
	                }, "json");
	            }
	        },
	        {
	            text : $.i18n.prop("cancel"),
	            iconCls : "icon-remove",
	            handler : function()
	            {
	                logBehavior("log.behavior.dialog.close", ["url.edit"]);
	                $dlgEditUrl.dialog("close");
	            }
	        }],
            onOpen : function()
            {
            	if (null != document.getElementById("dlgEditUrl"))
            	{
                	initEditUrlForm();
            	}	
            },
            onLoad : function()
            {
                initEditUrlForm();
            }
	    });
	    
	    $(".panel-tool-close", $dlgEditUrl.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["url.edit"]);
	    });
    }
    $dlgEditUrl.dialog("open");
}    


function initEditUrlForm()
{
    $frmEditUrl = $("form", $dlgEditUrl);
    $frmEditUrl.form("clear");
    $frmEditUrl.form("disableValidation");
    
    var row = $dgUrl.datagrid("getSelections")[0];
    //alert($.toJSON(row)+"   gggggggg");
    $frmEditUrl.form("load", row);
    $("input[name='urlName']", $frmEditUrl).focus();
}
//------------------------------------------------------------------delete ----------------------------------------------
function removeUrls()
{
    logBehavior("log.behavior.dialog.open", ["url.list", "remove"]);
    
    var messager = $.messager.confirm($.i18n.prop("url.remove"), $.i18n.prop("row.confirmDelete"), function(r)
    {
        if (r)
        {
            var rows = $dgUrl.datagrid("getSelections");
            var list = [];

            $.each(rows, function(index, item)
            {
                list.push(item.urlId);
            });

            $.ajax(
            {
                url : contextPath + "/system/urls?_method=delete",
                type : "post",
                dataType : "json",
                contentType : "application/json",
                data : $.toJSON(list),
                success : function()
                {
                    $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                    loadUrls();
                }
            });
        }
        else
        {
            logBehavior("log.behavior.dialog.close", ["url.remove"]);
        }
    });
    
    $(".panel-tool-close", messager.window("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["url.remove"]);
    });
}
//------------------------------------------------------------------show ------------------------------------------------
var $dlgShowUrl;
function showUrl()
{
    logBehavior("log.behavior.dialog.open", ["url.list", "detail"]);
    if (!$dlgShowUrl)
    {
    	$dlgShowUrl = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgShowUrl' />");
	    $dlgShowUrl.dialog(
	    {
	    	closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("url.detail"),
            width : 400,
            height : 350,
            href : contextPath + "/system/urls/show",
            buttons: "#dlgShowUrlButtons",
            onLoad: function()
            {
                initShowUrlForm();
            },
            onOpen: function()
            {
                if (null != document.getElementById("dlgShowUrl")){
                	initShowUrlForm();
            	}
            }
	    });
	    
        $("#dlgShowUrlButtons").show();
	    $(".panel-tool-close", $dlgShowUrl.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["url.detail"]);
	    });
	}
	
    $dlgShowUrl.dialog("open");
}

function initShowUrlForm()
{
    var $frmShowUrl = $("form", $dlgShowUrl);
    $frmShowUrl.form("clear");

    var row = $dgUrl.datagrid("getSelections")[0];
    $frmShowUrl.form("load", row);
    
    var $lastLoginDate = $("input[name='lastLoginDate']", $frmShowUrl);
    var $createdDate = $("input[name='createdDate']", $frmShowUrl);
    var $lastUpdatedDate = $("input[name='lastUpdatedDate']", $frmShowUrl);
    
    var lastLoginDate = $lastLoginDate.val();
    var createdDate = $createdDate.val();
    var lastUpdatedDate = $lastUpdatedDate.val();
    
    $lastLoginDate.val(formatDate(lastLoginDate));
    $createdDate.val(formatDate(createdDate));
    $lastUpdatedDate.val(formatDate(lastUpdatedDate)); 
}

function editUrlFromDetail()
{
    logBehavior("log.behavior.url.action1");
    $dlgShowUrl.dialog("close");
    editUrl();
}

function closeUrlDetailDialog()
{
    logBehavior("log.behavior.dialog.close", ["url.detail"]);
    $dlgShowUrl.dialog("close");
}