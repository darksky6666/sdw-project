package com.example.safefirst.userquarantine.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.userquarantine.Model.SelfTestModel;
import com.example.safefirst.userquarantine.UserView;

public class AddSelfTestResult extends AppCompatActivity {
    EditText editTextType, editTextPlace, editTextDate, editTextTestResult;
    Button confirm_button, cancel_button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_self_test_result);

        String phone = "0179875542";
        editTextType = findViewById(R.id.editTextType);
        editTextPlace = findViewById(R.id.editTextPlace);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTestResult = findViewById(R.id.editTextTestResult);
        confirm_button = findViewById(R.id.confirm_button);
        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelfTestModel db = new SelfTestModel(AddSelfTestResult.this);
                db.addSelfTest(editTextPlace.getText().toString().trim(),
                        editTextType.getText().toString().trim(),
                        editTextDate.getText().toString().trim(),
                        editTextTestResult.getText().toString().trim(),
                        phone);
            }
        });
        cancel_button = findViewById(R.id.cancel_button);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddSelfTestResult.this, UserView.class);
                startActivity(intent);
            }
        });
    }
}
