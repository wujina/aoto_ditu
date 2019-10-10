function getInfosList(node){
	var list = [];
	var info = null;
	//alert("node.children.length ==== "+node.children.length);
	for (var i = 0; i < node.children.length; i++) {  
		info = {};
		info.funId = node.children[i].id;
		info.oldFunId = node.children[i].id;
		info.funName = node.children[i].text;
		info.sortNum = i+1;
		list.push(info);
	}
	return list;
}

var selectedId = 0;
var maxLevelNum = 4;

$(function()
{
    $btnNewfun = $("#btnNewfun");
    $btnEditfun = $("#btnEditfun");
    $btnRemovefun = $("#btnRemovefun");
    $btnShowfun = $("#btnShowfun");
    $btnSetUrl = $("#btnSetUrl");
    $exportfun = $("#btnExportfun");
    $importfun = $("#btnImportfun");
    //FOR IE8
    $btnNewfun.attr("disabled","disabled");
    $btnEditfun.attr("disabled","disabled");
    $btnRemovefun.attr("disabled","disabled");
    $btnShowfun.attr("disabled","disabled");    
    $btnSetUrl.attr("disabled","disabled");    
    $fun = $("#fun").tree(
    {
        url : contextPath + "/system/funs/list",
        method : "get",
        lines : true,
        dnd : (1 == $btnEditfun.length),
        onSelect : function(node)
        {
            $btnNewfun.linkbutton("enable");
            $btnEditfun.linkbutton("enable");
            $btnShowfun.linkbutton("enable");
            $btnSetUrl.linkbutton("enable");
            //FOR IE8
            $btnNewfun.removeAttr("disabled");
            $btnEditfun.removeAttr("disabled");
            $btnShowfun.removeAttr("disabled"); 
            $btnSetUrl.removeAttr("disabled"); 
            
            var parentNode = $fun.tree("getParent", node.target);

            if (null == parentNode)
            {
                $btnEditfun.linkbutton("disable");
                $btnRemovefun.linkbutton("disable");
                $btnShowfun.linkbutton("disable");
            	$btnSetUrl.linkbutton("disable");
                //FOR IE8
                $btnEditfun.attr("disabled","disabled");
                $btnRemovefun.attr("disabled","disabled");
                $btnShowfun.attr("disabled","disabled");
            	$btnSetUrl.attr("disabled","disabled");
            }
            else
            {
                $btnEditfun.linkbutton("enable");
                $btnRemovefun.linkbutton("enable");
                $btnShowfun.linkbutton("enable");
           	    $btnSetUrl.linkbutton("enable");
                //FOR IE8
                $btnEditfun.removeAttr("disabled");
                $btnRemovefun.removeAttr("disabled");
                $btnShowfun.removeAttr("disabled");
            	$btnSetUrl.removeAttr("disabled"); 
            }
            if(node.attributes.levelNum>3){
            	$btnNewfun.linkbutton("disable");
                $btnNewfun.attr("disabled","disabled");
            }
        },
        onLoadSuccess : function(node, data)
        {
            var root = $fun.tree("getRoot");
            $fun.tree("expandAll", root.target);
            
            if(selectedId !=0){
                var node = $fun.tree("find", selectedId);
	            if (null != node)
	            {
	                $fun.tree("select", node.target);
	            }
	            selectedId = 0;
            }
        },
        onBeforeDrag : function(node)
        {
            var parentNode = $fun.tree("getParent", node.target);
            return (null != parentNode);
        },
        onBeforeDrop : function(target, source, point)
        {
             /*$.messager.confirm("操作提示", $.i18n.prop("fun.comfirmMove"), function (data) {  
	            alert(data);
             	if (data) {  
	                return true;
	            }  
	            else {  
	            	return false;
	            }  
	        });  */
            //return window.confirm($.i18n.prop("fun.comfirmMove"));
        	var flag = true;
        	var sourceNode = source;
        	var targetNode = $fun.tree("getNode", target);
            
            var targetNodeLevel = targetNode.attributes.levelNum;
            if ("append" == point){
            	if(targetNodeLevel + getDepthByParentNode(sourceNode)>maxLevelNum)  flag = false;
            }else{
            	if(targetNodeLevel + getDepthByParentNode(sourceNode)-1>maxLevelNum)  flag = false;
            }
        	
            if(!flag){
            	//logBehavior("log.behavior.dialog.open", ["dic.edit", "dic.edit"]);
            	$.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("maxLevelNum",maxLevelNum), "error",function(){});
            }
            
        	return flag;
        },
        onDrop : function(target, source, point)
        {
        	$.messager.confirm($.i18n.prop("operation.tip"), $.i18n.prop("fun.comfirmMove"), function (data) {  
             	if (data) {  
	                var sourceNode = source;
		            var targetNode = $fun.tree("getNode", target);
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
				                url : contextPath + "/system/funs/" + sourceNode.id + "/parent/" + targetNode.id + "/"+targetNode.attributes.levelNum+"?_method=put",
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
									$fun.tree("reload");
				            	}
				     	 });
		                
		            }
		            else
		            {
		            	var targetParentNode = $fun.tree("getParent", target);
		                if (null == targetParentNode)
		                {
		                	$fun.tree("reload");
		                    return false;
		                }
		                else
		                {
		                	tmpNode = $.extend(true, {}, targetParentNode);
							list = getInfosList(tmpNode);
		                    //更新排序号
		                	//alert("非 append");
			                $.ajax({
					                url : contextPath + "/system/funs/" + sourceNode.id + "/parent/" + tmpNode.id + "/"+tmpNode.attributes.levelNum+"?_method=put",
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
										$fun.tree("reload");
					            	}
					     	 });
		                    
		                }
		            }
		            
		            
	            }
	        }); 
        	
        }
    });
});

