package com.example.springbootdemo.rabbitmqdemo.basicQue;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

public class XiaoHua {

    private final static String QUEUE_NAME = "love";

    public static void main(String[] args) throws IOException, TimeoutException, SQLException {
     /*   ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //设置队列名称
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("等待接收消息");*/

        DatabaseMetaData ConnectionUtil = null;
//        Connection connection = (Connection) ConnectionUtil.getConnection();
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.newConnection();

        // 创建频道
        Channel channel = connection.createChannel();

        // 声明（创建）队列
        /**
         * 参数1：队列名称
         * 参数2：是否定义持久化队列
         * 参数3：是否独占本次连接
         * 参数4：是否在不使用的时候自动删除队列
         * 参数5：队列其它参数
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 接收消息
        DefaultConsumer consumer = new DefaultConsumer(channel){
            /**
             * consumerTag 消息者标签，在channel.basicConsume时候可以指定
             * envelope 消息包的内容，可从中获取消息id，消息routingkey，交换机，消息和重传标志(收到消息失败后是否需要重新发送)
             * properties 属性信息
             * body 消息
             */
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                //路由key
                System.out.println("路由key为：" + envelope.getRoutingKey());
                //交换机
                System.out.println("交换机为：" + envelope.getExchange());
                //消息id
                System.out.println("消息id为：" + envelope.getDeliveryTag());
                //收到的消息
                System.out.println("consumer1111接收到的消息为：" + new String(body, "utf-8"));
            }
        };
        //监听消息
        /**
         * 参数1：队列名称
         * 参数2：是否自动确认，设置为true为表示消息接收到自动向mq回复接收到了，mq接收到回复
         会删除消息，设置为false则需要手动确认
         * 参数3：消息接收到后回调
         */
        channel.basicConsume(QUEUE_NAME, true, consumer);

    }
}