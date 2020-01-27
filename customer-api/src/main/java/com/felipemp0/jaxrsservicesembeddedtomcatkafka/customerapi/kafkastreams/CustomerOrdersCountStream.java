package com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.kafkastreams;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.models.Sale;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.serdes.SaleSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

import static com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.constants.KafkaConstants.KAFKA_BROKER;

public class CustomerOrdersCountStream {

    public void startStream() {
        Properties props = new Properties();

        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "customer-api");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_BROKER);
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.StringSerde.class.getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SaleSerde.class.getName());

        final StreamsBuilder builder = new StreamsBuilder();

        KStream<String, Sale> source = builder.stream("sales");
        source.mapValues(Sale::getCustomerName)
              .groupBy((key, value) -> value)
              .count(Materialized.as("counts-store"))
              .toStream()
              .to("customers-order-count", Produced.with(Serdes.String(), Serdes.Long()));

        final Topology topology = builder.build();

        final KafkaStreams streams = new KafkaStreams(topology, props);

        final CountDownLatch latch = new CountDownLatch(1);

        Runtime.getRuntime().addShutdownHook(new Thread("streams-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });

        new Thread(() -> {
            try {
                streams.start();
                latch.await();
            } catch (Throwable e) {
                System.exit(1);
            }
            System.exit(0);
        }).start();
    }

}
