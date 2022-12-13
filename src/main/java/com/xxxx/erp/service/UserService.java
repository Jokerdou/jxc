package com.xxxx.erp.service;

import com.xxxx.erp.base.BaseService;
import com.xxxx.erp.dao.UserMapper;
import com.xxxx.erp.model.UserModel;
import com.xxxx.erp.utils.AssertUtil;
import com.xxxx.erp.utils.Md5Util;
import com.xxxx.erp.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author WongFaaCoi
 * @project CRM
 * @user 黄花菜
 * @date 2022年12月02日 15:17:00
 */
@Service
public class UserService extends BaseService<User, Integer> {

    @Resource
    private UserMapper userMapper;

    //用户登录传递用户名,密码
    public UserModel userLogin(String userName,String password){
        // 1.参数判断
        checkLoginParams(userName,password);

        // 2.调用数据访问层,通过用户名查询用户记录,返回用户对象
        User user = userMapper.queryUserByName(userName);

        // 3.判断用户对象是否为空 调用工具类中的isTrue方法判断
        AssertUtil.isTrue(user == null,"用户姓名不存在!");

        // 4.判断密码是否正确,比较客户端传递的用户密码与数据库中查询的用户对象中的用户密码作比较
        checkUserPwd(password, user.getPassword());

        // 5.返回构建用户对象
        return buildUserInfo(user);
    }

    // 构建需要返回给客户端的用户对象
    private UserModel buildUserInfo(User user) {
        //创建User模型用户对象
        UserModel userModel = new UserModel();
        //返回User模型用户ID
        userModel.setUserId(user.getUserId());
        //返回User模型用户姓名
        userModel.setUserName(user.getUserName());
        //返回User模型用户真实姓名
        userModel.setTrueName(user.getTrueName());
        //返回User模型对象
        return userModel;
    }

    /**
     * 判断传递密码与数据库中的密码是否相等的方法
     * @param password 前台传递
     * @param pwd 根据用户名在数据库中查询的用户的密码
     */
    private void checkUserPwd(String password, String pwd) {
        // 将客户端传递的密码通过md5加密
        //password = Md5Util.encode(password);

        // 判断密码是否相等
        AssertUtil.isTrue(!password.equals(pwd),"用户密码不正确!");
    }

    private void checkLoginParams(String userName, String password) {
        // 验证用户姓名 调用工具类中的isTrue方法将传递的用户名进行非空校验
        // 如果用户名为空,则返回用户姓名不能为空
        AssertUtil.isTrue(StringUtils.isBlank(userName),"用户姓名不能为空!");

        // 验证用户密码 调用工具类中的isTrue方法将传递的密码进行非空校验
        // 如果用户名为空,则返回用户密码不能为空
        AssertUtil.isTrue(StringUtils.isBlank(password),"用户密码不能为空!");
    }
}
