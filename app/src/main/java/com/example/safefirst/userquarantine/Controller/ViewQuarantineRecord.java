package com.example.safefirst.userquarantine.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.userquarantine.UserView;

public class ViewQuarantineRecord extends AppCompatActivity {

    Button ok_button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_quarantine_record);

        ok_button = findViewById(R.id.ok_button);
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewQuarantineRecord.this, UserView.class);
                startActivity(intent);
            }
        });
    }
}
