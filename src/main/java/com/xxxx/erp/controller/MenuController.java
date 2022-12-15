package com.xxxx.erp.controller;

import com.xxxx.erp.base.BaseController;
import com.xxxx.erp.base.ResultInfo;
import com.xxxx.erp.service.MenuService;
import com.xxxx.erp.vo.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 菜单控制层
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {
    /**
     * 菜单服务
     */
    @Resource
    private MenuService menuService;

    /**
     * 查询菜单列表
     *
     * @return Map<String, Object> - 菜单列表
     */
    @RequestMapping("list")
    @ResponseBody
    public Map<String, Object> queryMenuList() {
        return menuService.queryMenuList();
    }


    /**
     * 进入菜单管理页面
     *
     * @return String - 菜单管理页面
     */
    @RequestMapping("index")
    public String index() {
        return "menu/menu";
    }


    /**
     * 添加菜单
     *
     * @param menu 菜单
     * @return ResultInfo - 结果信息
     */
    @PostMapping("add")
    @ResponseBody
    public ResultInfo addMenu(Menu menu) {
        menuService.addMenu(menu);
        return success("添加菜单成功！");
    }

    /**
     * 修改菜单
     *
     * @param menu 菜单
     * @return ResultInfo
     */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo updateMenu(Menu menu) {
        menuService.updateMenu(menu);
        return success("修改菜单成功！");
    }

    /**
     * 删除菜单
     *
     * @param menuId 菜单Id
     * @return ResultInfo - 结果信息
     */
    @PostMapping("delete")
    @ResponseBody
    public ResultInfo deleteMenu(Integer menuId) {
        menuService.deleteMenu(menuId);
        return success("删除菜单成功！");
    }

    /**
     * 打开添加菜单的页面
     *
     * @param menuState 层级
     * @param pId       父菜单ID
     * @return String
     */
    @RequestMapping("addMenuPage")
    public String toAddMenuPage(Integer menuState, Integer pId, HttpServletRequest request) {
        // 将数据设置到请求域中
        request.setAttribute("menuState", menuState);
        request.setAttribute("pId", pId);
        return "menu/add";
    }

    /**
     * 打开修改菜单的页面
     *
     * @param menuId 菜单Id
     * @return 修改页面
     */
    @RequestMapping("toUpdateMenuPage")
    public String toUpdateMenuPage(Integer menuId, Model model) {
        // 将要修改的菜单对象设置到请求域中
        model.addAttribute("menu", menuService.selectByPrimaryKey(menuId));
        return "menu/update";
    }
}
