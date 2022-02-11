package com.example.activemqpro.msnactivemq.entity;

import lombok.Getter;

import java.io.Serializable;


public class SysMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String source;
    private String message;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SysMessage{" +
                "source='" + source + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
