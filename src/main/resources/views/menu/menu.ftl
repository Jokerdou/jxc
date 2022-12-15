<!DOCTYPE HTML>
<html lang="zh">
<head>
    <title></title>
    <#include "../common.ftl">
</head>
<body class="childrenBody">
<table id="menu-table" class="layui-table" lay-filter="menu-table"></table>
<script type="text/html" id="perform-action">
    <a class="layui-btn layui-btn-primary layui-btn-xs " lay-event="add">添加子项</a>
    <a class="layui-btn layui-btn-primary layui-btn-xs " lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs " lay-event="del">删除</a>
</script>
<script type="text/html" id="toolbar">
    <div class="layui-btn-container">
        <a class="layui-btn layui-btn-normal" lay-event="expand">
            <i class="layui-icon">&#xe608;</i>全部展开
        </a>
        <a class="layui-btn layui-btn-normal" lay-event="fold">
            <i class="layui-icon">&#xe608;</i>全部折叠
        </a>
        <a class="layui-btn layui-btn-normal" lay-event="add">
            <i class="layui-icon">&#xe608;</i>
            添加目录
        </a>
    </div>
</script>
<script type="text/javascript" src="${ctx}/js/menu/menu.js"></script>
</body>
</html>