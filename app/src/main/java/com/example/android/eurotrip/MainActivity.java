package com.example.android.eurotrip;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    /**
     * Initates an intent to the country details activity
     * @param view : Country card that was click by the user showing the intent to view the county details
     */
    public void countryCardClicked(View view) {
        Intent intent = new Intent(this, CountryDetails.class);
        String tag = (String) view.getTag();

        intent.putExtra("COUNTRY_SELECTED", tag);
        startActivity(intent);

    }

    /**
     * Initates an intent to the europe details activity
     * @param view : Country card that was click by the user showing the intent to view the county details
     */
    public void openEuroDescription (View view){
        Intent intent = new Intent(this, EuroDescription.class);
        startActivity(intent);
    }
}
