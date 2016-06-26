package br.com.android.jhowcs.androidandobserverpattern.pattern;

import br.com.android.jhowcs.androidandobserverpattern.models.Order;

/**
 * Created by jonathan_campos on 19/06/2016.
 */
public interface Observer {
    public abstract void updateUI(Order order);

}
