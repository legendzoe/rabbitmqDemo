package com.example.springbootdemo.schedul;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.model.*;
import com.example.springbootdemo.pojo.HttpClientResult;
import com.example.springbootdemo.service.MessageService;
import com.example.springbootdemo.util.HttpUtil;
import netscape.javascript.JSObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class WeatherTask {
    @Resource
    MessageService messageService;

//    @PostConstruct
    @Scheduled(cron = "0 15 10 ? * *")
    public void scheduledTask() {

        MessageVo2 messageVo2 = new MessageVo2();
        messageVo2.setType("10");
        messageVo2.setTargetId("9064255805281328");

        String cityCode = "101040100";
        try {
            HttpClientResult result = HttpUtil.doGet("https://api.help.bj.cn/apis/weather/?id=" + cityCode);
            CityWeather cityWeather = null;
            if (result.getCode() == 200) {
                JSONObject jsonObject = JSONObject.parseObject(result.getContent());
                cityWeather = JSONObject.toJavaObject(jsonObject, CityWeather.class);
//                messageVo2.setContent(cityWeather.toString());

                CardMessageVo cardMessageVo = new CardMessageVo();
                TextVo textVo = new TextVo();
                textVo.setContent(cityWeather.toString());
                AccessoryVo accessoryVo = new AccessoryVo();
                accessoryVo.setSrc(cityWeather.getWeatherimg().replace("//", "https://"));
                accessoryVo.setSize("sm");
                accessoryVo.setCircle(false);

                ModulesVo modulesVo = new ModulesVo();
                modulesVo.setMode("right");
                modulesVo.setAccessory(accessoryVo);
                modulesVo.setText(textVo);
                List<ModulesVo> modulesVoList = new ArrayList<>();
                modulesVoList.add(modulesVo);
                cardMessageVo.setModules(modulesVoList);

                List<CardMessageVo> cardMessageVoArrayList = new ArrayList<>();
                cardMessageVoArrayList.add(cardMessageVo);
                messageVo2.setContents(JSON.toJSONString(cardMessageVoArrayList));

                HttpClientResult result1 = messageService.sendMessages(messageVo2);
                JSONObject messageObj = JSONObject.parseObject(result1.getContent());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
