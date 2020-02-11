package com.woniu.model5;

import com.rabbitmq.client.*;
import com.woniu.ConnectionUtil;

import java.io.IOException;


/**
 * @className:Provider
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/28 10:28
 * @Version:1.0
 **/
public class Customer2 {
    private static final String EXECHANGNAME = "EXCHANGE";
    private static final String QUEEUNAME = "MQ1";
    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtil.getConnection();

        Channel channel = conn.createChannel();
        channel.exchangeDeclare(EXECHANGNAME, "topic");

        //声明消息队列
        channel.queueDeclare(QUEEUNAME, true, false, false, null);
        //把消息队列绑定到交换机上
        channel.queueBind(QUEEUNAME, EXECHANGNAME, "*.jxs");
        channel.basicQos(1);

        //需要一个消费者进行消费数据  是一个匿名内部类
        Consumer consumer = new DefaultConsumer(channel){
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg =  new String(body);
                System.out.println("消费者2获取到消息"+msg);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEEUNAME, false, consumer);


    }
}
