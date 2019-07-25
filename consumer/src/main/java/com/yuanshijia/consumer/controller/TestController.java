package com.yuanshijia.consumer.controller;

import com.yuanshijia.api.service.DemoService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author yuan
 * @date 2019/5/16
 * @description
 */
@RestController
public class TestController {


    @Reference
    private DemoService demoService;


    /**
     * 同步调用
     *
     * @return
     */
    @GetMapping("/test")
    public String test() {
        return demoService.sayHello("yuan");
    }

}
