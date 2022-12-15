<!DOCTYPE html>
<html lang="">
<head>
    <title>添加资源</title>
    <#include "../common.ftl">
</head>
<body>
<form class="layui-form" style="width:80%;">
    <div class="layui-form-item layui-row  layui-col-xs12">
        <label class="layui-form-label">菜单名称</label>
        <div class="layui-input-block">
            <label for="menuName"></label><input type="text" class="layui-input userName" lay-verify="required"
                                                 name="menuName" id="menuName" placeholder="菜单名">
        </div>
    </div>
    <div class="layui-form-item layui-row  layui-col-xs12">
        <label class="layui-form-label">菜单类型</label>
        <div class="layui-input-block">
            <label>
                <select name="menuState">
                    <#if menuState==0>
                        <option value="0" selected="selected">目录</option>
                    </#if>
                    <#if menuState==1>
                        <option value="1" selected="selected">菜单</option>
                    </#if>
                    <#if menuState==2>
                        <option value="2" selected="selected">按钮</option>
                    </#if>
                </select>
            </label>
        </div>
    </div>
    <div class="layui-form-item layui-row  layui-col-xs12">
        <label class="layui-form-label">菜单url</label>
        <div class="layui-input-block">
            <label for="menuUrl"></label><input type="text" class="layui-input userName" lay-verify="required"
                                                name="menuUrl" id="menuUrl" placeholder="菜单url">
        </div>
    </div>
    <div class="layui-form-item layui-row  layui-col-xs12">
        <label class="layui-form-label">权限码</label>
        <div class="layui-input-block">
            <label for="optValue"></label><input type="text" class="layui-input userName" lay-verify="required"
                                                 name="optValue" id="optValue" placeholder="权限码">
        </div>
    </div>
    <input name="pId" type="hidden" value="${pId}"/>
    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit="" lay-filter="addMenu">确认
            </button>
            <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx}/js/menu/add.js"></script>
</body>
</html>
