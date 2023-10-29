package com.example.springbootdemo.model;

import lombok.Data;

@Data
public class MessageVo {

    private String type;

    private String targetId;

    private String content;
}
