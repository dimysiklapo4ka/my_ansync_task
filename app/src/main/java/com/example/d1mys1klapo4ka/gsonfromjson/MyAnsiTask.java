package com.example.d1mys1klapo4ka.gsonfromjson;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by d1mys1klapo4ka on 06.06.2017.
 */

public class MyAnsiTask extends AsyncTask<Void,Void,String> {

    public static final String MY_TAG = "####";

    private String resultJson = "";

    @Override
    protected String doInBackground(Void... params) {
        // получаем данные с внешнего ресурса
        try {
            URL url = new URL("http://server.gojob.com.ua/api/v1/agencies");

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJson = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(MY_TAG,resultJson);
        return resultJson;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }

    public String stringJson(){
        return resultJson;
    }

}
