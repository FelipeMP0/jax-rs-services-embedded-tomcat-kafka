package com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.kafkaconsumers.impl;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.factories.KafkaConsumerFactory;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.kafkaconsumers.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;

import java.time.Duration;
import java.util.Collections;

import static com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.constants.KafkaConstants.KAFKA_BROKER;

public class SaleConsumer implements Consumer {

    private final KafkaConsumer<String, String> kafkaConsumer;

    public SaleConsumer() {
        this.kafkaConsumer = KafkaConsumerFactory.createConsumer(KAFKA_BROKER);
    }

    @Override
    public void consumeRecords() {
        kafkaConsumer.subscribe(Collections.singleton("sales"));

        while (true) {
            final ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(5));
            for (final ConsumerRecord<String, String> record : records) {
                System.out.println("Resultado" + record.value());
            }
        }
    }

}
