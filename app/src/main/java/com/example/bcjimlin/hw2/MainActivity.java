package com.example.bcjimlin.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //private RadioGroup radioGroup;
    private RadioButton button2;
    private RadioButton button3;
    private RadioButton button4;
    Button start;
    Button clear;
    EditText n1;
    EditText n2;
    EditText n3;
    EditText n4;
    TextView gcd;
    TextView lcm;
    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Initial*/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        button2 = findViewById(R.id.radioButton2);
        button2.setText("2");
        button3 = findViewById(R.id.radioButton3);
        button3.setText("3");
        button4 = findViewById(R.id.radioButton4);
        button4.setText("4");

        start = findViewById(R.id.button0);
        clear = findViewById(R.id.button1);

        n1.setEnabled(false);
        n2.setEnabled(false);
        n3.setEnabled(false);
        n4.setEnabled(false);

        /*button listener*/
        button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 2;
                n1.setEnabled(true);
                n2.setEnabled(true);
            }
        });
        button3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 3;
                n1.setEnabled(true);
                n2.setEnabled(true);
                n3.setEnabled(true);
            }
        });
        button4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = 4;
                n1.setEnabled(true);
                n2.setEnabled(true);
                n3.setEnabled(true);
                n4.setEnabled(true);
            }
        });

        /*Start to calculate*/
        start.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                int int_n1;
                int int_n2;
                int int_n3;
                int int_n4;
                //int[] array = new int[] {int_n1, int_n2, int_n3, int_n4};
                //for(int i=0; i<array.length-1; i++)
                //dogcd(array);
                switch(flag){
                    case 2:
                        int_n1 = Integer.parseInt(n1.getText().toString());
                        int_n2 = Integer.parseInt(n2.getText().toString());
                        gcd.setText(String.valueOf(gcd(int_n1,int_n2)));
                        lcm.setText(String.valueOf(lcm(int_n1,int_n2)));
                        break;
                    case 3:
                        int_n1 = Integer.parseInt(n1.getText().toString());
                        int_n2 = Integer.parseInt(n2.getText().toString());
                        int_n3 = Integer.parseInt(n3.getText().toString());
                        gcd.setText(String.valueOf(gcd(gcd(int_n1,int_n2),int_n3)));
                        lcm.setText(String.valueOf(lcm(lcm(int_n1,int_n2),int_n3)));
                        break;
                    case 4:
                        int_n1 = Integer.parseInt(n1.getText().toString());
                        int_n2 = Integer.parseInt(n2.getText().toString());
                        int_n3 = Integer.parseInt(n3.getText().toString());
                        int_n4 = Integer.parseInt(n4.getText().toString());
                        gcd.setText(String.valueOf(gcd(gcd(gcd(int_n1,int_n2),int_n3),int_n4)));
                        lcm.setText(String.valueOf(lcm(lcm(lcm(int_n1,int_n2),int_n3),int_n4)));
                        break;
                }


                //gcd.setText(String.valueOf(gcd_ans));
                //lcm.setText(String.valueOf(int_n1*int_n2*int_n3*int_n4/gcd_ans/gcd_ans/gcd_ans));
            }
        });
        clear.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                n1.setText("");n2.setText("");n3.setText("");n4.setText("");
                gcd.setText("");lcm.setText("");
            }
        });

    }
    private void findViews() { // EditText are the numbers in char typing by user
        n1 = (EditText)findViewById(R.id.editText1);
        n2 = (EditText)findViewById(R.id.editText2);
        n3 = (EditText)findViewById(R.id.editText3);
        n4 = (EditText)findViewById(R.id.editText4);

        gcd = (TextView)findViewById(R.id.textView16);
        lcm = (TextView)findViewById(R.id.textView17);

    }
    public int gcd(int m, int n) {
        while(n != 0) {
            int r = m % n;
            m = n;
            n = r;
        }
        return m;
    }

    public int lcm(int m, int n) {
        return m * n / gcd(m, n);
    }
    /*public static int gcd(int m, int n){
        int result = 1;
        while(m%n!=0){
            result=n;
            n=m%n;
            m=result;
        }
        result=n;
        return result;
    }
    public static int dogcd(int[] input){
        for(int i=0;i<input.length-1;i++){
            input[i+1] = gcd(input[i],input[i+1]);
        }
        return input[input.length-1];
    }*/
}
