package com.xxxx.erp.config;

import com.xxxx.erp.interceptor.NoLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author WongFaaCoi
 * @project ERP
 * @user 黄花菜
 * @date 2022年12月03日 10:33:38
 */

/**
 * 1、定义配置类：配置类也可以叫注册器
 * 2、该类是启动拦截器的配置类，所以定义在config包下，因为是配置类，所以一定要加上Configuration，拦截器才能生效
 * 并且可以在其中设置拦截的范围和放行的资源
 * 3、此外还需要让该类继承WebMVCConfigurerAdapter，重写addInterceptor方法，设置拦截的url
    解析WebMvcConfigurerAdapter：
        Spring内部的配置方式，采用javaBean的形式来替代传统的XML配置文件形式，进行框架的个性化定制
         addInterceptors：拦截器
            方法：
             addInterceptor：需要一个实现HandlerInterceptor接口的拦截器实例
             addPathPatterns：用于设置拦截器的过滤路径规则
             excludePathPatterns：用于设置不需要拦截的过滤规则
 */
//@Configuration
public class _MvcConfig implements WebMvcConfigurer {
    //通过@Bean去注解获取该对象的方法，交给ioc获取到该对象
    @Bean
    public NoLoginInterceptor noLoginInterceptor(){
        return new NoLoginInterceptor();
    }

    /*@Resource
    private NoLoginInterceptor noLoginInterceptor;*/

    /**
     * 重写添加拦截器方法
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //public InterceptorRegistration addInterceptor(HandlerInterceptor interceptor)
        //添加拦截器方法的参数，需要填的是实现拦截器接口的实现类对象，可以通过@Bean去注解获取该对象的方法，交给ioc获取到该对象
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(noLoginInterceptor());
        interceptorRegistration
                .addPathPatterns("/**")  //设置拦截器的过滤路径
                .excludePathPatterns("/css/**", "/images/**", "/js/**", "/lib/**", "/index", "/user/login");  //设置拦截器的放行资源

    }
}
