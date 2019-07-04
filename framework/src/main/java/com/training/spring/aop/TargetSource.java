package com.training.spring.aop;

/**
 * @author Wagic
 * @date 2019-07-04 10:44 by Wagic 创建
 */
public class TargetSource {

    private Class targetClass;

    private Object target;

    public TargetSource(Class targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
