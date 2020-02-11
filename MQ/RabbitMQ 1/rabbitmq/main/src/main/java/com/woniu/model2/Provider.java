package com.woniu.model2;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.woniu.ConnectionUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @className:Provider
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/27 10:25
 * @Version:1.0
 **/
public class Provider {
    public static final String QUEUENAME = "mq181";
    public static void main(String[] args) throws Exception {

        Connection conn = ConnectionUtil.getConnection();
        //创建一个频道
        Channel channel = conn.createChannel();
        //在这个频道上创建一个消息队列 第一个参数就是消息队列的名称
        boolean durable = true;
        Map map = new HashMap<String,String>();
        map.put("x-max-length", 20);
        map.put("x-overflow", "reject-publish");
        channel.queueDeclare(QUEUENAME, durable, false, false, map);

        for (int i = 0; i < 100; i++) {
            String msg = "i love laohan "+i;
            //发布消息  第一个参数是""  第二个参数就是QUEUE_NAME  第三个参数是消息的格式  第四个参数局势消息的字节数组
            channel.basicPublish("", QUEUENAME, null, msg.getBytes());
            System.out.println("消息发布成功了"+i);
        }



        conn.close();
    }
}
