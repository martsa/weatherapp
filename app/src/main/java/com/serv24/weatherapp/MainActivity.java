package com.serv24.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.provider.Settings;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    Button oneDay,fiveDay;
    LocationManager locationManager;
    String latitude= "0", longitude="1";
    TextView showLocation;
    private static final int REQUEST_LOCATION = 1;
    private Button button;
    private ImageView imageView;
    private Random random = new Random();
    private int lastDirection;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        oneDay=findViewById(R.id.oneDay);
        fiveDay=findViewById(R.id.fiveDay);

        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.holder,new weatherOneDayFragment()).addToBackStack(null).commit();
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            OnGPS();
        } else {
            getLocation();
        }


        oneDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PlaylistActivity.class);
                startActivity(intent);
/*
                FragmentManager fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.holder,new weatherOneDayFragment()).addToBackStack(null).commit();
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    OnGPS();
                } else {
                    getLocation();
                }*/

            }
        });

        fiveDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,WeatherActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("latitute",latitude);
                bundle.putString("longitute",longitude);
                intent.putExtras(bundle);


                startActivity(intent);
             /*   FragmentManager fragmentManager=getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.holder,new weatherFiveDayFragment()).addToBackStack(null).commit();*/


            }
        });



    }


    public void spin(View view){

        int newDirection = random.nextInt(3600);

        float pivoitX = imageView.getWidth()/2;
        float pivoitY = imageView.getHeight()/2;


        Animation rotate = new RotateAnimation(lastDirection, newDirection, pivoitX, pivoitY);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);
                //button.setBackgroundColor(Color.parseColor("#c1c1c1"));

                //https://fb.com/HiteshChoudharyPage
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        lastDirection = newDirection;

        imageView.startAnimation(rotate);



    }



    private void OnGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("Yes", new  DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            Location locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (locationGPS != null) {
                double lat = locationGPS.getLatitude();
                double longitud = locationGPS.getLongitude();
                latitude = String.valueOf(lat);
                longitude = String.valueOf(longitud);
               // showLocation.setText("Your Location: " + "\n" + "Latitude: " + latitude + "\n" + "Longitude: " + longitude);
                Log.e("javan",latitude);
                Log.e("javan",longitude);



            } else {
                Toast.makeText(this, "Unable to find location.", Toast.LENGTH_SHORT).show();
            }
        }


    }


}