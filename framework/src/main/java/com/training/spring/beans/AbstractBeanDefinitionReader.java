package com.training.spring.beans;

import com.training.spring.beans.io.ResourceLoader;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wagic
 * @date 2019-07-02 17:19 by Wagic 创建
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private Map<String, BeanDefinition> registry;

    private ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        registry = new HashMap<>();
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
