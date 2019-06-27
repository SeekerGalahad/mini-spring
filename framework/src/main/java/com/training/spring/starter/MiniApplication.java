package com.training.spring.starter;

import com.training.spring.beans.BeanFactory;
import com.training.spring.core.ClassScanner;
import com.training.spring.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

import java.io.IOException;
import java.util.List;

/**
 * @author Wagic
 * @date : 2019/6/25 20:44
 **/
public class MiniApplication {

    public static void run(Class<?> cls, String[] args) {
        System.out.println("Hello mini-spring!");
        TomcatServer tomcatServer = new TomcatServer(args);
        try {
            tomcatServer.startServer();
            List<Class<?>> classes = ClassScanner.scanClasses(cls.getPackage().getName());
            classes.forEach(x -> System.out.println(x.getName()));
            BeanFactory.initBean(classes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
