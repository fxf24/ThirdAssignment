package com.example.qudqj_000.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2, e3;
    Button b1, b2;
    TextView t1, t2;
    ImageView i1;
    int kor, math, eng, total, average;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("학점 계산기");
        program();
    }

    public void onClickButton(View v){
        switch (v.getId()){
            case R.id.gradeCalc:
                calculate();
                setImage(average);
                break;
            case R.id.reset:
                reset();
                break;

        }
    }

    void program() {
        e1 = (EditText)findViewById(R.id.kor);
        e2 = (EditText)findViewById(R.id.math);
        e3 = (EditText)findViewById(R.id.eng);
        b1 = (Button)findViewById(R.id.gradeCalc);
        b2 = (Button)findViewById(R.id.reset);
        t1 = (TextView)findViewById(R.id.totalscore);
        t2 = (TextView)findViewById(R.id.average);
        i1 = (ImageView)findViewById(R.id.grade);

    }

    void calculate(){
        if(e1.getText().toString().equals(null)||
                e2.getText().toString().equals(null)||
                e3.getText().toString().equals(null)||
                e1.getText().toString().equals("")||
                e2.getText().toString().equals("")||
                e3.getText().toString().equals("")){
            total = 0;
            average = 0;
        }
        else{
            String korg = e1.getText().toString();
            String mathg = e2.getText().toString();
            String engg = e3.getText().toString();

            kor = Integer.parseInt(korg);
            math = Integer.parseInt(mathg);
            eng = Integer.parseInt(engg);

            total = kor + math + eng;
            average = (kor + math + eng)/3;
        }

        t1.setText(total + "점");
        t2.setText(average + "점");
    }

    void setImage(int average){
        if(average>=90){
            i1.setImageResource(R.drawable.letter_a_red);
        }
        else if(average>=80){
            i1.setImageResource(R.drawable.letter_b_red);
        }
        else if(average>=70){
            i1.setImageResource(R.drawable.letter_c_red);
        }
        else if(average>=60){
            i1.setImageResource(R.drawable.letter_d_red);
        }
        else{
            i1.setImageResource(R.drawable.letter_f_red);
        }

    }
    void reset(){
        e1.setText("");
        e2.setText("");
        e3.setText("");
        t1.setText("0점");
        t2.setText("0점");
        i1.setImageResource(0);

        Toast.makeText(this, "초기화 되었습니다.", Toast.LENGTH_SHORT).show();
    }
}
