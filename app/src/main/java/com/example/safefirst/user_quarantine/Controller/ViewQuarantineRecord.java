package com.example.safefirst.user_quarantine.Controller;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.user_quarantine.Model.QuarantineRecordModel;
import com.example.safefirst.user_quarantine.View.UserUQView;

public class ViewQuarantineRecord extends AppCompatActivity {

    TextView quarantineTypeText, quarantineLocationText, quarantineDateText;
    Button ok_button;
    QuarantineRecordModel db;
    String id, type, location, startDate;

    String phone = new UserUQView().getPhone();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_quarantine_record);

        quarantineTypeText = findViewById(R.id.quarantineTypeText);
        quarantineLocationText = findViewById(R.id.quarantineLocationText);
        quarantineDateText = findViewById(R.id.quarantineDateText);
        db = new QuarantineRecordModel(ViewQuarantineRecord.this);

        displayData(phone);

        ok_button = findViewById(R.id.ok_button);
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewQuarantineRecord.this, UserUQView.class);
                startActivity(intent);
            }
        });


    }

    void displayData(String phone) {
        Cursor cursor = db.displayUQ();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data found.", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                if (cursor.getString(5).equals(phone)) {
                    id = cursor.getString(0);
                    type = cursor.getString(1);
                    location = cursor.getString(2);
                    startDate = cursor.getString(3);
                    quarantineTypeText.setText(type) ;
                    quarantineDateText.setText(startDate);
                    quarantineLocationText.setText(location);
                }
            }
        }
    }
}
