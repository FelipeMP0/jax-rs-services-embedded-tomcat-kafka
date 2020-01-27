package com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.config;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.kafkaconsumers.impl.CustomersOrderCountConsumer;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.kafkaconsumers.impl.SaleConsumer;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.kafkastreams.CustomerOrdersCountStream;

public class KafkaLoader {

    public static void startConsumers() {
        new SaleConsumer().consumeRecords();
        new CustomersOrderCountConsumer().consumeRecords();
        new CustomerOrdersCountStream().startStream();
    }
}
