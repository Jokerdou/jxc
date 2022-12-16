<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ERP-企业智能供给型管理系统</title>
    <#include "common.ftl">
</head>
<body class="layui-layout-body layuimini-all">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header header">
        <div class="layui-logo">
            <a href="">
                <img src="images/logo.png" alt="logo">
                <h1>ERP-进销存管理</h1>
            </a>
        </div>
        <a>
            <div class="layuimini-tool"><i title="展开" class="fa fa-outdent" data-side-fold="1"></i></div>
        </a>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item mobile layui-hide-xs" lay-unselect>
                <a href="javascript:;" data-check-screen="full"><i class="fa fa-arrows-alt"></i></a>
            </li>
            <li class="layui-nav-item layuimini-setting">
                <a href="javascript:;">${(user.userName)!""}</a>
                <dl class="layui-nav-child">
                    <dd>
                        <a href="javascript:;" data-iframe-tab="${ctx}/user/toSettingPage" data-title="基本资料"
                           data-icon="fa fa-gears">基本资料</a>
                    </dd>
                    <dd>
                        <a href="javascript:;" data-iframe-tab="${ctx}/user/toPasswordPage" data-title="修改密码"
                           data-icon="fa fa-gears">修改密码</a>
                    </dd>
                    <dd>
                        <a href="javascript:;" class="login-out">退出登录</a>
                    </dd>
                </dl>
            </li>
            <li class="layui-nav-item layuimini-select-bgcolor mobile layui-hide-xs" lay-unselect>
                <a href="javascript:;"></a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll layui-left-menu">
            <#-- 判断当前登录用户是否拥有权限 -->
            <#if roleMenus??>
            <ul class="layui-nav layui-nav-tree layui-left-nav-tree layui-this" id="currency">
                <#-- 通过freemarker中的seq_contains内建指令判断菜单是否显示 -->
                <#if roleMenus?seq_contains("100")>
                <li class="layui-nav-item">
                    <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-street-view"></i><span
                                class="layui-left-nav"> 进货管理</span> <span class="layui-nav-more"></span></a>
                    <dl class="layui-nav-child">
                        <#if roleMenus?seq_contains("101")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-1"
                               data-tab="sale_chance/index" target="_self"><i class="fa fa-tty"></i><span
                                        class="layui-left-nav"> 进货入库</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("102")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-2"
                               data-tab="cus_dev_plan/index" target="_self"><i class="fa fa-ellipsis-h"></i><span
                                        class="layui-left-nav"> 退货出库</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("103")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-2"
                               data-tab="cus_dev_plan/index" target="_self"><i class="fa fa-ellipsis-h"></i><span
                                        class="layui-left-nav"> 进货单据查询</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("104")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-2"
                               data-tab="cus_dev_plan/index" target="_self"><i class="fa fa-ellipsis-h"></i><span
                                        class="layui-left-nav"> 退货单据查询</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("105")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-2"
                               data-tab="cus_dev_plan/index" target="_self"><i class="fa fa-ellipsis-h"></i><span
                                        class="layui-left-nav"> 当前库存查询</span></a>
                        </dd>
                        </#if>
                    </dl>
                </li>
                </#if>
                <#if roleMenus?seq_contains("20")>
                <li class="layui-nav-item">
                    <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-flag"></i><span
                                class="layui-left-nav"> 销售管理</span> <span class="layui-nav-more"></span></a>
                    <dl class="layui-nav-child">
                        </#if>
                        <#if roleMenus?seq_contains("201")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-3"
                               data-tab="customer/index" target="_self"><i class="fa fa-exchange"></i><span
                                        class="layui-left-nav"> 销售出库</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("202")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-4"
                               data-tab="customer_loss/index" target="_self"><i class="fa fa-user-times"></i><span
                                        class="layui-left-nav"> 客户退货</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("203")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-4"
                               data-tab="customer_loss/index" target="_self"><i class="fa fa-user-times"></i><span
                                        class="layui-left-nav"> 销售单据查询</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("204")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-4"
                               data-tab="customer_loss/index" target="_self"><i class="fa fa-user-times"></i><span
                                        class="layui-left-nav"> 客户退货查询</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("205")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-4"
                               data-tab="customer_loss/index" target="_self"><i class="fa fa-user-times"></i><span
                                        class="layui-left-nav"> 当前库存查询</span></a>
                        </dd>
                        </#if>
                    </dl>
                </li>
                </#if>
                <#if roleMenus?seq_contains("30")>
                <li class="layui-nav-item">
                    <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-desktop"></i><span
                                class="layui-left-nav"> 库存管理</span> <span class="layui-nav-more"></span></a>
                    <dl class="layui-nav-child">
                        <#if roleMenus?seq_contains("301")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-5"
                               data-tab="customer_serve/index/1" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 商品报损</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("302")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-6"
                               data-tab="customer_serve/index/2" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 商品报溢</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("303")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-7"
                               data-tab="customer_serve/index/3" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 库存报警</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("304")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-8"
                               data-tab="customer_serve/index/4" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 报损报溢查询</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("305")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-9"
                               data-tab="customer_serve/index/5" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 当前库存查询</span></a>
                        </dd>
                        </#if>
                    </dl>
                </li>
                </#if>
                <#if roleMenus?seq_contains("40")>
                <li class="layui-nav-item">
                    <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-home"></i><span
                                class="layui-left-nav"> 统计报表</span> <span class="layui-nav-more"></span></a>
                    <dl class="layui-nav-child">
                        <#if roleMenus?seq_contains("401")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-10"
                               data-tab="report/0" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 供应商统计</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("402")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-10"
                               data-tab="report/1" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 客户统计</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("403")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-10"
                               data-tab="sale_chance/index" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 商品采购统计</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("404")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-10"
                               data-tab="report/3" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 商品销售统计</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("405")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-10"
                               data-tab="report/3" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 按日统计分析</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("406")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-10"
                               data-tab="report/3" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 商品销售统计</span></a>
                        </dd>
                        </#if>
                    </dl>
                </li>
                </#if>
                <#if roleMenus?seq_contains("50")>
                <li class="layui-nav-item">
                    <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-gears"></i><span
                                class="layui-left-nav">基础资料</span> <span class="layui-nav-more"></span></a>
                    <dl class="layui-nav-child">
                        <#if roleMenus?seq_contains("501")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-10"
                               data-tab="supplier/index" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 供应商管理</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("502")>
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-11"
                               data-tab="customer/index" target="_self"><i class="fa fa-user"></i><span
                                        class="layui-left-nav"> 客户管理</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("503")>
                        <dd class="">
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-12"
                               data-tab="goods/index" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 商品管理</span></a>
                        </dd>
                        </#if>
                        <#if roleMenus?seq_contains("504")>
                        <dd class="">
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-13"
                               data-tab="stock/index" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 期初库存</span></a>
                        </dd>
                        </#if>
                    </dl>
                </li>
                </#if>
