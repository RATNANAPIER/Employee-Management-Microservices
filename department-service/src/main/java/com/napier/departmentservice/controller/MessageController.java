package com.napier.departmentservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

               //It will trigger the refresh event to reload the configuration for yhe spring bean
@RefreshScope //Will force the messageController spring bean to reload the configuration
@RestController
public class MessageController {

    //Whenever there is a change in configuration it has to reflect for this @Value
    //To retrieve the value for this property from configuration file
    @Value(("${spring.boot.message}"))
    private String message;

    @GetMapping("message")
    public String message(){
        return message;
    }
}
