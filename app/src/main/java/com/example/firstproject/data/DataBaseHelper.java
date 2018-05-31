package com.example.firstproject.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "NewMyDBName.db";
    public static final String TIME_TABLE_NAME = "time";
    public static final String TIME_COLUMN_ID = "id";
    public static final String TIME_COLUMN_PASTTIME = "pastTime";
    private HashMap hp;

    public DataBaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create TABLE " + TIME_TABLE_NAME + "(" + TIME_COLUMN_ID +
                    " integer primary key autoincrement, " + TIME_COLUMN_PASTTIME + " text)");
    }

    public boolean insertTime (String pastTime) {
        SQLiteDatabase db = this.getWritableDatabase();
//        onCreate(db);
        ContentValues contentValues = new ContentValues();
        contentValues.put(TIME_COLUMN_PASTTIME, pastTime);
        db.insert(TIME_TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getData(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+ TIME_TABLE_NAME + " where id=" + id + "",
                                    null );
        return res;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TIME_TABLE_NAME);
        onCreate(db);
    }

    public boolean updateTime (Integer id, String pastTime) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TIME_COLUMN_PASTTIME, pastTime);
        db.update(TIME_TABLE_NAME, contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }

    public ArrayList<String> getAllCotacts() {
        ArrayList<String> array_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from " + TIME_TABLE_NAME, null );
        res.moveToFirst();
        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(TIME_COLUMN_PASTTIME)));
            res.moveToNext();
        }
        return array_list;
    }
}
