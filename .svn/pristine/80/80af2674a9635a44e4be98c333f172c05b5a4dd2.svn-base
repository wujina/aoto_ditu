if (window.top != window)
{
    window.top.location = window.location;
}

$(function()
{
    $username = $("#username");
    $password = $("#password");
    $frmLogin = $("#loginForm");
    focus();
    
    $('#loginForm').bootstrapValidator({
		excluded: [':disabled'],
	    feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {
	    	j_username: {	            
	            validators: {
	                notEmpty: {
	                    message: '该项为必输项'
	                },
	                regexp: {
	                	regexp: /^[a-zA-Z0-9]{1,16}$/,	                    
	                    message: '用户名不合法（允许字母数字，1-16字符）'
	                }
	            }
	        },
	        j_password: {
	            validators: {
	                notEmpty: {
	                    message: '该项为必输项'
	                },
	                regexp: {
	                    regexp: /^\w{6,}$/,
	                    message: '密码格式不正确，格式为字母、数字、下划线且至少6位'
	                }
	            }
	        }
	    }
	});
});

function focus()
{
    var username = $.trim($username.val());

    if (0 == username.length)
    {
        $username.focus();
        return;
    }

    var password = $password.val();

    if (0 == password.length)
    {
        $password.focus();
        return;
    }
}