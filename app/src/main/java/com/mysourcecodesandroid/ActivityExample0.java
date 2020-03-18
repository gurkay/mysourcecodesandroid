package com.mysourcecodesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toast;

public class ActivityExample0 extends AppCompatActivity {

    EditText edTxtInstallmentExample0;
    LinearLayout pnlInstallmentExample0, pnlInstallmentsExample0;
    RadioGroup radioGrpExample0;
    RadioButton radioBtnOneShotExample0, radioBtnInstallmentExample0;
    Button btnDisplayExample0;
    String enter;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example0);
        init();
    }

    public void init() {
        // toolbar add
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edTxtInstallmentExample0 = findViewById(R.id.edTxtInstallmentExample0);
        pnlInstallmentExample0 = findViewById(R.id.pnlInstallmentExample0);
        pnlInstallmentsExample0 = findViewById(R.id.pnlInstallmentsExample0);
        radioGrpExample0 = findViewById(R.id.radioGrpExample0);
        radioBtnOneShotExample0 = findViewById(R.id.radioBtnOneShotExample0);
        radioBtnInstallmentExample0 = findViewById(R.id.radioBtnInstallmentExample0);
        btnDisplayExample0 = findViewById(R.id.btnDisplayExample0);

        // for Radio Group
        radioGrpExample0.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Radio Group Button ID take with "radioGrpExample0.getCheckedRadioButtonId()"
                switch (checkedId) {
                    case R.id.radioBtnOneShotExample0:
                        pnlInstallmentExample0.setVisibility(View.INVISIBLE);
                        pnlInstallmentsExample0.setVisibility(View.INVISIBLE);
                        edTxtInstallmentExample0.setText("");
                        break;
                    case R.id.radioBtnInstallmentExample0:
                        pnlInstallmentExample0.setVisibility(View.VISIBLE);
                        edTxtInstallmentExample0.setText("");
                        break;
                }
            }
        });

        // Edit Text Installment remove and all check box
        edTxtInstallmentExample0.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_DEL) {
                    pnlInstallmentsExample0.removeAllViews();
                }
                return false;
            }
        });

        // Button Installment click event
        btnDisplayExample0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enter = edTxtInstallmentExample0.getText().toString();
                if(enter.matches("")) {
                    Toast.makeText(context, "Lütfen bir sayı giriniz!", Toast.LENGTH_LONG).show();
                    // goto not for subline go back with return
                    return;
                }
                // Show checkbox in panel installments
                pnlInstallmentsExample0.removeAllViews();
                pnlInstallmentsExample0.setVisibility(View.VISIBLE);

                // take number of installment
                int installment = Integer.parseInt(edTxtInstallmentExample0.getText().toString());
                // edTxtInstallmentExample0.setText("");
                // edTxtInstallmentExample0.requestFocus();
                if(installment > 0) {
                    // checkbox create
                    for (int i = 0; i < installment; i++) {
                        CheckBox checkBox = new CheckBox(context);
                        checkBox.setText((i+1) + ". Taksit");
                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if(isChecked) {
                                    Toast.makeText(context, buttonView.getText(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        pnlInstallmentsExample0.addView(checkBox);
                    }
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();

        if(itemId == R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
