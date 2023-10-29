package com.example.springbootdemo.model;

import lombok.Data;

@Data
public class CityWeather {

    //反馈代码 0成功
    private String status;
    //反馈信息
    private String msg;
    //城市名称英文
    private String cityen;
    //城市名称
    private String city;
    //城市编码
    private String citycode;
    //实时温度
    private String temp;
    //风向
    private String wd;
    //风力
    private String wdforce;
    //天气状况
    private String weather;
    //天气状况图标
    private String weatherimg;
    //天气状况英文
    private String weatheren;
    //能见度
    private String wisib;
    //湿度
    private String humidity;
    //今天日期
    private String today;

    @Override
    public String toString() {
        return "城市天气情况{" +
                ", 名称英文='" + cityen + '\'' +
                ", 城市名称='" + city + '\'' +
                ", 城市编码='" + citycode + '\'' +
                ", 实时温度='" + temp + '\'' +
                ", 风向='" + wd + '\'' +
                ", 风力='" + wdforce + '\'' +
                ", 天气状况='" + weather + '\'' +
                ", 天气状况图标='" + weatherimg + '\'' +
                ", 能见度='" + wisib + '\'' +
                ", 湿度='" + humidity + '\'' +
                ", 今天日期='" + today + '\'' +
                '}';
    }
}
