<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台管理-登录</title>
    <#include "common.ftl">
    <link rel="stylesheet" href="${ctx}/css/index.css" media="all">
</head>
<body>
<div class="layui-container" id="back">
    <div class="admin-login-background">
        <div class="layui-form login-form" id="border">
            <form class="layui-form" action="">
                <div class="layui-form-item logo-title">
                    <h1 id="first_head">
                        <span id="one">E</span><span id="two">R</span><span id="three">P</span><span id="four">后</span><span id="five">端</span><span id="sex">登</span><span id="seven">录</span>
                    </h1>
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-username" for="username"></label>
                    <input type="text" name="username" lay-verify="required|account" placeholder="请输入您的用户名" autocomplete="off" class="layui-input" >
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password" for="password"></label>
                    <input type="password" name="password" lay-verify="required|password" placeholder="请输入您的密码" autocomplete="off" class="layui-input" >
                </div>

                <div class="layui-form-item button">
                    <button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="login">登 录</button>
                </div>
            </form>
            <div id="light_div" class="button"><button id="light"><span id="span_light_one">白</span> <span id="span_light_two">天</span></button></div>
        </div>
    </div>
</div>

<script src="${ctx}/js/index.js" charset="utf-8"></script>
</body>
</html>