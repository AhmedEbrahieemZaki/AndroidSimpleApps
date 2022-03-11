package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Sql_t  extends SQLiteOpenHelper {


    public Sql_t(@Nullable Context context) {
        super(context, "data.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table mytable (id INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT, price TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("Drop TABLE IF EXISTS mytable");
        onCreate(sqLiteDatabase);
    }

    public Boolean insertDat(String name, String price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("price", price);
        long result = db.insert("mytable", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public ArrayList getrecord(){
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor= db.rawQuery("select * from mytable",null);
        cursor.moveToNext();
        while (cursor.isAfterLast()==false){
            String t1 = cursor.getString(0);
            String t2 = cursor.getString(1);
            String t3 = cursor.getString(2);
            arrayList.add(t1 + "-"+ t2 + " : " + t3);
            cursor.moveToNext();
        }
        return arrayList;
    }
}