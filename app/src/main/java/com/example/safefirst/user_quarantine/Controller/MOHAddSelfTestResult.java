package com.example.safefirst.user_quarantine.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.Model.UserQuarantine.SelfTestModel;

public class MOHAddSelfTestResult extends AppCompatActivity {

    EditText editTextTestPlace, editTextTestType, editTextTestDate, editTextTestResult, editTextUser;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moh_add_self_test_result);

        editTextTestPlace = findViewById(R.id.editTextTestPlace);
        editTextTestType = findViewById(R.id.editTextTestType);
        editTextTestDate = findViewById(R.id.editTextTestDate);
        editTextTestResult = findViewById(R.id.editTextTestResult);
        editTextUser = findViewById(R.id.editTextUser);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelfTestModel db = new SelfTestModel(MOHAddSelfTestResult.this);
                db.addSelfTest(editTextTestPlace.getText().toString().trim(),
                        editTextTestType.getText().toString().trim(),
                        editTextTestDate.getText().toString().trim(),
                        editTextTestResult.getText().toString().trim(),
                        editTextUser.getText().toString().trim());
            }
        });
    }
}