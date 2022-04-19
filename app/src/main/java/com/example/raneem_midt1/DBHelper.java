package com.example.raneem_midt1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final  String db="user.db";
    public static final  String table="user_data";
    Context c;
    public DBHelper(Context context){
        super(context,db,null,1);
        c=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String dbQuery = "CREATE TABLE user_data (id INTEGER,name TEXT, surname TEXT,nid INTEGER)";
        sqLiteDatabase.execSQL(dbQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertPerson(String id,String name,String surname,String nid) {
        String query = "INSERT INTO " + table+ " VALUES (?,?,?,?)";
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(query, new String[]{id,name,surname,nid});
        db.close();
        Toast.makeText(c, "Inserted!", Toast.LENGTH_SHORT).show();
    }
    public void deletePerson(String query) {
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = "name=? or ";
        String whereArgs[] = {query};
        db.delete(table, whereClause, whereArgs);
        Toast.makeText(c, "Deleted!", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<User> readUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + table, null);
        ArrayList<User> users = new ArrayList<User>();

        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                users.add(new User(cursorCourses.getString(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        cursorCourses.close();
        return users;
    }
}
