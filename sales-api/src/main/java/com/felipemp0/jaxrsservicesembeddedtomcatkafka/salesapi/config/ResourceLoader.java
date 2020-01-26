package com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.config;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.controllers.SaleController;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ResourceLoader extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();

        classes.add(SaleController.class);

        return classes;
    }

}
