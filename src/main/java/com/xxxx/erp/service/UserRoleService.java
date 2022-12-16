package com.xxxx.erp.service;

import com.xxxx.erp.base.BaseService;
import com.xxxx.erp.dao.UserRoleMapper;
import com.xxxx.erp.vo.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserRoleService extends BaseService<UserRole,Integer> {

    @Resource
    private UserRoleMapper userRoleMapper;
}
