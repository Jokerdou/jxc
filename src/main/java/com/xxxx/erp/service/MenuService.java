package com.xxxx.erp.service;

import com.xxxx.erp.base.BaseService;
import com.xxxx.erp.dao.MenuMapper;
import com.xxxx.erp.dao.RoleMenuMapper;
import com.xxxx.erp.model.TreeModel;
import com.xxxx.erp.utils.AssertUtil;
import com.xxxx.erp.vo.Menu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 菜单服务层
 */
@Service
public class MenuService extends BaseService<Menu, Integer> {

    /**
     * 菜单映射器
     */
    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RoleMenuMapper roleMenuMapper;

    //查询所有资源列表
    public List<TreeModel> queryAllModules(Integer roleId){
        // 查询所有的资源列表
        List<TreeModel> treeModelList = menuMapper.queryAllModules();
        // 查询指定角色已经授权过的资源列表 (查询角色拥有的资源ID)
        List<Integer> roleMenuIds = roleMenuMapper.queryRoleHasModuleIdsByRoleId(roleId);
        // 判断角色是否拥有资源ID
        if (roleMenuIds != null && roleMenuIds.size() > 0){
            // 循环所有的资源列表，判断用户拥有的资源ID中是否有匹配的，如果有，则设置checked属性为true
            treeModelList.forEach(treeModel -> {
                // 判断角色拥有的资源ID中是否有当前遍历的资源ID
                if (roleMenuIds.contains(treeModel.getId())){
                    // 如果包含你，则说明角色授权过，设置checked为true
                    treeModel.setChecked(true);
                }
            });
        }
        return treeModelList;
    }

    /**
     * 查询菜单列表
     *
     * @return 菜单列表
     */
    public Map<String, Object> queryMenuList() {
        Map<String, Object> map = new HashMap<>();
        List<Menu> menuList = menuMapper.queryMenuList();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", menuList.size());
        map.put("data", menuList);
        return map;
    }

    /**
     * 添加菜单
     *
     * @param menu 菜单
     */
    public void addMenu(Menu menu) {
        Integer menuState = menu.getMenuState();
        AssertUtil.isTrue(null == menuState || !(menuState == 0 || menuState == 1 || menuState == 2), "菜单层级不合法！");
        AssertUtil.isTrue(StringUtils.isBlank(menu.getMenuName()), "模块名称不能为空！");
        AssertUtil.isTrue(null != menuMapper.queryMenuByMenuStateAndMenuName(menuState, menu.getMenuName()), "改层级下模块名称已存在！");
        assert menuState != null;
        if (menuState == 0) {
            menu.setpId(1);
        } else if (menuState == 1) {
            AssertUtil.isTrue(StringUtils.isBlank(menu.getMenuUrl()), "URL不能为空！");
            AssertUtil.isTrue(null != menuMapper.queryMenuByMenuStateAndMenuUrl(menuState, menu.getMenuUrl()), "URL不可重复！");
        } else {
            AssertUtil.isTrue(null == menu.getpId(), "父级菜单不能为空！");
            AssertUtil.isTrue(null == menuMapper.selectByPrimaryKey(menu.getpId()), "请指定正确的父级菜单！");
        }
        AssertUtil.isTrue(StringUtils.isBlank(menu.getOptValue()), "权限码不能为空！");
        AssertUtil.isTrue(null != menuMapper.queryMenuByOptValue(menu.getOptValue()), "权限码已存在！");
        AssertUtil.isTrue(insertSelective(menu) < 1, "添加资源失败！");
    }

    /**
     * 更新菜单
     *
     * @param menu 菜单
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateMenu(Menu menu) {
        Integer menuId = menu.getMenuId();
        Menu temp = menuMapper.selectByPrimaryKey(menuId);
        Integer menuState = menu.getMenuState();
        String menuName = menu.getMenuName();
        String menuUrl = menu.getMenuUrl();
        String optValue = menu.getOptValue();
        AssertUtil.isTrue(null == menuId, "待更新记录不存在！");
        AssertUtil.isTrue(null == temp, "待更新记录不存在！");
        AssertUtil.isTrue(null == menuState || !(menuState == 0 || menuState == 1 || menuState == 2), "菜单层级不合法！");
        AssertUtil.isTrue(StringUtils.isBlank(menuName), "模块名称不能为空！");
        assert menuState != null;
        temp = menuMapper.queryMenuByMenuStateAndMenuName(menuState, menuName);
        if (temp != null) {
            AssertUtil.isTrue(!(temp.getMenuId()).equals(menuId), "该层级下菜单名已存在！");
        }
        if (menuState == 1) {
            AssertUtil.isTrue(StringUtils.isBlank(menuUrl), "菜单URL不能为空！");
            temp = menuMapper.queryMenuByMenuStateAndMenuUrl(menuState, menuUrl);
            if (temp != null) {
                AssertUtil.isTrue(!(temp.getMenuId()).equals(menuId), "该层级下菜单URL已存在！");
            }
        }
        AssertUtil.isTrue(StringUtils.isBlank(optValue), "权限码不能为空！");
        temp = menuMapper.queryMenuByOptValue(optValue);
        if (temp != null) {
            AssertUtil.isTrue(!(temp.getMenuId()).equals(menuId), "权限码已存在！");
        }
        AssertUtil.isTrue(menuMapper.updateByPrimaryKeySelective(menu) < 1, "修改资源失败！");
    }

    /**
     * 删除资源
     * 1. 判断删除的记录是否存在
     * 2. 如果当前资源存在子记录，则不可删除
     * 3. 删除资源时，将对应的权限表的记录也删除（判断权限表中是否存在关联数据，如果存在，则删除）
     * 4. 执行删除（更新）操作，判断受影响的行数
     *
     * @param menuId 菜单Id
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteMenu(Integer menuId) {
        Menu temp = menuMapper.selectByPrimaryKey(menuId);
        Integer count = menuMapper.queryMenuBypId(menuId);
        AssertUtil.isTrue(null == menuId, "待删除记录不存在！");
        AssertUtil.isTrue(null == temp, "待删除记录不存在！");
        AssertUtil.isTrue(count > 0, "该资源存在子记录，不可删除！");
        count = menuMapper.countRecordBypId(menuId);
        if (count > 0) {
            menuMapper.deleteByPrimaryKey(menuId);
        }
        AssertUtil.isTrue(menuMapper.countRecordBypId(menuId) != 0, "删除资源失败！");
    }
}
