package com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.config;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.kafkaconsumers.impl.SaleConsumer;

public class KafkaConsumersLoader {

    public static void startConsumers() {
        new SaleConsumer().consumeRecords();
    }
}
