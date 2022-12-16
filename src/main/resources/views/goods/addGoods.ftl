<!DOCTYPE html>
<html>
    <head>
        <#include "../common.ftl">
    </head>
    <body class="childrenBody">
        <form class="layui-form" style="width:80%;">
            <#-- 设置营销机会ID的隐藏域 -->
            <input type="hidden" name="goodsId" value="${(goods.goodsId)!}">

            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">商品编号</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" lay-verify="required" name="goodsCode" id="goodsCode"  value="${(goods.goodsCode)!}" placeholder="请输入客户名称">
                </div>
            </div>
            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">商品名称</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input"  name="goodsName" id="goodsName" value="${(goods.goodsName)!}" placeholder="请输入商品名称">
                </div>
            </div>
            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">商品型号</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" name="goodsModel"  lay-verify="required"  value="${(goods.goodsModel)!}" placeholder="请输入商品型号">
                </div>
            </div>

            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">商品单位</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" lay-verify="goodsUnit" name="goodsUnit" value="${(goods.goodsUnit)!}" id="goodsUnit" placeholder="请输入商品单位">
                </div>
            </div>

            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">采购价格</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" lay-verify="required" name="purchasingPrice" id="purchasingPrice"  value="${(goods.purchasingPrice)!}" placeholder="请输入采购价格">
                </div>
            </div>

            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">销售价格</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" lay-verify="required" name="sellingPrice" id="sellingPrice"  value="${(goods.sellingPrice)!}" placeholder="请输入销售价格">
                </div>
            </div>

            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">库存下限</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" lay-verify="required" name="minNum" id="minNum"  value="${(goods.minNum)!}" placeholder="请输入库存下限">
                </div>
            </div>

            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">生产厂商</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" lay-verify="required" name="goodsProducer" id="goodsProducer"  value="${(goods.goodsProducer)!}" placeholder="请输入生产厂商">
                </div>
            </div>

            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea placeholder="备注" name="remarks" class="layui-textarea">${(goods.remarks)!}</textarea>
                </div>
            </div>

            <br/>
            <div class="layui-form-item layui-row layui-col-xs12">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-lg" lay-submit=""  lay-filter="addOrUpdateCustomer">确认 </button>
                    <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
                </div>
            </div>
        </form>
    <script type="text/javascript" src="${ctx}/js/goods/addGoods.js"></script>
    </body>
</html>