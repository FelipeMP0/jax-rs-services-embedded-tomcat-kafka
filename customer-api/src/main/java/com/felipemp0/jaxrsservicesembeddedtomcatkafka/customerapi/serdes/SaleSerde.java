package com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.serdes;

import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.deserializers.SaleDeserializer;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.models.Sale;
import com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.serializers.SaleSerializer;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class SaleSerde implements Serde<Sale> {

    public SaleSerde() {
    }

    @Override
    public Serializer<Sale> serializer() {
        return new SaleSerializer();
    }

    @Override
    public Deserializer<Sale> deserializer() {
        return new SaleDeserializer();
    }

}
