package com.cntaiping.tpa.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class MessageController {

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/show")
    public String showMessage(@RequestParam String name){
        return restTemplate.getForObject("http://producer/get?name="+name, String.class);
    }
}
