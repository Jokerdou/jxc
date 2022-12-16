package com.xxxx.erp.dao;

import com.xxxx.erp.base.BaseMapper;
import com.xxxx.erp.vo.User;

public interface UserMapper extends BaseMapper<User, Integer> {
    public User queryUserByName(String userName);
}