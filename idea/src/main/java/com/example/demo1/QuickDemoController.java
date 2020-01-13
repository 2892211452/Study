package com.demo.springbootquickdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller和@RequestBody的结合
 */
@RestController
public class QuickDemoController {
    @RequestMapping("hello")
    public String hello(){
        return "hello world,spring-boot quick";
    }
}
