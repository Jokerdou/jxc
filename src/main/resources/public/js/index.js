layui.use(['form','jquery','jquery_cookie'], function () {
    var form = layui.form,
        layer = layui.layer,
        $ = layui.jquery,
        $ = layui.jquery_cookie($);
    
    // 表单submit提交
    form.on('submit(login)',function (data){
        console.log(data.field) //当前容器的全部表单字段,明值对形式:{name:value}
        /*表单元素的非空校验*/

        /*发送ajax请求,传递用户姓名与密码,执行用户登陆操作*/
        $.ajax({
            type:"post",
            url: ctx + "/user/login",
            data:{
                userName:data.field.username,
                password:data.field.password
            },
            success:function (result){  // result回调函数,用来接收后端返回的数据
                console.log(result);
                //判断是否登录成功  如果code = 200 则表示成功,否则表示失败
                if (result.code == 200){
                    // 登录成功
                    layer.msg("登录成功!",function (){
                        // 将用户信息设置到cookie中
                        $.cookie("userId",result.result.userId);
                        $.cookie("userName",result.result.username);
                        $.cookie("trueName",result.result.trueName);

                        // 登录成功的话,就跳转到首页
                        window.location.href = ctx + "/main";
                    })
                } else {
                    // 登录失败
                    layer.msg(result.msg,{icon:5})
                }
            }
        })
        return false; //阻止表单跳转,如果需要表单跳转,去掉这段即可.
    })
});