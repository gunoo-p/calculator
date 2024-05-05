package com.example.study;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    boolean inFirstInput = true;
    int resultNumber = 0;
    char operator = '+';
    final String CLEAR_INPUT_TEXT = "0";
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        resultText = findViewById(R.id.result_text);
    }

    public void buttonClick(View view) {

        Button getButton = findViewById(view.getId());

        if (view.getId() == R.id.all_clear_btn) {
            resultNumber = 0;
            operator = '+';
            setClearText("0");
        }

        if (view.getId() == R.id.CE_btn) {
            setClearText("0");
        }

        if (view.getId() == R.id.BS_btn) {
            if(resultText.getText().toString().length() > 1) {
                String getResultText = resultText.getText().toString();
                String subString = getResultText.substring(0, getResultText.length() -1);
                resultText.setText(subString);
            } else {
                setClearText("0");
            }
        }
    }

    public void numBtnClick(View view) {
        Button getButton = findViewById(view.getId());

        if (inFirstInput) {
            resultText.setTextColor(0xFF000000);
            resultText.setText(getButton.getText().toString());
            inFirstInput = false;
        } else {
            resultText.append(getButton.getText().toString());
        }
    }

    public void setClearText(String clearText) {
        inFirstInput = true;
        resultText.setTextColor(0xFF000000);
        resultText.setText(clearText);
    }

    public int  intCal(int result, int lastNum, char op) {
        if (op == '+') {
            result += lastNum;
        } else if (op == '-') {
            result -= lastNum;
        } else if (op == '/') {
            result /= lastNum;
        } else if (op == '*') {
            result *= lastNum;
        }
        return result;
    }

    public void operatorClick(View view) {
        Button getButton = findViewById(view.getId());

        if(view.getId() == R.id.result_btn) {
            resultNumber = intCal(resultNumber,  Integer.parseInt(resultText.getText().toString()), operator);
            resultText.setText(String.valueOf(resultNumber));
            inFirstInput = true;
        } else {
            int lastNum = Integer.parseInt(resultText.getText().toString());
            resultNumber = intCal(resultNumber,  lastNum, operator);
            operator = getButton.getText().toString().charAt(0);
            resultText.setText(String.valueOf(resultNumber));
            inFirstInput = true;
        }
    }
}
