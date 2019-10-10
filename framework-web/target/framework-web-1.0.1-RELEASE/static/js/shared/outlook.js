var $topmenu,$topmenu_li_a,$wnav,$wnav_li_a,$tabs,$mm,$mm_tabupdate;
var $mm_tabclose,$mm_tabcloseall,$tabs_inner_span,$mm_tabcloseother,$mm_tabcloseright;
var $mm_tabcloseleft,$mm_tabcloseright,$tabs_selected,$mm_tabcloseleft,$mm_exit;

$(function()
{
    $topmenu = $("#topmenu");
    $wnav = $("#wnav");
    $tabs = $("#tabs");
    $mm = $("#mm");
    $mm_tabupdate = $("#mm-tabupdate");
    $mm_tabclose = $("#mm-tabclose");
    $mm_tabcloseall = $("#mm-tabcloseall");
    $mm_tabcloseother = $("#mm-tabcloseother");
    $mm_tabcloseright = $("#mm-tabcloseright");
    $mm_tabcloseleft = $("#mm-tabcloseleft");
    $mm_tabcloseright = $("#mm-tabcloseright");
    $mm_tabcloseleft = $("#mm-tabcloseleft");
    $mm_exit = $("#mm_exit");

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

    tabClose();
    tabCloseEven();
});

function initMenu(menu)
{
    var first = null;
    var html = "";
    $.each(menu, function(i, m) {
        
        if (0 == i)
        {
            first = m.children;
        }
        
        html += "<li><a id='menu"+ m.id +"' href='javascript:void(0);'>" + m.text + "</a></li>";
    });
    
    $topmenu.html(html);
    $topmenu_li_a = $('#topmenu li a');
    
    $topmenu_li_a.click(function()
    { 
        $topmenu_li_a.removeClass('active');
        $(this).addClass('active');
        var id = this.id;

        $.each(menu, function(i, m) {
            if (("menu" + m.id) == id)
            {
                logBehavior("log.behavior.menu.action" + m.id);
                
                Clearnav();
                addNav(m.children);
                initLeftMenu(menu);
                return;
            }
        });
    });
    
    // 导航菜单绑定初始化
    $wnav.accordion(
    {
        fit : false,
        border : false,
        animate : false,
        multiple : true
    });

    addNav(first);
    initLeftMenu(menu);
}

function Clearnav()
{
    var pp = $wnav.accordion('panels');

    $.each(pp, function(i, n)
    {
        if (n)
        {
            var t = n.panel('options').title;
            $wnav.accordion('remove', t);
        }
    });

    pp = $wnav.accordion('getSelected');
    if (pp)
    {
        var title = pp.panel('options').title;
        $wnav.accordion('remove', title);
    }
}

function addNav(data)
{
    $.each(data, function(i, sm)
    {
        var menulist = "";
        menulist += '<ul>';
        $.each(sm.children, function(j, o)
        {
            menulist += '<li><div><a ref="' + o.id + '" href="javascript:void(0);" rel="' + contextPath + o.attributes.menuUrl + '" ><span class="icon ' + o.attributes.icon + '">&nbsp;</span><span class="nav">' + o.text + '</span></a></div></li>';
        });
        menulist += '</ul>';

        $wnav.accordion('add',
        {
            title : sm.text,
            content : menulist,
            iconCls : 'icon ' + sm.attributes.icon
        });
    });

    var pp = $wnav.accordion('panels');
    var t = pp[0].panel('options').title;
    $wnav.accordion('select', t);
    
    $wnav_li_a = $("#wnav li a");
    $wnav_li_div = $('#wnav li div');
}

function initLeftMenu(menu)
{
    hoverMenuItem();
    
    $wnav_li_a.on("click", function()
    {
        var menuId = $(this).attr("ref");
        logBehavior("log.behavior.menu.action" + menuId);
        
        var tabTitle = $(this).children('.nav').text();

        var url = $(this).attr("rel");
        var icon = $(this).children(":first").attr("class");

        addTab(tabTitle, url, icon);
        $wnav_li_div.removeClass("selected");
        $(this).parent().addClass("selected");
    });
}

function hoverMenuItem()
{
    $wnav_li_a.hover(function()
    {
        $(this).parent().addClass("hover");
    }, function()
    {
        $(this).parent().removeClass("hover");
    });
}

function addTab(subtitle, url, icon)
{
    if (!$tabs.tabs('exists', subtitle))
    {
        $tabs.tabs('add',
        {
            title : subtitle,
            content : createFrame(url),
            closable : true,
            icon : icon
        });
    }
    else
    {
        $tabs.tabs('select', subtitle);
        //$mm_tabupdate.click();
    }
    
    tabClose();
}

function createFrame(url)
{
    var s = '<iframe scrolling="auto" frameborder="0" src="' + url + '" style="width:100%;height:100%;"></iframe>';
    return s;
}

function tabClose()
{
    $tabs_inner = $(".tabs-inner");
    
    /* 双击关闭TAB选项卡 */
    $tabs_inner.dblclick(function()
    {
        var subtitle = $(this).children(".tabs-closable").text();
        $tabs.tabs('close', subtitle);
    });
    /* 为选项卡绑定右键 */
    $tabs_inner.bind('contextmenu', function(e)
    {
        $mm.menu('show',
        {
            left : e.pageX,
            top : e.pageY
        });

        var subtitle = $(this).children(".tabs-closable").text();

        $mm.data("currtab", subtitle);
        $tabs.tabs('select', subtitle);
        return false;
    });
}
// 绑定右键菜单事件
function tabCloseEven()
{    
    // 刷新
    $mm_tabupdate.click(function()
    {
        var currTab = $tabs.tabs('getSelected');
        var url = $(currTab.panel('options').content).attr('src');
        $tabs.tabs('update',
        {
            tab : currTab,
            options :
            {
                content : createFrame(url)
            }
        });
    });
    // 关闭当前
    $mm_tabclose.click(function()
    {
        var currtab_title = $('#mm').data("currtab");
        $tabs.tabs('close', currtab_title);
    });
    // 全部关闭
    $mm_tabcloseall.click(function()
    {
        $(".tabs-inner span").each(function(i, n)
        {
            var t = $(n).text();
            $tabs.tabs('close', t);
        });
    });
    // 关闭除当前之外的TAB
    $mm_tabcloseother.click(function()
    {
        $mm_tabcloseright.click();
        $mm_tabcloseleft.click();
    });
    // 关闭当前右侧的TAB
    $mm_tabcloseright.click(function()
    { 
        var nextall = $(".tabs-selected").nextAll();
        if (nextall.length == 0)
        {
            // msgShow('系统提示','后边没有啦~~','error');
            alert('后边没有啦~~');
            return false;
        }
        nextall.each(function(i, n)
        {
            var t = $('a:eq(0) span', $(n)).text();
            $tabs.tabs('close', t);
        });
        return false;
    });
    // 关闭当前左侧的TAB
    $mm_tabcloseleft.click(function()
    {
        var prevall = $(".tabs-selected").prevAll();
        if (prevall.length == 0)
        {
            alert('到头了，前边没有啦~~');
            return false;
        }
        prevall.each(function(i, n)
        {
            var t = $('a:eq(0) span', $(n)).text();
            $tabs.tabs('close', t);
        });
        return false;
    });

    // 退出
    $mm_exit.click(function()
    {
        $mm.menu('hide');
    });
}