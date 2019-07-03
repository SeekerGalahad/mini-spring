package com.training.spring.beans;

/**
 * @author Wagic
 * @date 2019-07-02 17:17 by Wagic 创建
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;

}
