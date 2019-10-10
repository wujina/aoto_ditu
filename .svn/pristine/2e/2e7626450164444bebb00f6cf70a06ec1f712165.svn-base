$(function()
{ 
	$queryDicName = $("#queryDicName");
	$queryDicType = $("#queryDicType");
	
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

function searchDic()
{
    logBehavior("log.behavior.page.query", ["dic.title","dic.list"]);
    loadDic();
}

function loadDic()
{
	$dgDic.datagrid("clearSelections");
    
    var param = {};
    // param.devicename = $uname.val();
    param.dicName = $queryDicName.val();
    param.dicType = $queryDicType.val();

    $dgDic.datagrid("load", param);
}

//---------------------------new dic ---------------------------------------
var $dlgNewDic;
function newDic()
{	
    logBehavior("log.behavior.dialog.open", ["dic.new", "dic.new"]);
    
	if (!$dlgNewDic)
    {
    	$dlgNewDic = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgNewDic' />");
		$dlgNewDic.dialog(
	    {
	    	closed : true,
            modal : true,
            cache : true,
            title : $.i18n.prop("dic.new"),
            width : 700,
            height : 480,
            href : contextPath + "/system/dics/new",
	    
	        buttons : [
	        {
	            text : $.i18n.prop("submit"),
	            iconCls : "icon-ok",
	            handler : function()
	            {
	            	$frmNewDic.form("enableValidation");
	
	                if (!$frmNewDic.form("validate"))
	                {
	                    logBehavior("log.behavior.dialog.invaild", ["dic.new"]);
	                    return;
	                }
	                
	                endEditing();
	
	                //得到表单数据
	                var rows = $dgdb.datagrid("getRows");
	                if(rows.length < 1){
	                	$.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("dic.validation.message1"), "warning");
	                	return;
	                }
	                var list =[];
	//                alert("创建者userId"+$("#userId").val());
	                
	                for(var i = 0;i<rows.length;i++){
	                	for(var j = i+1;j<rows.length;j++){
	                		if(rows[i].dicKey == rows[j].dicKey){
	                			$.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("dic.validation.message2",j+1,i+1), "warning");
	                			return;
	                		}
	                	}
	                }
	                $.each(rows, function(index, item)
	                {	
	    				  list.push(
	    				  {
	    					  dicName:$dlgNewDic.find("[name='dicName']").val(),
	    					  dicType:$dlgNewDic.find("[name='dicType']").val(),
	    				      dicKey: item.dicKey,
	    				      dicValue: item.dicValue,
	    				      dicSymbol: item.dicSymbol
	    				  });
	    		    });
	                //alert("数据"+$.toJSON(list));
	                $.ajax(
				            {
				                url : contextPath + "/system/dics",
				                type : "post",
				                dataType : "json",
				        		data : $.toJSON(list),
				        		contentType : "application/json",
				                success : function(result)
				                {	
				            		if ($.string(result.errorCode).blank())
				                    {
				                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
				                        $frmNewDic.form("clear");
				                    	$frmNewDic.form("disableValidation");
				                    	reject();
				                        $dlgNewDic.dialog("close");
				                        $("#dgDic").datagrid("reload");
				                        $("#dgDic").datagrid("clearSelections");
				                    }
				                    else
				                    {	
				                    	 //查询dicType不可重复
				                        $.messager.alert($.i18n.prop("messager.info"), result.errorCode, "error", function()
				                        {
				                            
				                        });
				                    }
				            	}
				     	 });
	            }
	        },
	        {
	            text : $.i18n.prop("cancel"),
	            iconCls : "icon-remove",
	            handler : function()
	            {
	                logBehavior("log.behavior.dialog.close", ["dic.new"]);
	                $dlgNewDic.dialog("close");
	            }
	        }],
            onLoad : function()
            {
                initNewDicForm();
            },
            onOpen : function()
            {
            	if (null != document.getElementById("dlgNewDic"))
            	{
            		initNewDicForm();
            	}
            }
	    });
	
	    $(".panel-tool-close", $dlgNewDic.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["dic.new"]);
	    });
    }  
    $dlgNewDic.dialog("open");
}    

