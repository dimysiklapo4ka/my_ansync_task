package com.example.d1mys1klapo4ka.gsonfromjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {

        MyAnsiTask myAnsiTask = new MyAnsiTask();

        switch (v.getId()){
            case R.id.button:

                myAnsiTask.execute();

                break;
            case R.id.button2:
                try {
                    ArrayList<String> name = myAnsiTask.getNameAgencies();

                    Log.e("@@@", name.get(1));
                }catch (Exception e){
                    e.printStackTrace();
                }

                break;
        }
    }
}
