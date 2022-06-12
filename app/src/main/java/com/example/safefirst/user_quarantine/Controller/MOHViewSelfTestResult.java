package com.example.safefirst.user_quarantine.Controller;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.safefirst.R;
import com.example.safefirst.user_quarantine.Model.SelfTestModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MOHViewSelfTestResult extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView imageView_emptydata;
    TextView textView_emptydata;

    SelfTestModel db;
    ArrayList<String> Test_ID, Test_Place, Test_Type, Test_Date, Test_Result, User_phoneNum;
    MOHSelfTestAdapter selfTestAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moh_view_self_test_result);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        imageView_emptydata = findViewById(R.id.imageView_emptydata);
        textView_emptydata = findViewById(R.id.textView_emptydata);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MOHViewSelfTestResult.this, MOHAddSelfTestResult.class);
                startActivity(intent);
            }
        });

        db = new SelfTestModel(MOHViewSelfTestResult.this);
        Test_ID = new ArrayList<>();
        Test_Place = new ArrayList<>();
        Test_Type = new ArrayList<>();
        Test_Date = new ArrayList<>();
        Test_Result = new ArrayList<>();
        User_phoneNum = new ArrayList<>();

        storeDataInArrays();
        selfTestAdapter = new MOHSelfTestAdapter(MOHViewSelfTestResult.this, this, Test_ID, Test_Place, Test_Type, Test_Date, Test_Result, User_phoneNum);
        recyclerView.setAdapter(selfTestAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MOHViewSelfTestResult.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays() {
        Cursor cursor = db.displaySelfTest();
        if (cursor.getCount() == 0) {
            imageView_emptydata.setVisibility(View.VISIBLE);
            textView_emptydata.setVisibility(View.VISIBLE);
        } else {
            imageView_emptydata.setVisibility(View.GONE);
            textView_emptydata.setVisibility(View.GONE);
            while (cursor.moveToNext()) {
                Test_ID.add(cursor.getString(0));
                Test_Place.add(cursor.getString(1));
                Test_Type.add(cursor.getString(2));
                Test_Date.add(cursor.getString(3));
                Test_Result.add(cursor.getString(4));
                User_phoneNum.add(cursor.getString(5));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.delete_all) {
            confirmDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete all? ");
        builder.setMessage("Are you sure you want to delete all data? ");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SelfTestModel db = new SelfTestModel(MOHViewSelfTestResult.this);
                db.deleteAllSelfTest();
                Intent intent = new Intent(MOHViewSelfTestResult.this, MOHViewSelfTestResult.class);
                startActivity(intent);
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
