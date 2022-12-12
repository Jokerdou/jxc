package com.xxxx.erp.service;

import com.xxxx.erp.base.BaseService;
import com.xxxx.erp.dao.UserMapper;
import com.xxxx.erp.vo.User;
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
}
