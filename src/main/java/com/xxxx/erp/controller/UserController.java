package com.xxxx.erp.controller;

import com.xxxx.erp.base.BaseController;
import com.xxxx.erp.base.ResultInfo;
import com.xxxx.erp.exceptions.ParamsException;
import com.xxxx.erp.model.UserModel;
import com.xxxx.erp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author WongFaaCoi
 * @project CRM
 * @user 黄花菜
 * @date 2022年12月02日 15:31:38
 */
@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    @PostMapping("login")
    @ResponseBody   //前台传递用户名密码 后台接受请求返回json格式数据给客户端
    public ResultInfo userLogin(String userName,String password){//接收用户名和密码传到service层去做非空判断

        //创建ResultInfo对象
        ResultInfo resultInfo = new ResultInfo();
        UserModel userModel = userService.userLogin(userName,password);
        // 设置ResultInfo的result的值 （将数据返回给请求）
        resultInfo.setResult(userModel);
        // 返回 resultInfo
        return resultInfo;
    }


}
