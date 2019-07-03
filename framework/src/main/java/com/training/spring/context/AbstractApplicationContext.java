package com.training.spring.context;

import com.training.spring.beans.factory.AbstractBeanFactory;

/**
 * @author Wagic
 * @date 2019-07-03 15:39 by Wagic 创建
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception{
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
