package com.lmx.mvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 功能描述: Web初始化
 *
 * @author LM.X
 * @date 2020/6/12 14:52
 */
public class WebInitializer implements WebApplicationInitializer {
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        // 1.启动SpringMVC 容器 类注入到Spring中
        AnnotationConfigWebApplicationContext app = new AnnotationConfigWebApplicationContext();
        // 2.注入我们的springmvc 的配置文件
        app.register(MyMvcConfig.class);
        // 3. 将我们的DispatcherServlet 注入到 serlvet容器中
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(app));
        // 4.填写url路径映射
        dynamic.addMapping("/");
        // 优先级最高表示 最早被加载
        dynamic.setLoadOnStartup(1);
        // 开启SpringMVC异步
        dynamic.setAsyncSupported(true);
    }
    // 基本配置已经ok呢？ web.xml ？ 使用WebApplicationInitializer 替代web.xml
    //为什么这个类WebInitializer 不需要直接呢？ 能够自动的找到该类呢、
}