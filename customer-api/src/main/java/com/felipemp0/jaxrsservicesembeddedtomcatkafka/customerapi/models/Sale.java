package com.felipemp0.jaxrsservicesembeddedtomcatkafka.customerapi.models;

import java.math.BigDecimal;

public class Sale {

    private Integer id;
    private String customerName;
    private BigDecimal value;

    public Sale() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", value=" + value +
                '}';
    }

}
