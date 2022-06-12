package com.example.safefirst.userquarantine.View;

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

public class UserQRView extends AppCompatActivity {

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
                Intent intent = new Intent(UserQRView.this, AddHealthAssessment.class);
                startActivity(intent);
            }
        });

        addSelfTestResult = findViewById(R.id.imageView3);
        addSelfTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserQRView.this, AddSelfTestResult.class);
                startActivity(intent);
            }
        });

        addQuarantineRecord = findViewById(R.id.imageView4);
        addQuarantineRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserQRView.this, AddQuarantineRecord.class);
                startActivity(intent);
            }
        });

        viewQuarantineRecord = findViewById(R.id.imageView6);
        viewQuarantineRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserQRView.this, ViewQuarantineRecord.class);
                startActivity(intent);
            }
        });

    }

    // Get user info
    private String name = "Ali bin Ahmad";
    private String ic = "880104201987";
    private String phone = "0127899954";

    public String getName() {
        return name;
    }

    public String getIc() {
        return ic;
    }

    public String getPhone() {
        return phone;
    }
}