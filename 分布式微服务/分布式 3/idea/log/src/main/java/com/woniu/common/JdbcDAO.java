package com.woniu.common;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @className:JdbcDAO
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/22 11:58
 * @Version:1.0
 **/
public class JdbcDAO {
    private static final Logger log = Logger.getLogger(JdbcDAO.class);
    static{
        try{
            Class.forName("com.mysql.jdbc.Drvier");
        }catch(Exception ex){
            log.fatal("驱动加载失败"+ex.getMessage());
        }
    }

        public static Connection getConnection(){
            Connection conn = null;
            try{
                conn = DriverManager.getConnection("");

            }catch(Exception ex){
                log.fatal("数据库连接失败"+ex.getMessage());
                throw new RuntimeException("数据库连接失败"+ex.getMessage());
            }
            return conn;
        }

    public static void main(String[] args) {
        JdbcDAO.getConnection();
    }

}
