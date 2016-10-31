package com.justinwells.joinslab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justinwells on 10/28/16.
 */

public class Helper extends SQLiteOpenHelper {

    public static final String EMPLOYEE_TABLE_NAME = "employee";
    public static final String COL_SSN = "SSN";
    public static final String COL_FIRST = "First";
    public static final String COL_LAST = "Last";
    public static final String COL_YEAR = "year";
    public static final String COL_CITY = "city";


    public static final String JOB_TABLE_NAME = "Jobs";
    public static final String COL_COMPANY = "Company";
    public static final String COL_SALARY = "Salary";
    public static final String COL_EXP = "Experience";

    private static final String CREATE_TABLE_EMPLOYEES = "CREATE TABLE " +
            EMPLOYEE_TABLE_NAME + " (" +
            COL_SSN + " TEXT PRIMARY KEY," +
            COL_FIRST + " TEXT," +
            COL_LAST + " TEXT," +
            COL_YEAR + " INTEGER," +
            COL_CITY + " TEXT" + ")";

    private static final String CREATE_TABLE_JOBS = "CREATE TABLE " +
            JOB_TABLE_NAME + " (" +
            COL_SSN + " TEXT PRIMARY KEY,  " +
            COL_COMPANY + " TEXT," +
            COL_SALARY + " INTEGER," +
            COL_EXP + " INTEGER" + ")";



    private static Helper sInstance;

    private Helper (Context context) {
        super(context,"db",null,1);
    }

    public static Helper getInstance (Context context) {
        if (sInstance == null) {
            sInstance = new Helper(context);
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_EMPLOYEES);
        sqLiteDatabase.execSQL(CREATE_TABLE_JOBS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + EMPLOYEE_TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + JOB_TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertRowEmployee (Employee employee) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SSN, employee.getSsn());
        values.put(COL_FIRST, employee.getFirstName());
        values.put(COL_LAST, employee.getLastName());
        values.put(COL_YEAR, employee.getBirthYear());
        values.put(COL_CITY, employee.getCity());
        db.insertOrThrow(EMPLOYEE_TABLE_NAME,null,values);
        db.close();
    }

    public void insertRowJobs (Job job) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_SSN, job.getSsn());
        values.put(COL_COMPANY, job.getCompany());
        values.put(COL_SALARY, job.getSalary());
        values.put(COL_EXP, job.getExp());
        db.insertOrThrow(JOB_TABLE_NAME, null, values);
        db.close();
    }

    public List<String> getMacyEmployees () {
        List<String>results = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT " + COL_FIRST + ", " + COL_LAST + " FROM " + EMPLOYEE_TABLE_NAME+
                " INNER JOIN " + JOB_TABLE_NAME + " ON " + EMPLOYEE_TABLE_NAME + "." + COL_SSN +
                " = " + JOB_TABLE_NAME + "." + COL_SSN + " WHERE " + COL_COMPANY  + " = 'Macys' ";


        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                results.add(cursor.getString(cursor.getColumnIndex(COL_FIRST)) + " " +
                            cursor.getString(cursor.getColumnIndex(COL_LAST)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return results;
    }

    public List<String> getHighestPaid () {
        List<String>highestNames = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT " + COL_FIRST + COL_LAST + " FROM " + EMPLOYEE_TABLE_NAME +
                "INNER JOIN " + JOB_TABLE_NAME + " ON " + EMPLOYEE_TABLE_NAME + "." + COL_SSN +
                " = " + JOB_TABLE_NAME + "." + COL_SSN + " ORDER BY " + COL_SALARY;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            highestNames.add(cursor.getString(cursor.getColumnIndex(COL_FIRST)) + " "
                            +cursor.getString(cursor.getColumnIndex(COL_LAST)));
        }

        return highestNames;
    }

    public List<String> getBostonCompanies () {
        List<String>results = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT " + COL_COMPANY + " FROM " + EMPLOYEE_TABLE_NAME+
                " INNER JOIN " + JOB_TABLE_NAME + " ON " + EMPLOYEE_TABLE_NAME + "." + COL_SSN +
                " = " + JOB_TABLE_NAME + "." + COL_SSN + " WHERE " + COL_CITY  + " = 'Boston' ";


        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                results.add(cursor.getString(cursor.getColumnIndex(COL_COMPANY)));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return results;

    }
}
