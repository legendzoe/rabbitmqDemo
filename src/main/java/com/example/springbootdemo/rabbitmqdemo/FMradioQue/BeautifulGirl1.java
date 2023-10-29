package com.example.springbootdemo.rabbitmqdemo.FMradioQue;

import com.rabbitmq.client.*;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class BeautifulGirl1 {

    //声明的队列名
//    private final static String QUE_NAME = "sweet_lie";
    private final static String QUE_NAME = "baby";
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
        channel.queueDeclare(QUE_NAME, true, false, false, null);

        //交换机与队列进行绑定
        channel.queueBind(QUE_NAME, EXCHANGE_NAME, "baby");

        System.out.println("等待接收消息");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {

            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" [美女1号] 接收到的消息 '" + message + "'");
            delivery.getEnvelope().getRoutingKey();
            //路由key
            System.out.println("路由key为：" + delivery.getEnvelope().getRoutingKey());
            //交换机
            System.out.println("交换机为：" + delivery.getEnvelope().getExchange());
            //消息id
            System.out.println("消息id为：" + delivery.getEnvelope().getDeliveryTag());

        };

        channel.basicConsume(QUE_NAME, true, deliverCallback, (consumerTag) -> {
        });
    }


}
