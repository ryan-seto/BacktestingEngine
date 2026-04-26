package com.backtest.model;

import java.time.LocalDate;

public class Trade {
    private String ticker;
    private LocalDate date;
    private Signal signal;
    private double price;
    private int quantity;

    public Trade(String ticker, LocalDate date, Signal signal, double price, int quantity) {
        this.ticker = ticker;
        this.date = date;
        this.signal = signal;
        this.price = price;
        this.quantity = quantity;
    }

    public String getTicker() {
        return ticker;
    }

    public LocalDate getDate() {
        return date;
    }

    public Signal getSignal() {
        return signal;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
