package com.example.safefirst.userquarantine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.userquarantine.Controller.AddHealthAssessment;
import com.example.safefirst.userquarantine.Controller.AddQuarantineRecord;
import com.example.safefirst.userquarantine.Controller.AddSelfTestResult;
import com.example.safefirst.userquarantine.Controller.ViewQuarantineRecord;

public class UserView extends AppCompatActivity {

    ImageView addHealthAssessment;
    ImageView addSelfTestResult;
    ImageView addQuarantineRecord;
    ImageView viewQuarantineRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);

        addHealthAssessment = findViewById(R.id.imageView7);
        addHealthAssessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserView.this, AddHealthAssessment.class);
                startActivity(intent);
            }
        });

        addSelfTestResult = findViewById(R.id.imageView3);
        addSelfTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserView.this, AddSelfTestResult.class);
                startActivity(intent);
            }
        });

        addQuarantineRecord = findViewById(R.id.imageView4);
        addQuarantineRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserView.this, AddQuarantineRecord.class);
                startActivity(intent);
            }
        });

        viewQuarantineRecord = findViewById(R.id.imageView6);
        viewQuarantineRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserView.this, ViewQuarantineRecord.class);
                startActivity(intent);
            }
        });

    }
}