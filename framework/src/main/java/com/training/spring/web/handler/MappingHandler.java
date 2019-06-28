package com.training.spring.web.handler;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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


    public boolean handle(ServletRequest req, ServletResponse res) throws IllegalAccessException, InstantiationException, IOException, InvocationTargetException {
        String requestURI = ((HttpServletRequest) req).getRequestURI();
        if (!uri.equals(requestURI)) {
            return false;
        }

        Object[] parameters = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            parameters[i] = req.getParameter(args[i]);
        }

        Object ctl = controller.newInstance();
        Object response = method.invoke(ctl, parameters);
        res.getWriter().println(response.toString());
        return true;
    }
}
