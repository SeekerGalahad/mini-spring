package com.training.spring.beans;

/**
 * @author Wagic
 * @date 2019-07-02 10:33 by Wagic 创建
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
