package com.example.d1mys1klapo4ka.gsonfromjson;

import android.os.AsyncTask;
import android.util.Log;

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
 * Created by d1mys1klapo4ka on 06.06.2017.
 */

public class MyAnsiTask extends AsyncTask<Void,Void,String> {

    private ArrayList<String> nameAgency = new ArrayList<>();
    private ArrayList<String> priceAgency;
    private ArrayList<String> phoneAgency;
    private ArrayList<String> addressAgency;
    private ArrayList<String> schrduleAgency;
    private ArrayList<String> latitudeAgency;
    private ArrayList<String> longitudeAgency;
    private ArrayList<String> requisitesAgency;
    private ArrayList<String> creditCardAgency;

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
        Log.d(MY_TAG, resultJson);

        return resultJson;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Log.d("@@@@", s);

        JSONObject dataJsonObj = null;

        try {
            dataJsonObj = new JSONObject(s);
            JSONArray agencies = dataJsonObj.getJSONArray("agencies");

            // 2. перебираем и выводим необходимые данные
            for (int i = 0; i < agencies.length(); i++) {
                JSONObject agent = agencies.getJSONObject(i);

                nameAgency.add(agent.getString("name"));
                Log.d("@@@@", nameAgency.get(i));
//                priceAgency.add(agent.getString("price"));
//                phoneAgency.add(agent.getString("phone"));
//                addressAgency.add(agent.getString("address"));
//                schrduleAgency.add(agent.getString("schrdule"));
//                latitudeAgency.add(agent.getString("latitude"));
//                longitudeAgency.add(agent.getString("longitude"));
//                requisitesAgency.add(agent.getString("requisites"));
//                creditCardAgency.add(agent.getString("credit_card"));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getNameAgencies(){
        return nameAgency;
    }

    //        price
    public ArrayList<String> getPriceAgencies() {
        return priceAgency;
    }

    //        phone
    public ArrayList<String> getPhoneAgencies() {
        return phoneAgency;
    }

    //        address
    public ArrayList<String> getAddressAgencies() {
        return addressAgency;
    }

    //        schrdule
    public ArrayList<String> getSchrduleAgencies() {
        return schrduleAgency;
    }

    //        latitude
    public ArrayList<String> getLatitudeAgencies() {
        return latitudeAgency;
    }

    //        longitude
    public ArrayList<String> getLongitudeAgencies() {
        return longitudeAgency;
    }

    //        requisites
    public ArrayList<String> getRequisitesAgencies() {
        return requisitesAgency;
    }

    //        credit_card
    public ArrayList<String> getCreditCardAgencies() {
        return creditCardAgency;
    }
}

