package com.example.safefirst.user_quarantine.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;

public class MainActivity extends AppCompatActivity {

    Button goToUserView;
    Button goToMOHView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToUserView = findViewById(R.id.button2);
        goToUserView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserUQView.class);
                startActivity(intent);
            }
        });

        goToMOHView = findViewById(R.id.button3);
        goToMOHView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MOHUQView.class);
                startActivity(intent);
            }
        });
    }
}

