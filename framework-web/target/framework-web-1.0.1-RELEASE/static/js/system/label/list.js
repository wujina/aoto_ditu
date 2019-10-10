$(function()
{
    $labelName = $("#labelName");
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

function initNewUrlForm()
{
    $frmNewUrl = $("form", $dlgNewUrl);
    $frmNewUrl.form("clear");
    $frmNewUrl.form("disableValidation");
}
function loadUrls()
{
    $dgDic.datagrid("clearSelections");
    var param = {};
    param.labelName = $labelName.val();
    $dgDic.datagrid("load", param);
}

//-----------------------------------delete dic--------------------------------
function removeDic()
{
    $dgDic = $("#dgDic");

    logBehavior("log.behavior.dialog.open", ["label.list", "remove"]);

    var messager = $.messager.confirm($.i18n.prop("label.remove"), $.i18n.prop("row.confirmDelete"), function(r)
    {
        if (r)
        {
            var rows = $dgDic.datagrid("getSelections");
            var list = [];
//            alert(rows.length);
            $.each(rows, function(index, item)
            {
                list.push(item.id);
            });

            $.ajax(
                {
                    url : contextPath + "/system/label?_method=DELETE",
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
            logBehavior("log.behavior.dialog.close", ["label.remove"]);
        }
    });

    $(".panel-tool-close", messager.window("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["label.remove"]);
    });
}


var $dlgNewUrl;
function newUrl()
{
    logBehavior("log.behavior.dialog.open", ["label.list", "new"]);
    if (!$dlgNewUrl)
    {

        $dlgNewUrl = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgNewUrl' />");
        $dlgNewUrl.dialog(
            {
                closed : true,
                modal : true,
                cache : true,
                title : $.i18n.prop("label.new"),
                width : 400,
                height : 350,
                href : contextPath + "/system/label/new",
                buttons : [
                    {
                        text : $.i18n.prop("submit"),
                        iconCls : "icon-ok",
                        handler : function()
                        {
                            $frmNewUrl.form("enableValidation");

                            if (!$frmNewUrl.form("validate"))
                            {
                                logBehavior("log.behavior.dialog.invaild", ["label.new"]);
                                return;
                            }
                            var url = contextPath + "/system/label";
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

                                }
                            }, "json");
                        }
                    },

                    {
                        text : $.i18n.prop("cancel"),
                        iconCls : "icon-remove",
                        handler : function()
                        {

                            logBehavior("log.behavior.dialog.close", ["label.new"]);
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
            logBehavior("log.behavior.dialog.x", ["label.new"]);
        });

    }
    $dlgNewUrl.dialog("open");
}
function searchDic()
{
    logBehavior("log.behavior.page.query", ["label.title","label.list"]);
    loadDic();
}
function loadDic()
{
    $dgDic.datagrid("clearSelections");
    var param = {};
    param.labelName =$('#labelName').combobox('getValue');
    console.log(param);
    if(param.labelName=="全部"){
        param.labelName = null;
    }
    if(param.labelName=="房屋优势标签"){
        param.labelName = "houseAdvantage";
    }
    if(param.labelName=="室内设置标签"){
        param.labelName = "indoorFacilities";
    }
    if(param.labelName=="室外设置标签"){
        param.labelName = "outdoorFacilities";
    }
    console.log(param);
    $dgDic.datagrid("load", param);
}

//-----------------------------------------show dic-----------------------------
var $dlgShowDic;
function showDic()
{
    logBehavior("log.behavior.dialog.open", ["dic.list", "detail"]);

    if (!$dlgShowDic)
    {
        $dlgShowDic = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgShowDic' />");
        $dlgShowDic.dialog(
            {
                closed:true,
                modal:true,
                cache:true,
                title: $.i18n.prop("dic.detail"),
                width: 700,
                height: 480,
                href: contextPath + "/system/dics/show",
                buttons: "#dlgShowDicButtons",
                onLoad: function()
                {
                    initShowDicForm();
                },
                onOpen: function()
                {
                    if (null != document.getElementById("dlgShowDic")){
                        initShowDicForm();
                    }
                }
            });
        $("#dlgShowDicButtons").show();

        $(".panel-tool-close", $dlgShowDic.dialog("header")).on("click", function()
        {
            logBehavior("log.behavior.dialog.x", ["dic.detail"]);
        });
    }
    $dlgShowDic.dialog("open");
}