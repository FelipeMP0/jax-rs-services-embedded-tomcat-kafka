package com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.services;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.factories.KafkaProducerFactory;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.models.Sale;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.math.BigDecimal;
import java.util.UUID;

import static com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.constants.KafkaConstants.KAFKA_BROKER;

public class SaleService {

    private final KafkaProducer<String, Sale> kafkaProducer;

    public SaleService() {
        this.kafkaProducer = KafkaProducerFactory.createProducer(KAFKA_BROKER);
    }

    public void sendSaleEvent(Sale sale) {
        this.kafkaProducer.send(new ProducerRecord<>("sales", UUID.randomUUID().toString(), sale));
    }

}
