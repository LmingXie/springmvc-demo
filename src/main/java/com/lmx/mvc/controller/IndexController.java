package com.lmx.mvc.controller;

import com.lmx.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Callable;

/**
 * 功能描述：
 *
 * @program: springmvc-demo
 * @author: LM.X
 * @create: 2020-06-12 12:08
 **/
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/", produces = "text/html;charset=UTF-8")
    public String index() {
        return "返回一句话。";
    }

    @RequestMapping("/index.html")
    public String pageIndex() {
        System.out.println(">>>pageIndex<<<<");
        return "index";
    }

    @ResponseBody
    @RequestMapping("/asyncLogin.html")
    public Callable<String> asyncLogin() {
        System.out.println("开始执行payToMember>>>> name:" + Thread.currentThread().getName());
        Callable callable = new Callable<String>() {
            // 异步的对吧！
            public String call() throws Exception {
                // 耗时的时间都可以放到这个里面做 安卓里面
                String member = userService.login("zs", "123456");
                return member;
            }
        };
        System.out.println("<<<<结束执行payToMember>>> name:" + Thread.currentThread().getName());
        return callable;
    }
    // 异步返回，不想转卷   客户端主动查询
}
