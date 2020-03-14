package com.mysourcecodesandroid;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Programmatically extends AppCompatActivity {
    private LinearLayout pnl;
    private Button btnIncrement, btnDecrement;
    private TextView txtCount;
    int count = 0;
    Context context = this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setContentView(pnl);
    }

    public void init() {

        pnl = new LinearLayout(context);
        pnl.setOrientation(LinearLayout.VERTICAL);

        txtCount = new TextView(context);
        txtCount.setText("Count = 0");
        txtCount.setTextSize(25);

        btnIncrement = new Button(context);
        btnIncrement.setText("Increment");
        btnIncrement.setAllCaps(false);

        btnDecrement = new Button(context);
        btnDecrement.setText("Decrement");
        btnDecrement.setAllCaps(false);

        pnl.addView(txtCount);
        pnl.addView(btnIncrement);
        pnl.addView(btnDecrement);

        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ++count;
                txtCount.setText("Count = " + count);
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                --count;
                txtCount.setText("Count = " + count);
            }
        });
    }
}
