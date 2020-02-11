package com.woniu;

import org.apache.log4j.*;

import java.io.IOException;

/**
 * @className:Test
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/22 11:47
 * @Version:1.0
 **/
public class Test {
    private static final Logger log = Logger.getLogger(Test.class);
    public static void main(String[] args) throws IOException {
//        System.out.println("开始打印日志了");
//        Layout layout = new TTCCLayout("yyyy-MM-dd hh:mm:ss");
//        layout = new HTMLLayout();
//        Appender appender = new FileAppender(layout,"c:/1.html");
//
//        log.addAppender(appender);
//        log.setLevel(Level.ALL);
        for (int i = 0; i < 50; i++) {
            log.debug("this is debug");
            log.error("this is error");
            log.fatal("this is fatal");
            log.warn("this is warn");
            log.info("this is info");
        }

    }
}
