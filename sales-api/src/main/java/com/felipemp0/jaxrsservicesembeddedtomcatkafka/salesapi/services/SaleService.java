package com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.services;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.factories.KafkaProducerFactory;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import static com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.constants.KafkaConstants.KAFKA_BROKER;

public class SaleService {

    private final KafkaProducer<String, String> kafkaProducer;

    public SaleService() {
        this.kafkaProducer = KafkaProducerFactory.createProducer(KAFKA_BROKER);
    }

    public void sendSaleEvent(String key, String value) {
        kafkaProducer.send(new ProducerRecord<>("sales", key, value));
    }

}
