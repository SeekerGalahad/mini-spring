package com.training.spring.starter;

import com.training.spring.beans.BeanDefinition;
import com.training.spring.beans.BeanFactory;
import com.training.spring.beans.factory.AbstractBeanFactory;
import com.training.spring.beans.factory.AutowireCapableBeanFactory;
import com.training.spring.beans.io.ResourceLoader;
import com.training.spring.beans.xml.XmlBeanDefinitionReader;
import com.training.spring.core.ClassScanner;
import com.training.spring.web.handler.HandlerManager;
import com.training.spring.web.server.TomcatServer;

import java.util.List;
import java.util.Map;

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

            XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
            xmlBeanDefinitionReader.loadBeanDefinitions("spring.xml");

            AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
            for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
                beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
            }

            List<Class<?>> classes = beanFactory.getBeanClasses();
            classes.addAll(ClassScanner.scanClasses(cls.getPackage().getName()));
            BeanFactory.initBean(classes);

            HandlerManager.resolveMappingHandler(classes);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
