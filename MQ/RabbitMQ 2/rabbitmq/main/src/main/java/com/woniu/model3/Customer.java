package com.woniu.model3;

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
public class Customer {
    private static final String EXECHANGNAME = "EXCHANGE18";
    private static final String QUEEUNAME = "MQ18";
    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtil.getConnection();

        //创建一个频道
        Channel channel = conn.createChannel();
        //在这个频道上创建一个消息队列 第一个参数就是消息队列的名称
        //发布者订阅模式其实是一种广播 fanout  无需指定谁来听 无需指定消息队列
        channel.exchangeDeclare(EXECHANGNAME, "fanout");//参数1 交换机的名称  参数2 交换机的类型  fanout

        //声明消息队列
        channel.queueDeclare(QUEEUNAME, true, false, false, null);
        //把消息队列绑定到交换机上
        channel.queueBind(QUEEUNAME, EXECHANGNAME, "");
        //在当前的fantou模式下，第三个参数即便你写了，也会被忽略
        channel.basicQos(1);

        //需要一个消费者进行消费数据  是一个匿名内部类
        Consumer consumer = new DefaultConsumer(channel){
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg =  new String(body);
                System.out.println("消费者1获取到消息"+msg);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        channel.basicConsume(QUEEUNAME, false, consumer);


    }
}
