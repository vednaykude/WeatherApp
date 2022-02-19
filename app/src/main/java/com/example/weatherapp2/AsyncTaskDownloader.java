package com.example.weatherapp2;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AsyncTaskDownloader extends AsyncTask<String, Void, String> {
    private final MainActivity mainActivity;

    public AsyncTaskDownloader(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected String doInBackground(String... strings) {
        mainActivity.data = "";
        try {
            mainActivity.data = "";
            String zip = mainActivity.e.getText().toString();
            String country = "us";
            URL myUrl = new URL("https://api.openweathermap.org/geo/1.0/zip?zip=" + zip + "," + country + "&appid=" + "insert API Key here");
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String inputLine = "";
            while (inputLine != null) {
                inputLine = br.readLine();
                stringBuilder.append(inputLine);
            }
            mainActivity.data = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            mainActivity.data = null;
        }
        return mainActivity.data;
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            mainActivity.gJson = new JSONObject(s);
            mainActivity.lat = mainActivity.gJson.getString("lat");
            mainActivity.lon = mainActivity.gJson.getString("lon");
            mainActivity.loc = mainActivity.gJson.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
