package com.example.safefirst.user_quarantine.Controller;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.user_quarantine.Model.QuarantineRecordModel;

public class MOHUpdateUserQuarantine extends AppCompatActivity {

    EditText editTextUQType, editTextUQLocation2, editTextUQstartDate2, editTextendDate2, editTextUser2;
    Button update_button2, delete_button2;

    String id, type, location, startDate, endDate, user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moh_update_user_quarantine_record);

        editTextUQType = findViewById(R.id.editTextUQType);
        editTextUQLocation2 = findViewById(R.id.editTextUQLocation2);
        editTextUQstartDate2 = findViewById(R.id.editTextUQstartDate2);
        editTextendDate2 = findViewById(R.id.editTextendDate2);
        editTextUser2 = findViewById(R.id.editTextUser2);
        update_button2 = findViewById(R.id.update_button2);
        delete_button2 = findViewById(R.id.delete_button2);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(user);
        }

        update_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuarantineRecordModel db = new QuarantineRecordModel(MOHUpdateUserQuarantine.this);
                type=editTextUQType.getText().toString().trim();
                location=editTextUQLocation2.getText().toString().trim();
                startDate=editTextUQstartDate2.getText().toString().trim();
                endDate=editTextendDate2.getText().toString().trim();
                user=editTextUser2.getText().toString().trim();
                db.updateUQ(id, type, location, startDate, endDate, user);
            }
        });

        delete_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData() {
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("type") &&
                getIntent().hasExtra("location") &&
                getIntent().hasExtra("startDate") &&
                getIntent().hasExtra("endDate") &&
                getIntent().hasExtra("user")) {
            // Getting intent data
            id = getIntent().getStringExtra("id");
            type = getIntent().getStringExtra("type");
            location = getIntent().getStringExtra("location");
            startDate = getIntent().getStringExtra("startDate");
            endDate = getIntent().getStringExtra("endDate");
            user = getIntent().getStringExtra("user");


            // Setting data
            editTextUQType.setText(type);
            editTextUQLocation2.setText(location);
            editTextUQstartDate2.setText(startDate);
            editTextendDate2.setText(endDate);
            editTextUser2.setText(user);

        } else {

        }
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete id " + id + " ?");
        builder.setMessage("Are you sure you want to delete id " + id + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                QuarantineRecordModel db = new QuarantineRecordModel(MOHUpdateUserQuarantine.this);
                db.deleteUQ(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }
}