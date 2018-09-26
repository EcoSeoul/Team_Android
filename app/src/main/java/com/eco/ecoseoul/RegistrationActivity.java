package com.eco.ecoseoul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class RegistrationActivity extends AppCompatActivity {

    //UI
    Spinner spinner1;

    //Adapter
    AdapterSpinner adapterSpinner1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //데이터
        List<String> data = new ArrayList<>();
        data.add("우리은행"); data.add("SC제일"); data.add("NH농협"); data.add("IBK기업");

        //UI생성
        spinner1 = (Spinner)findViewById(R.id.card_spinner);

        //Adapter
        adapterSpinner1 = new AdapterSpinner(this, data);

        //Adapter 적용
        spinner1.setAdapter(adapterSpinner1);
    }
}
