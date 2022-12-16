layui.use(['table','layer'],function(){
    var layer = parent.layer === undefined ? layui.layer : top.layer,
        $ = layui.jquery,
        table = layui.table;


    /**
     * 加载计划项数据表格
     */
    var tableIns1 = table.render({
        id:'cusDevPlanTable1'
        // 容器元素的ID属性值
        ,elem: '#cusDevPlanList1'
        // 容器的高度 full-差值
        ,height: 'full-125'
        // 单元格最小的宽度
        ,cellMinWidth:95
        // 访问数据的URL（后台的数据接口）
        ,url: ctx + '/goods/listHaveInventory?goodsId=' + $("[name='goodsId']").val()
        // 开启分页
        ,page: true
        // 默认每页显示的数量
        ,limit:10
        // 每页页数的可选项
        ,limits:[10,20,30,40,50]
        // 表头
        ,cols: [[
            // field：要求field属性值与返回的数据中对应的属性字段名一致
            // title：设置列的标题
            // sort：是否允许排序（默认：false）
            // fixed：固定列
            {type: 'checkbox', fixed: 'center'}
            , {field: 'goodsId', title: '编号', sort: true, fixed: 'left'}
            , {field: 'goodsCode', title: '商品编码', align: 'center'}
            , {field: 'goodsName', title: '商品名称', align: 'center'}
            , {field: 'goodsModel', title: '商品型号', align: 'center'}
            , {field: 'goodsUnit', title: '商品单位', align: 'center'}
            , {field: 'purchasingPrice', title: '采购价格', align: 'center'}
            , {field: 'sellingPrice', title: '销售价格', align: 'center'}
            , {field: 'remarks', title: '生产厂商', align: 'center'}
            , {field: 'inventoryQuantity', title: '库存', align: 'center'}
            /*,{title:'操作',templet:'#cusDevPlanListBar', fixed: 'right', align:'center', minWidth:150}*/
        ]]
    });


    /**
     * 搜索按钮的点击事件
     */
    $(".search_btn").click(function () {

        /**
         * 表格重载
         *  多条件查询
         */
        tableIns1.reload({
            // 设置需要传递给后端的参数
            where: { //设定异步数据接口的额外参数，任意设
                // 通过文本框/下拉框的值，设置传递的参数
                goodsName: $("[name='goodsName']").val() // 客户名称
            }
            , page: {
                curr: 1 // 重新从第 1 页开始
            }
        });

    });




});
