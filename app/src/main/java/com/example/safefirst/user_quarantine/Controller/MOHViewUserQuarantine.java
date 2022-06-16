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
import com.example.safefirst.Model.UserQuarantine.QuarantineRecordModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MOHViewUserQuarantine extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button2;
    ImageView imageView_emptydata2;
    TextView textView_emptydata2;

    QuarantineRecordModel db;
    ArrayList<String> UserQ_ID, UserQ_Type, UserQ_Location, UserQ_startDate, UserQ_endDate, User_phoneNum;
    MOHUserQuarantineAdapter mohUserQuarantineAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moh_view_user_quarantine_record);

        recyclerView = findViewById(R.id.recyclerView);
        add_button2 = findViewById(R.id.add_button2);
        imageView_emptydata2 = findViewById(R.id.imageView_emptydata2);
        textView_emptydata2 = findViewById(R.id.textView_emptydata2);
        add_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MOHViewUserQuarantine.this, MOHAddUserQuarantine.class);
                startActivity(intent);
            }
        });

        db = new QuarantineRecordModel(MOHViewUserQuarantine.this);
        UserQ_ID = new ArrayList<>();
        UserQ_Type = new ArrayList<>();
        UserQ_Location = new ArrayList<>();
        UserQ_startDate = new ArrayList<>();
        UserQ_endDate = new ArrayList<>();
        User_phoneNum = new ArrayList<>();

        storeDataInArrays();
        mohUserQuarantineAdapter = new MOHUserQuarantineAdapter(MOHViewUserQuarantine.this, this, UserQ_ID, UserQ_Type, UserQ_Location, UserQ_startDate, UserQ_endDate, User_phoneNum);
        recyclerView.setAdapter(mohUserQuarantineAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MOHViewUserQuarantine.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            recreate();
        }
    }

    void storeDataInArrays() {
        Cursor cursor = db.displayUQ();
        if (cursor.getCount() == 0) {
            imageView_emptydata2.setVisibility(View.VISIBLE);
            textView_emptydata2.setVisibility(View.VISIBLE);
        } else {
            imageView_emptydata2.setVisibility(View.GONE);
            textView_emptydata2.setVisibility(View.GONE);
            while (cursor.moveToNext()) {
                UserQ_ID.add(cursor.getString(0));
                UserQ_Type.add(cursor.getString(1));
                UserQ_Location.add(cursor.getString(2));
                UserQ_startDate.add(cursor.getString(3));
                UserQ_endDate.add(cursor.getString(4));
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
                QuarantineRecordModel db = new QuarantineRecordModel(MOHViewUserQuarantine.this);
                db.deleteAllUQ();
                Intent intent = new Intent(MOHViewUserQuarantine.this, MOHViewUserQuarantine.class);
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
