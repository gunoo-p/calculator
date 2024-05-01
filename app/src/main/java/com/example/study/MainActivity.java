package com.example.study;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        if (view.getId() == R.id.all_clear_btn) {
            inFirstInput = true;
            resultNumber = 0;
            operator = '+';
            resultText.setTextColor(0xFF000000);
            resultText.setText(String.valueOf(resultNumber));
        }


        Button getButton = findViewById(view.getId());


        if (view.getId() >= R.id.num_0_btn && view.getId() <= R.id.num_9_btn) {
            if (inFirstInput) {
                resultText.setTextColor(0xFF000000);
                resultText.setText(getButton.getText().toString());
                inFirstInput = false;
            } else {
                resultText.append(getButton.getText().toString());
            }

        } else if (view.getId() == R.id.num_2_btn) {
            if (inFirstInput) {
                resultText.setTextColor(0xFF000000);
                resultText.setText(getButton.getText().toString());
                inFirstInput = false;
            } else {
                resultText.append(getButton.getText().toString());
            }
        }
    }
}
