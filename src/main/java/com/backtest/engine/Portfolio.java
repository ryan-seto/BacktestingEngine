package com.backtest.engine;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private double cash;
    private Map<String,Integer> positions;

    public Portfolio(double initialCapital) {
        this.cash = initialCapital;
        positions = new HashMap<>();
    }

    public void buy(String ticker, double price, int quantity) {
        double cost = price*quantity;
        if (cost > cash){
            throw new IllegalArgumentException("Insufficient funds");
        }
        cash -= cost;
        int currentQuantity = positions.getOrDefault(ticker, 0);
        positions.put(ticker, currentQuantity + quantity);
    }

    public void sell(String ticker, double price, int quantity) {
        int held = positions.getOrDefault(ticker, 0);
        if (quantity > held){
            throw new IllegalArgumentException("Insufficient positions");
        }
        cash += price * quantity;
        positions.put(ticker, held - quantity);
    }

    public double getTotalValue(double currentPrice) {
        double total = cash;
        for (Integer holding : positions.values()) {
            total += (holding * currentPrice);
        }
        return total;
    }
}
