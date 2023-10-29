package com.example.springbootdemo.model;

import lombok.Data;

import java.util.List;

/***
 * 固定值，卡片式消息
 */
@Data
public class CardMessageVo {
    private String type = "card";
    private String theme = "secondary";
    //卡片显示大小 lg|sm
    private String size = "lg";

    private List<ModulesVo> modules;

}
