package com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.factories;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public class KafkaConsumerFactory {

    public static KafkaConsumer<String, String> createConsumer(final String bootstrapServers) {
        String deserializer = StringDeserializer.class.getName();

        final Properties consumerConfig = new Properties();

        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "test");
        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, deserializer);
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializer);

        return new KafkaConsumer<>(consumerConfig);
    }

}
