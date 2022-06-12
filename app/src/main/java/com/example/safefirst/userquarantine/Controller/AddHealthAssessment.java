package com.example.safefirst.userquarantine.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.safefirst.R;
import com.example.safefirst.userquarantine.Model.HealthAssessmentModel;
import com.example.safefirst.userquarantine.View.UserQRView;

public class AddHealthAssessment extends AppCompatActivity {

    RadioGroup h1RadioGroup, h2RadioGroup, h3RadioGroup, h4RadioGroup, h5RadioGroup;
    Button confirm_button, cancel_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_health_assessment_record);

        h1RadioGroup = findViewById(R.id.h1RadioGroup);
        h2RadioGroup = findViewById(R.id.h2RadioGroup);
        h3RadioGroup = findViewById(R.id.h3RadioGroup);
        h4RadioGroup = findViewById(R.id.h4RadioGroup);
        h5RadioGroup = findViewById(R.id.h5RadioGroup);
        confirm_button = findViewById(R.id.confirm_button4);
        confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int h1 = h1RadioGroup.getCheckedRadioButtonId();
                int h2 = h2RadioGroup.getCheckedRadioButtonId();
                int h3 = h3RadioGroup.getCheckedRadioButtonId();
                int h4 = h4RadioGroup.getCheckedRadioButtonId();
                int h5 = h5RadioGroup.getCheckedRadioButtonId();

                RadioButton selectedH1 = (RadioButton) findViewById(h1);
                RadioButton selectedH2 = (RadioButton) findViewById(h2);
                RadioButton selectedH3 = (RadioButton) findViewById(h3);
                RadioButton selectedH4 = (RadioButton) findViewById(h4);
                RadioButton selectedH5 = (RadioButton) findViewById(h5);

                selectedH1.getText().toString().trim();
                selectedH2.getText().toString().trim();
                selectedH3.getText().toString().trim();
                selectedH4.getText().toString().trim();
                selectedH5.getText().toString().trim();

                HealthAssessmentModel db = new HealthAssessmentModel(AddHealthAssessment.this);
                db.addHA(selectedH1.getText().toString().trim(),
                        selectedH2.getText().toString().trim(),
                        selectedH3.getText().toString().trim(),
                        selectedH4.getText().toString().trim(),
                        selectedH5.getText().toString().trim(),
                        null);

            }
        });
        cancel_button = findViewById(R.id.cancel_button4);
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddHealthAssessment.this, UserQRView.class);
                startActivity(intent);
            }
        });
    }
}
