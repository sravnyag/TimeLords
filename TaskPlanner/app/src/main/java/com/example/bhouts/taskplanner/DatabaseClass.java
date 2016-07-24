package com.example.bhouts.taskplanner;

/**
 * Created by Jeffwag on 7/16/2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import android.util.Log;

// need to import DatabaseOperations

public class DatabaseClass extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ProjectDB.db";

    private static final String TABLE = "projects";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "projectname";


    public DatabaseClass(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dB) {
        String CREATE_TABLE_CLASS = "CREATE TABLE " + TABLE + "(" +
                COLUMN_ID + " " + "INTEGER PRIMARY KEY," +
                COLUMN_NAME + " TEXT," + ")";


        dB.execSQL(CREATE_TABLE_CLASS);
        Log.d("Database class", "One row inserted");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public void addProject(Project mProject) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, mProject.getProjName());


        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE, null, values);
        db.close();
        Log.d("addProject database", "values stored in database");
    }

    public void changeName(String name, String newname) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, newname);

        db.update(TABLE, values, COLUMN_NAME + " = '" + name + "'", null);
        db.close();
    }


    public Cursor getProjects() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT " + COLUMN_ID + ", " + COLUMN_NAME + " FROM " + TABLE;
        Cursor cursor =  db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        return cursor;
    }


}