package com.example.safefirst.userquarantine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.userquarantine.Controller.MOHViewSelfTestResult;
import com.example.safefirst.userquarantine.Controller.MOHViewUserQuarantine;

public class MOHView extends AppCompatActivity {

    Button selfTest;
    Button quarantineRecord;
    Button healthAssessment;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moh_main);

        selfTest = findViewById(R.id.button6);
        selfTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MOHView.this, MOHViewSelfTestResult.class);
                startActivity(intent);
            }
        });

        quarantineRecord = findViewById(R.id.button7);
        quarantineRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MOHView.this, MOHViewUserQuarantine.class);
                startActivity(intent);
            }
        });
    }
}
