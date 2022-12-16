package com.xxxx.erp.dao;

import com.xxxx.erp.base.BaseMapper;
import com.xxxx.erp.vo.UserRole;

public interface UserRoleMapper extends BaseMapper<UserRole,Integer> {

    // 根据用户ID查询用户角色记录
    Integer countUserRoleByUserId(Integer userId);

    // 根据用户ID删除用户角色记录
    Integer deleteUserRoleByUserId(Integer userId);

}
