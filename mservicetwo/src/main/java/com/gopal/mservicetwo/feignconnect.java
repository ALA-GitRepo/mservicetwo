package com.gopal.mservicetwo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="configproperties")
public interface feignconnect {

    @GetMapping("/message")
    String getDataServiceOne();


}
