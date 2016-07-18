package com.example.jeffwag.sprint1;

/**
 * Created by Jeffwag on 7/8/2016.
 *
 * I am not 100% if this is working properly I made though a few tutorials
 * and I have a friend that has had experience with databases for android apps
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseOperations extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "assignmentDB.db";
    private static final String TABLE = "assignments";
    public static final String ID = "id";
    public static final String PROJECT = "project";
    public static final String TASK_NAME = "taskname";
    public static final String PROJECT_NAME = "projectname";
    public static final String NOTES = "notes";
    public static final String DUE_DATE = "duedate";
    public static final String COMPLETED = "completed";

    public DatabaseOperations(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_CLASS = "CREATE TABLE " + TABLE + "(" +
                ID + " " + "INTEGER PRIMARY KEY," +
                PROJECT + " " + " TEXT," +
                TASK_NAME + " TEXT," +
                PROJECT_NAME + "TEXT," +
                NOTES + " TEXT," +
                COMPLETED + "TEXT," +
                DUE_DATE + " TEXT" + ")";

        db.execSQL(CREATE_TABLE_CLASS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
    public void addTask(Task task) {

        ContentValues values = new ContentValues();
        values.put(PROJECT, task.getParentClass());
        values.put(TASK_NAME, task.getName());
        values.put(PROJECT_NAME, task.getProName());
        values.put(NOTES, task.getNotes());
        values.put(COMPLETED, task.getComp());
        values.put(DUE_DATE, task.getDueDate());
        

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE, null, values);
        db.close();
    }
    public Cursor getTasks(String Project) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE + " WHERE " + PROJECT + " = '" + Project + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        return cursor;
    }
    
    public void changeName(String name, String newname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TASK_NAME, newname);
        db.update(TABLE, values, TASK_NAME + " = '" + name + "'", null);
        db.close();
    }

    public void changeNotes(String notes, String newnotes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOTES, newnotes);
        db.update(TABLE, values, NOTES + " = '" + notes + "'", null);
        db.close();
    }

    public void changeProName(String name, String newname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PROJECT_NAME, newname);
        db.update(TABLE, values, PROJECT_NAME + " = '" + name + "'", null);
        db.close();
    }


    public void changeClass(String name, String newname) {
        String query = "Select * FROM " + TABLE + " WHERE " + PROJECT + " =  \"" + name + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        ContentValues values = new ContentValues();
        values.put(PROJECT, newname);
        if(cursor.moveToFirst()) {
            db.update(TABLE, values, PROJECT + " = '" + name + "'", null);
        }
        cursor.close();
        db.close();
    }

}
