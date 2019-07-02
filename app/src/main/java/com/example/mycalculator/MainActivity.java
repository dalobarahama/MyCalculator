package com.example.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private Button[] buttonNumber = new Button[10];
    private Button plusButton, minusButton, divideButton, timesButton, resultButton, clearButton, pointButton;
    private float temporaryValue1, temporaryValue2;
    private boolean plus, minus, divide, times;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.view_text);

        for (int i = 0; i < 10; i++) {
            String buttonNumId = "button_" + i;
            int resId = getResources().getIdentifier(buttonNumId, "id", getPackageName());
            buttonNumber[i] = findViewById(resId);
            buttonNumber[i].setOnClickListener(this);
        }

        plusButton = findViewById(R.id.button_plus);
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temporaryValue1 = Float.parseFloat(textView.getText() + "");
                plus = true;
                textView.setText(null);
            }
        });

        minusButton = findViewById(R.id.button_minus);
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temporaryValue1 = Float.parseFloat(textView.getText() + "");
                minus = true;
                textView.setText(null);
            }
        });

        divideButton = findViewById(R.id.button_divide);
        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temporaryValue1 = Float.parseFloat(textView.getText() + "");
                divide = true;
                textView.setText(null);
            }
        });

        timesButton = findViewById(R.id.button_time);
        timesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temporaryValue1 = Float.parseFloat(textView.getText() + "");
                times = true;
                textView.setText(null);
            }
        });

        resultButton = findViewById(R.id.button_result);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temporaryValue2 = Float.parseFloat(textView.getText() + "");

                if (plus) {
                    textView.setText(temporaryValue1 + temporaryValue2 + "");
                    plus = false;
                }

                if (minus) {
                    textView.setText(temporaryValue1 - temporaryValue2 + "");
                    minus = false;
                }

                if (divide) {
                    textView.setText(temporaryValue1 / temporaryValue2 + "");
                    divide = false;
                }

                if (times) {
                    textView.setText(temporaryValue1 * temporaryValue2 + "");
                    times = false;
                }
            }
        });

        clearButton = findViewById(R.id.button_clearText);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
            }
        });

        pointButton = findViewById(R.id.button_point);
        pointButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(textView.getText() + ".");
            }
        });
    }

    @Override
    public void onClick(View view) {
        for (int i = 0; i < 10; i++) {
            if (((Button) view).getText().toString().equals(((buttonNumber[i]).getText().toString()))) {
//                Toast.makeText(this, "Button " + i, Toast.LENGTH_LONG).show();
                textView.setText(textView.getText() + buttonNumber[i].getText().toString());
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putFloat("temporaryValue1", temporaryValue1);
        outState.putFloat("temporaryValue2", temporaryValue2);
        outState.putBoolean("plus", plus);
        outState.putBoolean("minus", minus);
        outState.putBoolean("times", times);
        outState.putBoolean("divide", divide);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        temporaryValue1 = savedInstanceState.getFloat("temporaryValue1");
        temporaryValue2 = savedInstanceState.getFloat("temporaryValue2");
        plus = savedInstanceState.getBoolean("plus");
        minus = savedInstanceState.getBoolean("minus");
        times = savedInstanceState.getBoolean("times");
        divide = savedInstanceState.getBoolean("divide");
    }
}
