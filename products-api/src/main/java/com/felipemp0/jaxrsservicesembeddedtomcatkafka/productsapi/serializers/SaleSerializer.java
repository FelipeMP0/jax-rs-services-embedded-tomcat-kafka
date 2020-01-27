package com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.productsapi.models.Sale;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class SaleSerializer implements Serializer<Sale> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {

    }

    @Override
    public byte[] serialize(String topic, Sale data) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(data).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    @Override
    public byte[] serialize(String topic, Headers headers, Sale data) {
        return this.serialize(topic, data);
    }

    @Override
    public void close() {

    }

}
