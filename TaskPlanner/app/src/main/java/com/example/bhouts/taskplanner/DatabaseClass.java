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
import android.widget.Toast;

// need to import DatabaseOperations

public class DatabaseClass extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ProjectDB.db";

    private static final String TABLE = "projects";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "projectname";
    public static final String COLUMN_QUANTITY = "quantity";


    public DatabaseClass(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase dB) {
        String CREATE_TABLE_CLASS = "CREATE TABLE " + TABLE + "(" +
                COLUMN_ID + " " + "INTEGER PRIMARY KEY," +
                COLUMN_NAME + " TEXT," + ")";
//                COLUMN_QUANTITY + " INTEGER," + ")";


        dB.execSQL(CREATE_TABLE_CLASS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }

    public void addProject(Project mProject) {

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, mProject.getProjName());
//        values.put(COLUMN_QUANTITY, mProject.getQuantity());


        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE, null, values);
        db.close();
    }


    public void addQuantity(String name) {
        String query = "Select * FROM " + TABLE + " WHERE " + COLUMN_NAME + " =  \"" + name + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        ContentValues values = new ContentValues();

        values.put(COLUMN_QUANTITY, cursor.getInt(cursor.getColumnIndex(COLUMN_QUANTITY)) + 1);

        db.update(TABLE, values, COLUMN_NAME + " = '" + name + "'", null);
        cursor.close();
        db.close();
    }

    public void changeName(String name, String newname) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, newname);

        db.update(TABLE, values, COLUMN_NAME + " = '" + name + "'", null);
        db.close();
    }



    public void decrementQuantity(String projectname) {
        String query = "Select * FROM " + TABLE + " WHERE " + COLUMN_NAME + " =  \"" + projectname + "\"";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        ContentValues values = new ContentValues();

        values.put(COLUMN_QUANTITY, cursor.getInt(cursor.getColumnIndex(COLUMN_QUANTITY)) - 1);

        db.update(TABLE, values, COLUMN_NAME + " = '" + projectname + "'", null);
        cursor.close();
        db.close();
    }

    public Cursor getProjects() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT " + COLUMN_ID + ", " + COLUMN_NAME + ", " + COLUMN_QUANTITY + " FROM " + TABLE;
        Cursor cursor =  db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        return cursor;
    }


}