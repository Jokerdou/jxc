<!DOCTYPE html>
<html>
<head>
    <title>客户开发计划管理</title>
    <#include "../common.ftl">
</head>
<body class="childrenBody">


<blockquote class="layui-elem-quote quoteBox">
    <form class="layui-form">
        <div class="layui-inline">
           <#-- <div class="layui-input-inline">
                <input type="text" name="goodsName"
                       class="layui-input
					searchVal" placeholder="商品名称" />
            </div>-->

            <#--<a class="layui-btn search_btn" data-type="reload"><i
                        class="layui-icon">&#xe615;</i>有库存的商品</a>-->
            <a class="layui-btn search_btn" data-type="reload"><i class="layui-icon">&#xe615;</i>有库存的商品</a>
        </div>
    </form>
</blockquote>
<div class="layui-col-md12">
    <table id="cusDevPlanList1" class="layui-table"  lay-filter="cusDevPlans"></table>
</div>
<script type="text/javascript" src="${ctx}/js/stock/stock2.js"></script>


<hr/>
<hr/>
<hr/>




<blockquote class="layui-elem-quote quoteBox">
    <form class="layui-form">
        <div class="layui-inline">
           <#-- <div class="layui-input-inline">
                <input type="text" name="goodsName"
                       class="layui-input
					searchVal" placeholder="商品名称" />
            </div>-->

            <a class="layui-btn search_btn" data-type="reload"><i
                        class="layui-icon">&#xe615;</i>无库存的商品</a>
        </div>
    </form>
</blockquote>
<div class="layui-col-md12">
    <table id="cusDevPlanList2" class="layui-table"  lay-filter="cusDevPlans"></table>
</div>



<script type="text/javascript" src="${ctx}/js/stock/stock.js"></script>



</body>
</html>