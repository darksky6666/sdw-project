package com.example.safefirst.user_quarantine.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.user_quarantine.Controller.AddQuarantineRecord;
import com.example.safefirst.user_quarantine.Controller.AddSelfTestResult;
import com.example.safefirst.user_quarantine.Controller.ViewQuarantineRecord;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserUQView extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    ImageView addSelfTestResult;
    ImageView addQuarantineRecord;
    ImageView viewQuarantineRecord;

    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        addSelfTestResult = findViewById(R.id.imageView3);
        addSelfTestResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserUQView.this, AddSelfTestResult.class);
                startActivity(intent);
            }
        });

        addQuarantineRecord = findViewById(R.id.imageView4);
        addQuarantineRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserUQView.this, AddQuarantineRecord.class);
                startActivity(intent);
            }
        });

        viewQuarantineRecord = findViewById(R.id.imageView6);
        viewQuarantineRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserUQView.this, ViewQuarantineRecord.class);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.bottom_home:
                return true;

            case R.id.bottom_notifications:
                return true;

            case R.id.bottom_qrscan:
                return true;

            case R.id.bottom_profile:
                return true;
        }

        return false;
    }
}