package com.woniu.model4;

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
    private static final String EXECHANGNAME = "EXCHANGE8";
    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtil.getConnection();

        Channel channel = conn.createChannel();

        channel.exchangeDeclare(EXECHANGNAME, "direct");//直接交换


        String msg = "this is error";
        channel.basicPublish(EXECHANGNAME, "error", null, msg.getBytes());

        msg = "this is debug";
        channel.basicPublish(EXECHANGNAME, "debug", null, msg.getBytes());

        System.out.println("提供者发布消息完毕");

        conn.close();
    }
}
