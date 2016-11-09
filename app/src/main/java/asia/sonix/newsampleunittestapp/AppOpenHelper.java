package asia.sonix.newsampleunittestapp;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AppOpenHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;

    public AppOpenHelper(Context context) {
        super(context, "app", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table stock(_id integer primary key autoincrement, name text not null, price integer not null, createdAt integer not null);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}




















