package com.example.d1mys1klapo4ka.gsonfromjson;

import android.os.Looper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by dev on 07.06.17.
 */

public class ServerUtils {

    private OnLoadComplite onLoadComplite;


    public void setOnLoadComplite(OnLoadComplite onLoadComplite) {
        this.onLoadComplite = onLoadComplite;
    }


    public void addNewAgency(final String mName){
        new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    URL url = new URL("http://server.gojob.com.ua/api/v1/agencies?agency[name]="+mName+"&"+"agency[price]="+mName+"&"+"agency[phone]="+mName+"&"+"agency[address]="+mName+"&"+"agency[schrdule]="+mName+"&"+"agency[latitude]="+mName+"&");

                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.setReadTimeout(5000);
                    urlConnection.connect();

                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuilder buffer = new StringBuilder();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }

//                    resultJson = buffer.toString();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();


    }

    public void getAllData(){
        new Thread(new Runnable() {
            @Override
            public void run() {


                try {
                    URL url = new URL("http://server.gojob.com.ua/api/v1/agencies");

                    HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(5000);
                    urlConnection.setReadTimeout(5000);
                    urlConnection.connect();

                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuilder buffer = new StringBuilder();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }

                    String resultJson = buffer.toString();
                    onLoadComplite.onLoadComplite(resultJson);

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }

}
