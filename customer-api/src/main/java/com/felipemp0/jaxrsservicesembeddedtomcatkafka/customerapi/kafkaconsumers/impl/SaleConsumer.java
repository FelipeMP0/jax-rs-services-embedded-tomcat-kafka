package com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.kafkaconsumers.impl;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.factories.KafkaConsumerFactory;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.kafkaconsumers.Consumer;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.models.Sale;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;

import static com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.constants.KafkaConstants.KAFKA_BROKER;

public class SaleConsumer implements Consumer {

    private final KafkaConsumer<String, Sale> kafkaConsumer;

    public SaleConsumer() {
        this.kafkaConsumer = KafkaConsumerFactory.createSaleConsumer(KAFKA_BROKER);
    }

    @Override
    public void consumeRecords() {
        new Thread(() -> {
            kafkaConsumer.subscribe(Collections.singleton("sales"));

            while (true) {
                final ConsumerRecords<String, Sale> records = kafkaConsumer.poll(Duration.ofSeconds(1));
                for (final ConsumerRecord<String, Sale> record : records) {
                    System.out.println("Resultado = " + record.value());
                }
            }
        }).start();
    }

}
