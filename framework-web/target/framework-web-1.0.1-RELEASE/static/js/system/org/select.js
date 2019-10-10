function selectOrg(input, callback)
{
    logBehavior("log.behavior.org.action3");

    var $name = $(input);
    var $id = $(input).next();
    var $orgCode = $(input).next().next();
    var $org = $("<ul />");
    var $form = $('<form class="form-grid"/>');
    $form.append('<div class="title">' + $.i18n.prop("org.info") + '</div>');
    $form.append($org);

    var $dlgOrg = $('<div style="width:400px;height:480px;padding: 15px 15px; overflow-x: hidden;"/>');
    $dlgOrg.append($form);

    $org.tree(
    {
        url : contextPath + "/system/orgs/list",
        method : "get",
        lines : true,
        onLoadSuccess: function()
        {
            var node = $org.tree("find", $id.val());

            if (null != node)
            {
                $org.tree("expandTo", node.target);
                $org.tree("select", node.target);
            }else{
            	var root = $org.tree("getRoot");
            	$org.tree("expand", root.target);
            }
        },
        onDblClick : function(node)
        {
            logBehavior("log.behavior.org.action4");
            
            $id.val(node.id);
            $name.val(node.text);
            $orgCode.val(node.orgCode);
            
            $dlgOrg.dialog("close");

            if (callback)
            {
                callback();
            }
        }
    });
    
    $dlgOrg.dialog(
    {
        width : 400,
        height : 480,
        closed : true,
        cache : true,
        modal : true,
        title : $.i18n.prop("org.select"),
        buttons : [
        {
            text : $.i18n.prop("ok"),
            iconCls : "icon-ok",
            handler : function()
            {
                logBehavior("log.behavior.dialog.ok", ["org.select"]);
                var node = $org.tree("getSelected");

                if (null == node)
                {
                    $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("org.selectOrg"), "warning");
                }
                else
                {
                    $id.val(node.id);
                    $name.val(node.text);
                    $orgCode.val(node.orgCode);

                    $dlgOrg.dialog("close");
                }

                if (callback)
                {
                    callback();
                }
            }
        },
        {
            text : $.i18n.prop("cancel"),
            iconCls : "icon-remove",
            handler : function()
            {
                logBehavior("log.behavior.dialog.close", ["org.select"]);
                $dlgOrg.dialog("close");
            }
        }],
        onClose : function()
        {
            $dlgOrg.dialog("destroy");
        }
    }).dialog("open");

    $(".panel-tool-close", $dlgOrg.dialog("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["org.select"]);
    });
}