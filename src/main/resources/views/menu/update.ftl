<!DOCTYPE html>
<html lang="zh">
<head>
    <#include "../common.ftl">
    <title>更新资源</title>
</head>
<body class="childrenBody">
<form class="layui-form" style="width:80%;">
    <div class="layui-form-item layui-row  layui-col-xs12">
        <label class="layui-form-label">菜单名称</label>
        <div class="layui-input-block">
            <label for="menuName"></label>
            <input type="text" class="layui-input userName" lay-verify="required" name="menuName" id="menuName"
                   value="${(menu.menuName)!}" placeholder="菜单名">
        </div>
    </div>
    <div class="layui-form-item layui-row  layui-col-xs12">
        <label class="layui-form-label">菜单类型</label>
        <div class="layui-input-block">
            <#if menu.menuState??>
                <label>
                    <select name="menuState">
                        <option value="0" <#if menu.menuState==0>selected="selected"</#if>>目录</option>
                        <option value="1" <#if menu.menuState==1>selected="selected"</#if>>菜单</option>
                        <option value="2" <#if menu.menuState==2>selected="selected"</#if>>按钮</option>
                    </select>
                </label>
            </#if>
        </div>
    </div>
    <div class="layui-form-item layui-row  layui-col-xs12">
        <label class="layui-form-label">菜单url</label>
        <div class="layui-input-block">
            <label for="menuUrl"></label><input type="text" class="layui-input userName" lay-verify="required"
                                                name="menuUrl" id="menuUrl"
                                                value="${(menu.menuUrl)!}" placeholder="菜单url">
        </div>
    </div>
    <div class="layui-form-item layui-row  layui-col-xs12">
        <label class="layui-form-label">权限码</label>
        <div class="layui-input-block">
            <label for="optValue"></label><input type="text" class="layui-input userName" lay-verify="required"
                                                 name="optValue" id="optValue"
                                                 value="${(menu.optValue)!}" placeholder="权限码">
        </div>
    </div>
    <input name="pId" type="hidden" value="${(menu.pId)!}"/>
    <input name="menuId" type="hidden" value="${(menu.menuId)!}"/>
    <br/>
    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-lg" lay-submit=""
                    lay-filter="updateMenu">确认
            </button>
            <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${ctx}/js/menu/update.js"></script>
</body>
</html>