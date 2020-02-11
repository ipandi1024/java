package com.woniu.rediscache.cache;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @className:AppliactionContextHolder
 * @Description:TODO
 * @Author:Laohan
 * @Date:2019/11/15 11:53
 * @Version:1.0
 **/
@Component
public class AppliactionContextHolder implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AppliactionContextHolder.applicationContext = applicationContext;
        System.out.println("输入成功");
    }

    public static <E> E get(String name){
        return (E)applicationContext.getBean(name);
    }

    public static <E> E get(Class<E> clss){
        return applicationContext.getBean(clss);
    }
}
