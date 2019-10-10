function getInfosList(node){
	var list = [];
	var info = null;
	//alert("node.children.length ==== "+node.children.length);
	for (var i = 0; i < node.children.length; i++) {  
		info = {};
		info.orgId = node.children[i].id;
		info.orgName = node.children[i].text;
		info.sortNum = i+1;
		list.push(info);
	}
	return list;
}

var selectedId = 0;

$(function()
{
    $sOrgName = $("#sOrgName");
    $sOrgCode = $("#sOrgCode");
    $btnNewOrg = $("#btnNewOrg");
    $btnEditOrg = $("#btnEditOrg");
    $btnRemoveOrg = $("#btnRemoveOrg");
    $btnShowOrg = $("#btnShowOrg");
    $exportOrg = $("#btnExportOrg");
    $importOrg = $("#btnImportOrg");
    //FOR IE8
    $btnNewOrg.attr("disabled","disabled");
    $btnEditOrg.attr("disabled","disabled");
    $btnRemoveOrg.attr("disabled","disabled");
    $btnShowOrg.attr("disabled","disabled");    
    $org = $("#org").tree(
    {
        url : contextPath + "/system/orgs/list",
        method : "get",
        lines : true,
        dnd : (1 == $btnEditOrg.length),
        onSelect : function(node)
        {
            $btnNewOrg.linkbutton("enable");
            $btnEditOrg.linkbutton("enable");
            $btnShowOrg.linkbutton("enable");
            //FOR IE8
            $btnNewOrg.removeAttr("disabled");
            $btnEditOrg.removeAttr("disabled");
            $btnShowOrg.removeAttr("disabled"); 
            
            var parentNode = $org.tree("getParent", node.target);

            if (null == parentNode)
            {
                $btnEditOrg.linkbutton("disable");
                $btnRemoveOrg.linkbutton("disable");
                $btnShowOrg.linkbutton("disable");
                //FOR IE8
                $btnEditOrg.attr("disabled","disabled");
                $btnRemoveOrg.attr("disabled","disabled");
                $btnShowOrg.attr("disabled","disabled");
            }
            else
            {
                $btnEditOrg.linkbutton("enable");
                $btnRemoveOrg.linkbutton("enable");
                $btnShowOrg.linkbutton("enable");
                //FOR IE8
                $btnEditOrg.removeAttr("disabled");
                $btnRemoveOrg.removeAttr("disabled");
                $btnShowOrg.removeAttr("disabled");
            }
        },
        onLoadSuccess : function(node, data)
        {
            var root = $org.tree("getRoot");
            $org.tree("expandAll", root.target);
            
            if(selectedId !=0){
                var node = $org.tree("find", selectedId);
	            if (null != node)
	            {
	                $org.tree("select", node.target);
	            }
	            selectedId = 0;
            }
        },
        onBeforeDrag : function(node)
        {
            var parentNode = $org.tree("getParent", node.target);
            return (null != parentNode);
        },
        onBeforeDrop : function(target, source, point)
        {
             /*$.messager.confirm("操作提示", $.i18n.prop("org.comfirmMove"), function (data) {  
	            alert(data);
             	if (data) {  
	                return true;
	            }  
	            else {  
	            	return false;
	            }  
	        });  */
            //return window.confirm($.i18n.prop("org.comfirmMove"));
        	return true;
        },
        onDrop : function(target, source, point)
        {
        	$.messager.confirm($.i18n.prop("operation.tip"), $.i18n.prop("org.comfirmMove"), function (data) {  
             	if (data) {  
	                var sourceNode = source;
		            var targetNode = $org.tree("getNode", target);
		            var url, param;
					var map = {};
		            map.list = [];
					var tmpNode = null;
					
		            if ("append" == point)
		            {
		            	var tmpNode = $.extend(true, {}, targetNode);
		            	map.list = getInfosList(tmpNode);	
		            	map.inheritedId = targetNode.attributes.inheritedId + "/" + sourceNode.id;
		            	map.inheritedName = targetNode.attributes.inheritedName + "/" + sourceNode.text;
		            	
		                $.ajax({
				                url : contextPath + "/system/orgs/" + sourceNode.id + "/parent/" + targetNode.id + "/"+targetNode.attributes.levelNum+"?_method=put",
				                type : "post",
				                dataType : "json",
				        		data : $.toJSON(map),
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
	        						loadOrgTree();
				            	}
				     	 });
		                
		                
		            }
		            else
		            {
		                var targetParentNode = $org.tree("getParent", target);
		
		                if (null == targetParentNode)
		                {
		                    loadOrgTree();
		                    return false;
		                }
		                else
		                {
		                    var tmpNode = $.extend(true, {}, targetParentNode);
			            	map.list = getInfosList(tmpNode);	
			            	map.inheritedId = tmpNode.attributes.inheritedId + "/" + sourceNode.id;
			            	map.inheritedName = tmpNode.attributes.inheritedName + "/" + sourceNode.text;	                
			                $.ajax({
					                url : contextPath + "/system/orgs/" + sourceNode.id + "/parent/" + tmpNode.id + "/"+tmpNode.attributes.levelNum+"?_method=put",
					                type : "post",
					                dataType : "json",
					        		data : $.toJSON(map),
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
	        							loadOrgTree();
					            	}
					     	 });
		                }
		            }
	            }
	        }); 
	        
        	
        }
    });
});

