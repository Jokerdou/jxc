<!DOCTYPE html>
<html>
<head>
	<title>营销机会管理</title>
	<#include "../common.ftl">
</head>
<body class="childrenBody">

<form class="layui-form" >
	<blockquote class="layui-elem-quote quoteBox">
		<form class="layui-form">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" name="supplierName"
						   class="layui-input
					searchVal" placeholder="供应商姓名" />
				</div>

				<a class="layui-btn search_btn" data-type="reload"><i
							class="layui-icon">&#xe615;</i> 搜索</a>
			</div>
			<iframe align="right" frameborder="no" border="0" marginwidth="0" marginheight="0" width=280 height=52 src="//music.163.com/outchain/player?type=2&id=320950&auto=1&height=32"></iframe>


			<div id="test1"></div>
			<script src="../src/layui.js"></script>
			<#--<script>
				layui.use('tree', function(){
					var tree = layui.tree;

					//渲染
					var inst1 = tree.render({
						elem: '#test1'  //绑定元素
						,data: [{
							title: '江西' //一级菜单
							,children: [{
								title: '南昌' //二级菜单
								,children: [{
									title: '高新区' //三级菜单
									//…… //以此类推，可无限层级
								}]
							}]
						},{
							title: '陕西' //一级菜单
							,children: [{
								title: '西安' //二级菜单
							}]
						}]
					});
				});
			</script>-->

		</form>
	</blockquote>


	<table id="supplierList" class="layui-table"  lay-filter="supplier"></table>


	<script type="text/html" id="toolbarDemo">
		<div class="layui-btn-container">
			<a class="layui-btn layui-btn-normal addNews_btn" lay-event="add">
				<i class="layui-icon">&#xe608;</i>
				添加
			</a>
			<a class="layui-btn layui-btn-normal delNews_btn" lay-event="del">
				<i class="layui-icon">&#xe608;</i>
				删除
			</a>

		</div>


	</script>


	<!--操作-->
	<script id="supplierListBar" type="text/html">
		<a class="layui-btn layui-btn-xs" id="edit" lay-event="edit">编辑</a>
		<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
	</script>

</form>
<script type="text/javascript" src="${ctx}/js/supplier/supplier.js"></script>



</body>
</html>