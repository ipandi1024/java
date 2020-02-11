package com.woniu.model3;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.woniu.ConnectionUtil;


/**
 * @className:Provider
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/28 10:28
 * @Version:1.0
 **/
public class Provider {
    private static final String EXECHANGNAME = "EXCHANGE18";
    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtil.getConnection();

        //创建一个频道
        Channel channel = conn.createChannel();
        //在这个频道上创建一个消息队列 第一个参数就是消息队列的名称
        //发布者订阅模式其实是一种广播 fanout  无需指定谁来听 无需指定消息队列

        channel.exchangeDeclare(EXECHANGNAME, "fanout");//参数1 交换机的名称  参数2 交换机的类型  fanout

        for (int i = 0; i <50 ; i++) {
            String msg = "i love laohan"+i;

            channel.basicPublish(EXECHANGNAME, "", null, msg.getBytes());
        }


        System.out.println("提供者发布消息完毕");

        conn.close();
    }
}
