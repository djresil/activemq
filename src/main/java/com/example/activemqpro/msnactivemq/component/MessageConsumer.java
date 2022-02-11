package com.example.activemqpro.msnactivemq.component;

import com.example.activemqpro.msnactivemq.entity.SysMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;



@Component
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "prueba-queue")
    public void messageListener(SysMessage sysMessage){
        LOGGER.info("Message received. {}", sysMessage);
    }

}