function loadfunTree()
{
    $btnNewfun.linkbutton("disable");
    $btnEditfun.linkbutton("disable");
    $btnRemovefun.linkbutton("disable");
    $btnShowfun.linkbutton("disable");
    //FOR IE8
    $btnNewfun.attr("disabled","disabled");
    $btnEditfun.attr("disabled","disabled");
    $btnRemovefun.attr("disabled","disabled");
    $btnShowfun.attr("disabled","disabled");
    $fun.tree("reload");
}

function exportExcel(){
	var url = contextPath + "/system/funs/exportExcel";
	window.location.href = url;
}

//----------------------------------------------- new fun --------------------------------------------
var $dlgNewfun;
function newfun()
{
    logBehavior("log.behavior.dialog.open", ["fun.list", "new"]);
    if (!$dlgNewfun)
    {
    	$dlgNewfun = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgNewfun' />");
	    $dlgNewfun.dialog(
	    {
	    	closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("fun.new"),
            width : 400,
            height : 300,
            href : contextPath + "/system/funs/new",
	        buttons : [
	        {
	            text : $.i18n.prop("submit"),
	            iconCls : "icon-ok",
	            handler : function()
	            {
	                $frmNewfun.form("enableValidation");
	
	                if (!$frmNewfun.form("validate"))
	                {
	                    logBehavior("log.behavior.dialog.invaild", ["fun.new"]);
	                    return;
	                }
	
	                var url = contextPath + "/system/funs";
	                var node = $fun.tree("getSelected");
	                var param = "levelNum=" + (node.attributes.levelNum + 1)
	                    + "&" + $frmNewfun.serialize();
	                //alert(param);     
	                
	                $.post(url, param, function(result)
	                {
	                    if ($.string(result.errorCode).blank())
	                    {
	                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
	                        $dlgNewfun.dialog("close");
	                        selectedId = node.id;
	                        loadfunTree();
	                    }
	                    else
	                    {
	                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop(result.errorCode), "info", function()
	                        {
	                            $funName.focus();
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
	                logBehavior("log.behavior.dialog.close", ["fun.new"]);
	                $dlgNewfun.dialog("close");
	            }
	        }],
            onLoad : function()
            {
                initNewFunForm();
            },
            onOpen : function()
            {
                if (null != document.getElementById("dlgNewfun"))
            	{
                	initNewFunForm();
            	}	
            }
	    });
	    
	    $(".panel-tool-close", $dlgNewfun.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["fun.new"]);
	    });

    }
    $dlgNewfun.dialog("open");
}

function initNewFunForm()
{
	$frmNewfun = $("form", $dlgNewfun);
	$frmNewfun.form("clear");
	$frmNewfun.form("disableValidation");
	var node = $fun.tree("getSelected");
    var children = $fun.tree("getChildren", node.target);
    var sortNum = (0 == children.length) ? 1 : children[children.length - 1].attributes.sortNum;

    $parentId = $("input[name='parentId']", $frmNewfun);
    $parentName = $("input[name='parentName']", $frmNewfun);
    $funId = $("input[name='funId']", $frmNewfun);
    $funName = $("input[name='funName']", $frmNewfun);
    $sortNum = $("input[name='sortNum']", $frmNewfun);

    $parentId.val(node.id);
    $parentName.val(node.text);
    var levelNum = node.attributes.levelNum+1;
    var tmpFunId;
    if(levelNum == 2){
    	tmpFunId = 10;
    }else if(levelNum > 2){
    	tmpFunId = node.id +"00";
    }
    tmpFunId = parseInt(tmpFunId);
    var tmpIdStr,last2Num,flag;
    for(var j=1;j<99;j++){
    	flag = true;
    	for(var i=0;i<children.length;i++){
	    	tmpIdStr = children[i].id.toString();
	    	last2Num = parseInt(tmpIdStr.substr(tmpIdStr.length-2));
	    	if(j==last2Num){
	    		flag = false;
	    		break;
	    	}
	    }
	    if(flag){
	    	last2Num = j;
	    	break;
	    } 
    }
    
    $funId.val(tmpFunId + j);
    $funName.focus();
    $sortNum.val(sortNum == 999 ? sortNum:sortNum + 1);
}
//--------------------------------------------------------------edit fun---------------------------------------------------------------------------
var $dlgEditfun;
function editfun()
{
    logBehavior("log.behavior.dialog.open", ["fun.list", "edit"]);
    if (!$dlgEditfun)
    {
    	$dlgEditfun = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgEditfun' />");
	    $dlgEditfun.dialog(
	    {
	    	closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("fun.edit"),
            width : 400,
            height : 300,
            href : contextPath + "/system/funs/edit",
	        buttons : [
	        {
	            text : $.i18n.prop("submit"),
	            iconCls : "icon-ok",
	            handler : function()
	            {
	                $frmEditfun.form("enableValidation");
	
	                if (!$frmEditfun.form("validate"))
	                {
	                    logBehavior("log.behavior.dialog.invaild", ["fun.edit"]);
	                    return;
	                }
	                
	                var node = $fun.tree("getSelected");
	                var parentNode = $fun.tree("getParent", node.target);
	                var url = contextPath + "/system/funs/" + node.id + "?_method=put";
	                var param = "&" + $frmEditfun.serialize();
	                $.post(url, param, function(result)
	                {
	                    if ($.string(result.errorCode).blank())
	                    {
	                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
	                        $dlgEditfun.dialog("close");
	                        selectedId = node.id;
	                        loadfunTree();
	                    }
	                    else
	                    {
	                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop(result.errorCode), "info", function()
	                        {
	                            //$funName.focus();
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
	                logBehavior("log.behavior.dialog.close", ["fun.edit"]);
	                $dlgEditfun.dialog("close");
	            }
	        }],
            onOpen : function()
            {
            	if (null != document.getElementById("dlgEditfun"))
            	{
                	initEditFunForm();
            	}	
            },
            onLoad : function()
            {
                initEditFunForm();
            }
	    });
		    
	    $(".panel-tool-close", $dlgEditfun.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["fun.edit"]);
	    });
	}
	
    $dlgEditfun.dialog("open");
}

function initEditFunForm()
{
	$frmEditfun = $("form", $dlgEditfun);
    $frmEditfun.form("clear");
    $frmEditfun.form("disableValidation");

    var node = $fun.tree("getSelected");
    var parentNode = $fun.tree("getParent", node.target);

    $parentId = $("input[name='parentId']", $frmEditfun);
    $parentName = $("input[name='parentName']", $frmEditfun);
    $funId = $("input[name='funId']", $frmEditfun);
    
    $funName = $("input[name='funName']", $frmEditfun);
    $sortNum = $("input[name='sortNum']", $frmEditfun);
    
    $parentId.val(parentNode.id);
    $parentName.val(parentNode.text);
    $funId.val(node.id);
    $funName.val(node.text);
    $sortNum.val(node.attributes.sortNum);
    
    $funName.focus();
}
//------------------------------------------------------delete fun-----------------------------------------------
function removefun()
{
    logBehavior("log.behavior.dialog.open", ["fun.list", "remove"]);
    
    var messager = $.messager.confirm($.i18n.prop("fun.remove"), $.i18n.prop("row.confirmDelete"), function(r)
    {
        if (r)
        {
            var node = $fun.tree("getSelected");
            $.post(contextPath + "/system/funs/" + node.id + "?_method=delete", null, function()
            {
                $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                loadfunTree();
            }, "json");
        }
        else
        {
            logBehavior("log.behavior.dialog.close", ["fun.remove"]);
        }
    });
    
    $(".panel-tool-close", messager.window("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["fun.remove"]);
    });
}

//------------------------------------------------------show fun ------------------------------------------------

var $dlgShowfun;
function showfun()
{
    logBehavior("log.behavior.dialog.open", ["fun.list", "detail"]);
    if (!$dlgShowfun)
    {
    	$dlgShowfun = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgShowfun' />");
	    $dlgShowfun.dialog(
	    {
	    	closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("fun.detail"),
            width : 400,
            height : 330,
            href : contextPath + "/system/funs/show",
            buttons: "#dlgShowfunButtons",
            onLoad: function()
            {
                initShowFunForm();
            },
            onOpen: function()
            {
                if (null != document.getElementById("dlgShowfun")){
                	initShowFunForm();
            	}
            }
	    });
	    
        $("#dlgShowfunButtons").show();
	    
	    $(".panel-tool-close", $dlgShowfun.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["fun.detail"]);
	    });
	}
	
    $dlgShowfun.dialog("open");
}

function initShowFunForm()
{
    var $frmShowfun = $("form", $dlgShowfun);
    $frmShowfun.form("clear");

    var node = $fun.tree("getSelected");
    var parentNode = $fun.tree("getParent", node.target);
    var $parentName = $("input[name='parentName']", $frmShowfun);
    var $funId = $("input[name='funId']", $frmShowfun);
    var $funName = $("input[name='funName']", $frmShowfun);
    var $sortNum = $("input[name='sortNum']", $frmShowfun);
    var $levelNum = $("input[name='levelNum']", $frmShowfun);
    
    $parentName.val(parentNode.text);
    $funId.val(node.id);
    $funName.val(node.text);
    $sortNum.val(node.attributes.sortNum);
    $levelNum.val(node.attributes.levelNum);
}

function editfunFromDetail()
{
    logBehavior("log.behavior.fun.action2");
    $dlgShowfun.dialog("close");
    editfun();
}

function closefunDetailDialog()
{
    logBehavior("log.behavior.dialog.close", ["fun.detail"]);
    $dlgShowfun.dialog("close");
}

//------------------------------------------------------fun url --------------------------------------------------------------------

var $dlgSelectUrl;
function setUrl()
{
    logBehavior("log.behavior.dialog.open", ["fun.list", "fun.setUrl"]);

    if (!$dlgSelectUrl)
    {
        $dlgSelectUrl = $("<div style='padding: 15px 15px;overflow:hidden;' id='dlgSelectUrl' />");
        $dlgSelectUrl.dialog(
        {
            closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("fun.setUrl"),
            width : 970,
            height : 450,
            href : contextPath + "/system/urls/select",
            
	        buttons : [
	        {
	            text : $.i18n.prop("submit"),
	            iconCls : "icon-ok",
	            handler : function()
	            {
	                var row = $fun.tree("getSelected");     
	                submitFunUrl(row.id);
	            }
	        },
	        {
	            text : $.i18n.prop("cancel"),
	            iconCls : "icon-remove",
	            handler : function()
	            {
	                logBehavior("log.behavior.dialog.close", ["fun.setUrl"]);
	                $dlgSelectUrl.dialog("close");
	            }
	        }],
	        onOpen : function()
	        {
	            if (null == document.getElementById("dgSelectedUser"))
                {
                    return;
                }
	            
	            var row = $fun.tree("getSelected"); 
	            initUserSelector(contextPath + "/system/funs/" + row.id + "/urls", null);
	        },
            onLoad : function()
            {
	            var row = $fun.tree("getSelected"); 
	            initUserSelector(contextPath + "/system/funs/" + row.id + "/urls", null);
            }
        });
        
	    $(".panel-tool-close", $dlgSelectUrl.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["fun.setUrl"]);
	    });
    }
    
    $dlgSelectUrl.dialog("open");
}

function submitFunUrl(funId)
{
    var rows = $dgSelectedUser.datagrid("getRows");

    if (0 == rows.length)
    {
        $.messager.confirm($.i18n.prop("messager.confirm"), $.i18n.prop("url.confirmUnselected"), function(r)
        {
            if (r)
            {
                postFunUrl(funId, null);
            }
            else
            {
                logBehavior("log.behavior.fun.action1");
            }
        });
    }
    else
    {
        postFunUrl(funId, rows);
    }
}

function postFunUrl(funId, rows)
{
    var list = [];

    if (null != rows)
    {
        $.each(rows, function(index, item)
        {
            list.push(item.urlId);
        });
    }

    var postData = $.toJSON(list);

    $.ajax(
    {
        url : contextPath + "/system/funs/" + funId + "/urls",
        type : "post",
        dataType : "json",
        contentType : "application/json",
        data : postData,
        success : function()
        {
            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
            $dlgSelectUrl.dialog("close");
            //loadRoles();
        }
    });
}