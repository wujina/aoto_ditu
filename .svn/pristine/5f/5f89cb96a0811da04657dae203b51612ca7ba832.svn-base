$(function()
{
    $oid = $("#oid");
    $uname = $("#uname");
    $containSub = $("#containSub");
    $dataChanged = $("#dataChanged");
    $beginDate = $("#beginDate");
    $endDate = $("#endDate");
    $btnShowDataLog = $("#btnShowDataLog");
    $seachFrom = $("#seachFrom");
    
    $dgBehaviorLog = $("#dgBehaviorLog").datagrid({
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
    var rows = $dgBehaviorLog.datagrid("getSelections");
    var method = "disable";
    
    if (1 == rows.length)
    {
        var row = rows[0];
        var method = row.dataChanged ? "enable" : "disable";
    }

    $btnShowDataLog.linkbutton(method);
}

function formatDataChanged(value, row, index)
{
    return value ? "<img src='" + staticPath + "/static/themes/default/icons/up.png" + "' />" : "";
}

function showDataLog()
{
    logBehavior("log.behavior.dialog.open", ["log.behavior", "log.behavior.showDataChanged"]);
    
    var row = $dgBehaviorLog.datagrid("getSelections")[0];
    var $dlgDataLog = $('<div style="width:800px;height:400px;padding: 15px 15px; overflow: hidden;"/>');

    $dlgDataLog.dialog(
    {
        closed : true,
        cache : true,
        modal : true,
        title : $.i18n.prop("log.data.dataChanged"),
        href : contextPath + "/system/logs/data?behaviorId=" + row.behaviorId,
        buttons : [
        {
            text : $.i18n.prop("cancel"),
            iconCls : "icon-remove",
            handler : function()
            {
                logBehavior("log.behavior.dialog.close", ["log.data.dataChanged"]);
                $dlgDataLog.dialog("close");
            }
        }],
        onClose : function()
        {
            $dlgDataLog.dialog("destroy");
        }
    }).dialog("open");
    
    $(".panel-tool-close", $dlgDataLog.dialog("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["log.data.dataChanged"]);
    });
}

function searchBehaviorLogs()
{
    logBehavior("log.behavior.page.query", ["log.behavior", "log.behavior.list"]);
    $seachFrom.form("enableValidation");
    if (!$seachFrom.form("validate"))
    {
        return;
    }
    loadBehaviorLogs();
}

function loadBehaviorLogs()
{
    $dgBehaviorLog.datagrid("clearSelections");
    $dgBehaviorLog.datagrid("load",
    {
        username : $uname.val(),
        orgId : $oid.val(),
        containSub : $containSub.is(":checked"),
        dataChanged : $dataChanged.is(":checked"),
        beginDate : $beginDate.datebox("getValue"),
        endDate : $endDate.datebox("getValue")
    });
}