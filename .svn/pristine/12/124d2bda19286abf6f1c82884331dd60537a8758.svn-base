function getInfosList(node){
	var list = [];
	var info = null;
	//alert("node.children.length ==== "+node.children.length);
	for (var i = 0; i < node.children.length; i++) {  
		info = {};
		info.menuId = node.children[i].id;
		info.menuName = node.children[i].text;
		info.sortNum = i+1;
		list.push(info);
	}
	return list;
}

var selectedId = 0;
var maxLevelNum = 4;

$(function()
{
    $btnNewmenu = $("#btnNewmenu");
    $btnEditmenu = $("#btnEditmenu");
    $btnRemovemenu = $("#btnRemovemenu");
    $btnShowmenu = $("#btnShowmenu");
    $exportmenu = $("#btnExportmenu");
    $importmenu = $("#btnImportmenu");
    //FOR IE8
    $btnNewmenu.attr("disabled","disabled");
    $btnEditmenu.attr("disabled","disabled");
    $btnRemovemenu.attr("disabled","disabled");
    $btnShowmenu.attr("disabled","disabled");    
    $menu = $("#menu").tree(
    {
        url : contextPath + "/system/menus/list",
        method : "get",
        lines : true,
        dnd : (1 == $btnEditmenu.length),
        onSelect : function(node)
        {
            $btnNewmenu.linkbutton("enable");
            $btnEditmenu.linkbutton("enable");
            $btnShowmenu.linkbutton("enable");
            //FOR IE8
            $btnNewmenu.removeAttr("disabled");
            $btnEditmenu.removeAttr("disabled");
            $btnShowmenu.removeAttr("disabled"); 
            
            var parentNode = $menu.tree("getParent", node.target);

            if (null == parentNode)
            {
                $btnEditmenu.linkbutton("disable");
                $btnRemovemenu.linkbutton("disable");
                $btnShowmenu.linkbutton("disable");
                //FOR IE8
                $btnEditmenu.attr("disabled","disabled");
                $btnRemovemenu.attr("disabled","disabled");
                $btnShowmenu.attr("disabled","disabled");
            }
            else
            {
                $btnEditmenu.linkbutton("enable");
                $btnRemovemenu.linkbutton("enable");
                $btnShowmenu.linkbutton("enable");
                //FOR IE8
                $btnEditmenu.removeAttr("disabled");
                $btnRemovemenu.removeAttr("disabled");
                $btnShowmenu.removeAttr("disabled");
            }
            if(node.attributes.levelNum>3){
            	$btnNewmenu.linkbutton("disable");
                $btnNewmenu.attr("disabled","disabled");
            }
        },
        onLoadSuccess : function(node, data)
        {
            var root = $menu.tree("getRoot");
           	$menu.tree("expandAll", root.target);
           	
            if(selectedId !=0){
                var node = $menu.tree("find", selectedId);
	            if (null != node)
	            {
	                $menu.tree("select", node.target);
	            }
	            selectedId = 0;
            }
        },
        onBeforeDrag : function(node)
        {
            var parentNode = $menu.tree("getParent", node.target);
            return (null != parentNode);
        },
        onBeforeDrop : function(target, source, point)
        {
             /*$.messager.confirm($.i18n.prop("operation.tip"), $.i18n.prop("menu.comfirmMove"), function (data) {  
	            alert(data);
             	if (data) {  
	                return true;
	            }  
	            else {  
	            	return false;
	            }  
	        });  */
            //return window.confirm($.i18n.prop("menu.comfirmMove"));
        	var flag = true;
        	var sourceNode = source;
        	var targetNode = $menu.tree("getNode", target);
            
            var targetNodeLevel = targetNode.attributes.levelNum;
            if ("append" == point){
            	if(targetNodeLevel + getDepthByParentNode(sourceNode)>maxLevelNum)  flag = false;
            }else{
            	if(targetNodeLevel + getDepthByParentNode(sourceNode)-1>maxLevelNum)  flag = false;
            }
        	
            if(!flag){
            	//logBehavior("log.behavior.dialog.open", ["dic.edit", "dic.edit"]);
            	$.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("maxLevelNum",maxLevelNum),"error", function()
	            {
	                
	            });
            }
            
        	return flag;
        },
        onDrop : function(target, source, point)
        {
        	$.messager.confirm($.i18n.prop("operation.tip"), $.i18n.prop("menu.comfirmMove"), function (data) {  
             	if (data) {  
	                var sourceNode = source;
		            var targetNode = $menu.tree("getNode", target);
		            var url, param;
					
					var list = [];
					var tmpNode = null;
					
		            if ("append" == point)
		            {
		            	//alert(" append");
		            	var tmpNode = $.extend(true, {}, targetNode);
		            	list = getInfosList(tmpNode);
		                //alert(targetNode.attributes.levelNum+"   targetNode.attributes.levelNum");
		            	//更新排序号
		                $.ajax({
				                url : contextPath + "/system/menus/" + sourceNode.id + "/parent/" + targetNode.id + "/"+targetNode.attributes.levelNum+"?_method=put",
				                type : "post",
				                dataType : "json",
				        		data : $.toJSON(list),
				        		contentType : "application/json",
				                success : function(result)
				                {	
				                	if ($.string(result.errorCode).blank())
				                    {
				                        //$.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                        				selectedId = sourceNode.id;
				                    }
				                    else
				                    {
				                        $.messager.alert($.i18n.prop("messager.info"), result.errorCode, "error", function()
				                        {
				                            
				                        });
				                    }
									$menu.tree("reload");
				            	}
				     	 });
		                
		            }
		            else
		            {
		            	var targetParentNode = $menu.tree("getParent", target);
		                if (null == targetParentNode)
		                {
		                    $menu.tree("reload");
		                    return false;
		                }
		                else
		                {
		                	tmpNode = $.extend(true, {}, targetParentNode);
							list = getInfosList(tmpNode);
		                    //更新排序号
		                	//alert("非 append");
			                $.ajax({
					                url : contextPath + "/system/menus/" + sourceNode.id + "/parent/" + tmpNode.id + "/"+tmpNode.attributes.levelNum+"?_method=put",
		                    		type : "post",
					                dataType : "json",
					        		data : $.toJSON(list),
					        		contentType : "application/json",
					                success : function(result)
					                {	
					                	if ($.string(result.errorCode).blank())
					                    {
					                        //$.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                        					selectedId = sourceNode.id;
					                    }
					                    else
					                    {
					                        $.messager.alert($.i18n.prop("messager.info"), result.errorCode, "error", function()
					                        {
					                            
					                        });
					                    }
										$menu.tree("reload");
					            	}
					     	 });
		                    
		                }
		            }
	            }
	            
	            $menu.tree("reload");
	            
	        }); 
        	
        }
    });
});

