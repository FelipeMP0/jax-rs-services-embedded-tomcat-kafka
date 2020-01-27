package com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.factories;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.models.Sale;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Properties;

public class KafkaConsumerFactory {

    public static KafkaConsumer<String, Sale> createSaleConsumer(final String bootstrapServers) {
        String keyDeserializer = StringDeserializer.class.getName();

        final Properties consumerConfig = new Properties();

        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "customerapi");
        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "com.felipemp0" +
                ".jaxrsservicesembeddedtomcatkafka.customerapi.deserializers.SaleDeserializer");

        return new KafkaConsumer<>(consumerConfig);
    }

    public static KafkaConsumer<String, Long> createLongConsumer(final String bootstrapServers) {
        String keyDeserializer = StringDeserializer.class.getName();
        String valueDeserializer = LongDeserializer.class.getName();

        final Properties consumerConfig = new Properties();

        consumerConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        consumerConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "customerapi");
        consumerConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
        consumerConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);

        return new KafkaConsumer<>(consumerConfig);
    }

}
