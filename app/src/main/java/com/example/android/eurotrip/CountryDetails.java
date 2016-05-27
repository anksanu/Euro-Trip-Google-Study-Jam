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

    /**
     * Returns the resource id of the requested resource based on the resource key and type of the requested resource
     *
     * @param key  : uniq key of the resource whose Id is requested
     * @param type : type of the resource ( id, style, drawable, string)
     * @return int : resource id of the requested resource
     */
    private int getResourceId(String key, String type) {
        return getResources().getIdentifier(key, type, getPackageName());
    }

    /**
     * Renders the details of the country passed into this activity view
     *
     * @param country : Name of the country whose details needs to be updated in the activity view
     */
    private void updateTheCountryDetails(String country) {
        country = country.toLowerCase();

        // Updates the title with the current selected county name
        setTitle(country.toUpperCase());

        // Get and update the head image on the activity with the selected county's head image
        ImageView headImageView = (ImageView) findViewById(getResourceId("country_details_head_img", "id"));
        headImageView.setBackgroundResource(getResourceId(country, "drawable"));

        // Update the popular destination image and description of the selected country in the view
        for (int i = 1; i <= 5; i++) {
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

        //Intent received from the main_activity
        Intent intent = getIntent();
        String countrySelected = intent.getStringExtra("COUNTRY_SELECTED");
        //Update the placeholders on the Country Details layout with the selected country's details
        updateTheCountryDetails(countrySelected);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
