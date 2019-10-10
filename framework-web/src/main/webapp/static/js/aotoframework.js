/*
var userAgent = navigator.userAgent.toLowerCase();
var ieVersion;

if (userAgent.indexOf("msie") > 0)
{
    alert(userAgent);
    var s = userAgent.match(/msie [\d.]+;/gi);
    ieVersion = parseInt((s + "").replace(/[^0-9.]/ig,""));
}
*/

$.i18n.properties(
{  
    name : "framework",
    path : contextPath + "/static/js/locale/",
    mode : 'map',
    cache : true,
    language : locale
});

$.ajaxSetup(
{
    cache : false,
    statusCode :
    {
        801 : function(xhr, status, e)
        {
            $.messager.alert($.i18n.prop("messager.warning"), $.i18n.prop(xhr.responseJSON), "warning");
        },
        901 : function(xhr, status, e)
        {
            window.top.location = contextPath;
        },
        500 : function(xhr, status, e)
        {
            $.messager.alert($.i18n.prop("messager.error"), $.i18n.prop(xhr.responseJSON), "error");
        }
    }
});

$.extend($.fn.validatebox.defaults.rules,
{
    idCard :
    {// 验证身份证
        validator : function(value)
        {
            return /^\d{15}(\d{2}[A-Za-z0-9])?$/i.test(value);
        },
        message : '身份证号码格式不正确'
    },
    minLength :
    {
        validator : function(value, param)
        {
            return value >= param[0];
        },
        message : '请输入至少{0}个字符.'
    },
    length :
    {
        validator : function(value, param)
        {
            var len = getLength($.trim(value));
            return len >= param[0] && len <= param[1];
        },
        message : "输入内容长度必须介于{0}和{1}之间，中文占两个字节"
    },
    compareDate :
    {
        validator : function(value, param)
        {
            if(!value) return true;
            var startDateStr = $("#"+param[0]).datebox("getValue");
            var endDateStr = $("#"+param[1]).datebox("getValue");
            var startDate,endDate;
            if(startDateStr&&endDateStr){
            	startDate = new Date(Date.parse(startDateStr.replace("-", "/")));
            	endDate = new Date(Date.parse(endDateStr.replace("-", "/")));
            	if(startDate>endDate){
            		return false;
            	}
            	return true;
            }
            return true;
        },
        message : "开始日期必须小于等于结束日期"
    },
    phone :
    {// 验证电话号码
        validator : function(value)
        {
        	var res;
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value)||/^(13|14|15|17|18)\d{9}$/i.test(value);
            
        },
        message : '请输入手机号或固定电话'
    },
    mobile :
    {// 验证手机号码
        validator : function(value)
        {
            return /^(13|14|15|17|18)\d{9}$/i.test(value);
        },
        message : '手机号码格式不正确'
    },
    tel :
    {
    	// 验证电话号码
        validator : function(value)
        {
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message : '格式不正确，请使用下面格式：025-89636585'
    },
    intOrFloat :
    {// 验证整数或小数
        validator : function(value)
        {
            return /^\d+(\.\d+)?$/i.test(value);
        },
        message : '请输入数字，并确保格式正确'
    },
    currency :
    {// 验证货币
        validator : function(value)
        {
            return /^\d+(\.\d+)?$/i.test(value);
        },
        message : '货币格式不正确'
    },
    qq :
    {// 验证QQ,从10000开始
        validator : function(value)
        {
            return /^[1-9]\d{4,9}$/i.test(value);
        },
        message : 'QQ号码格式不正确'
    },
    integer :
    {// 验证整数
        validator : function(value, param)
        {
            value = $.trim(value);
            len = param[0];
            
            if ("-" == value.substring(0, 1))
            {
                len++;
            }

            if (value.length <= len)
            {
                return /^\d+$/i.test(value);
            }
            
            return false;
        },
        message : '请输入整数，长度为{0}'
    },
    positiveInteger :
    {// 验证正整数
        validator : function(value, param)
        {
            value = $.trim(value);
            len = param[0];

            if (value.length <= len)
            {
                return /^[1-9]\d*$/i.test(value);
            }
            
            return false;
        },
        message : '请输入正整数，长度为{0}'
    },
    age :
    {// 验证年龄
        validator : function(value)
        {
            return /^(?:[1-9][0-9]?|1[01][0-9]|120)$/i.test(value);
        },
        message : '年龄必须是0到120之间的整数'
    },
    chinese :
    {// 验证中文
        validator : function(value)
        {
            return /^[\u4e00-\u9fa5]+$/i.test(value);
        },
        message : '请输入中文'
    },
    english :
    {// 验证英语
        validator : function(value)
        {
            return /^[A-Za-z]+$/i.test(value);
        },
        message : '请输入英文'
    },
    unnormal :
    {// 验证是否包含空格和非法字符
        validator : function(value)
        {
            return /.+/i.test(value);
        },
        message : '输入值不能为空和包含其他非法字符'
    },
    chrnum :
    {// 验证用户名
        validator : function(value)
        {
            return /^([a-zA-Z0-9]+)$/i.test(value);
        },
        message : '输入值允许字母数字'
    },    
    username :
    {// 验证用户名
        validator : function(value)
        {
            return /^[a-zA-Z0-9]{1,16}$/i.test(value);
        },
        message : '用户名不合法（允许字母数字，1-16字符）'
    },
    code :
    {// 编码
        validator : function(value)
        {
            return /^[a-zA-Z0-9]{1,16}$/i.test(value);
        },
        message : '编码不合法（允许字母数字，1-16字符）'
    },
    faxno :
    {// 验证传真
        validator : function(value)
        {
            // return /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[
            // ]){1,12})+$/i.test(value);
            return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/i.test(value);
        },
        message : '传真号码不正确'
    },
    zip :
    {// 验证邮政编码
        validator : function(value)
        {
            return /^[1-9]\d{5}$/i.test(value);
        },
        message : '邮政编码格式不正确'
    },
    ip :
    {// 验证IP地址
        validator : function(value)
        {
            return /^(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])\.(\d{1,2}|1\d\d|2[0-4]\d|25[0-5])$/i.test(value);
        },
        message : 'IP地址格式不正确'
    },
    name :
    {// 验证姓名，可以是中文或英文
        validator : function(value)
        {
            return /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/i.test(value);
        },
        message : '请输入正确的格式，字母数字下划线或者中文'
    },
    date :
    {// 验证姓名，可以是中文或英文
        validator : function(value)
        {
            // 格式yyyy-MM-dd或yyyy-M-d
            return /^(?:(?!0000)[0-9]{4}([-]?)(?:(?:0?[1-9]|1[0-2])\1(?:0?[1-9]|1[0-9]|2[0-8])|(?:0?[13-9]|1[0-2])\1(?:29|30)|(?:0?[13578]|1[02])\1(?:31))|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)([-]?)0?2\2(?:29))$/i.test(value);
        },
        message : '请输入合适的日期格式'
    },
    msn :
    {
        validator : function(value)
        {
            return /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value);
        },
        message : '请输入有效的msn账号(例：abc@hotmail(msn/live).com)'
    },
    same :
    {
        validator : function(value, param)
        {
            if ($("#" + param[0]).val() != "" && value != "")
            {
                return $("#" + param[0]).val() == value;
            }
            else
            {
                return true;
            }
        },
        message : '两次输入的密码不一致！'
    },
    password :
    {
        validator : function(value)
        {
            return /^\w{6,}$/.test(value);
        },
        message : '密码格式不正确，格式为字母、数字、下划线且至少6位'
    },
    text :
    {
        validator : function(value)
        {
            return /^([^\x00-\xff]|\w|\s)+$/i.test(value);
        },
        message : '请输入正确的格式，不能包含特殊字符'
    }
});
/*
function closeLoading()
{
    $("#loading").fadeOut("normal", function()
    {
        $(this).remove();
    });
}

var pc;

$.parser.onComplete = function()
{
    if (pc)
    {
        clearTimeout(pc);
    }

    pc = setTimeout(closeLoading, 100);
};
*/
function queryString(key)
{
    var search = window.location.search + '';

    if (search.charAt(0) != '?')
    {
        return null;
    }
    else
    {
        search = search.replace('?', '').split('&');

        for ( var i = 0; i < search.length; i++)
        {
            if (search[i].split('=')[0] == key)
            {
                return decodeURI(search[i].split('=')[1]);
            }
        }
        return null;
    }
}

function formatDate(val)
{
    if ($.isNumeric(val))
    {
        return new Date(parseInt(val)).toString("yyyy-MM-dd HH:mm");
    }
    else
    {
        return "";
    }
}

function getLength(str)
{
    return str.replace(/[^\x00-\xff]/g, "rr").length;
}

function logBehavior(code, args)
{ 
    if (!logBehaviorEnabled)
    {
        return;
    }
    
    var param;
    if (null == args || 0 == args.length)
    {
        param = "code=" + code + "&args[]=";
    }
    else
    {
        param = $.param({code:code,args:args});
    }
    
    $.post(contextPath + "/system/logs/behavior", param);
}