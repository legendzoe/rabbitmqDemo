package com.example.springbootdemo.rabbitmqdemo.FMradioQue;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import lombok.SneakyThrows;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/***
 * rabbitmq 广播模式(也叫订阅模式，消息将通过交换机发送到所有的que(队列)中)
 */
public class Cheater {

    //声明的队列名
//    private final static String QUE_NAME = "sweet_lie";
//    private final static String QUE_NAME1 = "sweet_lie";
    private final static String QUE_NAME = "baby";
    private final static String QUE_NAME1 = "ate";
    //声明的交换机名
    private final static String EXCHANGE_NAME = "pick_talk";

    @SneakyThrows
    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        //创建连接，创建通道
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            //声明交换机,参数1：交换机名称,参数2：交换机类型，fanout、topic、direct、headers
            //fanout指的是广播发送到所有通道中，direct值的是发往具体的某个通道
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

            //声明队列
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("id", 1);
            //参数1，通道名，参数2是否持久化，3，是否独占，4，是否在不适用时自动删除队列 5，带的参数
//            channel.queueDeclare(QUE_NAME, true, false, false, null);
//            channel.queueDeclare(QUE_NAME1, true, false, false, null);
            channel.queueDeclare(QUE_NAME, true, false, false, null);
            channel.queueDeclare(QUE_NAME1, true, false, false, null);
            //队列与交换机进行绑定
//            channel.queueBind(QUE_NAME, EXCHANGE_NAME, "baby");
//            channel.queueBind(QUE_NAME1, EXCHANGE_NAME, "ate");
            channel.queueBind(QUE_NAME, EXCHANGE_NAME, "baby");
            channel.queueBind(QUE_NAME1, EXCHANGE_NAME, "ate");

            //发送消息
            for (int i = 0; i < 10; i++) {
                String message = "I like you honey, you'r my crush。";
                String ate = "ate, I'm sorry";
                if (i > 3) {
                    channel.basicPublish(EXCHANGE_NAME, "ate", null, ate.getBytes(StandardCharsets.UTF_8));
                } else {
                    channel.basicPublish(EXCHANGE_NAME, "baby", null, message.getBytes(StandardCharsets.UTF_8));
                }

                System.out.println("cheater 发送消息[ " + message + "]" + i);
            }

        }


    }
}
