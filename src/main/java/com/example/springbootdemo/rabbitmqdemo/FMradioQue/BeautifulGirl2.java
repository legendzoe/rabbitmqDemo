package com.example.springbootdemo.rabbitmqdemo.FMradioQue;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class BeautifulGirl2 {

    //声明的队列名
//    private final static String QUE_NAME1 = "sweet_lie1";
    private final static String QUE_NAME1 = "ate";
    //声明的交换机名
    private final static String EXCHANGE_NAME = "pick_talk";

    @SneakyThrows
    public static void main(String[] args) {


        //创建连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        Map<String, Object> receiveMap = new HashMap<>();

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        //声明队列
        channel.queueDeclare(QUE_NAME1, true, false, false, receiveMap);

        //绑定队列
        channel.queueBind(QUE_NAME1, EXCHANGE_NAME, "ate");

        System.out.println("等待接收消息");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [美女2号] 接收到的消息 '" + message + "'");
            delivery.getEnvelope().getRoutingKey();
            //路由key
            System.out.println("路由key为：" + delivery.getEnvelope().getRoutingKey());
            //交换机
            System.out.println("交换机为：" + delivery.getEnvelope().getExchange());
            //消息id
            System.out.println("消息id为：" + delivery.getEnvelope().getDeliveryTag());

        };

        channel.basicConsume(QUE_NAME1, true, deliverCallback, (consumerTag) -> {
        });

    }
}
