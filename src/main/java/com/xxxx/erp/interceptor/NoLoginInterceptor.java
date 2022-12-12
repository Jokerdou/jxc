package com.xxxx.erp.interceptor;

import com.xxxx.erp.dao.UserMapper;
import com.xxxx.erp.exceptions.NoLoginException;
import com.xxxx.erp.utils.LoginUserUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author WongFaaCoi
 * @project CRM
 * @user 黄花菜
 * @date 2022年12月03日 09:55:16
 */
//@Component //定义的拦截器交给ioc容器管理
public class NoLoginInterceptor implements HandlerInterceptor {
    //要先注入dao等的接口UserMapper才可调用根据主键查询user的方法
    @Resource
    private UserMapper userMapper;

    /**
     * 未登录拦截器，验证用户是否处于登录状态
     * 根据前台的请求request获取到cookie，获取cookie中的userId
     * 判断userId是否为空，判断userId对应的数据库记录是否存在
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //* 未登录拦截器，验证用户是否处于登录状态
        //* 根据前台的请求request获取到cookie，获取cookie中的userId
        Integer userId = LoginUserUtil.releaseUserIdFromCookie(request);
        //* 判断userId是否为空，判断userId对应的数据库记录是否存在
        if(userId == null || userMapper.selectByPrimaryKey(userId) == null){
            throw new NoLoginException();
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
