package com.xxxx.erp.controller;

import com.xxxx.erp.base.BaseController;
import com.xxxx.erp.base.ResultInfo;
import com.xxxx.erp.exceptions.ParamsException;
import com.xxxx.erp.model.UserModel;
import com.xxxx.erp.query.UserQuery;
import com.xxxx.erp.service.UserService;
import com.xxxx.erp.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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


    //用户管理
    @RequestMapping("list")
    @ResponseBody
    public Map<String,Object> selectByParams(UserQuery userQuery){
       return userService.queryByParamsForTable(userQuery);
    }

    //进入用户列表
    @RequestMapping("index")
    public String index(){
        return "user/user";
    }

    //添加用户
    @PostMapping("/save")
    @ResponseBody
    public ResultInfo saveUser(User user){
        userService.saveUser(user);
        return success("用户添加成功");
    }

    //更新用户
    @PostMapping("/update")
    @ResponseBody
    public ResultInfo updateUser(User user){
        userService.updateUser(user);
        return success("用户更新成功");
    }

    //用户删除
    @DeleteMapping("/delete")
    @ResponseBody
    public ResultInfo deleteUser(Integer[] ids){
        userService.deleteByIds(ids);
        return success("用户删除成功");
    }

    //打开添加或更新用户页面
    @RequestMapping("/toAddOrUpdateUserPage")
    public String addUserPage(Integer userId, HttpServletRequest request){
        // 判断id是否为空，不为空表示更新操作，查询用户对象
       if (userId != null){
           User user = userService.selectByPrimaryKey(userId);
           request.setAttribute("userInfo",user);
       }
        return "user/add_update";
    }

}
