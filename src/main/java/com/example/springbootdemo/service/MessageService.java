package com.example.springbootdemo.service;

import com.example.springbootdemo.model.MessageVo;
import com.example.springbootdemo.model.MessageVo2;
import com.example.springbootdemo.pojo.HttpClientResult;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface MessageService {

    HttpClientResult sendMessage(MessageVo messageVo) throws Exception;

    HttpClientResult sendMessages(MessageVo2 messageVo2) throws Exception;
}
