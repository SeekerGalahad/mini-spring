package com.training.spring.web.handler;

import java.lang.reflect.Method;

/**
 * @author Wagic
 * @date 2019-06-27 17:37 by Wagic 创建
 */
public class MappingHandler {

    private String uri;

    private Method method;

    private Class<?> controller;

    private String[] args;

    public MappingHandler(String uri, Method method, Class<?> controller, String[] args) {
        this.uri = uri;
        this.method = method;
        this.controller = controller;
        this.args = args;
    }


}
