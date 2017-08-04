package com.lin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017-8-2.
 */
@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(){
        return restTemplate.getForObject("http://HELLO-SERVICE/hello",String.class);
    }

    public String hiError() {
        return "sorry,error!";
    }
}
