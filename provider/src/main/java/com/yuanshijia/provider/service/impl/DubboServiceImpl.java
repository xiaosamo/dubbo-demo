package com.yuanshijia.provider.service.impl;

import com.yuanshijia.api.service.DubboService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author yhf
 * @date 2019/5/16
 * @description
 */
@Component
@Service(version = "1.0.0")
public class DubboServiceImpl implements DubboService {


    @Value("${server.port}")
    private String port;

    @Override
    public String get() {
        return "service port:" + port;
    }

}
