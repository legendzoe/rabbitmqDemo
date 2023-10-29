package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.MessageVo;
import com.example.springbootdemo.pojo.HttpClientResult;
import com.example.springbootdemo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/robot/requestHelp")
public class SendMessageController {

    @Autowired
    MessageService messageService;

    /***
     * 发送消息到某个频道
     * @param messageVo 消息主体
     * @return
     * @throws Exception
     */
    @PostMapping("/sendMessage")
    @ResponseBody
    public HttpClientResult sendMessage(MessageVo messageVo) throws Exception {

        return messageService.sendMessage(messageVo);
    }
}
