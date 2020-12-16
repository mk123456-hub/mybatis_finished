package com.abc.ssm.spring;

import java.math.BigDecimal;

/**
 * @Author Administrator
 * @create 2020/12/16 0016 13:00
 */
public class Phone {
    private String name;
    private BigDecimal price;

    public Phone() {
    }

    public Phone(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
