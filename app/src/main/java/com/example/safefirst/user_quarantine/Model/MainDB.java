package com.example.safefirst.user_quarantine.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MainDB extends SQLiteOpenHelper {

    // Declare variable for SafeFirst Database
    private static final String DATABASE_NAME = "SafeFirst.db";
    private static final int DATABASE_VERSION = 1;

    public MainDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create Table Method
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create SelfTest Table
        db.execSQL("CREATE TABLE TestResult (Test_ID INTEGER PRIMARY KEY AUTOINCREMENT, Test_Place TEXT, Test_Type TEXT, Test_Date TEXT, Test_Result TEXT, User_phoneNum TEXT);");
        // Create UserQuarantine Table
        db.execSQL("CREATE TABLE UserQuarantine (UserQ_ID INTEGER PRIMARY KEY AUTOINCREMENT, UserQ_Type TEXT, UserQ_Location TEXT, UserQ_startDate TEXT, UserQ_endDate TEXT, User_phoneNum TEXT);");
        // Create HealthAssessment Table
        db.execSQL("CREATE TABLE HealthAssessment (HA_ID INTEGER PRIMARY KEY AUTOINCREMENT, HA_Q1 TEXT, HA_Q2 TEXT, HA_Q3 TEXT, HA_Q4 TEXT, HA_Q5 TEXT, User_phoneNum TEXT);");
    }

    // Upgrade table method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS TestResult");
        db.execSQL("DROP TABLE IF EXISTS UserQuarantine");
        db.execSQL("DROP TABLE IF EXISTS HealthAssessment");
        onCreate(db);
    }


}
