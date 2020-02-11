package com.woniu;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @className:ConnectionUtil
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/27 10:20
 * @Version:1.0
 **/
public class ConnectionUtil {

    public static Connection getConnection() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection conn = factory.newConnection();
        return conn;
    }

}
