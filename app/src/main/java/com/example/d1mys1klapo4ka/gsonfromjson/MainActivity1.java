package com.example.d1mys1klapo4ka.gsonfromjson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by d1mys1klapo4ka on 07.06.2017.
 */

    public class MainActivity1 extends AppCompatActivity implements View.OnClickListener{


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button:


                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            makeRequest();
                        }
                    }).start();


                    break;
            }
        }

        private void makeRequest(){

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

                ArrayList<String> mResultArray = parseRequest(resultJson);

                for (int i = 0; i < mResultArray.size(); i++) {

                    Log.e("###", "makeRequest:result array "+ mResultArray.get(i));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        private ArrayList<String> parseRequest(String json){

            ArrayList<String> priceAgency = new ArrayList<>();

            Log.e("###", "parseRequest:json "+json );

            try {

                JSONObject dataJsonObj = new JSONObject(json);
                JSONArray agencies = dataJsonObj.getJSONArray("agencies");

// 2. перебираем и выводим необходимые данные
                for (int i = 0; i < agencies.length(); i++) {
                    JSONObject agent = agencies.getJSONObject(i);
                    priceAgency.add(agent.getString("price"));
// phoneAgency.add(agent.getString("phone"));
// addressAgency.add(agent.getString("address"));
// schrduleAgency.add(agent.getString("schrdule"));
// latitudeAgency.add(agent.getString("latitude"));
// longitudeAgency.add(agent.getString("longitude"));
// requisitesAgency.add(agent.getString("requisites"));
// creditCardAgency.add(agent.getString("credit_card"));
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return priceAgency;
        }

    }
