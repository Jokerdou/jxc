package com.xxxx.erp.dao;

import com.xxxx.erp.base.BaseMapper;
import com.xxxx.erp.model.TreeModel;
import com.xxxx.erp.vo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu, Integer> {

    // 查询所有的资源列表
    public List<TreeModel> queryAllModules();

    /**
     * 查询所有的资源数据
     *
     * @return 菜单
     */
    List<Menu> queryMenuList();

    /**
     * 通过层级与菜单名查询资源对象
     *
     * @param menuState 菜单状态
     * @param menuName  菜单名称
     * @return 菜单
     */
    Menu queryMenuByMenuStateAndMenuName(@Param("menuState") Integer menuState, @Param("menuName") String menuName);

    // 通过层级与URL查询资源对象
    Menu queryMenuByMenuStateAndMenuUrl(@Param("menuState") Integer menuState, @Param("menuUrl") String menuUrl);

    // 通过权限码查询资源对象
    Menu queryMenuByOptValue(String optValue);

    // 查询指定资源是否存在子记录
    Integer queryMenuBypId(Integer id);

    Integer countRecordBypId(Integer id);
}