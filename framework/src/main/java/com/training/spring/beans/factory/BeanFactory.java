package com.training.spring.beans.factory;

import com.training.spring.beans.BeanDefinition;

/**
 * @author Wagic
 * @date 2019-07-02 10:50 by Wagic 创建
 */
public interface BeanFactory {

    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition);
}
