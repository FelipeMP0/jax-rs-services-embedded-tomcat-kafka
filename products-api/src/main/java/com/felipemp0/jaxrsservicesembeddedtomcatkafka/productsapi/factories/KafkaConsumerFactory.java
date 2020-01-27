package com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.factories;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.models.Sale;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public class KafkaConsumerFactory {

    public static KafkaConsumer<String, Sale> createConsumer(final String bootstrapServers) {
        String keyDeserializer = StringDeserializer.class.getName();

        final Properties consumerConfig = new Properties();

        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "productsapi");
        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "com.felipemp0" +
                ".jaxrsservicesembeddedtomcatkafka.productsapi.deserializers.SaleDeserializer");

        return new KafkaConsumer<>(consumerConfig);
    }

}
