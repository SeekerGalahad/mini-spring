package com.training.spring.starter;

import com.training.spring.beans.BeanDefinition;
import com.training.spring.beans.BeanFactory;
import com.training.spring.beans.factory.AbstractBeanFactory;
import com.training.spring.beans.factory.AutowireCapableBeanFactory;
import com.training.spring.beans.io.ResourceLoader;
import com.training.spring.beans.xml.XmlBeanDefinitionReader;
import com.training.spring.context.ApplicationContext;
import com.training.spring.context.ClassPathXmlApplicationContext;
import com.training.spring.core.ClassScanner;
import com.training.spring.web.handler.HandlerManager;
import com.training.spring.web.server.TomcatServer;

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
            BeanFactory.initBean(classes);

            HandlerManager.resolveMappingHandler(classes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
