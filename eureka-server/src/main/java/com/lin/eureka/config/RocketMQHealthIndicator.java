package com.lin.eureka.config;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017-8-4.
 */
@Component
public class RocketMQHealthIndicator implements HealthIndicator{
    @Override
    public Health health() {
        int errorCode = check();
        if (errorCode != 0){
            return Health.down().withDetail("Error Code",errorCode).build();
        }
        return Health.up().build();
    }

    private int check(){
        return 1;
    }
}
