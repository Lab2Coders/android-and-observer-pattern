package br.com.android.jhowcs.androidandobserverpattern;

import br.com.android.jhowcs.androidandobserverpattern.models.Order;
import br.com.android.jhowcs.androidandobserverpattern.pattern.Observer;

/**
 * Created by jonathan_campos on 19/06/2016.
 */
public class BussinessLogicLayer {

    private Order order;

    private Observer observer;

    public BussinessLogicLayer(Observer observer) {
        this.order = new Order();
        this.observer = observer;

        this.notifyObserver();
    }

    public void setQuantity(double quantity) {
        this.order.setQuantity(quantity);
        notifyObserver();
    }

    public void setDiscount(double discount) {
        this.order.setDiscount(discount);
        notifyObserver();
    }

    public void setPrice(double price) {
        this.order.setDiscount(calculate(price));
        notifyObserver();
    }

    private double calculate(double price) {
        return 100 - ((price * 100) / order.getFullPrice());
    }

    public void notifyObserver() {
        this.observer.updateUI(this.order);
    }
}
