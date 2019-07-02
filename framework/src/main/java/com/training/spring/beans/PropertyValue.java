package com.training.spring.beans;

/**
 * @author Wagic
 * @date 2019-07-02 16:38 by Wagic 创建
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
