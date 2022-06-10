package com.example.safefirst.userquarantine.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainDB extends SQLiteOpenHelper {

    // Declare variable for SafeFirst Database
    private Context context;
    private static final String DATABASE_NAME = "SafeFirst.db";
    private static final int DATABASE_VERSION = 1;

//    private static final String UserQuarantine = "UserQuarantine";
//    private static final String UserQ_ID = "UserQ_ID";
//    private static final String UserQ_Type = "UserQ_Type";
//    private static final String UserQ_Location = "UserQ_Location";
//    private static final String UserQ_startDate = "UserQ_startDate";
//    private static final String UserQ_endDate = "UserQ_endDate";
//    private static final String User_phoneNum = "User_phoneNum";

    // Declare variable for Self Test Database
    private static final String TestResult = "TestResult";
    private static final String Test_ID = "Test_ID";
    private static final String Test_Place = "Test_Place";
    private static final String Test_Type = "Test_Type";
    private static final String Test_Date = "Test_Date";
    private static final String Test_Result = "Test_Result";
    private static final String User_phoneNum = "User_phoneNum";


    public MainDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    // Create Table Method
    @Override
    public void onCreate(SQLiteDatabase db) {
//        String query =
//                "CREATE TABLE " + UserQuarantine +
//                        " (" + UserQ_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                        UserQ_Type + " TEXT, " +
//                        UserQ_Location + " TEXT, " +
//                        UserQ_startDate + " TEXT, " +
//                        UserQ_endDate + " TEXT, " +
//                        User_phoneNum + " TEXT);";

        // Create Self Test Table
        String query =
                "CREATE TABLE " + TestResult +
                        " (" + Test_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        Test_Place + " TEXT, " +
                        Test_Type + " TEXT, " +
                        Test_Date + " TEXT, " +
                        Test_Result + " TEXT, " +
                        User_phoneNum + " TEXT);";
        db.execSQL(query);
    }

    // Upgrade table method
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TestResult);
        onCreate(db);
    }

    //Self Test CRUD
    //Create Self Test
    public void addSelfTest(String place, String type, String date, String result, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
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

    public Cursor displaySelfTest() {
        String query = "SELECT * FROM " + TestResult;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    public void updateSelfTest(String row_id, String place, String type, String date, String result, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();
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

    public void deleteSelfTest(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long sqlresult = db.delete(TestResult, "Test_ID=?", new String[]{row_id});
        if (sqlresult == -1){
            Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Deleted successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteAllSelfTest(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TestResult);
    }


}
