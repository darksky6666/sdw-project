package com.example.safefirst.user_quarantine.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class HealthAssessmentModel {

    private MainDB mainDB;
    private Context context;

    // Declare variable for Health Assessment Database
    private static final String HealthAssessment = "HealthAssessment";
    private static final String HA_ID = "HA_ID";
    private static final String HA_Q1 = "HA_Q1";
    private static final String HA_Q2 = "HA_Q2";
    private static final String HA_Q3 = "HA_Q3";
    private static final String HA_Q4 = "HA_Q4";
    private static final String HA_Q5 = "HA_Q5";
    private static final String User_phoneNum = "User_phoneNum";

    public HealthAssessmentModel (@Nullable Context context) {
        mainDB = new MainDB(context);
        this.context = context;
    }

    //HealthAssessment CRUD
    //Create HealthAssessment
    public void addHA(String q1, String q2, String q3, String q4, String q5, String phone) {
        SQLiteDatabase db = mainDB.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(HA_Q1, q1);
        cv.put(HA_Q2, q2);
        cv.put(HA_Q3, q3);
        cv.put(HA_Q4, q4);
        cv.put(HA_Q5, q5);
        cv.put(User_phoneNum, phone);
        long sqlresult = db.insert(HealthAssessment, null, cv);
        if (sqlresult == -1){
            Toast.makeText(context, "Failed to insert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Inserted successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    // Read Health Assessment
    public Cursor displayHA() {
        String query = "SELECT * FROM " + HealthAssessment;
        SQLiteDatabase db = mainDB.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    // Update Health Assessment
    public void updateHA(String row_id, String q1, String q2, String q3, String q4, String q5, String phone) {
        SQLiteDatabase db = mainDB.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(HA_Q1, q1);
        cv.put(HA_Q2, q2);
        cv.put(HA_Q3, q3);
        cv.put(HA_Q4, q4);
        cv.put(HA_Q5, q5);
        cv.put(User_phoneNum, phone);

        long sqlresult = db.update(HealthAssessment, cv, "HA_ID=?", new String[]{row_id});
        if (sqlresult == -1){
            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    // Delete Health Assessment
    public void deleteHA(String row_id){
        SQLiteDatabase db = mainDB.getWritableDatabase();
        long sqlresult = db.delete(HealthAssessment, "HA_ID=?", new String[]{row_id});
        if (sqlresult == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Deleted successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    //Delete all health assessment
    public void deleteAllHA(){
        SQLiteDatabase db = mainDB.getWritableDatabase();
        db.execSQL("DELETE FROM " + HealthAssessment);
    }
}
