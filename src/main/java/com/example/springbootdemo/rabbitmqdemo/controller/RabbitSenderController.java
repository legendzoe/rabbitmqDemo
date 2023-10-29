package com.example.springbootdemo.rabbitmqdemo.controller;


import com.example.springbootdemo.rabbitmqdemo.WebInstance;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/robot/trytoSend")
public class RabbitSenderController {

    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    ConfigurableApplicationContext context;

    @PostMapping("/consumer")
    @ResponseBody
    public String sendMessage() throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(WebInstance.TOPIC_EXCHANGE_NAME, WebInstance.ROUTING_KEY, "Hello from RabbitMQ!");
//        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
//        context.close();
        return "success";

    }
}
