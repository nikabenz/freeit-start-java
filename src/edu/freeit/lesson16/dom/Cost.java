package edu.freeit.lesson16.dom;

import java.util.StringJoiner;

public class Cost {
    private String currency;
    private double cost;

    public Cost() {
        super();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Cost.class.getSimpleName() + "[", "]")
                .add("currency='" + currency + "'")
                .add("cost=" + cost)
                .toString();
    }
}
