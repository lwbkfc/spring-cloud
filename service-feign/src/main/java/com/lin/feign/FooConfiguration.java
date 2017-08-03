package com.lin.feign;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FooConfiguration {
//    @Bean
//    public Contract feignContractg() {
//        return new feign.Contract.Default();
//    }
//
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("user", "password");
//    }
//
//    @Bean
//    @Scope("prototype")
//    public Feign.Builder feignBuilder() {
//        return Feign.builder();
//    }

    @Bean
    public SchedualServiceHiHystric fb(){
        return new SchedualServiceHiHystric();
    }
}