function initNewDicForm()
{
	$frmNewDic = $("#dlgNewDic form");
    $frmNewDic.form("clear");
    $frmNewDic.form("disableValidation");
	$dgdb = $("#dgdb");
}
//-----------------------------------edit dic ------------------------------------

function initEditDicForm()
{
	$frmEditDic = $("#dlgEditDic form");
    $frmEditDic.form("clear");
    $frmEditDic.form("disableValidation");
    var row = $dgDic.datagrid("getSelections")[0];
	var param = {};
	param.byPage = false;
    param.dicType = row.dicType;
	$dgdbEd = $("#dgdbEd");
	console.log("111:" + row.dicType);
	console.log(param);
	$dgdbEd.datagrid(
    {
        url : contextPath + "/system/dics/"+row.dicType,
        method : "get",
        queryParams:param
    });
	$dlgEditDic.find("[name='dicName']").val(row.dicName);
	$dlgEditDic.find("[name='dicType']").val(row.dicType);
}
var $dlgEditDic;

function editDic()
{	
    logBehavior("log.behavior.dialog.open", ["dic.edit", "dic.edit"]);
	if (!$dlgEditDic)
    {
    	$dlgEditDic = $("<div style='padding: 15px 15px; overflow: hidden;' id='dlgEditDic' />");
		$dlgEditDic.dialog(
	    {
	        closed:true,
            modal:true,
            cache:true,
            title: $.i18n.prop("dic.edit"),
            width: 700,
            height: 480,
            href: contextPath + "/system/dics/edit",
	    	buttons : [
	        {
	            text : $.i18n.prop("submit"),
	            iconCls : "icon-ok",
	            handler : function()
	            {
	            	$frmEditDic.form("enableValidation");
	
	                if (!$frmEditDic.form("validate"))
	                {
	                    logBehavior("log.behavior.dialog.invaild", ["dic.edit"]);
	                    return;
	                }
	                endEditingEd();
	                var dicName = $dlgEditDic.find("[name='dicName']").val();
	                var dicType = $dlgEditDic.find("[name='dicType']").val();
	                var rows = $dgdbEd.datagrid('getRows');
	                if(rows.length < 1){
	                	$.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("dic.validation.message1"), "warning");
	                	return;
	                }
				    for(var i = 0;i<rows.length;i++){
	                	for(var j = i+1;j<rows.length;j++){
	                		if(rows[i].dicKey == rows[j].dicKey){
	                			$.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("dic.validation.message2",j+1,i+1), "warning");
	                			return;
	                		}
	                	}
	                }
	                
					var list = [];
					
	                var inserted = $dgdbEd.datagrid('getChanges', "inserted");
	                var deleted = $dgdbEd.datagrid('getChanges', "deleted");
	                
				    $.each(inserted, function(index, item)
				    {	
				        list.push(
				        {
				        	  dicName:dicName,
						  	  dicType:dicType,
	    				      dicKey: item.dicKey,
	    				      dicValue: item.dicValue,
	    				      dicSymbol: item.dicSymbol,
	    				      status:'inserted'
				        });
				    });
				    $.each(deleted, function(index, item)
				    {	
				        list.push(
				        {
				        	dicId: item.dicId,
				    	    status:'deleted'
				        });
				    });
				    
	                
	                $.each(rows, function(index, item)
				    {	
				    	if(item.dicId>0){
				    		list.push(
					        {
					        	  dicId: item.dicId,
					        	  dicName:dicName,
							  	  dicType:dicType,
		    				      dicKey: item.dicKey,
		    				      dicValue: item.dicValue,
		    				      dicSymbol: item.dicSymbol,
					    	   	  status:'updated'
					        });
				    	}
				    });
					//alert($.toJSON(list));
				    $.ajax({
			                url : contextPath + "/system/dics?_method=put",
			                type : "post",
			                dataType : "json",
			        		data : $.toJSON(list),
			        		contentType : "application/json",
			                success : function(result)
			                {	
			                	if ($.string(result.errorCode).blank())
			                    {
			                        $.messager.alert($.i18n.prop("messager.info"), $.i18n.prop("submit.success"), "info");
			                        $frmEditDic.form("clear");
			                    	$frmEditDic.form("disableValidation");
			                        $dlgEditDic.dialog("close");
			                        $("#dgDic").datagrid("reload");
			                        $("#dgDic").datagrid("clearSelections");
			                    }
			                    else
			                    {
			                        $.messager.alert($.i18n.prop("messager.info"), result.errorCode, "error", function()
			                        {
			                            
			                        });
			                    }
			            	}
			     	 });
					    
	               }
	        },
	        {
	            text : $.i18n.prop("cancel"),
	            iconCls : "icon-remove",
	            handler : function()
	            {
	                logBehavior("log.behavior.dialog.close", ["dic.edit"]);
	                $dlgEditDic.dialog("close");
	            }
	        }],
            onLoad : function()
            {
                initEditDicForm();
            },
            onOpen : function()
            {
            	if (null != document.getElementById("dlgEditDic")){
                	initEditDicForm();
            	}
            }
	    });
	
	    $(".panel-tool-close", $dlgEditDic.dialog("header")).on("click", function()
	    {
	        logBehavior("log.behavior.dialog.x", ["dic.edit"]);
	    });
    }
    
    $dlgEditDic.dialog("open");
    
}
//-----------------------------------delete dic--------------------------------
function removeDic()
{
	$dgDic = $("#dgDic");
	
    logBehavior("log.behavior.dialog.open", ["dic.list", "remove"]);

    var messager = $.messager.confirm($.i18n.prop("dic.remove"), $.i18n.prop("row.confirmDelete"), function(r)
    {
        if (r)
        {
            var rows = $dgDic.datagrid("getSelections");
            var list = [];
//            alert(rows.length);
            $.each(rows, function(index, item)
            {
                list.push(item.dicType);
            });

            $.ajax(
            {
                url : contextPath + "/system/dics?_method=DELETE",
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
            logBehavior("log.behavior.dialog.close", ["dic.remove"]);
        }
    });

    $(".panel-tool-close", messager.window("header")).on("click", function()
    {
        logBehavior("log.behavior.dialog.x", ["dic.remove"]);
    });
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

function initShowDicForm()
{
	var $frmShowDic = $("form", $dlgShowDic);
    $frmShowDic.form("clear");
    
	$queryDicKey = $("#queryDicKey");
	$queryDicValue = $("#queryDicValue");
	$queryDicSymbol = $("#queryDicSymbol");
	$dicDgShow = $("#dicDgShow");
	loadDicDetail();
}


function searchDicDetail()
{
    logBehavior("log.behavior.page.query", ["dic.title","dic.list"]);
    loadDicDetail();
}

function loadDicDetail(){
	var row = $dgDic.datagrid("getSelections")[0];
	$dlgShowDic.find("[name='dicName']").val(row.dicName);
	$dlgShowDic.find("[name='dicType']").val(row.dicType);
	var param = {};
    param.dicType = row.dicType;
    param.byPage = true;
    param.dicKey = $queryDicKey.val();
    param.dicValue = $queryDicValue.val();
    param.dicSymbol = $queryDicSymbol.val();
    
    //alert($.toJSON(param));
    
	$dicDgShow.datagrid(
    {
        url : contextPath + "/system/dics/"+row.dicType,
        method : "get",
        queryParams:param
    });
}

function editDicFromDetail()
{
    logBehavior("log.behavior.dic.action2");
    $dlgShowDic.dialog("close");
    editDic();
}

function closeDicDetailDialog()
{
    logBehavior("log.behavior.dialog.close", ["dic.detail"]);
    $dlgShowDic.dialog("close");
}