package com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.config;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.kafkaconsumers.impl.SaleConsumer;

public class KafkaConsumersLoader {

    public static void startConsumers() {
        new SaleConsumer().consumeRecords();
    }
}
