package com.gopal.mservicetwo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class feignConnectImpl {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "displaydata")
    public String getDataServiceOne() {
        String data = restTemplate.getForObject("http://localhost:8080/message",String.class);
        return data;
    }

    public String displaydata() {
        return "Service One not reachable";
    }
}
