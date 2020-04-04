package com.example.prosoltestdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SqliteDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "employeeData";
    public static final String TABLE_EMPLOYEE = "Employee";
    public static final String KEY_ID = "id";
    public static final String EMPLOYEE_NAME = "EmployeeName";
    public static final String EMPLOYEE_PHONE = "EmployeePhone";
    public static final String EMPLOYEE_EMAIL = "EmployeeEmail";
    public static final String EMPLOYEE_ADDRESS = "EmployeeAdrress";


    public SqliteDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_EMPLOYEE_TABLE = " CREATE TABLE " + TABLE_EMPLOYEE + "(" + KEY_ID + " INTEGER PRIMARY KEY," + EMPLOYEE_NAME + "TEXT,"
                + EMPLOYEE_PHONE + " TEXT ," + EMPLOYEE_EMAIL + "TEXT, " + EMPLOYEE_ADDRESS + "TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_EMPLOYEE_TABLE);

    }

    public void AddEmployee(UserModel userModel) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMPLOYEE_NAME, userModel.getEmpName());
        values.put(EMPLOYEE_EMAIL, userModel.getEmpEmail());
        values.put(EMPLOYEE_ADDRESS, userModel.getEmpAddress());
        values.put(EMPLOYEE_PHONE, userModel.getEmpPhone());
        sqLiteDatabase.insert(TABLE_EMPLOYEE, null, values);
        sqLiteDatabase.close();


    }

    public List getAllEmployees() {
        List employeeList = new ArrayList();
        String selectQuery = "SELECT * FROM " + TABLE_EMPLOYEE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                UserModel userModel = new UserModel();
                userModel.setEmpName(cursor.getString(1));
                userModel.setEmpPhone(cursor.getString(2));
                userModel.setEmpEmail(cursor.getString(3));
                userModel.setEmpAddress(cursor.getString(4));
                employeeList.add(userModel);
            } while (cursor.moveToNext());
        }

        return employeeList;
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEE);
        onCreate(sqLiteDatabase);
    }
}
