package com.woniu.model5;

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
    private static final String EXECHANGNAME = "EXCHANGE";
    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtil.getConnection();

        Channel channel = conn.createChannel();

        channel.exchangeDeclare(EXECHANGNAME, "topic");//直接交换


        String msg = "this order send by jd";
        channel.basicPublish(EXECHANGNAME, "jd.zy", null, msg.getBytes());

        msg = "this order send by jd jxs";
        channel.basicPublish(EXECHANGNAME, "jd.jxs", null, msg.getBytes());

        msg = "this order send by tm zy";
        channel.basicPublish(EXECHANGNAME, "tm.zy", null, msg.getBytes());

        msg = "this order send by tm jxs";
        channel.basicPublish(EXECHANGNAME, "tm.jxs", null, msg.getBytes());


        System.out.println("提供者发布消息完毕");

        conn.close();
    }
}
