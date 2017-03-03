package baltamon.mx.localstoragepractice.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Baltazar Rodriguez on 03/03/2017.
 */

public class FriendsSQLiteHelper extends SQLiteOpenHelper {

    //CREATE TABLE
    String sqlCreate = "CREATE TABLE Friends (" +
            "ID INTEGER AUTOINCREMENT PRIMARY KEY," +
            "FIRST_NAME TEXT NOT NULL," +
            "LAST_NAME TEXT NOT NULL," +
            "EMAIL TEXT NOT NULL," +
            "PHONE TEXT NOT NULL" +
            ")";

    /*String sqlCreate = "CREATE TABLE Usuarios (codigo INTEGER, nombre TEXT)";*/
    public FriendsSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public FriendsSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        /*
        IN CASE WE CHANGE THE SCHEDULE, THEN WE DELETE THE TABLE TO CREATE ANOTHER ONE
        THIS ALSO DELETE THE CURRENT INFORMATION INTO THE TABLE
         */
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Friends");
        sqLiteDatabase.execSQL(sqlCreate);
    }
}
