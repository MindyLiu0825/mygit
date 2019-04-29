package com.cn.mindy.shop.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class TestController {

    @RequestMapping("/hello")
    public void test(){

        System.out.println("hello....");
    }
}
