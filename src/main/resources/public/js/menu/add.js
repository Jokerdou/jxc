layui.use(['form', 'layer'], function () {
    const form = layui.form, $ = layui.jquery;
    let layer = parent.layer === undefined ? layui.layer : top.layer;


    //表单提交
    form.on("submit(addMenu)", data => {
        let index = top.layer.msg('数据提交中，请稍后', {icon: 16, time: false, shade: 0.8});
        $.post(ctx + "/menu/add", data.field, ({code, msg}) => {
            if (code === 200) {
                setTimeout(function () {
                    top.layer.close(index);
                    top.layer.msg("操作成功！");
                    layer.closeAll("iframe");
                    parent.location.reload();
                }, 500);
            } else {
                layer.msg(msg, {icon: 5});
            }
        });
        return false;
    })
    //关闭弹出层
    $("#closeBtn").click(function () {
        let index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    })
})