function loadOrgTree()
{
    $btnNewOrg.linkbutton("disable");
    $btnEditOrg.linkbutton("disable");
    $btnRemoveOrg.linkbutton("disable");
    $btnShowOrg.linkbutton("disable");
    //FOR IE8
    $btnNewOrg.attr("disabled","disabled");
    $btnEditOrg.attr("disabled","disabled");
    $btnRemoveOrg.attr("disabled","disabled");
    $btnShowOrg.attr("disabled","disabled");
    $org.tree("reload");  
    //setTimeout(function(){searchOrgs();alert('wwwww');},6000);
}

function searchOrgs()
{
    logBehavior("log.behavior.page.query", ["org.title","org.list"]);
    var sData = {};
    if($sOrgName.val()) sData.text = $sOrgName.val();
    if($sOrgCode.val()) sData.orgCode = $sOrgCode.val();
    //alert($.toJSON(sData));
    $org.tree("search",sData);	 
}

//new org
var $dlgNewOrg;

function newOrg()
{
    logBehavior("log.behavior.dialog.open", ["org.list", "new"]);
    if (!$dlgNewOrg)
    {
        $dlgNewOrg = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgNewOrg' />");
        $dlgNewOrg.dialog(
        {
            closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("org.new"),
            width : 400,
            height : 430,
            href : contextPath + "/system/orgs/new",
            buttons : [
            {
                text : $.i18n.prop("submit"),
                iconCls : "icon-ok",
                handler : function()
                {
                    $frmNewOrg.form("enableValidation");

                    if (!$frmNewOrg.form("validate"))
                    {
                        logBehavior("log.behavior.dialog.invaild", ["org.new"]);
                        return;
                    }

                    var url = contextPath + "/system/orgs";
                    var node = $org.tree("getSelected");
                    var param = "levelNum=" + (node.attributes.levelNum + 1) + "&parentInheritedId=" + node.attributes.inheritedId 
                        + "&inheritedName=" + node.attributes.inheritedName + "/" + $.trim($orgName.val()) + "&";
                    param = encodeURI(param) + $frmNewOrg.serialize();
					
                    $.post(url, param, function(result)
                    {
                        if ($.string(result.errorCode).blank())
                        {
                            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                            $dlgNewOrg.dialog("close");
                            selectedId = node.id;
                            loadOrgTree();
                        }
                        else
                        {
                            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop(result.errorCode), "info", function()
                            {
                                $orgName.focus();
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
                    logBehavior("log.behavior.dialog.close", ["org.new"]);
                    $dlgNewOrg.dialog("close");
                }
            }],
            onOpen : function()
            {
                initNewOrgForm();
            },
            onLoad: function()
            {
                initNewOrgForm();
            }
        });
        
        $(".panel-tool-close", $dlgNewOrg.dialog("header")).on("click", function()
        {
            logBehavior("log.behavior.dialog.x", ["org.new"]);
        });
    }
    
    $dlgNewOrg.dialog("open");
}

function initNewOrgForm()
{
    $frmNewOrg = $("form", $dlgNewOrg);
    $frmNewOrg.form("clear");
    $frmNewOrg.form("disableValidation");

    var node = $org.tree("getSelected");
    var children = $org.tree("getChildren", node.target);
    var sortNum = (0 == children.length) ? 1 : children[children.length - 1].attributes.sortNum;

    $parentId = $("input[name='parentId']", $frmNewOrg);
    $parentName = $("input[name='parentName']", $frmNewOrg);
    $orgName = $("input[name='orgName']", $frmNewOrg);
    $sortNum = $("input[name='sortNum']", $frmNewOrg);

    $parentId.val(node.id);
    $parentName.val(node.text);
    $orgName.focus();
    $sortNum.val(sortNum + 1);
}

// edit org
var $dlgEditOrg;

function editOrg()
{
    logBehavior("log.behavior.dialog.open", ["org.list", "edit"]);
    
    if (!$dlgEditOrg)
    {
        $dlgEditOrg = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgEditOrg' />");
        $dlgEditOrg.dialog(
        {
            closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("org.edit"),
            width : 400,
            height : 430,
            href : contextPath + "/system/orgs/new",
            buttons : [
            {
                text : $.i18n.prop("submit"),
                iconCls : "icon-ok",
                handler : function()
                {
                    $frmEditOrg.form("enableValidation");

                    if (!$frmEditOrg.form("validate"))
                    {
                        logBehavior("log.behavior.dialog.invaild", ["org.edit"]);
                        return;
                    }
                    
                    var node = $org.tree("getSelected");
                    var parentNode = $org.tree("getParent", node.target);
                    var url = contextPath + "/system/orgs/" + node.id + "?_method=put";
                    var param = "&inheritedName=" + parentNode.attributes.inheritedName + "/" + $.trim($orgName.val()) + "&";
                    param = encodeURI(param) + $frmEditOrg.serialize();

                    $.post(url, param, function(result)
                    {
                        if ($.string(result.errorCode).blank())
                        {
                            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                            $dlgEditOrg.dialog("close");
                            selectedId = node.id;
                            loadOrgTree();
                        }
                        else
                        {
                            $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop(result.errorCode), "info", function()
                            {
                                $orgName.focus();
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
                    logBehavior("log.behavior.dialog.close", ["org.edit"]);
                    $dlgEditOrg.dialog("close");
                }
            }],
            onOpen : function()
            {
                initEditOrgForm();
            },
            onLoad: function()
            {
                initEditOrgForm();
            }
        });
        
        $(".panel-tool-close", $dlgEditOrg.dialog("header")).on("click", function()
        {
            logBehavior("log.behavior.dialog.x", ["org.edit"]);
        });
    }
    
    $dlgEditOrg.dialog("open");
}

function initEditOrgForm()
{
    $frmEditOrg = $("form", $dlgEditOrg);
    $frmEditOrg.form("clear");
    $frmEditOrg.form("disableValidation");

    var node = $org.tree("getSelected");
    var parentNode = $org.tree("getParent", node.target);

    $parentId = $("input[name='parentId']", $frmEditOrg);
    $parentName = $("input[name='parentName']", $frmEditOrg);
    $orgName = $("input[name='orgName']", $frmEditOrg);
    $sortNum = $("input[name='sortNum']", $frmEditOrg);
    $orgCode = $("input[name='orgCode']", $frmEditOrg);
    $tel = $("input[name='tel']", $frmEditOrg);
    $address = $("textarea[name='address']", $frmEditOrg);
    $remark = $("textarea[name='remark']", $frmEditOrg);
    $parentId.val(parentNode.id);
    $parentName.val(parentNode.text);
    $orgName.val(node.text);
    $sortNum.val(node.attributes.sortNum);
    $orgCode.val(node.orgCode);
    $tel.val(node.attributes.tel);
    $address.val(node.attributes.address);
    $remark.val(node.attributes.remark);
    $orgName.focus();
}

// remove org
function removeOrg()
{
    logBehavior("log.behavior.dialog.open", ["org.list", "remove"]);
    
    var messager = $.messager.confirm($.i18n.prop("org.remove"), $.i18n.prop("row.confirmDelete"), function(r)
    {
        if (r)
        {
            var node = $org.tree("getSelected");
            
            var url = contextPath + "/system/orgs/" +node.id + "?_method=delete";
            $.post(url, null, function(result)
            {
                if (result > 0)
                {
                    $.messager.alert($.i18n.prop("messager.info"), "该组织或子组织有正在使用的设备！");
                    logBehavior("log.behavior.dialog.close", ["org.remove"]);
                }
                else
                {
                    $.post(contextPath + "/system/orgs/" + node.id + "?_method=delete", null, function()
                            {
                                $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
                                loadOrgTree();
                            }, "json");
                }
            }, "json");

        }
        else
        {
            logBehavior("log.behavior.dialog.close", ["org.remove"]);
        }
    });
    
    $(".panel-tool-close", messager.window("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["org.remove"]);
    });
}

// show org
var $dlgShowOrg;

function showOrg()
{
    logBehavior("log.behavior.dialog.open", ["org.list", "detail"]);
    
    if (!$dlgShowOrg)
    {
        $dlgShowOrg = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgShowOrg' />");
        $dlgShowOrg.dialog(
        {
            closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("org.detail"),
            width : 600,
            height : 430,
            href : contextPath + "/system/orgs/show",
            buttons: "#dlgShowOrgButtons",
            onOpen : function()
            {
                initShowOrgForm();
            },
            onLoad : function()
            {
                initShowOrgForm();
            }
        });
        
        $("#dlgShowOrgButtons").show();
        
        $(".panel-tool-close", $dlgShowOrg.dialog("header")).on("click", function()
        {
            logBehavior("log.behavior.dialog.x", ["org.detail"]);
        });
    }
    
    $dlgShowOrg.dialog("open");
}

function initShowOrgForm()
{
    var $frmShowOrg = $("form", $dlgShowOrg);
    $frmShowOrg.form("clear");

    var node = $org.tree("getSelected");
    var parentNode = $org.tree("getParent", node.target);
    var $parentName = $("input[name='parentName']", $frmShowOrg);
    var $orgName = $("input[name='orgName']", $frmShowOrg);
    var $sortNum = $("input[name='sortNum']", $frmShowOrg);
    var $levelNum = $("input[name='levelNum']", $frmShowOrg);
    var $orgCode = $("input[name='orgCode']", $frmShowOrg);
    var $tel = $("input[name='tel']", $frmShowOrg);
    var $address = $("textarea[name='address']", $frmShowOrg);
    var $remark = $("textarea[name='remark']", $frmShowOrg);
    var $createdByName = $("input[name='createdByName']", $frmShowOrg);
    var $createdDate = $("input[name='createdDate']", $frmShowOrg);
    var $lastUpdatedByName = $("input[name='lastUpdatedByName']", $frmShowOrg);
    var $lastUpdatedDate = $("input[name='lastUpdatedDate']", $frmShowOrg);
    
    $parentName.val(parentNode.text);
    $orgName.val(node.text);
    $sortNum.val(node.attributes.sortNum);
    $levelNum.val(node.attributes.levelNum);
    $tel.val(node.attributes.tel);
    $address.val(node.attributes.address);
    $orgCode.val(node.orgCode);
    $remark.val(node.attributes.remark);
    $createdByName.val(node.attributes.createdByName);
    $lastUpdatedByName.val(node.attributes.lastUpdatedByName);
    $createdDate.val(formatDate(node.attributes.createdDate));
    $lastUpdatedDate.val(formatDate(node.attributes.lastUpdatedDate));
}

function editOrgFromDetail()
{
    logBehavior("log.behavior.org.action2");
    $dlgShowOrg.dialog("close");
    editOrg();
}

function closeOrgDetailDialog()
{
    logBehavior("log.behavior.dialog.close", ["org.detail"]);
    $dlgShowOrg.dialog("close");
}

// export org
function exportExcel()
{
    window.location.href = contextPath + "/system/orgs/export";
}

// import org
var $dlgImportOrg;

function importExcel()
{
    logBehavior("log.behavior.dialog.open", ["org.list", "import"]);
    
    if (!$dlgImportOrg)
    {
        $dlgImportOrg = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgImportOrg' />");
        $dlgImportOrg.dialog(
        {
            closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("org.import"),
            width : 400,
            height : 250,
            href : contextPath + "/system/orgs/import",
            buttons : [
            {
                text : $.i18n.prop("submit"),
                iconCls : "icon-ok",
                handler : function()
                {
                    ajaxFileUpload();
                }
            },
            {
                text : $.i18n.prop("cancel"),
                iconCls : "icon-remove",
                handler : function()
                {
                    logBehavior("log.behavior.dialog.close", ["org.import"]);
                    $dlgImportOrg.dialog("close");
                }
            }],
            onOpen : function()
            {
//                $frmNewResFile = $("form", $dlgImportOrg);
//
//                var $fileName = $("input[name='fileName']", $frmNewResFile);
//
//                $frmNewResFile.form("clear");
//                $frmNewResFile.form("disableValidation");
//
//                $fileName.focus();
            },
            onLoad: function()
            {
//                $frmNewResFile = $("form", $dlgImportOrg);
//
//                var $fileName = $("input[name='fileName']", $frmNewResFile);
//
//                $frmNewResFile.form("clear");
//                $frmNewResFile.form("disableValidation");
//
//                $fileName.focus();
            }
        });

        $(".panel-tool-close", $dlgImportOrg.dialog("header")).on("click", function()
        {
            logBehavior("log.behavior.dialog.close", ["org.import"]);
        });
    }
    
    $dlgImportOrg.dialog("open");
}

var err = { "acceptFileTypes": "只能上传excel文档，支持文件类型(.xls或.xlsx)",
        "maxFileSize": "上传文件大小超出范围60M"
};


function hasError(file) {
    var acceptFileTypes = /(\.|\/)(xls|xlsx)$/i;

    if (!(acceptFileTypes.test(file))) {
        return "acceptFileTypes";
    }
    return "OK";
}

function ajaxFileUpload()
{
    var filepath=$("input[name='files']").val();
    if(filepath != "" && filepath != "undefined" && filepath != null){
        if(hasError(filepath) != "OK"){
            $.messager.alert("温馨提示",err[hasError(filepath)],"warning");
            return false;
        }       
    }
    
    var url = contextPath + '/system/orgs/import';
    $(".datagrid-mask").css({display:"block",width:"100%",height:$(window).height()});
    $(".datagrid-mask-msg").css({display:"block",left:($dlgImportOrg.outerWidth(true) - 190) / 2,top:($(window).height() - 280) / 2});
    $.ajaxFileUpload
    (
        {
            url:url,
            secureuri:false,
            fileElementId:'fileupload',
            dataType: 'json',
            success: function (data, status)
            {
                $(".datagrid-mask").hide();
                $(".datagrid-mask-msg").hide();
                if(data.msg == "success"){
                     $.messager.alert($.i18n.prop("messager.info"), "上传成功", "info");
                     $dlgImportOrg.dialog("close");
                     loadOrgTree();
                }else if(data.msg == "overSize"){
                    $.messager.alert("温馨提示",err["maxFileSize"],"warning");
                    return false;
                }else{
                    $.messager.alert("温馨提示",data.msg,"warning");
                    return false;
                }
            },
            error: function (data, status, e)
            {
                $(".datagrid-mask").hide();
                $(".datagrid-mask-msg").hide();         
                $.messager.alert("温馨提示","上传失败","warning");
                return false;
            }
        }
    );
}