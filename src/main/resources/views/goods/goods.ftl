<!DOCTYPE html>
<html>
<head>
	<title>当前库存查询</title>
	<#include "../common.ftl">
</head>
<body class="childrenBody">

<form class="layui-form" >
	<blockquote class="layui-elem-quote quoteBox">
		<form class="layui-form">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="goodsProducer"
						   class="layui-input
					searchVal" placeholder="生产厂商名" />
				</div>
				<div class="layui-input-inline">
					<input type="text" name="goodsName" class="layui-input
					searchVal" placeholder="商品名称" />
				</div>
				<div class="layui-input-inline">
					<input type="text" name="goodsCode" class="layui-input
					searchVal" placeholder="商品编码" />
				</div>
				<a class="layui-btn search_btn" data-type="reload"><i
							class="layui-icon">&#xe615;</i> 搜索</a>
			</div>
		</form>

	</blockquote>
	<table id="goodsList" class="layui-table"  lay-filter="goods"></table>





</form>
<script type="text/javascript" src="${ctx}/js/goods/goods.js"></script>

</body>
</html>