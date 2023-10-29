package com.example.springbootdemo.service.Impl;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.model.MessageVo;
import com.example.springbootdemo.model.MessageVo2;
import com.example.springbootdemo.pojo.HttpClientResult;
import com.example.springbootdemo.pojo.WebContent;
import com.example.springbootdemo.service.MessageService;
import com.example.springbootdemo.util.HttpUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    private static final String BASE_URL = "https://www.kookapp.cn";


    /***
     * 给与某个频道发送消息
     * @param messageVo 消息对象
     * @return String 返回
     */
    @Override
    public HttpClientResult sendMessage(MessageVo messageVo) throws Exception {
        if (!ObjectUtils.isEmpty(messageVo)) {
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("type", messageVo.getType());
            paramMap.put("target_id", messageVo.getTargetId());
            paramMap.put("content", messageVo.getContent());

            HttpClientResult result = HttpUtil.doPost(BASE_URL + WebContent.SEND_MESSAGE_TO_CHANNEL, new HashMap<>(), paramMap);

            return result;
        }
        return new HttpClientResult();
    }

    @Override
    public HttpClientResult sendMessages(MessageVo2 messageVo2) throws Exception {
        if (!ObjectUtils.isEmpty(messageVo2)) {
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("type", messageVo2.getType());
            paramMap.put("target_id", messageVo2.getTargetId());
            paramMap.put("content", messageVo2.getContents());

            HttpClientResult result = HttpUtil.doPost(BASE_URL + WebContent.SEND_MESSAGE_TO_CHANNEL, new HashMap<>(), paramMap);

            return result;
        }
        return new HttpClientResult();
    }


}
