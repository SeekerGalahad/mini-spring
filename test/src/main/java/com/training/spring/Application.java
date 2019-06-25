package com.training.spring;

import com.training.spring.starter.MiniApplication;

/**
 * @author Wagic
 * @date : 2019/6/25 20:29
 **/
public class Application {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        MiniApplication.run(Application.class, args);
    }
}
