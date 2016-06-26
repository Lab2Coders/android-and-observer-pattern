package br.com.android.jhowcs.androidandobserverpattern.models;

/**
 * Created by jonathan_campos on 19/06/2016.
 */
public class Order {
    private double quantity;
    private double discount;
    private double price;
    private double fullPrice;

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return getFullPrice() * (1 - (discount / 100));
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFullPrice() {
        return 20.00;
    }

    public double getTotal() {
        return getPrice() * getQuantity();
    }
}
