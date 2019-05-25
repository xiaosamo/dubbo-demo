package com.yuanshijia.consumer.controller;

import com.yuanshijia.api.service.AsyncService;
import com.yuanshijia.api.service.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author yuan
 * @date 2019/5/16
 * @description
 */
@RestController
public class TestController {


    @Reference
    private DubboService dubboService;


    @Reference(async = true)
    private AsyncService asyncService;




    /**
     * 同步调用
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/test")
    public String test() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        String s1 = dubboService.findBar();

        String s2 = dubboService.findFoo();

        long end = System.currentTimeMillis();
        System.out.println("test同步调用执行时间：" + (end - start) + "ms");

        return s1 + "\n\n" + s2;
    }


    @GetMapping("/test2")
    public String asyncTest() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        // 此调用会立即返回null
        asyncService.findBar();
        // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
        CompletableFuture<String> future1 = RpcContext.getContext().getCompletableFuture();

        StringBuilder sb = new StringBuilder();

        // 为Future添加回调
        future1.whenComplete((retValue, exception) -> {
            if (exception == null) {
                sb.append(retValue);
                System.out.println(retValue);
            } else {
                exception.printStackTrace();
            }
        });


        long time1 = System.currentTimeMillis();
        System.out.println("test异步调用getBar执行时间：" + (time1 - start) + "ms");


        asyncService.findFoo();
        // 拿到调用的Future引用，当结果返回后，会被通知和设置到此Future
        CompletableFuture<String> future2 = RpcContext.getContext().getCompletableFuture();

        // 为Future添加回调
        future2.whenComplete((retValue, exception) -> {
            if (exception == null) {
                sb.append(retValue);
                System.out.println(retValue);
            } else {
                exception.printStackTrace();
            }
        });


        long time2 = System.currentTimeMillis();
        System.out.println("test异步调用getFoo执行时间：" + (time2 - start) + "ms");

        return "null";
    }

}
