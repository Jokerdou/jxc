package com.xxxx.erp.service;

import com.xxxx.erp.base.BaseMapper;
import com.xxxx.erp.base.BaseService;
import com.xxxx.erp.dao.RoleMenuMapper;
import com.xxxx.erp.vo.RoleMenu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleMenuService extends BaseService<RoleMenu,Integer> {

    @Resource
    private RoleMenuMapper roleMenuMapper;

    //通过查询用户拥有的角色，角色拥有的资源，得到用户拥有的资源列表 （资源权限码）
    public List<String> queryUserHasRoleHasPermissionByUserId(Integer userId){
        return roleMenuMapper.queryUserHasRoleHasPermissionByUserId(userId);
    }
}
