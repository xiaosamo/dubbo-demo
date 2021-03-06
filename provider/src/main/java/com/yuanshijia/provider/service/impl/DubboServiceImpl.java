package com.yuanshijia.provider.service.impl;


import com.yuanshijia.api.service.DubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yuan
 * @date 2019/5/16
 * @description
 */
@Component
@Service
public class DubboServiceImpl implements DubboService {


    @Override
    public String findBar() {
        long start = System.currentTimeMillis();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("调用getBar，执行时间：" + (end - start) + "ms");

        return "service receiver msg: getBar success";
    }

    @Override
    public String findFoo() {
        long start = System.currentTimeMillis();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("调用getFoo，执行时间：" + (end - start) + "ms");

        return "service receiver msg: getFoo success";
    }
}
