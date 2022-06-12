package com.example.safefirst.userquarantine;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.userquarantine.View.MOHUQView;
import com.example.safefirst.userquarantine.View.UserQRView;

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
                Intent intent = new Intent(MainActivity.this, UserQRView.class);
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

