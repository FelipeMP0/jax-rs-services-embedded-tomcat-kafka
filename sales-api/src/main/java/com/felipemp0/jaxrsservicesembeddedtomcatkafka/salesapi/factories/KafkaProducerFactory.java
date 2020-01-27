package com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.factories;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.salesapi.models.Sale;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerFactory {

    public static KafkaProducer<String, Sale> createProducer(final String bootstrapServers) {
        String keySerializer = StringSerializer.class.getName();

        final Properties producerConfig = new Properties();

        producerConfig.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        producerConfig.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
        producerConfig.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "com.felipemp0" +
                ".jaxrsservicesembeddedtomcatkafka.salesapi.serializers.SaleSerializer");

        return new KafkaProducer<>(producerConfig);
    }

}
