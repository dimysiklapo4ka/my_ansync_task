package com.example.d1mys1klapo4ka.gsonfromjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    MyAnsiTask getJsonMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getJsonMap = (MyAnsiTask) new MyAnsiTask().execute();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:

                String s = getJsonMap.stringJson();

                JSONObject dataJsonObj = null;
                String secondName = "";

                try {
                    dataJsonObj = new JSONObject(s);
                    JSONArray friends = dataJsonObj.getJSONArray("agencies");

                    // 1. достаем инфо о втором друге - индекс 1
                    JSONObject secondFriend = friends.getJSONObject(1);
                    secondName = secondFriend.getString("name");


                    // 2. перебираем и выводим контакты каждого друга
                    for (int i = 0; i < friends.length(); i++) {
                        JSONObject friend = friends.getJSONObject(i);

 //                       JSONObject contacts = friend.getJSONObject("contacts");

                        String phone = friend.getString("id");
                        String email = friend.getString("name");
                        String skype = friend.getString("price");

                        Log.d("id@@@", "id: "+ i +" : "+ phone);
                        Log.d("name@@@", "email: " + i +" : " + email);
                        Log.d("price@@@", "skype: " + i +" : " + skype);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                Log.d("@@", secondName);

                break;
        }
    }
}
