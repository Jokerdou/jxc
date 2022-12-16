package com.xxxx.erp.controller;

import com.xxxx.erp.base.BaseController;
import com.xxxx.erp.base.ResultInfo;
import com.xxxx.erp.model.UserModel;
import com.xxxx.erp.service.UserService;
import com.xxxx.erp.utils.CookieUtil;
import com.xxxx.erp.utils.LoginUserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author WongFaaCoi
 * @project CRM
 * @user 黄花菜
 * @date 2022年12月02日 15:31:38
 */

@Controller
@RequestMapping("user")
public class UserController extends BaseController {
    // 自动注入Service依赖
    @Resource
    private UserService userService;

    // 定义一个ResultInfo对象接收前台传来的参数
    @PostMapping("login")
    @ResponseBody
    public ResultInfo userLogin(String userName,String password){

    // 创建ResultInfo对象
    ResultInfo resultInfo = new ResultInfo();
    UserModel userModel = userService.userLogin(userName,password);

    // 设置ResultInfo的result值
    resultInfo.setResult(userModel);

    // 返回ResultInfo
    return  resultInfo;
    }

    /**
     * 用户修改密码
     * @param request
     * @param oldPassword
     * @param newPassword
     * @param repeatPassword
     * @return
     */
    @PostMapping("updatePwd")
    @ResponseBody
    public ResultInfo updatePwd(HttpServletRequest request, String oldPassword, String newPassword,String repeatPassword) {
        ResultInfo resultInfo = new ResultInfo();

        //获取cookie中的userid
        /*Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);*/
        Cookie[] cookies = request.getCookies();
        String userId = null;
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if("userId".equals(name)){
                userId = cookie.getValue();
                break;
            }
        }
        userService.updatePassword(Integer.parseInt(userId),oldPassword,newPassword,repeatPassword);

        return resultInfo;
    }

    /**
     * 进入修改密码页面
     * @return
     */
    @RequestMapping("toPasswordPage")
    public String toPasswordPage(){
        return "user/password";
    }

    /**
     * toSettingPage
     * @return
     */
    @RequestMapping("toSettingPage")
    public String toSettingPage(){
        return "setting";
    }

    @RequestMapping("/updateTrueName")
    @ResponseBody
    public ResultInfo updateTrueName(HttpServletRequest request, String trueName){
        String userIdString = CookieUtil.getCookieValue(request, "userId");
        Integer userId = Integer.parseInt(userIdString);
        userService.updateTrueName(userId, trueName);
        return success("真名修改成功");
    }

}
