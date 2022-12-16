package com.xxxx.erp.service;

import com.xxxx.erp.base.BaseService;
import com.xxxx.erp.dao.UserMapper;
import com.xxxx.erp.model.UserModel;
import com.xxxx.erp.utils.AssertUtil;
import com.xxxx.erp.utils.Md5Util;
import com.xxxx.erp.vo.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sun.security.krb5.internal.PAData;

import javax.annotation.Resource;
import javax.swing.*;


/**
 * @author WongFaaCoi
 * @project CRM
 * @user 黄花菜
 * @date 2022年12月02日 15:17:00
 */
@Service
public class UserService extends BaseService<User, Integer> {
    @Resource
    //注入dao层依赖
    private UserMapper userMapper;

    //用户登录传递用户名,密码
    public UserModel userLogin(String userName,String password){
        // 1.参数判断
        checkLoginParams(userName,password);

        // 2.通过用户名查询数据库中用户记录是否存在,返回用户对象
        User user = userMapper.queryUserByName(userName);

         // 3.判断用户对象是否为空
        AssertUtil.isTrue(user == null,"用户姓名不存在!");

        // 4.判断密码是否正确,将客户端传递的密码和数据库中查询的用户对象的用户密码作比较
        checkUserPwd(password,user.getPassword());

        // 5.返回构建用户对象
        return  buildUserInfo(user);
    }

    //支持当前事务,如果当前没有事务,则创建一个事务,这是最常见的选择
    @Transactional(propagation = Propagation.REQUIRED)
    public void updatePassword(Integer userId,String oldPwd,String newPwd,String repeatPwd){
        //通过用户ID查询用户记录,返回用户对象
        User user = userMapper.selectByPrimaryKey(userId);
        //判断用户记录是否存在
        AssertUtil.isTrue(null == user,"待更新记录不存在!");

        //参数效验
        checkPasswordParams(user,oldPwd,newPwd,repeatPwd);

        //设置用户新密码
        user.setPassword(Md5Util.encode(newPwd));

        //执行更新,判断受影响的行数
        AssertUtil.isTrue(userMapper.updateByPrimaryKeySelective(user) < 1,"修改密码失败!");
    }

    private void checkPasswordParams(User user, String oldPwd, String newPwd, String repeatPwd) {
        //判断原始的密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(oldPwd),"原始密码不能为空");
        //判断原始密码是否正确(查询的用户对象中的用户密码是否与原始密码保持一致)
        AssertUtil.isTrue(!user.getPassword().equals(Md5Util.encode(oldPwd)),"原始密码不正确!");

        //判断新密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(newPwd),"新密码不能为空!");
        //判断新密码是否与原始密码一致(不允许新密码与原始密码不一致)
        AssertUtil.isTrue(oldPwd.equals(newPwd),"新密码不能与原始密码相同!");

        //判断确认密码是否为空
        AssertUtil.isTrue(StringUtils.isBlank(repeatPwd),"确认密码不能为空!");
        //判断确认密码是否与新密码一致
        AssertUtil.isTrue(!newPwd.equals(repeatPwd),"确认密码与新密码不一致!");
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


    /*判断传递姓名与数据库中的姓名是否相同*/
    private void checkUserName(String trueName,String tn){
        AssertUtil.isTrue(StringUtils.isBlank(tn),"前台输入的用户姓名不能为空!");
        AssertUtil.isTrue(trueName.equals(tn),"用户姓名与原来姓名相同!");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateTrueName(Integer userId ,String tn){
        //通过用户ID查询用户记录,返回用户对象
        User user = userMapper.selectByPrimaryKey(userId);
        //判断用户记录是否存在
        AssertUtil.isTrue(null == user,"系统异常 待更新用户不存在!");

        //参数效验
        checkUserName(user.getTrueName(),tn);

        //设置用户新真名
        user.setTrueName(tn);

        //执行更新,判断受影响的行数
        AssertUtil.isTrue(userMapper.updateByPrimaryKeySelective(user) < 1,"修改密码失败!");
    }
}
