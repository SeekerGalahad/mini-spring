package com.training.spring.beans.factory;

import com.training.spring.beans.BeanDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Wagic
 * @date 2019-07-02 10:52 by Wagic 创建
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private final Map<String, Class<?>> beanClassNames = new ConcurrentHashMap<>();

    @Override
    public Object getBean(String name) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("No bean named " + name + " is defined");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }

    public void preInstantiateSingletons() throws Exception {
        for (String beanDefinitionName : this.beanClassNames.keySet()) {
            getBean(beanDefinitionName);
        }
    }

    public List<Class<?>> getBeanClasses() {
        return new ArrayList<>(beanClassNames.values());
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
        beanClassNames.put(name, beanDefinition.getBeanClass());
    }

    /**
     * 初始化bean
     * @param beanDefinition
     * @return
     */
    abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
