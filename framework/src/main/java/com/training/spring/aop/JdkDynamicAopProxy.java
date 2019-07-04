package com.training.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *    举个例子
 *     // 1. 设置被代理对象(Joinpoint)
 * 		AdvisedSupport advisedSupport = new AdvisedSupport();
 * 		TargetSource targetSource = new TargetSource(helloWorldService, HelloWorldService.class);
 * 		advisedSupport.setTargetSource(targetSource);
 *
 * 		// 2. 设置拦截器(Advice)
 * 		TimerInterceptor timerInterceptor = new TimerInterceptor();
 * 		advisedSupport.setMethodInterceptor(timerInterceptor);
 *
 * 		// 3. 创建代理(Proxy)
 * 		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
 * 		HelloWorldService helloWorldServiceProxy = (HelloWorldService) jdkDynamicAopProxy.getProxy();
 *
 *         // 4. 基于AOP的调用
 *         helloWorldServiceProxy.helloWorld();
 *
 * @author Wagic
 * @date 2019-07-04 10:58 by Wagic 创建
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{advised.getTargetSource().getTargetClass()}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodInterceptor methodInterceptor = advised.getMethodInterceptor();
        return methodInterceptor.invoke(new ReflectiveMethodInvocation(advised.getTargetSource().getTarget(), method, args));
    }
}
