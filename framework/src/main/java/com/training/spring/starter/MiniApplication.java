package com.training.spring.starter;

import com.training.spring.web.server.TomcatServer;
import org.apache.catalina.LifecycleException;

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
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
