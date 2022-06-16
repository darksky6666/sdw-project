package com.example.safefirst.user_quarantine.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SelfTestModel {

    private MainDB mainDB;
    private Context context;

    // Declare variable for Self Test Database
    private static final String TestResult = "TestResult";
    private static final String Test_Place = "Test_Place";
    private static final String Test_Type = "Test_Type";
    private static final String Test_Date = "Test_Date";
    private static final String Test_Result = "Test_Result";
    private static final String User_phoneNum = "User_phoneNum";

    public SelfTestModel(@Nullable Context context) {
        mainDB = new MainDB(context);
        this.context = context;
    }

    //Self Test CRUD
    //Create Self Test
    public void addSelfTest(String place, String type, String date, String result, String phone) {
        SQLiteDatabase db = mainDB.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Test_Place, place);
        cv.put(Test_Type, type);
        cv.put(Test_Date, date);
        cv.put(Test_Result, result);
        cv.put(User_phoneNum, phone);
        long sqlresult = db.insert(TestResult, null, cv);
        if (sqlresult == -1){
            Toast.makeText(context, "Failed to insert", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Inserted successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    // Read Self Test
    public Cursor displaySelfTest() {
        String query = "SELECT * FROM " + TestResult;
        SQLiteDatabase db = mainDB.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    // Update Self Test
    public void updateSelfTest(String row_id, String place, String type, String date, String result, String phone) {
        SQLiteDatabase db = mainDB.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Test_Place, place);
        cv.put(Test_Type, type);
        cv.put(Test_Date, date);
        cv.put(Test_Result, result);
        cv.put(User_phoneNum, phone);

        long sqlresult = db.update(TestResult, cv, "Test_ID=?", new String[]{row_id});
        if (sqlresult == -1){
            Toast.makeText(context, "Failed to update", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Updated successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    // Delete Self Test
    public void deleteSelfTest(String row_id){
        SQLiteDatabase db = mainDB.getWritableDatabase();
        long sqlresult = db.delete(TestResult, "Test_ID=?", new String[]{row_id});
        if (sqlresult == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Deleted successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    // Delete All Self Test
    public void deleteAllSelfTest(){
        SQLiteDatabase db = mainDB.getWritableDatabase();
        db.execSQL("DELETE FROM " + TestResult);
    }


}
