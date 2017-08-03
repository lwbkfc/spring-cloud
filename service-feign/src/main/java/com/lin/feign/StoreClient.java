package com.lin.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(name = "stores", configuration = FooConfiguration.class)
public interface StoreClient {
    //..
}