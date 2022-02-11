package com.example.activemqpro.msnactivemq.controller;

import com.example.activemqpro.msnactivemq.config.JmsConfig;
import com.example.activemqpro.msnactivemq.entity.SysMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PublishController {

    private final JmsConfig jmsTemplate;

    @PostMapping("publishMessage")
    public ResponseEntity<String> publishMessage(@RequestBody SysMessage sysMessage){
        try {
            jmsTemplate.jmsTemplate().convertAndSend("prueba-queue", sysMessage);
            return new ResponseEntity<>("Sent", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
