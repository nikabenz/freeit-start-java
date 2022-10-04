package edu.freeit.lesson16.example.model;

import java.util.StringJoiner;

public class Price {
    private String currency;
    private int code;
    private double price;

    public Price() {
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Price.class.getSimpleName() + "[", "]")
                .add("currency='" + currency + "'")
                .add("code=" + code)
                .add("price=" + price)
                .toString();
    }
}
