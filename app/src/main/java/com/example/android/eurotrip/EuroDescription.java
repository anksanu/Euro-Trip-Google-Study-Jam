package com.example.android.eurotrip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class EuroDescription extends AppCompatActivity {

    private float currencyConversionRatio = 74.51f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_euro_description);
        //removing the auto focus on the edit text view
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setTitle("Europe");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }


    /**
     * calculate the euro for the given inr and update the activity
     * @param view
     */
    public void convertCurrency(View view){
        EditText inrEditTextView = (EditText) findViewById(R.id.currency_inr);
        TextView euroEditTextView = (TextView) findViewById(R.id.currency_euro);

        float inr = Float.parseFloat(inrEditTextView.getText().toString());
        float euro = inr / currencyConversionRatio;
        euroEditTextView.setText(String.format("%.2f", euro));

    }

}
