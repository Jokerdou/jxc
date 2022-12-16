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
        return false; //阻止表单跳转
    })
});
var flag = true;
var start = document.getElementById("first_head");
start.onclick = function(){
    if (flag) {
        start.style.color = "red";
            document.getElementById("one").innerText = "Y";
            document.getElementById("two").innerText = "J";
            document.getElementById("three").innerText = "X";
            document.getElementById("four").innerText = "六";
            document.getElementById("five").innerText = "组";
            document.getElementById("sex").innerText = "项";
            document.getElementById("seven").innerText = "目";
        flag = false;
    } else {
        document.getElementById("one").innerText = "E";
        document.getElementById("two").innerText = "R";
        document.getElementById("three").innerText = "P";
        document.getElementById("four").innerText = "后";
        document.getElementById("five").innerText = "端";
        document.getElementById("sex").innerText = "登";
        document.getElementById("seven").innerText = "录";
        flag = true;
    }
}
var open = true;
var back = document.getElementById("back");
var border = document.getElementById("border");
document.getElementById("light").onclick = function (){
    if (open) {
        back.style.width = "100%";
        back.style.height = "100%";
        back.style.overflow = "hidden";
        back.style.background = "white";
        back.style.transition = "all 3s";
        document.getElementById("span_light_one").innerText = "黑";
        document.getElementById("span_light_two").innerText = "夜";
        open = false
    } else {
        back.style.width = "100%";
        back.style.height = "100%";
        back.style.overflow = "hidden";
        back.style.background = "black";
        back.style.transition = "all 3s";
        document.getElementById("span_light_one").innerText = "白";
        document.getElementById("span_light_two").innerText = "天";
        open = true
    }
}