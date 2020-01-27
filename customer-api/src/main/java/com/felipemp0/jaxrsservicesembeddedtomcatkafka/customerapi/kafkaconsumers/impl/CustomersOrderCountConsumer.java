package com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.kafkaconsumers.impl;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.factories.KafkaConsumerFactory;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.kafkaconsumers.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;

import static com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.constants.KafkaConstants.KAFKA_BROKER;

public class CustomersOrderCountConsumer implements Consumer {

    private final KafkaConsumer<String, Long> kafkaConsumer;

    public CustomersOrderCountConsumer() {
        this.kafkaConsumer = KafkaConsumerFactory.createLongConsumer(KAFKA_BROKER);
    }

    @Override
    public void consumeRecords() {
        new Thread(() -> {
            kafkaConsumer.subscribe(Collections.singleton("customers-order-count"));

            while (true) {
                final ConsumerRecords<String, Long> records = kafkaConsumer.poll(Duration.ofSeconds(1));
                for (final ConsumerRecord<String, Long> record : records) {
                    System.out.println("Resultado = " + record.key() + record.value());
                }
            }
        }).start();
    }

}
