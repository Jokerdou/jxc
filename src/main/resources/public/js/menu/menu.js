layui.use(['table', 'treetable'], () => {
    //声明变量
    const $ = layui.jquery,
        table = layui.table,
        treeTable = layui.treetable;
    //渲染表格
    treeTable.render({
        treeColIndex: 1,
        treeSpid: 1,
        treePidName: 'pId',
        treeIdName: 'menuId',
        elem: '#menu-table',
        url: ctx + '/menu/list',
        toolbar: "#toolbar",
        treeDefaultClose: true,
        page: true,
        cols: [[
            {type: 'numbers'},
            {field: 'menuId', width: 120, title: '菜单Id'},
            {
                field: 'menuState', width: 120, align: 'center',
                templet({menuState}) {
                    if (menuState === 0) {
                        return '<span class="layui-badge layui-bg-blue">目录</span>';
                    }
                    if (menuState === 1) {
                        return '<span class="layui-badge-rim">菜单</span>';
                    } else {
                        return '<span class="layui-badge layui-bg-gray">按钮</span>'
                    }
                }, title: '类型',
            },
            {field: 'menuName', minWidth: 100, align: 'center', title: '菜单名称'},
            {field: 'menuUrl', title: '菜单url'},
            {templet: '#perform-action', minWidth: 240, align: 'center', title: '操作'}
        ]],
        done() {
            layer.closeAll('loading');
        }
    });

    //添加资源
    function addMenu(menuState, pId) {
        const title = "<h3>资源管理 - 添加资源</h3>";
        let url = ctx + "/menu/addMenuPage?menuState=" + menuState + "&pId=" + pId;
        layui.layer.open({
            type: 2,
            title: title,
            content: url,
            area: ["700px", "450px"],
            maxmin: true
        })
    }

    //头部工具栏
    table.on('toolbar(menu-table)', function (data) {
        if (data.event === "expand") {
            treeTable.expandAll("#menu-table");
        } else if (data.event === "fold") {
            treeTable.foldAll("#menu-table");
        } else if (data.event === "add") {
            addMenu(0, 1);
        }
    });

    //删除模块
    function deleteMenu(menuId) {
        layer.confirm('你确定删除该记录吗？', {icon: 3, title: "资源管理"}, () => {
            $.post(ctx + "/menu/delete", {menuId: menuId}, result => {
                if (result.code === 200) {
                    layer.msg("删除成功！", {icon: 6});
                    window.location.reload();
                } else {
                    layer.msg(result.msg, {icon: 5});
                }
            })
        });
    }

    //修改模块
    function updateMenu(menuId) {
        const title = "<h3>资源管理 - 修改资源</h3>";
        let url = ctx + "/menu/toUpdateMenuPage?menuId=" + menuId;
        layui.layer.open({
            type: 2,
            title: title,
            content: url,
            area: ["700px", "450px"],
            maxmin: true
        });
    }

    //行工具栏
    table.on('tool(menu-table)', data => {
        const {pId, menuState, menuId} = data.data;
        if (data.event === "add") {
            addMenu(menuState + 1, pId);
        } else if (data.event === "edit") {
            updateMenu(menuId)
        } else if (data.event === "del") {
            deleteMenu(menuId);
        }
    })
})