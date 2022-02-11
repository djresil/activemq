package com.example.activemqpro.msnactivemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import java.util.Arrays;

@Configuration
@EnableJms
public class JmsConfig {

    // se que podia poner variables del tipo ${XXXXX} pero es una prueba x.x
    private final String BROKE_URL = "tcp://localhost:61616";
    private final String BROKE_USER = "system";
    private final String BROKE_PASSWORD = "manager";

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){

        ActiveMQConnectionFactory connectionFactory= new ActiveMQConnectionFactory();
        // este lo generé porque por alguna razón no me esta reconociendo este paquete en especifico.
        connectionFactory.setTrustedPackages(Arrays.asList("com.example.activemqpro.msnactivemq.entity"));
        connectionFactory.setBrokerURL(BROKE_URL);
        connectionFactory.setUserName(BROKE_USER);
        connectionFactory.setPassword(BROKE_PASSWORD);

        return connectionFactory;

    }

    public JmsTemplate jmsTemplate(){

        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        return template;
    }

    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(){

        DefaultJmsListenerContainerFactory jmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();

        jmsListenerContainerFactory.setConnectionFactory(connectionFactory());
        jmsListenerContainerFactory.setConcurrency("5-10");
        return jmsListenerContainerFactory;
    }

}
