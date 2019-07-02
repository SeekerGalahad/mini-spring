package com.training.spring.beans.factory;

import com.training.spring.beans.BeanDefinition;
import com.training.spring.beans.PropertyValue;

import java.lang.reflect.Field;

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
    Object doCreateBean(BeanDefinition beanDefinition) throws InstantiationException, IllegalAccessException, NoSuchFieldException {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws NoSuchFieldException, IllegalAccessException {
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }

    private Object createBeanInstance(BeanDefinition beanDefinition) throws IllegalAccessException, InstantiationException {
        return beanDefinition.getBeanClass().newInstance();
    }
}
