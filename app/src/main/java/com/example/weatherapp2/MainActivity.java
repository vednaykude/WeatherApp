package com.example.weatherapp2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {
    JSONObject gJson;
    JSONObject gJson2;
    JSONArray hourlyArray;
    JSONObject temp;
    JSONObject windSpeed;
    JSONObject weather;
    String lat;
    String lon;
    String loc;
    TextView t;
    String data;
    String data2 = "";
    EditText e;
    Button b;
    String fin;
    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    String fin1;
    String fin2;
    String fin3;
    String fin4;
    String ttt;
    MainActivity mainActivity;
    int count = 0;
    AsyncTaskDownloader asyncTaskDownloader;
    AsyncTaskDownloader2 asyncTaskDownloader2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t = findViewById(R.id.textViewB);
        e = findViewById(R.id.editTextTextPersonName);
        b = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        mainActivity = this;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asyncTaskDownloader = new AsyncTaskDownloader(mainActivity);
                asyncTaskDownloader2 = new AsyncTaskDownloader2(mainActivity);
                asyncTaskDownloader.execute();
                asyncTaskDownloader2.execute();
            }
        });
    }

}