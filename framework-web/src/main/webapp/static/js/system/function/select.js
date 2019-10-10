function selectFun(input, callback)
{
    logBehavior("log.behavior.fun.action3");

    var $name = $(input);
    var $id = $(input).next();
    var $fun = $("<ul />");
    var $form = $('<form class="form-grid"/>');
    $form.append('<div class="title">' + $.i18n.prop("fun.info") + '</div>');
    $form.append($fun);

    var $dlgFun = $('<div style="width:400px;height:480px;padding: 15px 15px; overflow-x: hidden;"/>');
    $dlgFun.append($form);

    $fun.tree(
    {
        url : contextPath + "/system/funs/list",
        method : "get",
        lines : true,
        onLoadSuccess: function()
        {
            var node = $fun.tree("find", $id.val());
			
            if (null != node)
            {
                $fun.tree("expandTo", node.target);
                $fun.tree("select", node.target);
            }else{
            	var root = $fun.tree("getRoot");
            	$fun.tree("expand", root.target);
            }
        },
        onDblClick : function(node)
        {
            logBehavior("log.behavior.fun.action4");
            
            $id.val(node.id);
            $name.val(node.text);
            
            $dlgFun.dialog("close");

            if (callback)
            {
                callback();
            }
        }
    });
    
    $dlgFun.dialog(
    {
        width : 400,
        height : 480,
        closed : true,
        cache : true,
        modal : true,
        title : $.i18n.prop("fun.select"),
        buttons : [
        {
            text : $.i18n.prop("ok"),
            iconCls : "icon-ok",
            handler : function()
            {
                logBehavior("log.behavior.dialog.ok", ["fun.select"]);
                var node = $fun.tree("getSelected");

                if (null == node)
                {
                    $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("fun.selectFun"), "warning");
                }
                else
                {
                    $id.val(node.id);
                    $name.val(node.text);

                    $dlgFun.dialog("close");
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
                logBehavior("log.behavior.dialog.close", ["fun.select"]);
                $dlgFun.dialog("close");
            }
        }],
        onClose : function()
        {
            $dlgFun.dialog("destroy");
        }
    }).dialog("open");

    $(".panel-tool-close", $dlgFun.dialog("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["fun.select"]);
    });
}