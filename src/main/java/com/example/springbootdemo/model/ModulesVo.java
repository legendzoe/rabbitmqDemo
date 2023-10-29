package com.example.springbootdemo.model;

import lombok.Data;

import java.util.List;

/***
 * 模块，选择你需要添加的模块参数
 */
@Data
public class ModulesVo {

    //模块
    private String type = "section";
    //文字主体
    private TextVo text;
    //元素主体，图片|按钮
    private AccessoryVo accessory;
    //位置 left|right
    private String mode;



}
