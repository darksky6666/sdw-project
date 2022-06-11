package com.example.safefirst.userquarantine.Controller;

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
import com.example.safefirst.userquarantine.Model.SelfTestModel;

public class MOHUpdateSelfTestResult extends AppCompatActivity {

    EditText editTextTestPlace, editTextTestType, editTextTestDate, editTextTestResult, editTextUser;
    Button update_button, delete_button;

    String id, place, type, date, result, user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moh_update_self_test_result);

        editTextTestPlace = findViewById(R.id.editTextTestPlace2);
        editTextTestType = findViewById(R.id.editTextTestType2);
        editTextTestDate = findViewById(R.id.editTextTestDate2);
        editTextTestResult = findViewById(R.id.editTextTestResult2);
        editTextUser = findViewById(R.id.editTextUser2);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(user);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelfTestModel db = new SelfTestModel(MOHUpdateSelfTestResult.this);
                place=editTextTestPlace.getText().toString().trim();
                type=editTextTestType.getText().toString().trim();
                date=editTextTestDate.getText().toString().trim();
                result=editTextTestResult.getText().toString().trim();
                user=editTextUser.getText().toString().trim();
                db.updateSelfTest(id, place, type, date, result, user);
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }

    void getAndSetIntentData() {
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("place") &&
                getIntent().hasExtra("type") &&
                getIntent().hasExtra("date") &&
                getIntent().hasExtra("result") &&
                getIntent().hasExtra("user")) {
            // Getting intent data
            id = getIntent().getStringExtra("id");
            place = getIntent().getStringExtra("place");
            type = getIntent().getStringExtra("type");
            date = getIntent().getStringExtra("date");
            result = getIntent().getStringExtra("result");
            user = getIntent().getStringExtra("user");


            // Setting data
            editTextTestPlace.setText(place);
            editTextTestType.setText(type);
            editTextTestDate.setText(date);
            editTextTestResult.setText(result);
            editTextUser.setText(user);

        } else {
            Toast.makeText(this, "No data found.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete id " + id + " ?");
        builder.setMessage("Are you sure you want to delete id " + id + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SelfTestModel db = new SelfTestModel(MOHUpdateSelfTestResult.this);
                db.deleteSelfTest(id);
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