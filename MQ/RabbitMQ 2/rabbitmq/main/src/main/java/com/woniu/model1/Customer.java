package com.woniu.model1;

import com.rabbitmq.client.*;
import com.woniu.ConnectionUtil;

import java.io.IOException;

/**
 * @className:Customer
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/27 11:06
 * @Version:1.0
 **/
public class Customer {
    public static final String QUEUENAME = "mq181";
    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtil.getConnection();

        //创建一个频道
        final Channel channel = conn.createChannel();
        //在这个频道上创建一个消息队列 第一个参数就是消息队列的名称
        channel.queueDeclare(QUEUENAME, false, false, false, null);
        //需要一个消费者进行消费数据  是一个匿名内部类
        Consumer consumer = new DefaultConsumer(channel){
            //当消息被接受的时候会自动调用这个handleDelivery方法
            //consumerTag 消息的一个标签 或者一个消息的索引
            //envelope 消息的包装类
            //BasicProperties 消息的格式
            //body 消息
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String msg =  new String(body);
                System.out.println("获取到消息"+msg);
                //第一个参数要当前消息的索引下标  envelope.getDeliveryTag()
                //true 确认当前消息和下标比当前消息小的所有消息 前面的批量确认
                //false 只确认当前消息
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        //准备开始接受消息
        //第二个参数就是true|false 确认方式： true 消息自动确认，收到的时候，就直接确认了
        //false 消息必须进行手工确认，如果不确认，消息是一个unack的状态
        channel.basicConsume(QUEUENAME, false, consumer);
    }

}