function loadmenuTree()
{
    $btnNewmenu.linkbutton("disable");
    $btnEditmenu.linkbutton("disable");
    $btnRemovemenu.linkbutton("disable");
    $btnShowmenu.linkbutton("disable");
    //FOR IE8
    $btnNewmenu.attr("disabled","disabled");
    $btnEditmenu.attr("disabled","disabled");
    $btnRemovemenu.attr("disabled","disabled");
    $btnShowmenu.attr("disabled","disabled");
    $menu.tree("reload");
}

function exportExcel(){
	var url = contextPath + "/system/menus/exportExcel";
	window.location.href = url;
}

//--------------------------------------------------------------new --------------------------------------------------
var $dlgNewmenu;
function newmenu()
{
    logBehavior("log.behavior.dialog.open", ["menu.list", "new"]);
    if (!$dlgNewmenu)
    {
    	$dlgNewmenu = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgNewmenu' />");
	    $dlgNewmenu.dialog(
	    {
	    	closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("menu.new"),
            width : 400,
            height : 380,
            href : contextPath + "/system/menus/new",
	        buttons : [
	        {
	            text : $.i18n.prop("submit"),
	            iconCls : "icon-ok",
	            handler : function()
	            {
	                $frmNewmenu.form("enableValidation");
	
	                if (!$frmNewmenu.form("validate"))
	                {
	                    logBehavior("log.behavior.dialog.invaild", ["menu.new"]);
	                    return;
	                }
	
	                var url = contextPath + "/system/menus";
	                var node = $menu.tree("getSelected");
	                var param = "levelNum=" + (node.attributes.levelNum + 1)
	                    + "&" + $frmNewmenu.serialize();  
	                $.post(url, param, function(result)
	                {
	                    if ($.string(result.errorCode).blank())
	                    {
	                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
	                        $dlgNewmenu.dialog("close");
	                        selectedId = node.id;
	                        loadmenuTree();
	                    }
	                    else
	                    {
	                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop(result.errorCode), "info", function()
	                        {
	                            $menuName.focus();
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
	                logBehavior("log.behavior.dialog.close", ["menu.new"]);
	                $dlgNewmenu.dialog("close");
	            }
	        }],
            onLoad : function()
            {
                initNewmenuForm();
            },
            onOpen : function()
            {
                if (null != document.getElementById("dlgNewmenu"))
            	{
                	initNewmenuForm();
            	}	
            }
	    });
	    
	    $(".panel-tool-close", $dlgNewmenu.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["menu.new"]);
	    });

	}

    $dlgNewmenu.dialog("open");
}
         
function initNewmenuForm()
{
	$frmNewmenu = $("form", $dlgNewmenu);
    $frmNewmenu.form("clear");
    $frmNewmenu.form("disableValidation");

    var node = $menu.tree("getSelected");
    var children = $menu.tree("getChildren", node.target);
    var sortNum = (0 == children.length) ? 1 : children[children.length - 1].attributes.sortNum;

    $parentId = $("input[name='parentId']", $frmNewmenu);
    $funId = $("input[name='funId']", $frmNewmenu);
    $parentName = $("input[name='parentName']", $frmNewmenu);
    $menuName = $("input[name='menuName']", $frmNewmenu);
    $sortNum = $("input[name='sortNum']", $frmNewmenu);

    $parentId.val(node.id);
    $funId.val(0);
    $parentName.val(node.text);
    var levelNum = node.attributes.levelNum+1;
    
    $menuName.focus();
    $sortNum.val(sortNum == 999 ? sortNum:sortNum + 1);
}

//-----------------------------------------------------------edit---------------------------------------------------
var $dlgEditmenu;
function editmenu()
{
    logBehavior("log.behavior.dialog.open", ["menu.list", "edit"]);
    if (!$dlgEditmenu)
    {
    	$dlgEditmenu = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgEditmenu' />");
	    $dlgEditmenu.dialog(
	    {
	    	closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("menu.edit"),
            width : 400,
            height : 380,
            href : contextPath + "/system/menus/edit",
	        buttons : [
	        {
	            text : $.i18n.prop("submit"),
	            iconCls : "icon-ok",
	            handler : function()
	            {
	                $frmEditmenu.form("enableValidation");
	
	                if (!$frmEditmenu.form("validate"))
	                {
	                    logBehavior("log.behavior.dialog.invaild", ["menu.edit"]);
	                    return;
	                }
	                
	                var node = $menu.tree("getSelected");
	                var parentNode = $menu.tree("getParent", node.target);
	                var url = contextPath + "/system/menus/" + node.id + "?_method=put";
	                var param = "&" + $frmEditmenu.serialize();
	                $.post(url, param, function(result)
	                {
	                    if ($.string(result.errorCode).blank())
	                    {
	                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
	                        $dlgEditmenu.dialog("close");
	                        selectedId = node.id;
	                        loadmenuTree();
	                    }
	                    else
	                    {
	                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop(result.errorCode), "info", function()
	                        {
	                            //$menuName.focus();
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
	                logBehavior("log.behavior.dialog.close", ["menu.edit"]);
	                $dlgEditmenu.dialog("close");
	            }
	        }],
            onOpen : function()
            {
            	if (null != document.getElementById("dlgEditmenu"))
            	{
                	initEditMenuForm();
            	}	
            },
            onLoad : function()
            {
                initEditMenuForm();
            }
	    });
	    
	    $(".panel-tool-close", $dlgEditmenu.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["menu.edit"]);
	    });
    }

    $dlgEditmenu.dialog("open");
}


function initEditMenuForm()
{

    $frmEditmenu = $("form", $dlgEditmenu);
    $frmEditmenu.form("clear");
    $frmEditmenu.form("disableValidation");

    var node = $menu.tree("getSelected");
    var parentNode = $menu.tree("getParent", node.target);

    $parentId = $("input[name='parentId']", $frmEditmenu);
    $parentName = $("input[name='parentName']", $frmEditmenu);
    $menuId = $("input[name='menuId']", $frmEditmenu);
    $menuName = $("input[name='menuName']", $frmEditmenu);
    $menuUrl = $("input[name='menuUrl']", $frmEditmenu);
    $icon = $("input[name='icon']", $frmEditmenu);
    $funId = $("input[name='funId']", $frmEditmenu);
    $funName = $("input[name='funName']", $frmEditmenu);
    $sortNum = $("input[name='sortNum']", $frmEditmenu);
    
    $parentId.val(parentNode.id);
    $parentName.val(parentNode.text);
    $menuId.val(node.id);
    $menuName.val(node.text);
    $menuUrl.val(node.attributes.menuUrl);
    $icon.val(node.attributes.icon);
    $funId.val(node.attributes.funId);
    $funName.val(node.attributes.funName);
    $sortNum.val(node.attributes.sortNum);
    
    $menuName.focus();
}    
//---------------------------------------------------------delete--------------------------------------------
function removemenu()
{
    logBehavior("log.behavior.dialog.open", ["menu.list", "remove"]);
    
    var messager = $.messager.confirm($.i18n.prop("menu.remove"), $.i18n.prop("row.confirmDelete"), function(r)
    {
        if (r)
        {
            var node = $menu.tree("getSelected");
            $.post(contextPath + "/system/menus/" + node.id + "?_method=delete", null, function()
            {
                $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                loadmenuTree();
            }, "json");
        }
        else
        {
            logBehavior("log.behavior.dialog.close", ["menu.remove"]);
        }
    });
    
    $(".panel-tool-close", messager.window("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["menu.remove"]);
    });
}
//---------------------------------------------------------------show ------------------------------------------------
var $dlgShowmenu;
function showmenu()
{
    logBehavior("log.behavior.dialog.open", ["menu.list", "detail"]);
    if (!$dlgShowmenu)
    {
    	$dlgShowmenu = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgShowmenu' />");
	    $dlgShowmenu.dialog(
	    {
	    	closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("menu.detail"),
            width : 400,
            height : 430,
            href : contextPath + "/system/menus/show",
            buttons: "#dlgShowmenuButtons",
            onLoad: function()
            {
                initShowmenuForm();
            },
            onOpen: function()
            {
                if (null != document.getElementById("dlgShowmenu")){
                	initShowmenuForm();
            	}
            }
	    });
	    
        $("#dlgShowmenuButtons").show();
	    
	    $(".panel-tool-close", $dlgShowmenu.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["menu.detail"]);
	    });
	}
	
    $dlgShowmenu.dialog("open");
}

function initShowmenuForm()
{
	var $frmShowmenu = $("form", $dlgShowmenu);
    $frmShowmenu.form("clear");

    var node = $menu.tree("getSelected");
    var parentNode = $menu.tree("getParent", node.target);
    var $parentName = $("input[name='parentName']", $frmShowmenu);
    var $menuId = $("input[name='menuId']", $frmShowmenu);
    var $menuName = $("input[name='menuName']", $frmShowmenu);
    var $menuUrl = $("input[name='menuUrl']", $frmShowmenu);
    var $icon = $("input[name='icon']", $frmShowmenu);
    var $funName = $("input[name='funName']", $frmShowmenu);
    var $sortNum = $("input[name='sortNum']", $frmShowmenu);
    var $levelNum = $("input[name='levelNum']", $frmShowmenu);
    
    $parentName.val(parentNode.text);
    $menuId.val(node.id);
    $menuName.val(node.text);
    $menuUrl.val(node.attributes.menuUrl);
    $icon.val(node.attributes.icon);
    $funName.val(node.attributes.funName);
    $sortNum.val(node.attributes.sortNum);
    $levelNum.val(node.attributes.levelNum);
}

function editmenuFromDetail()
{
    logBehavior("log.behavior.menu.action2");
    $dlgShowmenu.dialog("close");
    editmenu();
}

function closemenuDetailDialog()
{
    logBehavior("log.behavior.dialog.close", ["menu.detail"]);
    $dlgShowmenu.dialog("close");
}