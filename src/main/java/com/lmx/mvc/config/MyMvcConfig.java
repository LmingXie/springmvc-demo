package com.lmx.mvc.config;

import com.lmx.mvc.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 功能描述：
 *
 * @program: springmvc-demo
 * @author: LM.X
 * @create: 2020-06-09 18:26
 **/
@Configuration
@ComponentScan(basePackages = {"com.lmx.mvc.controller","com.lmx.mvc.service"})
@EnableAsync
public class MyMvcConfig extends WebMvcConfigurationSupport {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        // 前缀
        internalResourceViewResolver.setPrefix("/WEB-INF/view/");
        // 后缀
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Bean
    public TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有的请求
        registry.addInterceptor(tokenInterceptor()).addPathPatterns("/**");
    }

}
