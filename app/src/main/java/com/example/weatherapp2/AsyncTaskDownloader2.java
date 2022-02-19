package com.example.weatherapp2;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AsyncTaskDownloader2 extends AsyncTask<String, Void, String> {
    private final MainActivity mainActivity;
    private JSONArray jsonWeather;

    public AsyncTaskDownloader2(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            mainActivity.data2 = "";
            URL myUrl = new URL("https://api.openweathermap.org/data/2.5/onecall?lat=" + mainActivity.lat + "&lon=" + mainActivity.lon + "&units=imperial&exclude=minutely,daily&appid=" + "insert API Key here");
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
            connection.connect();
            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String inputLine = "";
            while (inputLine != null) {
                inputLine = br.readLine();
                stringBuilder.append(inputLine);
            }
            br.close();
            inputStreamReader.close();
            mainActivity.data2 = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            mainActivity.data2 = null;
        }
        return mainActivity.data2;
    }

    @Override
    protected void onPostExecute(String s) {
        mainActivity.fin = "";
        try {
            mainActivity.fin = "";
            mainActivity.gJson2 = new JSONObject(s);
            mainActivity.hourlyArray = mainActivity.gJson2.getJSONArray("hourly");
            jsonWeather = mainActivity.hourlyArray;
            mainActivity.fin += "Location: " + mainActivity.loc + "\n";
            mainActivity.fin += "Latitude: " + mainActivity.lat + ", " + "Longitude: " + mainActivity.lon + "\n";
            mainActivity.ttt = mainActivity.fin;
            for (int i = 0; i <= 3; i++) {
                mainActivity.fin = "";
                long unix = Integer.parseInt(mainActivity.hourlyArray.getJSONObject(i).getString("dt"));
                SimpleDateFormat sdf = new SimpleDateFormat("h:mm a");
                Date date = new Date(unix * 1000L);
                sdf.setTimeZone(java.util.TimeZone.getTimeZone("EST"));
                String time = sdf.format(date);
                mainActivity.fin += "Time: " + time + "\n";
                String temp = mainActivity.hourlyArray.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("icon");
                if (i == 0) {
                    mainActivity.fin += "Temperature: " + mainActivity.hourlyArray.getJSONObject(i).getString("temp") + "°F" + "\n";
                    mainActivity.fin += "Weather: " + mainActivity.hourlyArray.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description");
                    mainActivity.fin1 = mainActivity.fin;
                    if (temp.equals("01d") || temp.equals("01n"))
                        mainActivity.imageView.setImageResource(R.drawable.one);
                    if (temp.equals("02d") || temp.equals("02n"))
                        mainActivity.imageView.setImageResource(R.drawable.two);
                    if (temp.equals("03d") || temp.equals("04d") || temp.equals("03n") || temp.equals("04n"))
                        mainActivity.imageView.setImageResource(R.drawable.three);
                    if (temp.equals("10d") || temp.equals("10n") || temp.equals("09d") || temp.equals("09n"))
                        mainActivity.imageView.setImageResource(R.drawable.four);
                    if (temp.equals("13d") || temp.equals("13n"))
                        mainActivity.imageView.setImageResource(R.drawable.five);

                }
                if (i == 1) {
                    mainActivity.fin += "Temperature: " + mainActivity.hourlyArray.getJSONObject(i).getString("temp") + "°F" + "\n";
                    mainActivity.fin += "Weather: " + mainActivity.hourlyArray.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description");
                    mainActivity.fin2 = mainActivity.fin;
                    if (temp.equals("01d") || temp.equals("01n"))
                        mainActivity.imageView2.setImageResource(R.drawable.one);
                    if (temp.equals("02d") || temp.equals("02n"))
                        mainActivity.imageView2.setImageResource(R.drawable.two);
                    if (temp.equals("03d") || temp.equals("04d") || temp.equals("03n") || temp.equals("04n"))
                        mainActivity.imageView2.setImageResource(R.drawable.three);
                    if (temp.equals("10d") || temp.equals("10n") || temp.equals("09d") || temp.equals("09n"))
                        mainActivity.imageView2.setImageResource(R.drawable.four);
                    if (temp.equals("13d") || temp.equals("13n"))
                        mainActivity.imageView2.setImageResource(R.drawable.five);
                }
                if (i == 2) {
                    mainActivity.fin += "Temperature: " + mainActivity.hourlyArray.getJSONObject(i).getString("temp") + "°F" + "\n";
                    mainActivity.fin += "Weather: " + mainActivity.hourlyArray.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description");
                    mainActivity.fin3 = mainActivity.fin;
                    if (temp.equals("01d") || temp.equals("01n"))
                        mainActivity.imageView3.setImageResource(R.drawable.one);
                    if (temp.equals("02d") || temp.equals("02n"))
                        mainActivity.imageView3.setImageResource(R.drawable.two);
                    if (temp.equals("03d") || temp.equals("04d") || temp.equals("03n") || temp.equals("04n"))
                        mainActivity.imageView3.setImageResource(R.drawable.three);
                    if (temp.equals("10d") || temp.equals("10n") || temp.equals("09d") || temp.equals("09n"))
                        mainActivity.imageView3.setImageResource(R.drawable.four);
                    if (temp.equals("13d") || temp.equals("13n"))
                        mainActivity.imageView3.setImageResource(R.drawable.five);
                }
                if (i == 3) {
                    mainActivity.fin += "Temperature: " + mainActivity.hourlyArray.getJSONObject(i).getString("temp") + "°F" + "\n";
                    mainActivity.fin += "Weather: " + mainActivity.hourlyArray.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("description");
                    mainActivity.fin4 = mainActivity.fin;
                    if (temp.equals("01d") || temp.equals("01n"))
                        mainActivity.imageView4.setImageResource(R.drawable.one);
                    if (temp.equals("02d") || temp.equals("02n"))
                        mainActivity.imageView4.setImageResource(R.drawable.two);
                    if (temp.equals("03d") || temp.equals("04d") || temp.equals("03n") || temp.equals("04n"))
                        mainActivity.imageView4.setImageResource(R.drawable.three);
                    if (temp.equals("10d") || temp.equals("10n") || temp.equals("09d") || temp.equals("09n"))
                        mainActivity.imageView4.setImageResource(R.drawable.four);
                    if (temp.equals("13d") || temp.equals("13n"))
                        mainActivity.imageView4.setImageResource(R.drawable.five);
                }
                mainActivity.fin = "";
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mainActivity.t.setText(mainActivity.ttt);
        mainActivity.t1.setText(mainActivity.fin1);
        mainActivity.t2.setText(mainActivity.fin2);
        mainActivity.t3.setText(mainActivity.fin3);
        mainActivity.t4.setText(mainActivity.fin4);
    }
}
