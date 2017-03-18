package com.example.qudqj_000.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;

public class Main3Activity extends AppCompatActivity {
    Button b1, b2;
    Switch s1;
    DatePicker dp1;
    TimePicker tp1;
    EditText e1, e2, e3;
    TextView t1, t2, t3, t4, t5;
    FrameLayout f1;
    LinearLayout l1, l2;
    TableLayout tb1;
    GridLayout g1, bp1;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        program();
    }

    void program(){
        b1 = (Button)findViewById(R.id.prev);
        b2 = (Button)findViewById(R.id.next);
        s1 = (Switch)findViewById(R.id.start);
        dp1 = (DatePicker)findViewById(R.id.datePicker);
        tp1 = (TimePicker)findViewById(R.id.timePicker);
        e1 = (EditText)findViewById(R.id.adult);
        e2 = (EditText)findViewById(R.id.teenager);
        e3 = (EditText)findViewById(R.id.children);
        t1 = (TextView)findViewById(R.id.dates);
        t2 = (TextView)findViewById(R.id.time);
        t3 = (TextView)findViewById(R.id.adultR);
        t4 = (TextView)findViewById(R.id.teenagerR);
        t5 = (TextView)findViewById(R.id.childrenR);
        f1 = (FrameLayout)findViewById(R.id.whole_page);
        l1 = (LinearLayout)findViewById(R.id.first_page);
        l2 = (LinearLayout)findViewById(R.id.second_page);
        g1 = (GridLayout)findViewById(R.id.third_page);
        tb1 = (TableLayout)findViewById(R.id.forth_page);
        bp1 = (GridLayout)findViewById(R.id.buttonPanel);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                f1.setVisibility(View.VISIBLE);
                bp1.setVisibility(View.VISIBLE);
                b1.setEnabled(false);
            }
        });
    }

    public void OnClick(View v){
        switch (v.getId()){
            case R.id.prev:
                if(index>0){
                    index--;
                }
                pageChange(index);
                break;
            case R.id.next:
                if(index<4){
                    index++;
                }
                pageChange(index);
                break;
        }
    }

    void pageChange(int index){
        if(index ==0){
            l1.setVisibility(View.VISIBLE);
            l2.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            tb1.setVisibility(View.INVISIBLE);
        }
        else if(index ==1){
            l1.setVisibility(View.INVISIBLE);
            l2.setVisibility(View.VISIBLE);
            g1.setVisibility(View.INVISIBLE);
            tb1.setVisibility(View.INVISIBLE);
            b1.setEnabled(true);
        }
        else if(index==2){
            l1.setVisibility(View.INVISIBLE);
            l2.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.VISIBLE);
            tb1.setVisibility(View.INVISIBLE);
            b2.setEnabled(true);
        }
        else if(index==3){
            l1.setVisibility(View.INVISIBLE);
            l2.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            tb1.setVisibility(View.VISIBLE);
            b2.setEnabled(false);
        }
    }
}
