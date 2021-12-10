package com.example.register_login;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final int Data_version = 1;
    public static final String Data_id = "id";
    public static final String Data_base = "Regi";
    public static final String Data_Table = "LEAVES";
    public static final String User = "userid";
    public static final String key = "password";

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Data_base, factory, Data_version);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q = " CREATE TABLE " +
                Data_Table + " ( " +
                Data_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                User + " TEXT, " +
                key + " TEXT " + " ) ";


        db.execSQL(q);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table if exists " + Data_Table);
        onCreate(db);

    }

    public boolean add(String usrid, String pssword) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(User, usrid);
        values.put(key, pssword);
        long in = db.insert(Data_Table, null, values);
        if (in == -1)

            return false;

        else
            return true;
    }

    public boolean checkusername(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query="SELECT * FROM "+ Data_Table +" Where "+User +"= \""+ username+ "\"";
        Cursor cursor = db.rawQuery(query,null);

        if (cursor.getCount() > 0) {
            return true;
        }
        else
            return false;
    }

    public boolean checkpassword( String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String quary = "Select * FROM " + Data_Table + " WHERE " + key + " =  \"" + password+ "\"";
        Cursor c=db.rawQuery(quary,null);
        if (c.getCount()>0) {
            return true;
        }
        else
            return false;
    }
}
