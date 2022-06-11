package com.example.safefirst.userquarantine.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.userquarantine.Model.QuarantineRecordModel;
import com.example.safefirst.userquarantine.UserView;

public class AddQuarantineRecord extends AppCompatActivity {
    EditText editTextQuarantineType, editTextQuarantineLocation, editTextDate2;
    Button confirm_button, cancel_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_quarantine_record);

        String phone = "0179875542";
        editTextQuarantineType = findViewById(R.id.editTextQuarantineType);
        editTextQuarantineLocation = findViewById(R.id.editTextQuarantineLocation);
        editTextDate2 = findViewById(R.id.editTextDate2);
        confirm_button = findViewById(R.id.confirm_button);
        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuarantineRecordModel db = new QuarantineRecordModel(AddQuarantineRecord.this);
                db.addUQ(editTextQuarantineType.getText().toString().trim(),
                        editTextQuarantineLocation.getText().toString().trim(),
                        editTextDate2.getText().toString().trim(),
                        null,
                        phone);
            }
        });
        cancel_button = findViewById(R.id.cancel_button);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddQuarantineRecord.this, UserView.class);
                startActivity(intent);
            }
        });
    }
}
