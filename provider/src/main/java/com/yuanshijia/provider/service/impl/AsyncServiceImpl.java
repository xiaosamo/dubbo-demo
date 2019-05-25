package com.yuanshijia.provider.service.impl;

import com.yuanshijia.api.service.AsyncService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

/**
 * @author yuan
 * @date 2019/5/25
 * @description
 */
@Component
@Service
public class AsyncServiceImpl implements AsyncService {

    @Override
    public CompletableFuture<String> findBar() {
        long start = System.currentTimeMillis();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("调用getBar，执行时间：" + (end - start) + "ms");

        return CompletableFuture.completedFuture("service receiver msg: getBar success");
    }

    @Override
    public CompletableFuture<String> findFoo() {
        long start = System.currentTimeMillis();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("调用getFoo，执行时间：" + (end - start) + "ms");

        return CompletableFuture.completedFuture("service receiver msg: getFoo success");
    }

}
