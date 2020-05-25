package com.example.instatry;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.instatry.Maps.Main2Activity;

public class Place extends AppCompatActivity {

    public String description, placepicture, title, latitude, longitude;
    private static final String TAG = "Place";
    private TextView title_tv, desc_tv;
    private ImageView bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);

        Intent enterdets = getIntent();

        description = enterdets.getStringExtra("description");
        latitude = enterdets.getStringExtra("latitude");
        longitude = enterdets.getStringExtra("longitude");
        placepicture = enterdets.getStringExtra("placepicture");
        title = enterdets.getStringExtra("title");

        title_tv = (TextView) findViewById(R.id.place_title_tv);
        desc_tv = (TextView) findViewById(R.id.place_info_tv);
        bg = (ImageView) findViewById(R.id.place_image_bg);

        title_tv.setText(title);
        desc_tv.setText(description);

        Glide.with(Place.this)
                .asBitmap()
                .load(placepicture)
                .into(bg);
    }

    public void gotoMaps(View view) {
        Toast.makeText(this, "Maps" + latitude + longitude, Toast.LENGTH_SHORT).show();
        // Go to Maps Activity (use intent or whatever)
        // use variables latitude and longitude variables

        Intent intent = new Intent(Place.this, Main2Activity.class);
        double d1=Double.parseDouble(latitude);
        double d2=Double.parseDouble(longitude);

//        double d1=13.3525;
//        double d2=74.7928;
        String s1=String.valueOf(d1);
        String s2=String.valueOf(d2);
        intent.putExtra("coor1",s1);
        intent.putExtra("coor2",s2);
        startActivity(intent);




    }
}
