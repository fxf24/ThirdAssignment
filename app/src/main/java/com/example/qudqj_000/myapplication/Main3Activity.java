package com.example.qudqj_000.myapplication;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
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
    TextView t1, t2, t3, t4, t5, rt;
    FrameLayout f1;
    LinearLayout l1, l2;
    TableLayout tb1;
    GridLayout g1, bp1;
    Chronometer ch1;
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
        rt = (TextView)findViewById(R.id.reservation_time_text);
        f1 = (FrameLayout)findViewById(R.id.whole_page);
        l1 = (LinearLayout)findViewById(R.id.first_page);
        l2 = (LinearLayout)findViewById(R.id.second_page);
        g1 = (GridLayout)findViewById(R.id.third_page);
        tb1 = (TableLayout)findViewById(R.id.forth_page);
        bp1 = (GridLayout)findViewById(R.id.buttonPanel);
        ch1 = (Chronometer)findViewById(R.id.chronometer);

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked==true) {
                    f1.setVisibility(View.VISIBLE);
                    bp1.setVisibility(View.VISIBLE);
                    rt.setVisibility(View.VISIBLE);
                    ch1.setVisibility(View.VISIBLE);
                    l1.setVisibility(View.VISIBLE);
                    tb1.setVisibility(View.INVISIBLE);
                    ch1.setBase(SystemClock.elapsedRealtime());
                    ch1.start();
                    b1.setEnabled(false);
                    b2.setEnabled(true);
                    index = 0;
                }
                else{
                    f1.setVisibility(View.INVISIBLE);
                    bp1.setVisibility(View.INVISIBLE);
                    rt.setVisibility(View.INVISIBLE);
                    ch1.setVisibility(View.INVISIBLE);
                    ch1.stop();
                    ch1.setBase(SystemClock.elapsedRealtime());
                }
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

    void setForthPage(){
        int month = dp1.getMonth();
        int day = dp1.getDayOfMonth();
        int year = dp1.getYear();
        int hour = tp1.getHour();
        int minutes = tp1.getMinute();

        t1.setText(year + "년 " + month + "월 " + day+"일");
        t2.setText(hour + "시 " + minutes + "분");

        String adult = e1.getText().toString();
        String teenager = e2.getText().toString();
        String children = e3.getText().toString();
        int adn = Integer.parseInt(adult);
        int tgn = Integer.parseInt(teenager);
        int cdn = Integer.parseInt(children);

        t3.setText(adn + "명");
        t4.setText(tgn + "명");
        t5.setText(cdn + "명");
    }

    void pageChange(int index){
        if(index ==0){
            l1.setVisibility(View.VISIBLE);
            l2.setVisibility(View.INVISIBLE);
            g1.setVisibility(View.INVISIBLE);
            tb1.setVisibility(View.INVISIBLE);
            b1.setEnabled(false);
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
            setForthPage();
        }
    }
}
