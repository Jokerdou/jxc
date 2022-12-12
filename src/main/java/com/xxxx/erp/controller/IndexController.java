package com.xxxx.erp.controller;

import com.xxxx.erp.base.BaseController;
import com.xxxx.erp.service.UserService;
import com.xxxx.erp.utils.LoginUserUtil;
import com.xxxx.erp.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author WongFaaCoi
 * @project CRM
 * @user 黄花菜
 * @date 2022年12月02日 10:37:14
 */
@Controller
public class IndexController extends BaseController {
    @Resource
    private UserService userService;
    /**
     * 系统登录页
     * @return
     */
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    // 系统界面欢迎页
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    /**
     * 后端管理主页面
     * @return
     */
    @RequestMapping("main")
    public String main(HttpServletRequest request){
        //在跳转到main主页之前，先获得user对象，设置到session作用域中，不然前台页面无法显示登陆者的用户信息
        //1、先通过一个工具类，通过request对象获取到cookie的用户加密id，对id进行解密（再改工具类中已经完成解密）
        int userId = LoginUserUtil.releaseUserIdFromCookie(request);
        //2、由于UserService extends BaseService，所以注入由于UserService可直接使用BaseService对象的方法
        User user = userService.selectByPrimaryKey(userId);
        //3、将user设置到session作用域中
        request.getSession().setAttribute("user", user);
        return "main";
    }
}
