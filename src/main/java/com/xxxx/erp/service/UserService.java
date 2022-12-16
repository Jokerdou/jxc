package com.xxxx.erp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxxx.erp.base.BaseService;
import com.xxxx.erp.dao.UserMapper;
import com.xxxx.erp.dao.UserRoleMapper;
import com.xxxx.erp.model.UserModel;
import com.xxxx.erp.query.UserQuery;
import com.xxxx.erp.utils.AssertUtil;
import com.xxxx.erp.utils.Md5Util;
import com.xxxx.erp.vo.User;
import com.xxxx.erp.vo.UserRole;
import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Resource
    private UserRoleMapper userRoleMapper;



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

    //用户管理
    //添加用户
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveUser(User user){
        /* 1. 参数校验 */
        checkUserParams(user.getUserName(),user.getTrueName(),user.getRemarks(),null);

        // 设置默认密码
        user.setPassword(Md5Util.encode("123456"));
        /* 3. 执行添加操作，判断受影响的行数 */
        AssertUtil.isTrue(userMapper.insertSelective(user) == null,"用户添加失败");

        //用户角色关联
        relationUserRole(user.getUserId(),user.getRoleIds());
    }

    //用户角色关联
    public void relationUserRole(Integer userId,String roleIds){
        // 通过用户ID查询角色记录
        Integer count = userRoleMapper.countUserRoleByUserId(userId);
        // 判断角色记录是否存在
        if (count > 0){
            // 如果角色记录存在，则删除该用户对应的角色记录
            AssertUtil.isTrue(userRoleMapper.deleteUserRoleByUserId(userId) != count,"用户角色分配失败！");
        }
        // 判断角色ID是否存在，如果存在，则添加该用户对应的角色记录
        if (StringUtils.isNoneBlank(roleIds)){
            // 将用户角色数据设置到集合中，执行批量添加
            List<UserRole> userRoleList = new ArrayList<>();
            // 将角色ID字符串转换成数组
            String[] roleIdArray = roleIds.split(",");
            // 遍历数组，得到对应的用户角色对象，并设置到集合中
            for (String roleId: roleIdArray) {
                UserRole userRole = new UserRole();
                userRole.setRoleId(Integer.parseInt(roleId));
                userRole.setUserId(userId);
                //设置到作用域中
                userRoleList.add(userRole);
            }
            //批量添加用户角色记录
            AssertUtil.isTrue(userRoleMapper.insertBatch(userRoleList) != userRoleList.size(),"用户角色分配失败");
        }
    }


    //更新用户
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateUser(User user){

        // 通过id查询数据
        User temp = userMapper.selectByPrimaryKey(user.getUserId());
        // 判断是否存在
        AssertUtil.isTrue(temp == null,"待更新记录不存在");
        // 参数校验
        checkUserParams(user.getUserName(),user.getTrueName(),user.getRemarks(),user.getUserId());

        //执行更新操作，判断受影响的行数
        AssertUtil.isTrue(userMapper.updateByPrimaryKeySelective(user) !=1,"用户更新失败");

        //用户角色关联
        relationUserRole(user.getUserId(),user.getRoleIds());
    }

    //参数校验
    private void checkUserParams(String userName, String trueName, String remarks,Integer userId) {
        // 判断用户名是否为空
        AssertUtil.isTrue(StringUtils.isBlank(userName),"用户名不能为空");
        // 判断用户名的唯一性
        // 通过用户名查询用户对象
        User temp = userMapper.queryUserByName(userName);
        // 如果用户对象为空，则表示用户名可用；如果用户对象不为空，则表示用户名不可用
        // 如果是添加操作，数据库中无数据，只要通过名称查到数据，则表示用户名被占用
        // 如果是修改操作，数据库中有对应的记录，通过用户名查到数据，可能是当前记录本身，也可能是别的记录
        // 如果用户名存在，且与当前修改记录不是同一个，则表示其他记录占用了该用户名，不可用
        AssertUtil.isTrue(null != temp && !(temp.getUserId().equals(userId)),"用户名已存在，请重新输入");
        //非空
        AssertUtil.isTrue(StringUtils.isBlank(trueName),"真实姓名不能为空");
        AssertUtil.isTrue(StringUtils.isBlank(remarks),"备注不能为空");
    }

    //用户删除
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteByIds(Integer[] ids){
        // 判断ids是否为空，长度是否大于0
        AssertUtil.isTrue(null == ids || ids.length == 0,"请选择待删除的用户记录!");
        // 执行删除操作，判断受影响的行数
        AssertUtil.isTrue(deleteBatch(ids) !=ids.length,"用户删除失败");
    }
}
