package com.example.d1mys1klapo4ka.gsonfromjson;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by dev on 07.06.17.
 */

public class ParsedJsonUtils implements OnLoadComplite{

    private static ParsedJsonUtils parsedJsonUtils;
    private ArrayList<String> nameAgency;
    private ArrayList<String> priceAgency;
    private ArrayList<String> phoneAgency;
    private ArrayList<String> addressAgency;
    private ArrayList<String> schrduleAgency;
    private ArrayList<String> latitudeAgency;
    private ArrayList<String> longitudeAgency;
    private ArrayList<String> requisitesAgency;
    private ArrayList<String> creditCardAgency;

    private static Context mContext;

    private ParsedJsonUtils(){
        nameAgency = new ArrayList<>();
        priceAgency = new ArrayList<>();
        phoneAgency = new ArrayList<>();
        addressAgency = new ArrayList<>();
        schrduleAgency = new ArrayList<>();
        latitudeAgency = new ArrayList<>();
        longitudeAgency = new ArrayList<>();
        requisitesAgency = new ArrayList<>();
        creditCardAgency = new ArrayList<>();
        ServerUtils myAsyncTask  = new ServerUtils();
        myAsyncTask.setOnLoadComplite(this);
        myAsyncTask.getAllData();

    }

    public static ParsedJsonUtils getInstance(Context context) {
        if (parsedJsonUtils == null){
            parsedJsonUtils = new ParsedJsonUtils();
        }
        mContext = context;
        return parsedJsonUtils;
    }


    @Override
    public void onLoadComplite(final String json) {

        ((MainActivity)mContext).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (json.isEmpty()){

                    Toast.makeText(mContext, "Load data error", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(mContext, "Data were load seccessfuly", Toast.LENGTH_SHORT).show();



                JSONObject dataJsonObj = null;

                try {
                    dataJsonObj = new JSONObject(json);
                    JSONArray agencies = dataJsonObj.getJSONArray("agencies");

                    // 2. перебираем и выводим необходимые данные
                    for (int i = 0; i < agencies.length(); i++) {
                        JSONObject agent = agencies.getJSONObject(i);

                        nameAgency.add(agent.getString("name"));
                        priceAgency.add(agent.getString("price"));
                        phoneAgency.add(agent.getString("phone"));
                        addressAgency.add(agent.getString("address"));
                        schrduleAgency.add(agent.getString("schrdule"));
                        latitudeAgency.add(agent.getString("latitude"));
                        longitudeAgency.add(agent.getString("longitude"));
                        requisitesAgency.add(agent.getString("requisites"));
                        creditCardAgency.add(agent.getString("credit_card"));
                    }
                    Log.e("###", "onLoadComplite: "+nameAgency.size());

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });




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
