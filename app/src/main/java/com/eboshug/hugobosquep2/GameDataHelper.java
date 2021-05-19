package com.eboshug.hugobosquep2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

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
                "PRICE REAL," +
                "IMAGE_ID INTEGER," +
                "NEW_GAME INTEGER," +
                "DISCOUNTED INTEGER," +
                "CONSOLE TEXT" +
                ")");
        db.execSQL("CREATE TABLE SHOPPING_LIST(" +
                "_id INTEGER," +
                "FOREIGN KEY (_id) REFERENCES GAMES(_id) ON UPDATE CASCADE ON DELETE CASCADE" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List<VideoGame> getShoppingList() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM GAMES WHERE _id IN (SELECT _id FROM SHOPPING_LIST)", null);

        List<VideoGame> listaVideoJuegos = new ArrayList<VideoGame>(cursor.getCount());

        while (cursor.moveToNext()) {
            listaVideoJuegos.add(new VideoGame(
                    cursor.getString(cursor.getColumnIndex("NAME")),
                    cursor.getString(cursor.getColumnIndex("DESCRIPTION")),
                    cursor.getFloat(cursor.getColumnIndex("PRICE")),
                    cursor.getInt(cursor.getColumnIndex("IMAGE_ID")),
                    cursor.getInt(cursor.getColumnIndex("NEW_GAME")),
                    cursor.getInt(cursor.getColumnIndex("DISCOUNTED")),
                    cursor.getString(cursor.getColumnIndex("CONSOLE"))
            ));

        }

        return listaVideoJuegos;

    }

    public void addVideogame(VideoGame game) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues gameData = new ContentValues();
        gameData.put("NAME", game.getNombre());
        gameData.put("DESCRIPTION", game.getDescripcion());
        gameData.put("PRICE", game.getPrecio());
        gameData.put("IMAGE_ID", game.getImg_id());
        gameData.put("NEW_GAME", game.getNuevo());
        gameData.put("DISCOUNTED", game.getDescuento());
        gameData.put("CONSOLE", game.getConsola());

        db.insert("GAMES", null, gameData);
    }
}
