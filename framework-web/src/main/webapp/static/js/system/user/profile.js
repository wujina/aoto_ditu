$(function() {
	$("#breadcrumbId", window.parent.document).empty();
	$("#breadcrumbId", window.parent.document).prepend("<li class='active'>" + $.i18n.prop("user.setting") + "</li>");
	$('#wnav li', window.parent.document).removeClass('active');
	$.fn.editable.defaults.mode = 'inline';
	$.fn.editableform.loading = "<div class='editableform-loading'><i class='light-blue icon-2x icon-spinner icon-spin'></i></div>";
    $.fn.editableform.buttons = '<button type="submit" class="btn btn-info editable-submit"><i class="icon-ok icon-white"></i></button>'+
                                '<button type="button" class="btn editable-cancel"><i class="icon-remove"></i></button>';    
                      
	//editables 
    $('#realName').editable({
		type: 'text',
		validate:function(value) {
			if (!$.trim(value)) {
                return $.i18n.prop("user.setting.realname.failed.message1");
            }
		},
		url: function(params) {
			var deferred = new $.Deferred;			
			setTimeout(function(){					
				$.post(contextPath + "/system/commuser/realname",
					{realName:$('#realName').next().find('input.input-medium:eq(0)').val(), userId:currentUserId},
					function (result) {
						if($.string(result.errorCode).blank()) {
							deferred.resolve({'status':'OK'});									
						}
						else {
							deferred.resolve({'status':result.errorCode});										
						}
					}
				);
									
			 } , parseInt(Math.random() * 800 + 800));					
			
			return deferred.promise();
		},
		
		success: function(response, newValue) {
			if (response.status == 'OK') {					
				if(last_gritter) $.gritter.remove(last_gritter);
				$("#realNameSpan",window.parent.document).text($('#realName').next().find('input.input-medium:eq(0)').val());
				last_gritter = $.gritter.add({
					title: $.i18n.prop("user.setting.realname.success.title"),
					text: $.i18n.prop("user.setting.realname.success.message"),
					class_name: 'gritter-info gritter-center'
				});
			}
			else {
				if(last_gritter) $.gritter.remove(last_gritter);
				last_gritter = $.gritter.add({
					title: $.i18n.prop("user.setting.realname.failed.title"),
					text: $.i18n.prop(result.errorCode),
					class_name: 'gritter-error gritter-center'
				});
			}
		}
    });

	$('#birthday').editable({
		type: 'date',
		format: 'yyyy-mm-dd',
		viewformat: 'yyyy-mm-dd',
		datepicker: {
			weekStart: 0
		},
		url: function(params) {
			var deferred = new $.Deferred;
			console.log($('#birthday').next().find('input.input-medium:eq(0)').val());
			setTimeout(function(){					
				$.post(contextPath + "/system/commuser/birthday",
					{birthday:$('#birthday').next().find('input.input-medium:eq(0)').val(), userId:currentUserId},
					function (result) {
						if($.string(result.errorCode).blank()) {
							deferred.resolve({'status':'OK'});									
						}
						else {
							deferred.resolve({'status':result.errorCode});										
						}
					}
				);
									
			 } , parseInt(Math.random() * 800 + 800));					
			
			return deferred.promise();
		},
		
		success: function(response, newValue) {
			if (response.status == 'OK') {					
				if(last_gritter) $.gritter.remove(last_gritter);					
				last_gritter = $.gritter.add({
					title: $.i18n.prop("user.setting.birthday.success.title"),
					text: $.i18n.prop("user.setting.birthday.success.message"),
					class_name: 'gritter-info gritter-center'
				});
			}
			else {
				if(last_gritter) $.gritter.remove(last_gritter);
				last_gritter = $.gritter.add({
					title: $.i18n.prop("user.setting.birthday.failed.title"),
					text: $.i18n.prop(result.errorCode),
					class_name: 'gritter-error gritter-center'
				});
			}
		}
	});

    $('#age').editable({
        type: 'spinner',			
		spinner : {
			min : 16, max:99, step:1
		},			
		url: function(params) {
			var deferred = new $.Deferred;				
			setTimeout(function(){					
				$.post(contextPath + "/system/commuser/age",
					{age:$('#age').next().find('input.spinner-input:eq(0)').val(), userId:currentUserId},
					function (result) {
						if($.string(result.errorCode).blank()) {
							deferred.resolve({'status':'OK'});									
						}
						else {
							deferred.resolve({'status':result.errorCode});										
						}
					}
				);
									
			 } , parseInt(Math.random() * 800 + 800));					
			
			return deferred.promise();
		},
		
		success: function(response, newValue) {
			if (response.status == 'OK') {					
				if(last_gritter) $.gritter.remove(last_gritter);					
				last_gritter = $.gritter.add({
					title: $.i18n.prop("user.setting.age.success.title"),
					text: $.i18n.prop("user.setting.age.success.message"),
					class_name: 'gritter-info gritter-center'
				});
			}
			else {
				if(last_gritter) $.gritter.remove(last_gritter);
				last_gritter = $.gritter.add({
					title: $.i18n.prop("user.setting.age.failed.title"),
					text: $.i18n.prop(result.errorCode),
					class_name: 'gritter-error gritter-center'
				});
			}
		}
	});

	$('#about').editable({
		mode: 'inline',
        type: 'wysiwyg',			
		wysiwyg : {
			//css : {'max-width':'300px'}
		},
		url: function(params) {
			var deferred = new $.Deferred;				
			setTimeout(function(){					
				$.post(contextPath + "/system/commuser/about",
					{about:$('#about').next().find('div.wysiwyg-editor:eq(0)').html(), userId:currentUserId},
					function (result) {
						if($.string(result.errorCode).blank()) {
							deferred.resolve({'status':'OK'});									
						}
						else {
							deferred.resolve({'status':result.errorCode});										
						}
					}
				);
									
			 } , parseInt(Math.random() * 800 + 800));					
			
			return deferred.promise();
		},
		
		success: function(response, newValue) {
			if (response.status == 'OK') {					
				if(last_gritter) $.gritter.remove(last_gritter);					
				last_gritter = $.gritter.add({
					title: $.i18n.prop("user.setting.about.success.title"),
					text: $.i18n.prop("user.setting.about.success.message"),
					class_name: 'gritter-info gritter-center'
				});
			}
			else {
				if(last_gritter) $.gritter.remove(last_gritter);
				last_gritter = $.gritter.add({
					title: $.i18n.prop("user.setting.about.failed.title"),
					text: $.i18n.prop(result.errorCode),
					class_name: 'gritter-error gritter-center'
				});
			}
		}
	});
	
	try {	
		if( /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ) Image.prototype.appendChild = function(el){}

		var last_gritter
		$('#avatar').editable({
			type: 'image',
			name: 'avatar',
			value: null,
			image: {					
				btn_choose: $.i18n.prop("user.setting.upload.title"),
				droppable: true,					
				name: 'avatar',
				max_size: 110000,
				on_error : function(code) {
					if(last_gritter) {
						$.gritter.remove(last_gritter);
					}
					if(code == 1) {
						last_gritter = $.gritter.add({
							title: $.i18n.prop("user.setting.upload.failed.title"),
							text: $.i18n.prop("user.setting.upload.failed.message3"),
							class_name: 'gritter-error gritter-center'
						});
					}
					else if(code == 2) {
						last_gritter = $.gritter.add({
							title: $.i18n.prop("user.setting.upload.failed.title"),
							text: $.i18n.prop("user.setting.upload.failed.message4"),
							class_name: 'gritter-error gritter-center'
						});
					}
					else {
					}
				},
				on_success : function() {
					$.gritter.removeAll();
				}
			},
		    url: function(params) {
				var deferred = new $.Deferred;
				var value = $('#avatar').next().find('input[type=hidden]:eq(0)').val();
				if(!value || value.length == 0) {
					deferred.resolve();
					return deferred.promise();
				}	

				setTimeout(function(){
					if("FileReader" in window) {
						var thumb = $('#avatar').next().find('img').data('thumb');
						if(thumb) $('#avatar').get(0).src = thumb;
						$.post(contextPath + "/system/commuser/upload",
							{base64Data:$('#avatar')[0].src, userId:currentUserId},
							function (result) {
								if($.string(result.errorCode).blank()) {
									deferred.resolve({'status':'OK'});									
								}
								else {
									deferred.resolve({'status':result.errorCode});										
								}
							}
						);
					}						
				 } , parseInt(Math.random() * 800 + 800));					
				
				return deferred.promise();
			},
			
			success: function(response, newValue) {
				if (response.status == 'OK') {
					$("#userPicImgId",window.parent.document)[0].src = $('#avatar')[0].src;
					if(last_gritter) $.gritter.remove(last_gritter);
					last_gritter = $.gritter.add({
						title: $.i18n.prop("user.setting.upload.success.title"),
						text: $.i18n.prop("user.setting.upload.success.message"),
						class_name: 'gritter-info gritter-center'
					});
				}
				else {
					if(last_gritter) $.gritter.remove(last_gritter);
					last_gritter = $.gritter.add({
						title: $.i18n.prop("user.setting.upload.failed.title"),
						text: $.i18n.prop(result.errorCode),
						class_name: 'gritter-error gritter-center'
					});
				}
			}
		})
	}catch(e) {}		
});