package com.example.shiva.she;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ProgrammingKnowledge on 4/3/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "registered.db";
    public static final String TABLE_NAME = "login_table";
    public static final String COL_1 = "Name";
    public static final String COL_2 = "Aadhar";
    public static final String COL_3 = "Phone";
    public static final String COL_4 = "Password";
    public static final String COL_5 = "Confirm";
    public static final String COL_6 = "Address";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (NAME TEXT,Aadhar INTEGER PRIMARY KEY AUTOINCREMENT,Phone INTEGER,Password Text,Confirm Text,Address Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String Name,String Phone,String Password,String Confirm,String Address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,Name);
        contentValues.put(COL_3,Phone);
        contentValues.put(COL_4,Password);
        contentValues.put(COL_5,Confirm);
        contentValues.put(COL_6,Address);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String Name,String Aadhar,String Phone,String Password,String Confirm,String Address) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,Name);
        contentValues.put(COL_2,Aadhar);
        contentValues.put(COL_3,Phone);
        contentValues.put(COL_4,Password);
        contentValues.put(COL_5,Confirm);
        contentValues.put(COL_6,Address);

        db.update(TABLE_NAME, contentValues, "Aadhar = ?",new String[] { Aadhar });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "Aadhar = ?",new String[] {id});
    }
}