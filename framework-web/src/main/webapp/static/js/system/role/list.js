$(function()
{
    $oid = $("#oid");
    $rname = $("#rname");
    $containSub = $("#containSub");
    
    $btnEditRole = $("#btnEditRole");
    $btnRemoveRole = $("#btnRemoveRole");
    $btnAuthorization = $("#btnAuthorization");
    $btnSetMembership = $("#btnSetMembership");
    
    $btnEditRole.attr("disabled","disabled");
    $btnRemoveRole.attr("disabled","disabled");
    $btnAuthorization.attr("disabled","disabled");
    $btnSetMembership.attr("disabled","disabled");
    
    $dgRole = $("#dgRole").datagrid({
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
    var length = $dgRole.datagrid("getSelections").length;
    
    if (1 == length)
    {
        $btnEditRole.linkbutton("enable");
        $btnAuthorization.linkbutton("enable");
        $btnSetMembership.linkbutton("enable");
        
        $btnEditRole.removeAttr("disabled");
        $btnAuthorization.removeAttr("disabled");
        $btnSetMembership.removeAttr("disabled");
    }
    else
    {
        $btnEditRole.linkbutton("disable");
        $btnAuthorization.linkbutton("disable");
        $btnSetMembership.linkbutton("disable");
        
        $btnEditRole.attr("disabled","disabled");
        $btnAuthorization.attr("disabled","disabled");
        $btnSetMembership.attr("disabled","disabled");
    }
    
    if (length > 0)
    {
        $btnRemoveRole.linkbutton("enable");
        
        $btnRemoveRole.removeAttr("disabled");
    }
    else
    {
        $btnEditRole.linkbutton("disable");
        $btnRemoveRole.linkbutton("disable");
        $btnAuthorization.linkbutton("disable");
        $btnSetMembership.linkbutton("disable");
        
        $btnEditRole.attr("disabled","disabled");
        $btnRemoveRole.attr("disabled","disabled");
        $btnAuthorization.attr("disabled","disabled");
        $btnSetMembership.attr("disabled","disabled");
    }
}

function searchRoles()
{
    logBehavior("log.behavior.page.query", ["role.title","role.list"]);
    loadRoles();
}

function loadRoles()
{
    $dgRole.datagrid("clearSelections");
    var param = {};
    param.roleName = $rname.val();
    param.orgId = $oid.val();
    param.containSub = $containSub.is(':checked');
    $dgRole.datagrid("load", param);
}

// new role
var $dlgNewRole;

function newRole()
{
    logBehavior("log.behavior.dialog.open", ["role.list", "new"]);

    if (!$dlgNewRole)
    {
        $dlgNewRole = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgNewUser' />");
        $dlgNewRole.dialog(
        {
            closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("role.new"),
            width : 400,
            height : 250,
            href : contextPath + "/system/roles/new",
            buttons : [
            {
                text : $.i18n.prop("submit"),
                iconCls : "icon-ok",
                handler : function()
                {
                    $frmNewRole.form("enableValidation");

                    if (!$frmNewRole.form("validate"))
                    {
                        logBehavior("log.behavior.dialog.invaild", ["role.new"]);
                        return;
                    }

                    var url = contextPath + "/system/roles";
                    $.post(url, $frmNewRole.serialize(), function(result)
                    {
                        if ($.string(result.errorCode).blank())
                        {
                            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                            $dlgNewRole.dialog("close");
                            loadRoles();
                        }
                        else
                        {
                            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop(result.errorCode), "info", function()
                            {
                                $roleName.focus();
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
                    logBehavior("log.behavior.dialog.close", ["role.new"]);
                    $dlgNewRole.dialog("close");
                }
            }],
            onOpen : function()
            {
                initNewRoleForm();
            },
            onLoad : function()
            {
                initNewRoleForm();
            }
        });
        
        $(".panel-tool-close", $dlgNewRole.dialog("header")).on("click", function()
        {
            logBehavior("log.behavior.dialog.x", ["role.new"]);
        });
    }
    
    $dlgNewRole.dialog("open");
}

function initNewRoleForm()
{
    $frmNewRole = $("form", $dlgNewRole);

    $roleName = $("input[name='roleName']", $frmNewRole);
    var $orgName = $("input[name='orgName']", $frmNewRole);
    var $orgId = $("input[name='orgId']", $frmNewRole);

    var orgName = $orgName.val();
    var orgId = $orgId.val();

    $frmNewRole.form("clear");
    $frmNewRole.form("disableValidation");

    $orgName.val(orgName);
    $orgId.val(orgId);
    $roleName.focus();
}

// edit role
var $dlgEditRole;

function editRole()
{
    logBehavior("log.behavior.dialog.open", ["role.list", "edit"]);
    
    if (!$dlgEditRole)
    {
        $dlgEditRole = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgNewUser' />");
        $dlgEditRole.dialog(
        {
            closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("role.edit"),
            width : 400,
            height : 250,
            href : contextPath + "/system/roles/edit",
            buttons : [
            {
                text : $.i18n.prop("submit"),
                iconCls : "icon-ok",
                handler : function()
                {
                    $frmEditRole.form("enableValidation");

                    if (!$frmEditRole.form("validate"))
                    {
                        logBehavior("log.behavior.dialog.invaild", ["role.edit"]);
                        return;
                    }

                    var row = $dgRole.datagrid("getSelections")[0];
                    var url = contextPath + "/system/roles/" + row.roleId + "?_method=put";
                    var param = "roleId=" + row.roleId + "&" + $frmEditRole.serialize();
                    $.post(url, param, function(result)
                    {
                        if ($.string(result.errorCode).blank())
                        {
                            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                            $dlgEditRole.dialog("close");
                            loadRoles();
                        }
                        else
                        {
                            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop(result.errorCode), "info", function()
                            {
                                $("#roleName").focus();
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
                    logBehavior("log.behavior.dialog.close", ["role.edit"]);
                    $dlgEditRole.dialog("close");
                }
            }],
            onOpen : function()
            {
                initEditRoleForm();
            },
            onLoad : function()
            {
                initEditRoleForm();
            }
        });
        
        $(".panel-tool-close", $dlgEditRole.dialog("header")).on("click", function()
        {
            logBehavior("log.behavior.dialog.x", ["role.edit"]);
        });
    }
    
    $dlgEditRole.dialog("open");
}

function initEditRoleForm()
{
    $frmEditRole = $("form", $dlgEditRole);
    $frmEditRole.form("clear");
    $frmEditRole.form("disableValidation");
    
    var row = $dgRole.datagrid("getSelections")[0];
    $frmEditRole.form("load", row);

    $("input[name='roleName']", $frmEditRole).focus();
}


// remove roles
function removeRoles()
{
    logBehavior("log.behavior.dialog.open", ["role.list", "remove"]);
    
    var messager = $.messager.confirm($.i18n.prop("role.remove"), $.i18n.prop("row.confirmDelete"), function(r)
    {
        if (r)
        {
            var rows = $dgRole.datagrid("getSelections");
            var list = [];

            $.each(rows, function(index, item)
            {
                list.push(item.roleId);
            });

            $.ajax(
            {
                url : contextPath + "/system/roles?_method=delete",
                type : "post",
                dataType : "json",
                contentType : "application/json",
                data : $.toJSON(list),
                success : function()
                {
                    $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                    loadRoles();
                }
            });
        }
        else
        {
            logBehavior("log.behavior.dialog.close", ["role.remove"]);
        }
    });
    
    $(".panel-tool-close", messager.window("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["role.remove"]);
    });
}

// authorize
var $dlgFun;

function authorize()
{
    logBehavior("log.behavior.dialog.open", ["role.list", "authorization"]);

    if (!$dlgFun)
    {
        $dlgFun = $("<div style='padding: 15px 15px;overflow-x:hidden;' id='dlgFun' />");
        $dlgFun.dialog(
        {
            closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("role.authorization"),
            width : 800,
            height : 450,
            href : contextPath + "/system/funs/select",
            buttons : [
            {
                text : $.i18n.prop("submit"),
                iconCls : "icon-ok",
                handler : function()
                {
                    var row = $dgRole.datagrid("getSelections")[0];
                    submitRoleFun(row.roleId);
                }
            },
            {
                text : $.i18n.prop("cancel"),
                iconCls : "icon-remove",
                handler : function()
                {
                    logBehavior("log.behavior.dialog.close", ["role.authorization"]);
                    $dlgFun.dialog("close");
                }
            }],
            onOpen : function()
            {
                if (null == document.getElementById("fieldsetFun"))
                {
                    return;
                }
                
                var row = $dgRole.datagrid("getSelections")[0];
                initFunctions(row.roleId);
            },
            onLoad : function()
            {
                var row = $dgRole.datagrid("getSelections")[0];
                initFunctions(row.roleId);
            }
        });
        
        $(".panel-tool-close", $dlgFun.dialog("header")).on("click", function()
        {
            logBehavior("log.behavior.dialog.x", ["role.authorization"]);
        });
    }
    
    $dlgFun.dialog("open");
}

function submitRoleFun(roleId)
{
    var list = [];

    $("#fieldsetFun input[type=checkbox]:checked").each(function()
    {
        list.push($(this).val());
    });

    if (0 == list.length)
    {
        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("fun.validation.message1"), "info");
        return;
    }

    $.ajax(
    {
        url : contextPath + "/system/roles/" + roleId + "/funs",
        type : "post",
        dataType : "json",
        contentType : "application/json",
        data : $.toJSON(list),
        success : function()
        {
            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
            $dlgFun.dialog("close");
            loadRoles();
        }
    });
}

function checkAll(id, chked)
{
    var chks = $("[name='" + id + "']");

    if (0 == chks.length)
    {
        return;
    }

    chks.each(function()
    {
        this.checked = chked;
        checkAll(this.id, chked);
    });
}

function uncheckParent(id)
{
    var name = $("#" + id).attr("name");

    if (null == name)
    {
        return;
    }

    var chks = $("[name='" + name + "']");
    var c = true;

    chks.each(function()
    {
        if (!this.checked)
        {
            c = false;
            return;
        }
    });

    if (c)
    {
        $("#" + name)[0].checked = true;
    }
    else
    {
        $("#" + name)[0].checked = false;
    }

    uncheckParent(name);
}

function initFunctions(roleId)
{        
    $("#fieldsetFun input[type=checkbox]").each(function()
    {
        this.checked = false;

        $(this).click(function()
        {
            checkAll(this.id, this.checked);
            uncheckParent(this.id, this.checked);
        });
    });

    $.get(contextPath + "/system/roles/" + roleId + "/funs", null, function(result)
    {
        $.each(result, function(i, v)
        {
        	if ($("#chkFun" + v)[0]) {
        		$("#chkFun" + v)[0].checked = true;
        	}
        });
    }, "json");
}

// set Membership
var $dlgSelectUser;

function setMembership()
{
    logBehavior("log.behavior.dialog.open", ["role.list", "role.setMembership"]);
    
    if (!$dlgSelectUser)
    {
        $dlgSelectUser = $("<div style='padding: 15px 15px;overflow:hidden;' id='dlgSelectUser' />");
        $dlgSelectUser.dialog(
        {
            closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("role.setMembership"),
            width : 940,
            height : 450,
            href : contextPath + "/system/users/select",
            buttons : [
            {
                text : $.i18n.prop("submit"),
                iconCls : "icon-ok",
                handler : function()
                {
                    var row = $dgRole.datagrid("getSelections")[0];
                    submitRoleUser(row.roleId);
                }
            },
            {
                text : $.i18n.prop("cancel"),
                iconCls : "icon-remove",
                handler : function()
                {
                    logBehavior("log.behavior.dialog.close", ["role.setMembership"]);
                    $dlgSelectUser.dialog("close");
                }
            }],
            onOpen : function()
            {
                if (null == document.getElementById("dgUnselectedUser"))
                {
                    return;
                }
                
                var row = $dgRole.datagrid("getSelections")[0];
                initUserSelector(contextPath + "/system/roles/" + row.roleId + "/users", null);
            },
            onLoad : function()
            {
                var row = $dgRole.datagrid("getSelections")[0];
                initUserSelector(contextPath + "/system/roles/" + row.roleId + "/users", null);
            }
        });
        
        $(".panel-tool-close", $dlgSelectUser.dialog("header")).on("click", function()
        {
            logBehavior("log.behavior.dialog.x", ["role.setMembership"]);
        });
    }
    
    $dlgSelectUser.dialog("open");
}

function submitRoleUser(roleId)
{
    var rows = $dgSelectedUser.datagrid("getRows");

    if (0 == rows.length)
    {
        $.messager.confirm($.i18n.prop("messager.confirm"), $.i18n.prop("user.confirmUnselected"), function(r)
        {
            if (r)
            {
                postRoleUser(roleId, null);
            }
            else
            {
                logBehavior("log.behavior.role.action1");
            }
        });
    }
    else
    {
        postRoleUser(roleId, rows);
    }
}

function postRoleUser(roleId, rows)
{
    var list = [];

    if (null != rows)
    {
        $.each(rows, function(index, item)
        {
            list.push(item.userId);
        });
    }

    var postData = $.toJSON(list);

    $.ajax(
    {
        url : contextPath + "/system/roles/" + roleId + "/users",
        type : "post",
        dataType : "json",
        contentType : "application/json",
        data : postData,
        success : function()
        {
            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
            $dlgSelectUser.dialog("close");
            loadRoles();
        }
    });
}