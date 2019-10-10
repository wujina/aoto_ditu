$(function()
{
    $oid = $("#oid");
    $uname = $("#uname");
    $containSub = $("#containSub");
    $beginDate = $("#beginDate");
    $endDate = $("#endDate");
    $dgLoginLog = $("#dgLoginLog");
    $seachFrom = $("#seachFrom");
});

function searchLoginLogs()
{
    logBehavior("log.behavior.page.query", ["log.login","log.login.list"]);
    $seachFrom.form("enableValidation");
    if (!$seachFrom.form("validate"))
    {
        return;
    }
    loadLoginLogs();
}

function loadLoginLogs()
{
    $dgLoginLog.datagrid("clearSelections");
    $dgLoginLog.datagrid("load",
    {
        username : $uname.val(),
        orgId : $oid.val(),
        containSub : $containSub.is(":checked"),
        beginDate : $beginDate.datebox("getValue"),
        endDate : $endDate.datebox("getValue")
    });
}

function showUser(userId)
{
    $dlgUser = $('<div style="width:600px;height:480px;padding: 15px 15px; overflow: hidden;"/>');
    $dlgUser.dialog(
    {
        closed : true,
        cache : true,
        modal : true,
        title : $.i18n.prop("user.detail"),
        href : contextPath + "/system/users/" + userId,
        buttons : [
        {
            text : $.i18n.prop("cancel"),
            iconCls : "icon-remove",
            handler : function()
            {
                $dlgUser.dialog("close");
            }
        }],
        onClose : function()
        {
            $dlgUser.dialog("destroy");
        }
    }).dialog("open");
}

function formatUsername(val, row, index)
{
    return "<a href='javascript:void(0);' onclick='showUser(" + row.userId + ");'>" + val + "</a>";
}