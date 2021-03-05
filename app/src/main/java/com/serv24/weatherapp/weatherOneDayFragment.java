package com.serv24.weatherapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link weatherOneDayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class weatherOneDayFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private Button button;
    private ImageView imageView;
    private Random random = new Random();
    private int lastDirection;
    private String mParam1;
    private String mParam2;
    EditText editText;

    TextView  textView,temptv, time, longitude, latitude, humidity, sunrise, sunset, pressure, wind, country, city_nam, max_temp, min_temp, feels;
    String latitute,longitute;

    public weatherOneDayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment weatherOneDayFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static weatherOneDayFragment newInstance(String param1, String param2) {
        weatherOneDayFragment fragment = new weatherOneDayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        if(getArguments() !=null) {
            latitute = getArguments().getString("lat");
            longitute = getArguments().getString("long");
            Log.e("javan-freag", String.valueOf(latitute));
            Log.e("javan-freg", String.valueOf(longitute));
        }
        else {
            Log.e("javan","zero value ");
        }

        View view = inflater.inflate(R.layout.fragment_weather_one_day, container, false);
        textView= view.findViewById(R.id.textView);

        editText = view.findViewById(R.id.editTextTextPersonName);

        button = view.findViewById(R.id.button);
        imageView = view.findViewById(R.id.imageView);

        temptv = view.findViewById(R.id.textView3);
        time = view.findViewById(R.id.textView2);
        longitude = view.findViewById(R.id.longitude);
        latitude = view.findViewById(R.id.latitude);
        humidity = view.findViewById(R.id.humidity);
        sunrise = view.findViewById(R.id.sunrise);
        sunset = view.findViewById(R.id.sunset);
        pressure = view.findViewById(R.id.pressure);
        wind = view.findViewById(R.id.wind);
        country =view. findViewById(R.id.country);
        city_nam = view.findViewById(R.id.city_nam);
        max_temp = view.findViewById(R.id.temp_max);
        min_temp = view.findViewById(R.id.min_temp);
        feels = view.findViewById(R.id.feels);









        return inflater.inflate(R.layout.fragment_weather_one_day, container, false);
    }





    }



