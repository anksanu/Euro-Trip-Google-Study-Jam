package com.example.android.eurotrip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryDetails extends AppCompatActivity {

    private int getResourceId(String key, String type){
        return getResources().getIdentifier(key, type, getPackageName());
    }

    private void updateTheCountryDetails(String country){
        country = country.toLowerCase();

        setTitle(country.toUpperCase());

        ImageView headImageView = (ImageView) findViewById(R.id.country_details_head_img);
        headImageView.setBackgroundResource(getResourceId(country, "drawable"));

        for(int i=1; i<=5; i++) {
            ImageView touristSpotImage = (ImageView) findViewById(getResourceId("country_details_t" + i + "_image", "id"));
            TextView touristSpotDesc = (TextView) findViewById(getResourceId("country_details_t" + i + "_desc", "id"));
            touristSpotImage.setBackgroundResource(getResourceId("t" + i + "_" + country, "drawable"));
            touristSpotDesc.setText(getResourceId(country + "_t" + i + "_description", "string"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        Intent intent = getIntent();
        String countrySelected = intent.getStringExtra("COUNTRY_SELECTED");

        updateTheCountryDetails(countrySelected);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_country_details, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
