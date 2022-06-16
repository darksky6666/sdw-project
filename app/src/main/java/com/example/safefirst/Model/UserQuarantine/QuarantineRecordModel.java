package com.example.safefirst.Model.UserQuarantine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class QuarantineRecordModel {

    private MainDB mainDB;
    private Context context;

    // Declare variable for UserQuarantine Database
    private static final String UserQuarantine = "UserQuarantine";
    private static final String UserQ_Type = "UserQ_Type";
    private static final String UserQ_Location = "UserQ_Location";
    private static final String UserQ_startDate = "UserQ_startDate";
    private static final String UserQ_endDate = "UserQ_endDate";
    private static final String User_phoneNum = "User_phoneNum";

    public QuarantineRecordModel(@Nullable Context context) {
        mainDB = new MainDB(context);
        this.context = context;
    }

    //UserQuarantine CRUD
    //Create Quarantine
    public void addUQ(String type, String location, String startDate, String endDate, String phone) {
        SQLiteDatabase db = mainDB.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(UserQ_Type, type);
        cv.put(UserQ_Location, location);
        cv.put(UserQ_startDate, startDate);
        cv.put(UserQ_endDate, endDate);
        cv.put(User_phoneNum, phone);
        long sqlresult = db.insert(UserQuarantine, null, cv);
        if (sqlresult == -1){
            Toast.makeText(context, "Failed to insert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Inserted successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    // Read Quarantine
    public Cursor displayUQ() {
        String query = "SELECT * FROM " + UserQuarantine;
        SQLiteDatabase db = mainDB.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    // Update Quarantine
    public void updateUQ(String row_id, String type, String location, String startDate, String endDate, String phone) {
        SQLiteDatabase db = mainDB.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(UserQ_Type, type);
        cv.put(UserQ_Location, location);
        cv.put(UserQ_startDate, startDate);
        cv.put(UserQ_endDate, endDate);
        cv.put(User_phoneNum, phone);

        long sqlresult = db.update(UserQuarantine, cv, "UserQ_ID=?", new String[]{row_id});
        if (sqlresult == -1){
            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    // Delete Quarantine
    public void deleteUQ(String row_id){
        SQLiteDatabase db = mainDB.getWritableDatabase();
        long sqlresult = db.delete(UserQuarantine, "UserQ_ID=?", new String[]{row_id});
        if (sqlresult == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Deleted successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    //Delete all quarantine
    public void deleteAllUQ(){
        SQLiteDatabase db = mainDB.getWritableDatabase();
        db.execSQL("DELETE FROM " + UserQuarantine);
    }
}
