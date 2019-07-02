package com.training.spring.beans.factory;

import com.training.spring.beans.BeanDefinition;

/**
 * @author Wagic
 * @date 2019-07-02 11:03 by Wagic 创建
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    /**
     * 初始化bean
     *
     * @param beanDefinition
     * @return
     */
    @Override
    Object doCreateBean(BeanDefinition beanDefinition) {
        try {
            Object object = beanDefinition.getBeanClass().newInstance();
            return object;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
