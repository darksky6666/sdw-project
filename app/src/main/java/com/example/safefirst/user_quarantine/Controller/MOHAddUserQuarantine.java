package com.example.safefirst.user_quarantine.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.Model.UserQuarantine.QuarantineRecordModel;

public class MOHAddUserQuarantine extends AppCompatActivity {

    EditText editTextUQType, editTextUQLocation, editTextUQstartDate, editTextendDate, editTextUser2;
    Button add_button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moh_add_user_quarantine);

        editTextUQType = findViewById(R.id.editTextUQType);
        editTextUQLocation = findViewById(R.id.editTextUQLocation);
        editTextUQstartDate = findViewById(R.id.editTextUQstartDate);
        editTextendDate = findViewById(R.id.editTextendDate);
        editTextUser2 = findViewById(R.id.editTextUser2);
        add_button2 = findViewById(R.id.add_button2);
        add_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuarantineRecordModel db = new QuarantineRecordModel(MOHAddUserQuarantine.this);
                db.addUQ(editTextUQType.getText().toString().trim(),
                        editTextUQLocation.getText().toString().trim(),
                        editTextUQstartDate.getText().toString().trim(),
                        editTextendDate.getText().toString().trim(),
                        editTextUser2.getText().toString().trim());
            }
        });
    }
}