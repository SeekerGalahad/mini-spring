package com.training.spring.web.server;

import com.training.spring.web.servlet.TestServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * @author Wagic
 * @date 2019-06-26 17:42 by Wagic 创建
 */
public class TomcatServer {

    private Tomcat tomcat;
    private String[] args;

    public TomcatServer(String[] args) {
        this.args = args;
    }

    public void startServer() throws LifecycleException {
        tomcat = new Tomcat();
        tomcat.setPort(6699);
        tomcat.start();

        /*
         * tomcat容器有四层：Engine，Context，Wrapper，Servlet
         * 创建标准Context容器
         */
        Context context = new StandardContext();
        context.setPath("");
        // 添加生命周期监听
        context.addLifecycleListener(new Tomcat.FixContextListener());

        // 实例化Servlet对象，servlet注册到到Tomcat容器中
        TestServlet servlet = new TestServlet();
        // 用tomcat的静态方法，将Servlet对象注册到context容器内
        Tomcat.addServlet(context, "testServlet", servlet)
                // 支持异步
                .setAsyncSupported(true);

        // 添加一个Servlet到URI的映射，访问URI时，将会调用这个servlet
        context.addServletMappingDecoded("/test.json", "testServlet");
        // Context容器需要依附在host容器，所以在这里将context对象注册到默认的host容器
        tomcat.getHost().addChild(context);

        Thread awaitThread = new Thread("tomcat_await_thread") {
            @Override
            public void run() {
                TomcatServer.this.tomcat.getServer().await();
            }
        };

        awaitThread.setDaemon(false);
        awaitThread.start();
    }


}
