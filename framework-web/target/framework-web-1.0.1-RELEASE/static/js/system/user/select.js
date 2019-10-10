function initUserSelector(url, params)
{
    $suname = $("#suname");
    $soid = $("#soid");
    $scontainSub = $("#scontainSub");
    $dgUnselectedUser = $("#dgUnselectedUser");
    $dgSelectedUser = $("#dgSelectedUser").datagrid(
    {
        url : url,
        method : "get",
        queryParams : params,
        onLoadSuccess : function(data)
        {
            var excepted = "";
            if (data.rows.length > 0)
            {
                $.each(data.rows, function(index, item)
                {
                    excepted += item.userId + ",";
                });
            }
            
            loadUsers();
        }
    });
}

function searchUsers()
{
    logBehavior("log.behavior.page.query1", ["user.select","user.list"]);
    loadUsers();
}

function loadUsers()
{
    var selectedRows = $dgSelectedUser.datagrid("getRows");
    var excepted = "";

    $.each(selectedRows, function(index, item)
    {
        excepted += item.userId + ",";
    });
    
    $dgUnselectedUser.datagrid("clearSelections");
    $dgSelectedUser.datagrid("clearSelections");
    $dgUnselectedUser.datagrid("load",{
        excepted : excepted,
        username : $suname.val(),
        orgId : $soid.val(),
        containSub : $scontainSub.is(":checked")
    });
}

function moveRight()
{
    logBehavior("log.behavior.user.action2");

    var checkedRows = $dgUnselectedUser.datagrid("getChecked");

    if (0 == checkedRows.length)
    {
        return;
    }

    $.each(checkedRows, function(index, item)
    {
        $dgSelectedUser.datagrid("appendRow", item);
    });

    loadUsers();
}

function moveLeft()
{
    logBehavior("log.behavior.user.action3");
    
    var checkedRows = $dgSelectedUser.datagrid("getChecked");

    if (0 == checkedRows.length)
    {
        return;
    }

    var list = [];

    $.each(checkedRows, function(index, item)
    {
        list.push(item.userId);
    });

    var rowIndex;

    $.each(list, function(index, item)
    {
        rowIndex = $dgSelectedUser.datagrid("getRowIndex", item);
        $dgSelectedUser.datagrid("deleteRow", rowIndex);
    });

    loadUsers();
}