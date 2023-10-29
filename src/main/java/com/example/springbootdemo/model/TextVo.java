package com.example.springbootdemo.model;

import lombok.Data;

@Data
public class TextVo {

    private String type = "plain-text";
    private String content;
}
