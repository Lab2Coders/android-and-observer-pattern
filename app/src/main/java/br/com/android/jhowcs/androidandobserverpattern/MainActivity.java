package br.com.android.jhowcs.androidandobserverpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.android.jhowcs.androidandobserverpattern.models.Order;
import br.com.android.jhowcs.androidandobserverpattern.pattern.Observer;

public class MainActivity extends AppCompatActivity implements Observer {

    private EditText edtQuantity;
    private EditText edtDiscount;
    private EditText edtPrice;
    private EditText edtTotal;

    private BussinessLogicLayer mBll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtQuantity = (EditText) findViewById(R.id.edtQuantity);
        edtDiscount = (EditText) findViewById(R.id.edtDiscount);
        edtPrice = (EditText) findViewById(R.id.edtPrice);
        edtTotal    = (EditText) findViewById(R.id.edtTotal);

        mBll = new BussinessLogicLayer(this);

        initListeners();
    }

    private void initListeners() {
        edtQuantity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                double value = edtQuantity.getText().toString() != null && edtQuantity.getText().toString().length() > 0 ? Double.parseDouble(edtQuantity.getText().toString()) : 0.0;

                mBll.setQuantity(value);
            }
        });

        edtDiscount.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                double value = edtDiscount.getText().toString() != null && edtDiscount.getText().toString().length() > 0 ? Double.parseDouble(edtDiscount.getText().toString()) : 0.0;

                mBll.setDiscount(value);
            }
        });

        edtPrice.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                double value = edtPrice.getText().toString() != null && edtPrice.getText().toString().length() > 0 ? Double.parseDouble(edtPrice.getText().toString()) : 0.0;

                mBll.setPrice(value);
            }
        });
    }

    @Override
    public void updateUI(Order order) {
        edtQuantity.setText(String.valueOf(order.getQuantity()));
        edtDiscount.setText(String.valueOf(order.getDiscount()));
        edtPrice.setText(String.valueOf(order.getPrice()));
        edtTotal.setText(String.valueOf(order.getTotal()));
    }
}
