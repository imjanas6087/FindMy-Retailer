package com.example.findmyretailer;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DataBaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DataBaseAccess instance;
    ArrayList<Details> details = new ArrayList<>();
    Cursor cursor = null;
    Cursor cursor1 = null;

    public DataBaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    public static DataBaseAccess getInstance(Context context){

        if(instance==null){
           instance = new DataBaseAccess(context);
        }
        return instance;
    }

    public void open(){
        this.database = openHelper.getWritableDatabase();
    }

    public void close(){
        if(this.database!=null){
            this.database.close();
        }
    }

    public ArrayList<Details> getDetails(){
        cursor = database.rawQuery("select * from RetailerMaster",new String[]{});
        cursor1 = database.rawQuery("select * from  RetailerAddress",new String[]{});
        while(cursor.moveToNext() && cursor1.moveToNext()){
            details.add(new Details(cursor.getString(2),cursor.getString(0),cursor1.getString(1),cursor1.getString(5),cursor1.getString(6),
                    cursor1.getString(7),cursor1.getString(9),"Data not given"));
        }
        return details;
    }
}
