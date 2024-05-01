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

        switch (view.getId()) {
            case R.id.all_clear_btn:
                inFirstInput = true;
                resultNumber = 0;
                operator = '+';
                resultText.setTextColor(0xFF000000);
                resultText.setText(String.valueOf(resultNumber));
                break;

            case R.id.num_0_btn:
            case R.id.num_1_btn:
            case R.id.num_2_btn:
            case R.id.num_3_btn:
            case R.id.num_4_btn:
            case R.id.num_5_btn:
            case R.id.num_6_btn:
            case R.id.num_7_btn:
            case R.id.num_8_btn:
            case R.id.num_9_btn:
                if (inFirstInput) {
                    resultText.setTextColor(0xFF000000);
                    resultText.setText(getButton.getText().toString());
                    inFirstInput = false;
                } else {
                    resultText.append(getButton.getText().toString());
                }
                break;

            default:
                Toast.makeText(getApplicationContext(),getButton.getText().toString() + "버튼이 클릭되었습니다.", Toast.LENGTH_LONG).show();
                break;
        }

//        if (view.getId() == R.id.all_clear_btn) {
//            inFirstInput = true;
//            resultNumber = 0;
//            operator = '+';
//            resultText.setTextColor(0xFF000000);
//            resultText.setText(String.valueOf(resultNumber));
//        }
//
//
//        if (view.getId() == R.id.num_0_btn
//                || view.getId() == R.id.num_1_btn
//                || view.getId() == R.id.num_2_btn
//                || view.getId() == R.id.num_3_btn
//                || view.getId() == R.id.num_4_btn
//                || view.getId() == R.id.num_5_btn
//                || view.getId() == R.id.num_6_btn
//                || view.getId() == R.id.num_7_btn
//                || view.getId() == R.id.num_8_btn
//                || view.getId() == R.id.num_9_btn) {
//
//            if (inFirstInput) {
//                resultText.setTextColor(0xFF000000);
//                resultText.setText(getButton.getText().toString());
//                inFirstInput = false;
//            } else {
//                resultText.append(getButton.getText().toString());
//            }
//        }

    }
}
