window.setInterval(function()
{
    $.post(contextPath + "/system/logs/heartbeat?_method=put");
}, heartbeatInterval);

$(function()
{
	$("#myModal").on("hidden.bs.modal", function() {
		$("#changeFailed").css({'display':'none'});
		$("#changeSuccess").css({'display':'none'});
		$('#changePasswordForm').data('bootstrapValidator').destroy();
	    $('#changePasswordForm').data('bootstrapValidator', null);
		clearForm($('#changePasswordForm'));
		loadChangePasswordFormValidator();
	});
	
	$(window.parent.document).find("#mainframe").load(function(){	
	    var main = $(window.parent.document).find("#mainframe");
	    var thisheight = $(document).height()-$("#breadcrumbs").outerHeight()-$("#navbar").outerHeight()-6;
	    main.height(thisheight);
	});
	
	$wnav = $("#wnav");
	
	$.ajax({
        type: "GET",
        url: contextPath + "/system/my/menus",
        dataType: "json",
        cache: false,
        headers: {
            Accept: "application/json; charset=utf-8"
        },
        success: function(menu) {
            initMenu(menu);
        }
    });
	
	loadChangePasswordFormValidator();
});

var clearForm = function(form) {
    $(':input', form).each(function () {
        var type = this.type;
        var tag = this.tagName.toLowerCase();
        if (type == 'text' || type == 'password' || tag == 'textarea'){
            this.value = "";
        }
        else if (tag == 'select'){
            this.selectedIndex = -1;
        }
    });
};

var initMenu = function(menu)
{    
    var html = "";
    $.each(menu, function(i, m) {
        html += "<li><a id='menu"+ m.id +"' class='dropdown-toggle' href='javascript:void(0);'><i class='" 
        	+ (null==m.attributes.icon ? "icon-desktop" : m.attributes.icon) 
        	+ "'></i><span class='menu-text'>" + m.text 
        	+ "</span><b class='arrow icon-angle-down'></b></a></li>";
    });   
    
    $wnav.append(html);    
    
    $('#wnav li a').click(function()
    {    	
        var id = this.id;

        $.each(menu, function(i, m) {
            if (("menu" + m.id) == id)
            {            	
                logBehavior("log.behavior.menu.action" + m.id);
                addNav(id,m.children);
                return;
            }
        });
    });
}

var loadChangePasswordFormValidator = function() {
	$('#changePasswordForm').bootstrapValidator({
		excluded: [':disabled'],
	    feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {
	    	oldpass: {	           
	            validators: {
	                notEmpty: {
	                    message: '该项为必输项'
	                },
	                regexp: {
	                    regexp: /^\w{6,}$/,
	                    message: '密码格式不正确，格式为字母、数字、下划线且至少6位'
	                }
	            }
	        },
	        newpass: {
	            validators: {
	                notEmpty: {
	                    message: '该项为必输项'
	                },
	                regexp: {
	                    regexp: /^\w{6,}$/,
	                    message: '密码格式不正确，格式为字母、数字、下划线且至少6位'
	                }
	            }
	        },
	        newpassAgain: {
	            validators: {
	                notEmpty: {
	                    message: '该项为必输项'
	                },
	                regexp: {
	                    regexp: /^\w{6,}$/,
	                    message: '密码格式不正确，格式为字母、数字、下划线且至少6位'
	                },
	                identical: {
	                	field:"newpass",
	                	message: '两次输入密码不一致'
	                }
	            }
	        }
	    }
	});
}
var addNav = function(id,data)
{	
	if (data.length == 0) {   	 
		return;
	}
	
	$("#" + id).next("ul").remove();
	$("#" + id).parent().append("<ul class='submenu'></ul>");	
		
    $.each(data, function(i, sm)
    {
    	if (null != sm.attributes.menuUrl) {
	        $("#" + id).next("ul").append("<li><a id='menu" + sm.id 
	        		+ "' class='dropdown-toggle' target='mainframe' href='" 
	        		+ contextPath + sm.attributes.menuUrl + "' ><i class='" + (null==sm.attributes.icon ? "icon-double-angle-right" : sm.attributes.icon) + "'></i><span class='menu-text'>" 
	        		+ sm.text + "</span></a></li>");
	        $("#menu" + sm.id).click(function(){
	        	logBehavior("log.behavior.menu.action" + sm.id);
	        	$('#wnav li').removeClass('active');
	        	$(this).parent().addClass("active");
	        	$(this).parents('li').each(function(i){
	        		if (i == 0){
	        			$("#breadcrumbId").empty();
	        			$("#breadcrumbId").prepend("<li class='active'>" + $(this).children("a").children("span").text() + "</li>");
	        		}
	        		else{
	        			$("#breadcrumbId").prepend("<li>" + $(this).children("a").children("span").text() + "</li>");
	        		}
	        	});
	        });
    	}
    	else {
    		$("#" + id).next("ul").append("<li><a id='menu" + sm.id 
	        		+ "' class='dropdown-toggle' href='javascript:void(0);'><i class='" + (null==sm.attributes.icon ? "icon-double-angle-right" : sm.attributes.icon) + "'></i><span class='menu-text'>" 
	        		+ sm.text + "</span></a></li>");
    		$("#menu" + sm.id).click(function(){
	        	logBehavior("log.behavior.menu.action" + sm.id);	        	
	        });
    	}
        
    	if (sm.children.length > 0) {
    		addNav("menu" + sm.id, sm.children);
    	}
    });
}

var saveUpdate = function(){
	$("#changePasswordForm").data("bootstrapValidator").validate();
	var flag = $("#changePasswordForm").data("bootstrapValidator").isValid();
	if (!flag) {
		logBehavior("log.behavior.modal.client.invaild", ["user.changePassword"]);
		return;
	}
	
	var data =
    {
        oldPassword : $("#oldpass").val(),
        newPassword : $("#newpass").val()
    };	
	$.ajax({
        url : contextPath + "/system/users/" + currentUserId + "/password?_method=put",
        type : "post",
        dataType : "json",
        data : data,
        success : function(result)
        {
            if ($.string(result.errorCode).blank())
            {
            	$("#changeFailed").css({'display':'none'});
                $("#changeSuccess").css({'display':'inline','font-size':'20px','height':'30px','display':'block'});
                $("#changeSuccess").text($.i18n.prop("submit.success"));
                logBehavior("log.behavior.modal.server.submit", ["user.changePassword"]);
            }
            else
            {
            	$("#changeSuccess").css({'display':'none'});
            	$("#changeFailed").css({'display':'inline','font-size':'20px','height':'30px','display':'block'});
            	$("#changeFailed").text($.i18n.prop(result.errorCode));
            	logBehavior("log.behavior.modal.server.invaild", ["user.changePassword"]);
            }
        }
    });
}
