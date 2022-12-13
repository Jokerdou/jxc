<!DOCTYPE html>
<html>
    <head>
        <#include "../common.ftl">
    </head>
    <body class="childrenBody">
        <form class="layui-form" style="width:80%;">
            <#-- 设置营销机会ID的隐藏域 -->
            <input type="hidden" name="id" value="${(supplier.supplierId)!}">

            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">供货商名称</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" lay-verify="required" name="supplierName" id="supplierName"  value="${(supplier.supplierName)!}" placeholder="请输入供货商名称">
                </div>
            </div>
            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">供货商联系人</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input"  name="contacts" id="contacts" value="${(supplier.contacts)!}" placeholder="请输入供货商联系人">
                </div>
            </div>
            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">联系人电话</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" name="phoneNumber"  lay-verify="required"  value="${(supplier.phoneNumber)!}" placeholder="请输入联系人电话">
                </div>
            </div>

            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">供货商地址</label>
                <div class="layui-input-block">
                    <input type="text" class="layui-input" lay-verify="address" name="address" value="${(supplier.address)!}" id="address" placeholder="请输入供货商地址">
                </div>
            </div>
            <div class="layui-form-item layui-row layui-col-xs12">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <textarea placeholder="备注" name="remarks" class="layui-textarea">${(supplier.remarks)!}</textarea>
                </div>
            </div>

            <br/>
            <div class="layui-form-item layui-row layui-col-xs12">
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-lg" lay-submit=""  lay-filter="addOrUpdateSupplier">确认 </button>
                    <button class="layui-btn layui-btn-lg layui-btn-normal" id="closeBtn">取消</button>
                </div>
            </div>
        </form>
    <script type="text/javascript" src="${ctx}/js/supplier/addSupplier.js"></script>
    </body>
</html>