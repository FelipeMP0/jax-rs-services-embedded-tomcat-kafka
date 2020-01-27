package com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.models.Sale;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class SaleDeserializer implements Deserializer<Sale> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public Sale deserialize(String topic, byte[] data) {
        ObjectMapper mapper = new ObjectMapper();
        Sale sale = null;
        try {
            sale = mapper.readValue(data, Sale.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sale;
    }

    @Override
    public Sale deserialize(String topic, Headers headers, byte[] data) {
        return this.deserialize(topic, data);
    }

    @Override
    public void close() {

    }

}
