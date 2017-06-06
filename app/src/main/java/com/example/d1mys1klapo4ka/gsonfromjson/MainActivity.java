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
        switch (v.getId()){
            case R.id.button:


                MyAnsiTask myAnsiTask = (MyAnsiTask) new MyAnsiTask().execute();
                ArrayList<String> name = myAnsiTask.getNameAgencies();

                Log.d("@@@", name.get(0));

                break;
        }
    }
}
