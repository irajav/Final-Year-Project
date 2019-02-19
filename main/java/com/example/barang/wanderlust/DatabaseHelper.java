package com.example.barang.wanderlust;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by barang on 20/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    //name of database
    public static final String DATABASE_NAME = "wanderlust.db";
    private static final int DATABASE_VERSION = 1;

    //names of tables
    public static final String USERS_TABLE = "UsersTable";

    //UsersTable Columns
    public static final String COL_USERS = "USERNAME";
    public static final String COL_PASSWORD = "PASSWORD";
    public static final String COL_USERID = "USERID";
    public static final String COL_FIRSTNAME = "FIRSTNAME";
    public static final String COL_LASTNAME = "LASTNAME";
    public static final String COL_EMAIL = "EMAIL";
    public static final String COL_NUMBER = "NUMBER";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + USERS_TABLE + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, PASSWORD TEXT, FIRSTNAME TEXT, LASTNAME TEXT, EMAIL TEXT, NUMBER TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + USERS_TABLE);
        onCreate(db);

    }

    /**************************************************************************************************************************************************
     METHODS OF UsersTable
     **************************************************************************************************************************************************/


    //inserts data into the UsersTable
    void insertData(String username, String password, String firstname, String lastname, String email, String number, int usertype) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_USERS, username);
        contentValues.put(COL_PASSWORD, password);
        contentValues.put(COL_FIRSTNAME, firstname);
        contentValues.put(COL_LASTNAME, lastname);
        contentValues.put(COL_EMAIL, email);
        contentValues.put(COL_NUMBER, number);
        db.insert(USERS_TABLE, null, contentValues);

    }

    //will check if the user already exists or if the username is taken - Used in the REGISTERNOW CLASS
    boolean checkUser(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("UsersTable", null, "USERNAME=?", new String[]{username}, null, null, null);
        if (cursor.getCount() > 0) {
            cursor.close();
            return true;
        } else {
            return false;
        }
    }


    //checks if the username is in the database - used in the MAINACTIVITY CLASS
    String checkUsername(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("UsersTable", null, "USERNAME=?", new String[]{username}, null, null, null);
        if (cursor.getCount() < 1) {
            cursor.close();
            return "Username doesn't exist.";
        }

        cursor.moveToFirst();
        String password = cursor.getString(cursor.getColumnIndex("PASSWORD"));
        return password;

    }


    String getPhone(String username) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("UsersTable", null, "USERNAME=?", new String[]{username}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            String userphone = cursor.getString(cursor.getColumnIndex("NUMBER"));
            return userphone;
        } else {
            return "";
        }
    }

    String getEmail(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("UsersTable", null, "USERNAME=?", new String[]{email}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String useremail = cursor.getString(cursor.getColumnIndex("EMAIL"));
            return useremail;
        } else {
            return "";
        }
    }

    String getName(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("UsersTable", null, "USERNAME=?", new String[]{username}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String userfname = cursor.getString(cursor.getColumnIndex("FIRSTNAME"));
            return userfname;
        } else {
            return "";
        }
    }

    void updateNumber(String username, String number) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_NUMBER, number);
        db.update(USERS_TABLE, contentValues, "USERNAME = ?", new String[]{username});
    }


    void updateEmail(String username, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EMAIL, email);
        db.update(USERS_TABLE, contentValues, "USERNAME = ?", new String[]{username});
    }
}
