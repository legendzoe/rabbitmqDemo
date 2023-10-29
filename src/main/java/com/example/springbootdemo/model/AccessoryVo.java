package com.example.springbootdemo.model;

import lombok.Data;

@Data
public class AccessoryVo {

    private String type = "image";


    private String src;
    //图片大小 sm|lg
    private String size;

    //图片是原型还是方形的 方形：false|圆形：true
    private Boolean circle;

}
