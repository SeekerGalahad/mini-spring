package com.training.spring.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wagic
 * @date 2019-07-02 16:39 by Wagic 创建
 */
public class PropertyValues {

    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public PropertyValues() {
    }

    public void addPropertyValue(PropertyValue pv) {
        // 对于重复propertyName进行判断
        if (!propertyValueList.contains(pv)) {
            this.propertyValueList.add(pv);
        }
    }

    public List<PropertyValue> getPropertyValues() {
        return this.propertyValueList;
    }

}
