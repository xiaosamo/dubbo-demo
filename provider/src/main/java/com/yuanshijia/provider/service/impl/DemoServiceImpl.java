package com.yuanshijia.provider.service.impl;

import com.yuanshijia.api.service.DemoService;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author yuanshijia
 * @date 2019-07-25
 * @description
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}