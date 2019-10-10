$(function()
{
    $oid = $("#oid");
    $uname = $("#uname");
    $containSub = $("#containSub");

    $btnEditUser = $("#btnEditUser");
    $btnShowUser = $("#btnShowUser");
    $btnRemoveUser = $("#btnRemoveUser");
    $btnResetPassword = $("#btnResetPassword");
    $btnLockUser = $("#btnLockUser");
    $btnUnlockUser = $("#btnUnlockUser");
    
    $btnEditUser.attr("disabled","disabled");
    $btnShowUser.attr("disabled","disabled");
    $btnRemoveUser.attr("disabled","disabled");
    $btnResetPassword.attr("disabled","disabled");
    $btnLockUser.attr("disabled","disabled");
    $btnUnlockUser.attr("disabled","disabled");

    $dgUser = $("#dgUser").datagrid(
    {
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

// toolbar
function enableToolbar()
{
    var length = $dgUser.datagrid("getSelections").length;

    if (1 == length)
    {
        $btnEditUser.linkbutton("enable");
        $btnShowUser.linkbutton("enable");
        
        $btnEditUser.removeAttr("disabled");
        $btnShowUser.removeAttr("disabled");
    }
    else
    {
        $btnEditUser.linkbutton("disable");
        $btnShowUser.linkbutton("disable");
        
        $btnEditUser.attr("disabled","disabled");
        $btnShowUser.attr("disabled","disabled");
    }

    if (length > 0)
    {
        $btnRemoveUser.linkbutton("enable");
        $btnResetPassword.linkbutton("enable");
        $btnLockUser.linkbutton("enable");
        $btnUnlockUser.linkbutton("enable");
        
        $btnRemoveUser.removeAttr("disabled");
        $btnResetPassword.removeAttr("disabled");
        $btnLockUser.removeAttr("disabled");
        $btnUnlockUser.removeAttr("disabled");
    }
    else
    {
        $btnRemoveUser.linkbutton("disable");
        $btnResetPassword.linkbutton("disable");
        $btnLockUser.linkbutton("disable");
        $btnUnlockUser.linkbutton("disable");
        
        $btnRemoveUser.attr("disabled","disabled");
        $btnResetPassword.attr("disabled","disabled");
        $btnLockUser.attr("disabled","disabled");
        $btnUnlockUser.attr("disabled","disabled");
    }
}

// search users
function searchUsers()
{
    logBehavior("log.behavior.page.query", ["user.title", "user.list"]);
    loadUsers();
}

function loadUsers()
{
    $dgUser.datagrid("clearSelections");

    var param = {};
    param.username = $uname.val();
    param.orgId = $oid.val();
    param.containSub = $containSub.is(':checked');

    $dgUser.datagrid("load", param);
}

//new user
var $dlgNewUser;

function newUser()
{
    logBehavior("log.behavior.dialog.open", ["user.list", "new"]);

    if (!$dlgNewUser)
    {
        $dlgNewUser = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgNewUser' />");
        $dlgNewUser.dialog(
        {
            closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("user.new"),
            width : 400,
            height : 440,
            href : contextPath + "/system/users/new",
            buttons : [
            {
                text : $.i18n.prop("submit"),
                iconCls : "icon-ok",
                handler : function()
                {
                    $frmNewUser.form("enableValidation");

                    if (!$frmNewUser.form("validate"))
                    {
                        logBehavior("log.behavior.dialog.invaild", ["user.new"]);
                        return;
                    }

                    var url = contextPath + "/system/users";
                    $.post(url, $frmNewUser.serialize(), function(result)
                    {
                        if ($.string(result.errorCode).blank())
                        {
                            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                            $dlgNewUser.dialog("close");
                            loadUsers();
                        }
                        else
                        {
                            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop(result.errorCode), "info", function()
                            {
                                $("#username").focus();
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
                    logBehavior("log.behavior.dialog.close", ["user.new"]);
                    $dlgNewUser.dialog("close");
                }
            }],
            onLoad : function()
            {
                initNewUserForm();
            },
            onOpen : function()
            {
            	
            	if (null != document.getElementById("dlgNewUser"))
            	{
                	initNewUserForm();
            	}	
            }
        });

        $(".panel-tool-close", $dlgNewUser.dialog("header")).on("click", function()
        {
            logBehavior("log.behavior.dialog.x", ["user.new"]);
        });
    }

    $dlgNewUser.dialog("open");
}

function initNewUserForm()
{
    $frmNewUser = $("form", $dlgNewUser);

    var $username = $("input[name='username']", $frmNewUser);
    var $orgName = $("input[name='orgName']", $frmNewUser);
    var $orgId = $("input[name='orgId']", $frmNewUser);

    var orgName = $orgName.val();
    var orgId = $orgId.val();

    $frmNewUser.form("clear");
    $frmNewUser.form("disableValidation");

    $username.focus();
    $orgName.val(orgName);
    $orgId.val(orgId);
}

// edit user
var $dlgEditUser;

function editUser()
{
    logBehavior("log.behavior.dialog.open", ["user.list", "edit"]);
    
    if (!$dlgEditUser)
    {
        $dlgEditUser = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgEditUser' />");
        $dlgEditUser.dialog(
        {
            closed:true,
            modal:true,
            cache:true,
            title: $.i18n.prop("user.edit"),
            width: 400,
            height: 440,
            href: contextPath + "/system/users/edit",
            buttons : [
            {
                text : $.i18n.prop("submit"),
                iconCls : "icon-ok",
                handler : function()
                {
                    $frmEditUser.form("enableValidation");

                    if (!$frmEditUser.form("validate"))
                    {
                        logBehavior("log.behavior.dialog.invaild", ["user.edit"]);
                        return;
                    }

                    var row = $dgUser.datagrid("getSelections")[0];
                    var url = contextPath + "/system/users/" + row.userId + "?_method=put";
                    
                    $.post(url, $frmEditUser.serialize(), function(result)
                    {
                        if ($.string(result.errorCode).blank())
                        {
                            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                            $dlgEditUser.dialog("close");
                            loadUsers();
                        }
                        else
                        {
                            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop(result.errorCode), "info", function()
                            {
                                $("#username").focus();
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
                    logBehavior("log.behavior.dialog.close", ["user.edit"]);
                    $dlgEditUser.dialog("close");
                }
            }],
            onOpen : function()
            {
            	if (null != document.getElementById("dlgEditUser"))
            	{
                	initUserEditForm();
            	}	
            },
            onLoad : function()
            {
                initUserEditForm();
            }
        });

        $(".panel-tool-close", $dlgEditUser.dialog("header")).on("click", function()
        {
            logBehavior("log.behavior.dialog.x", ["user.edit"]);
        });
    }

    $dlgEditUser.dialog("open");
}

function initUserEditForm()
{
    $frmEditUser = $("form", $dlgEditUser);
    $frmEditUser.form("clear");
    $frmEditUser.form("disableValidation");
    
    var row = $dgUser.datagrid("getSelections")[0];
    $frmEditUser.form("load", row);

    $("input[name='realName']", $frmEditUser).focus();
}

// remove users
function removeUsers()
{
    logBehavior("log.behavior.dialog.open", ["user.list", "remove"]);

    var messager = $.messager.confirm($.i18n.prop("user.remove"), $.i18n.prop("row.confirmDelete"), function(r)
    {
        if (r)
        {
            var rows = $dgUser.datagrid("getSelections");
            var list = [];

            $.each(rows, function(index, item)
            {
                list.push(item.userId);
            });

            $.ajax(
            {
                url : contextPath + "/system/users?_method=delete",
                type : "post",
                dataType : "json",
                contentType : "application/json",
                data : $.toJSON(list),
                success : function()
                {
                    $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                    loadUsers();
                }
            });
        }
        else
        {
            logBehavior("log.behavior.dialog.close", ["user.remove"]);
        }
    });

    $(".panel-tool-close", messager.window("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["user.remove"]);
    });
}

// show user
var $dlgShowUser;

function showUser()
{
    logBehavior("log.behavior.dialog.open", ["user.list", "detail"]);
    
    if (!$dlgShowUser)
    {
        $dlgShowUser = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgShowUser' />");
        $dlgShowUser.dialog(
        {
            closed:true,
            modal:true,
            cache:true,
            title: $.i18n.prop("user.edit"),
            width: 600,
            height: 440,
            href: contextPath + "/system/users/show",
            buttons: "#dlgShowUserButtons",
            onOpen: function()
            {
                initUserShowForm();
            },
            onLoad: function()
            {
                initUserShowForm();
            }
        });
        
        $("#dlgShowUserButtons").show();

        $(".panel-tool-close", $dlgShowUser.dialog("header")).on("click", function()
        {
            logBehavior("log.behavior.dialog.x", ["user.detail"]);
        });
    }
    
    $dlgShowUser.dialog("open");
}

function initUserShowForm()
{
    var $frmShowUser = $("form", $dlgShowUser);
    $frmShowUser.form("clear");

    var row = $dgUser.datagrid("getSelections")[0];
    $frmShowUser.form("load", row);
    
    var $lastLoginDate = $("input[name='lastLoginDate']", $frmShowUser);
    var $createdDate = $("input[name='createdDate']", $frmShowUser);
    var $lastUpdatedDate = $("input[name='lastUpdatedDate']", $frmShowUser);
    
    var lastLoginDate = $lastLoginDate.val();
    var createdDate = $createdDate.val();
    var lastUpdatedDate = $lastUpdatedDate.val();
    
    $lastLoginDate.val(formatDate(lastLoginDate));
    $createdDate.val(formatDate(createdDate));
    $lastUpdatedDate.val(formatDate(lastUpdatedDate)); 
}

function editUserFromDetail()
{
    logBehavior("log.behavior.user.action1");
    $dlgShowUser.dialog("close");
    editUser();
}

function closeUserDetailDialog()
{
    logBehavior("log.behavior.dialog.close", ["user.detail"]);
    $dlgShowUser.dialog("close");
}

// reset password
function resetPassword()
{
    logBehavior("log.behavior.dialog.open", ["user.list", "user.reset"]);
    
    var messager = $.messager.confirm($.i18n.prop("user.reset"), $.i18n.prop("user.confirmReset"), function(r)
    {
        if (r)
        {
            var list = [];
            var rows = $dgUser.datagrid("getSelections");
            
            $.each(rows, function(index, item)
            {
                list.push(
                {
                    userId : item.userId,
                    username : item.username
                });
            });

            $.ajax(
            {
                url : contextPath + "/system/users/password?_method=put",
                type : "post",
                dataType : "json",
                contentType : "application/json",
                data : $.toJSON(list),
                success : function()
                {
                    $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                    loadUsers();
                }
            });
        }
        else
        {
            logBehavior("log.behavior.dialog.close", ["user.reset"]);
        }
    });
    
    $(".panel-tool-close", messager.window("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["user.reset"]);
    });
}

// lock users
function lockUsers()
{
    logBehavior("log.behavior.dialog.open", ["user.list", "user.lock"]);
    postUserLocked("user.lock", true, $.i18n.prop("user.lock"), $.i18n.prop("user.confirmLock"));
}

function postUserLocked(code, locked, msgTitle, confirmMessage)
{
    var messager = $.messager.confirm(msgTitle, confirmMessage, function(r)
    {
        if (r)
        {
            // logBehavior("log.behavior.dialog.ok", [code]);
            var list = [];
            var rows = $dgUser.datagrid("getSelections");

            $.each(rows, function(i, u)
            {
                list.push(u.userId);
            });

            var model = {};
            model.list = list;
            model.locked = locked;

            $.ajax(
            {
                url : contextPath + "/system/users/locked?_method=put",
                type : "post",
                dataType : "json",
                contentType : "application/json; charset=utf-8",
                data : $.toJSON(model),
                success : function()
                {
                    $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                    loadUsers();
                }
            });
        }
        else
        {
            logBehavior("log.behavior.dialog.close", [code]);
        }
    });

    $(".panel-tool-close", messager.window("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", [code]);
    });
}

// unlock users
function unlockUsers()
{
    logBehavior("log.behavior.dialog.open", ["user.list", "user.unlock"]);
    postUserLocked("user.unlock", false, $.i18n.prop("user.unlock"), $.i18n.prop("user.confirmUnlock"));
}

function postUserUnlocked(code, locked, msgTitle, confirmMessage)
{
    var messager = $.messager.confirm(msgTitle, confirmMessage, function(r)
    {
        if (r)
        {
            var list = [];
            var rows = $dgUser.datagrid("getSelections");

            $.each(rows, function(i, u)
            {
                list.push(u.userId);
            });

            var model = {};
            model.list = list;
            model.locked = locked;

            $.ajax(
            {
                url : contextPath + "/system/users/locked?_method=put",
                type : "post",
                dataType : "json",
                contentType : "application/json; charset=utf-8",
                data : $.toJSON(model),
                success : function()
                {
                    $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                    loadUsers();
                }
            });
        }
        else
        {
            logBehavior("log.behavior.dialog.close", [code]);
        }
    });

    $(".panel-tool-close", messager.window("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", [code]);
    });
}
        
function formatLocked(val, row)
{
    var h = "";

    if (val)
    {
        h = "<span style='color:red'>" + $.i18n.prop("user.locked") + "</span>";
    }
    else
    {
        h = "<span style='color:green'>" + $.i18n.prop("user.unlocked") + "</span>";
    }

    return h;
}