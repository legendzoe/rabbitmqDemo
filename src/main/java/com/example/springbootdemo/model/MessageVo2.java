package com.example.springbootdemo.model;

import lombok.Data;

import java.util.List;

@Data
public class MessageVo2 {

    private String type;

    private String targetId;

    private String contents;

}
