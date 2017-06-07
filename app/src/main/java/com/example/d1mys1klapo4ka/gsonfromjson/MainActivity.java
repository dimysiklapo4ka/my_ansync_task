package com.example.d1mys1klapo4ka.gsonfromjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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

                ParsedJsonUtils.getInstance(this);

                break;
            case R.id.button2:
                try {
                    Toast.makeText(this, ParsedJsonUtils.getInstance(this).getNameAgencies().get(1), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(this, ParsedJsonUtils.getInstance(this).getCreditCardAgencies().get(1), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(this, ParsedJsonUtils.getInstance(this).getPhoneAgencies().get(1), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(this, ParsedJsonUtils.getInstance(this).getSchrduleAgencies().get(1), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(this, ParsedJsonUtils.getInstance(this).getLatitudeAgencies().get(1), Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }

                break;
        }
    }
}
