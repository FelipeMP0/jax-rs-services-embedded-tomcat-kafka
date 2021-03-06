package com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.config.KafkaConsumersLoader;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.config.ResourceLoader;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.io.File;

public class Application {

    public static void main(String[] args) throws Exception {
        KafkaConsumersLoader.startConsumers();

        new Application().start();
    }

    public void start() throws LifecycleException {
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8082);

        Context context = tomcat.addWebapp("/products/v1", new File(".").getAbsolutePath());

        Tomcat.addServlet(context, "jersey-container-servlet", resourceConfig());
        context.addServletMappingDecoded("/*", "jersey-container-servlet");

        tomcat.start();
        tomcat.getServer().await();
    }

    private ServletContainer resourceConfig() {
        return new ServletContainer(new ResourceConfig(new ResourceLoader().getClasses()));
    }

}
