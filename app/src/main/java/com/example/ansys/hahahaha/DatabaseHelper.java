package com.example.ansys.hahahaha;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static String NAME = "quiz.db";
    public static int VERSION =1;

    public DatabaseHelper(Context context){
        super(context, NAME, null, VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        String sql = "create table if not exists noteData("
                +"_id integer PRIMARY KEY autoincrement, "
                +"question text, "
                +"choice1 text, "
                +"choice2 text, "
                +"choice3 text, "
                +"choice4 text, "
                +"score integer, "
                +"name text)";
        db.execSQL(sql);
    }

    public void onOpen(SQLiteDatabase db){}

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        if(newVersion>1) {
            db.execSQL("DROP TABLE IF EXISTS quiz");
        }
    }
}