<#--                <#if roleMenus?seq_contains("60")>-->
                <li class="layui-nav-item">
                    <a href="javascript:;" class="layui-menu-tips"><i class="fa fa-gears"></i><span
                                class="layui-left-nav"> 系统管理</span> <span class="layui-nav-more"></span></a>
                    <dl class="layui-nav-child">
<#--                        <#if roleMenus?seq_contains("601")>-->
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-10"
                               data-tab="role/index" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 角色管理</span></a>
                        </dd>
<#--                        </#if>-->
<#--                        <#-->
                        <dd>
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-11"
                               data-tab="user/index" target="_self"><i class="fa fa-user"></i><span
                                        class="layui-left-nav"> 用户管理</span></a>
                        </dd>
                        <dd class="">
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-12"
                               data-tab="menu/index" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav">菜单管理</span></a>
                        </dd>
                        <dd class="">
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-13"
                               data-tab="module/index" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 修改密码</span></a>
                        </dd>
                        <dd class="">
                            <a href="javascript:;" class="layui-menu-tips" data-type="tabAdd" data-tab-mpi="m-p-i-13"
                               data-tab="module/index" target="_self"><i class="fa fa-tachometer"></i><span
                                        class="layui-left-nav"> 安全退出</span></a>
                        </dd>
                    </dl>
                </li>
                <span class="layui-nav-bar" style="top: 201px; height: 0px; opacity: 0;"></span>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <div class="layui-tab" lay-filter="layuiminiTab" id="top_tabs_box">
            <ul class="layui-tab-title" id="top_tabs">
                <li class="layui-this" id="layuiminiHomeTabId" lay-id="welcome"><i class="fa fa-home"></i>
                    <span>首页</span></li>
            </ul>

            <ul class="layui-nav closeBox">
                <li class="layui-nav-item">
                    <a href="javascript:;"> <i class="fa fa-dot-circle-o"></i> 页面操作</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;" data-page-close="other"><i class="fa fa-window-close"></i> 关闭其他</a>
                        </dd>
                        <dd><a href="javascript:;" data-page-close="all"><i class="fa fa-window-close-o"></i> 关闭全部</a>
                        </dd>
                    </dl>
                </li>
            </ul>
            <div class="layui-tab-content clildFrame">
                <div id="layuiminiHomeTabIframe" class="layui-tab-item layui-show">
                </div>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript" src="${ctx}/js/main.js"></script>
<script src="https://eqcn.ajz.miesnfu.com/wp-content/plugins/wp-3d-pony/live2dw/lib/L2Dwidget.min.js"></script>
<!--小帅哥： https://unpkg.com/live2d-widget-model-chitose@1.0.5/assets/chitose.model.json-->
<!--萌娘：https://unpkg.com/live2d-widget-model-shizuku@1.0.5/assets/shizuku.model.json-->
<!--小可爱（女）：https://unpkg.com/live2d-widget-model-koharu@1.0.5/assets/koharu.model.json-->
<!--小可爱（男）：https://unpkg.com/live2d-widget-model-haruto@1.0.5/assets/haruto.model.json-->
<!--初音：https://unpkg.com/live2d-widget-model-miku@1.0.5/assets/miku.model.json-->
<!--水手服（女）https://unpkg.com/live2d-widget-model-z16@1.0.5/assets/z16.model.json-->
<!--学生（女）https://unpkg.com/live2d-widget-model-tsumiki@1.0.5/assets/tsumiki.model.json-->
<!--红衣美女（女）https://unpkg.com/live2d-widget-model-izumi@1.0.5/assets/izumi.model.json-->
<!-- 上边的不同链接显示的是不同的小人，这个可以根据需要来选择 下边的初始化部分，可以修改宽高来修改小人的大小，或者是鼠标移动到小人上的透明度，也可以修改小人在页面出现的位置。 -->
<script>
    /*https://unpkg.com/live2d-widget-model-shizuku@1.0.5/assets/shizuku.model.json*/
    L2Dwidget.init({ "model": { jsonPath:
                "https://unpkg.com/live2d-widget-model-izumi@1.0.5/assets/izumi.model.json",
            "scale": 1 }, "display": { "position": "left", "width": 110, "height": 150,
            "hOffset": 0, "vOffset": -20 }, "mobile": { "show": true, "scale": 0.5 },
        "react": { "opacityDefault": 0.8, "opacityOnHover": 0.1 } });
</script>
</body>
</html>
