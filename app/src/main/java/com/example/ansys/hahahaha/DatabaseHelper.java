package com.example.ansys.hahahaha;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private ArrayList<QuestionBean> questions;
    private String table = "quiz";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        questions = new ArrayList<>();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder b = new StringBuilder();
        b.append("create table quiz(");
        b.append("id integer primary key autoincrement, type integer,");
        b.append("question text, answer integer,");
        b.append("choice1 text, choice2 text, choice3 text, choice4 text)");
        String sql = b.toString();
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table quiz";
        db.execSQL(sql);
        onCreate(db);
    }

    public long insert(QuestionBean q){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("type", q.getType());
        values.put("question", q.getQuestion());
        values.put("answer", q.getAnswer());
        for(int i=0; i<q.getChoices().length;i++){
            int index = i+1;
            values.put("choice" + index, q.getChoices()[i]);
        }
        return db.insert(table, null, values);
    }

    public QuestionBean select(int id){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(table, null, "id=?", new String[] {String.valueOf(id)}, null, null, null);
        if(c.getCount()!=0){
            if(c.moveToNext()){
                QuestionBean bean = new QuestionBean();
                bean.setId(c.getInt(c.getColumnIndex("id")));
                bean.setType(c.getInt(c.getColumnIndex("type")));
                bean.setQuestion(c.getString(c.getColumnIndex("question")));
                bean.setAnswer(c.getInt(c.getColumnIndex("answer")));
                String[] choices = new String[4];
                for(int i=1; i<5;i++){
                    choices[i-1] = c.getString(c.getColumnIndex("choice"+i));
                }
                bean.setChoices(choices);
                return bean;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }
    public ArrayList<QuestionBean> select(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.query(table, null, null, null, null, null, null);
        questions.clear();
        if(c.getCount()!=0){
            while(c.moveToNext()){
                QuestionBean bean = new QuestionBean();
                bean.setId(c.getInt(c.getColumnIndex("id")));
                bean.setType(c.getInt(c.getColumnIndex("type")));
                bean.setQuestion(c.getString(c.getColumnIndex("question")));
                bean.setAnswer(c.getInt(c.getColumnIndex("answer")));
                String[] choices = new String[4];
                for(int i=1; i<5;i++){
                    choices[i-1] = c.getString(c.getColumnIndex("choice"+i));
                }
                bean.setChoices(choices);
                questions.add(bean);
            }
        }
        return questions;
    }

    public int update(QuestionBean bean){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", bean.getId());
        values.put("type", bean.getType());
        values.put("question", bean.getQuestion());
        values.put("answer", bean.getAnswer());
        for(int i=0; i<bean.getChoices().length;i++){
            int index = i+1;
            values.put("choice" + index, bean.getChoices()[i]);
        }
        return db.update(table, values, "id=?", new String[] {String.valueOf(bean.getId())});
    }

    public int delete(int id){
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(table, "id=?", new String[]{String.valueOf(id)});
    }
}
