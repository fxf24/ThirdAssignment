package com.example.qudqj_000.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void ChooseProblem(View v){
        switch(v.getId()){
            case R.id.first:
                intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.second:

                break;
        }
    }
}
