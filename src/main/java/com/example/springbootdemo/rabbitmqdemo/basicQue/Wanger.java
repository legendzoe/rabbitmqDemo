package com.example.springbootdemo.rabbitmqdemo.basicQue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Wanger implements AutoCloseable {
    private final static String QUEUE_NAME = "love";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "小巷，我喜欢你。";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [王二] 发送 '" + message + "'");
        }
        /*Channel channel = null;
        Connection connection = null;
        try {
            //创建连接
            connection = factory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "我喜欢你，陌生人";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [王二] 发送 '" + message + "'");
        } catch (Exception e) {

        } finally {
            channel.close();
            connection.close();
        }*/

    }

    @Override
    public void close() throws Exception {

    }
}
