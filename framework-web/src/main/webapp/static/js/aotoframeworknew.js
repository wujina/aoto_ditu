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