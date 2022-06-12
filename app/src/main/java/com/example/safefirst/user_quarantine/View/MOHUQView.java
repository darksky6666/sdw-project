package com.example.safefirst.user_quarantine.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.user_quarantine.Controller.MOHViewSelfTestResult;
import com.example.safefirst.user_quarantine.Controller.MOHViewUserQuarantine;

public class MOHUQView extends AppCompatActivity {

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
                Intent intent = new Intent(MOHUQView.this, MOHViewSelfTestResult.class);
                startActivity(intent);
            }
        });

        quarantineRecord = findViewById(R.id.button7);
        quarantineRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MOHUQView.this, MOHViewUserQuarantine.class);
                startActivity(intent);
            }
        });
    }
}
