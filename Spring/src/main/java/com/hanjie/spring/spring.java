package com.hanjie.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author authorname
 * @date 2020/10/31 14:07
 * @Version version
 */
public class spring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationfile.xml");
    }
}
