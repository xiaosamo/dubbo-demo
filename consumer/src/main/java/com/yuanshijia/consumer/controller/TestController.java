package com.yuanshijia.consumer.controller;

import com.yuanshijia.api.service.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yhf
 * @date 2019/5/16
 * @description
 */
@RestController
public class TestController {


    @Reference(version = "1.0.0",check = false)
    private DubboService dubboService;

    @GetMapping("/get")
    public String get(){
        return dubboService.get();
    }
}
