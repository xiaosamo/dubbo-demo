package com.yuanshijia.api.service;

import java.util.concurrent.CompletableFuture;

/**
 * @author yuan
 * @date 2019/5/25
 * @description 注意接口的返回类型是CompletableFuture
 */
public interface AsyncService {
    CompletableFuture<String> findBar();

    CompletableFuture<String> findFoo();

}
