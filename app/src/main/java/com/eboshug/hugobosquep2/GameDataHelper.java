package com.eboshug.hugobosquep2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GameDataHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "gamedatabase";
    private static final int DBVERSION = 1;

    public GameDataHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE GAMES (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT," +
                "DESCRIPTION TEXT," +
                "PRICE TEXT," +
                "IMAGE_ID INTEGER," +
                "NEW_GAME INTEGER," +
                "DISCOUNTED INTEGER" +
                ")");
        db.execSQL("CREATE TABLE SHOPPING_LIST(" +
                "_id INTEGER," +
                "FOREIGN KEY (_id) REFERENCES GAMES(_id) ON UPDATE CASCADE ON DELETE CASCADE" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor getShoppingList() {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("SELECT * FROM GAMES WHERE _id IN (SELECT _id FROM SHOPPING_LIST)", null);
    }

    public void addVideogame(String nombre, String descripcion, int precio, int img_id, int nuevo, int descuento) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues gameData = new ContentValues();
        gameData.put("NAME", nombre);
        gameData.put("DESCRIPTION", descripcion);
        gameData.put("PRICE", precio);
        gameData.put("IMAGE_ID", img_id);
        gameData.put("NEW_GAME", nuevo);
        gameData.put("DISCOUNTED", descuento);

        db.insert("GAMES", null, gameData);
    }
}
