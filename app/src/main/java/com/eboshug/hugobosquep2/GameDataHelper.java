package com.eboshug.hugobosquep2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GameDataHelper extends SQLiteOpenHelper {

    private Context context;

    public GameDataHelper(Context context) {
        super(context, "gamedatabase", null, 1);
        this.context = context;
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
                "_id INTEGER UNIQUE," +
                "FOREIGN KEY (_id) REFERENCES GAMES(_id) ON UPDATE CASCADE ON DELETE CASCADE" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void mockData() {
        this.addVideogame(new VideoGame("Nombre1", "Descripcion1", 1.1f, R.drawable.ic_launcher_background, 1, 0, "PS4"));
        this.addVideogame(new VideoGame("Nombre2", "Descripcion2", 1.1f, R.drawable.ic_launcher_background, 1, 0, "PS4"));
        this.addVideogame(new VideoGame("Nombre3", "Descripcion3", 1.1f, R.drawable.ic_launcher_background, 1, 0, "PS4"));
        this.addVideogame(new VideoGame("Nombre4", "Descripcion4", 1.1f, R.drawable.ic_launcher_background, 0, 0, "PS4"));
        this.addVideogame(new VideoGame("Nombre5", "Descripcion5", 1.1f, R.drawable.ic_launcher_background, 0, 0, "PS4"));
        this.addVideogame(new VideoGame("Nombre6", "Descripcion6", 1.1f, R.drawable.ic_launcher_background, 0, 0, "PS4"));
        this.addVideogame(new VideoGame("Nombre7", "Descripcion7", 1.1f, R.drawable.ic_launcher_background, 0, 1, "PS4"));
        this.addVideogame(new VideoGame("Nombre8", "Descripcion8", 1.1f, R.drawable.ic_launcher_background, 0, 1, "PS4"));
        this.addVideogame(new VideoGame("Nombre9", "Descripcion9", 1.1f, R.drawable.ic_launcher_background, 0, 1, "PS4"));
        this.addVideogame(new VideoGame("Nombre10", "Descripcion10", 1.1f, R.drawable.ic_launcher_background, 1, 0, "XBOX"));
        this.addVideogame(new VideoGame("Nombre11", "Descripcion11", 1.1f, R.drawable.ic_launcher_background, 1, 0, "XBOX"));
        this.addVideogame(new VideoGame("Nombre12", "Descripcion12", 1.1f, R.drawable.ic_launcher_background, 1, 0, "XBOX"));
        this.addVideogame(new VideoGame("Nombre13", "Descripcion13", 1.1f, R.drawable.ic_launcher_background, 0, 0, "XBOX"));
        this.addVideogame(new VideoGame("Nombre14", "Descripcion14", 1.1f, R.drawable.ic_launcher_background, 0, 0, "XBOX"));
        this.addVideogame(new VideoGame("Nombre15", "Descripcion15", 1.1f, R.drawable.ic_launcher_background, 0, 0, "XBOX"));
        this.addVideogame(new VideoGame("Nombre16", "Descripcion16", 1.1f, R.drawable.ic_launcher_background, 0, 1, "XBOX"));
        this.addVideogame(new VideoGame("Nombre17", "Descripcion17", 1.1f, R.drawable.ic_launcher_background, 0, 1, "XBOX"));
        this.addVideogame(new VideoGame("Nombre18", "Descripcion18", 1.1f, R.drawable.ic_launcher_background, 0, 1, "XBOX"));
    }

    public List<VideoGame> getShoppingList() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM GAMES WHERE _id IN (SELECT _id FROM SHOPPING_LIST)", null);
        List<VideoGame> listaVideoJuegos = new ArrayList<VideoGame>(cursor.getCount());

        int[] nameIndex = {cursor.getColumnIndex("NAME"),
                cursor.getColumnIndex("DESCRIPTION"),
                cursor.getColumnIndex("PRICE"),
                cursor.getColumnIndex("IMAGE_ID"),
                cursor.getColumnIndex("NEW_GAME"),
                cursor.getColumnIndex("DISCOUNTED"),
                cursor.getColumnIndex("CONSOLE")
        };

        while(cursor.moveToNext()) {
            listaVideoJuegos.add(new VideoGame(
                    cursor.getString(nameIndex[0]),
                    cursor.getString(nameIndex[1]),
                    cursor.getFloat(nameIndex[2]),
                    cursor.getInt(nameIndex[3]),
                    cursor.getInt(nameIndex[4]),
                    cursor.getInt(nameIndex[5]),
                    cursor.getString(nameIndex[6])
            ));
        }


        cursor.close();

        return listaVideoJuegos;

    }

    public ArrayList<VideoGame> getNovedades() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM GAMES WHERE NEW_GAME=1", null);
        ArrayList<VideoGame> listaNovedades = new ArrayList<VideoGame>(cursor.getCount());

        int[] nameIndex = {cursor.getColumnIndex("NAME"),
                cursor.getColumnIndex("DESCRIPTION"),
                cursor.getColumnIndex("PRICE"),
                cursor.getColumnIndex("IMAGE_ID"),
                cursor.getColumnIndex("NEW_GAME"),
                cursor.getColumnIndex("DISCOUNTED"),
                cursor.getColumnIndex("CONSOLE")
        };

        while(cursor.moveToNext()) {
            listaNovedades.add(new VideoGame(
                    cursor.getString(nameIndex[0]),
                    cursor.getString(nameIndex[1]),
                    cursor.getFloat(nameIndex[2]),
                    cursor.getInt(nameIndex[3]),
                    cursor.getInt(nameIndex[4]),
                    cursor.getInt(nameIndex[5]),
                    cursor.getString(nameIndex[6])
            ));
        }


        return listaNovedades;

    }

    public ArrayList<VideoGame> getOfertas() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM GAMES WHERE DISCOUNTED=1", null);
        ArrayList<VideoGame> listaOfertas = new ArrayList<VideoGame>(cursor.getCount());

        int[] nameIndex = {cursor.getColumnIndex("NAME"),
                cursor.getColumnIndex("DESCRIPTION"),
                cursor.getColumnIndex("PRICE"),
                cursor.getColumnIndex("IMAGE_ID"),
                cursor.getColumnIndex("NEW_GAME"),
                cursor.getColumnIndex("DISCOUNTED"),
                cursor.getColumnIndex("CONSOLE")
        };

        while(cursor.moveToNext()) {
            listaOfertas.add(new VideoGame(
                    cursor.getString(nameIndex[0]),
                    cursor.getString(nameIndex[1]),
                    cursor.getFloat(nameIndex[2]),
                    cursor.getInt(nameIndex[3]),
                    cursor.getInt(nameIndex[4]),
                    cursor.getInt(nameIndex[5]),
                    cursor.getString(nameIndex[6])
            ));
        }

        cursor.close();

        return listaOfertas;

    }

    public ArrayList<VideoGame> getPS4Games() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM GAMES WHERE CONSOLE='PS4'", null);
        ArrayList<VideoGame> listaJuegos = new ArrayList<VideoGame>(cursor.getCount());

        int[] nameIndex = {cursor.getColumnIndex("NAME"),
                cursor.getColumnIndex("DESCRIPTION"),
                cursor.getColumnIndex("PRICE"),
                cursor.getColumnIndex("IMAGE_ID"),
                cursor.getColumnIndex("NEW_GAME"),
                cursor.getColumnIndex("DISCOUNTED"),
                cursor.getColumnIndex("CONSOLE")
        };

        while(cursor.moveToNext()) {
            listaJuegos.add(new VideoGame(
                    cursor.getString(nameIndex[0]),
                    cursor.getString(nameIndex[1]),
                    cursor.getFloat(nameIndex[2]),
                    cursor.getInt(nameIndex[3]),
                    cursor.getInt(nameIndex[4]),
                    cursor.getInt(nameIndex[5]),
                    cursor.getString(nameIndex[6])
            ));
        }


        return listaJuegos;

    }

    public ArrayList<VideoGame> getXBOXGames() {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM GAMES WHERE CONSOLE='XBOX'", null);
        ArrayList<VideoGame> listaJuegos = new ArrayList<VideoGame>(cursor.getCount());

        int[] nameIndex = {cursor.getColumnIndex("NAME"),
                cursor.getColumnIndex("DESCRIPTION"),
                cursor.getColumnIndex("PRICE"),
                cursor.getColumnIndex("IMAGE_ID"),
                cursor.getColumnIndex("NEW_GAME"),
                cursor.getColumnIndex("DISCOUNTED"),
                cursor.getColumnIndex("CONSOLE")
        };

        while(cursor.moveToNext()) {
            listaJuegos.add(new VideoGame(
                    cursor.getString(nameIndex[0]),
                    cursor.getString(nameIndex[1]),
                    cursor.getFloat(nameIndex[2]),
                    cursor.getInt(nameIndex[3]),
                    cursor.getInt(nameIndex[4]),
                    cursor.getInt(nameIndex[5]),
                    cursor.getString(nameIndex[6])
            ));
        }


        return listaJuegos;

    }

    public void addToShoppingList(VideoGame videogame) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.execSQL("INSERT INTO SHOPPING_LIST (_id) VALUES ((SELECT _id FROM GAMES WHERE NAME='" + videogame.getNombre() + "'))");
        } catch (SQLiteConstraintException e) {
            Log.d("DATABASE", "addToShoppingList: Game already in shopping list");
        }

    }

    public void removeFromShoppingList(VideoGame videogame) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM SHOPPING_LIST " +
                "WHERE _id IN ((SELECT _id FROM GAMES WHERE NAME='" + videogame.getNombre() + "'))");
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
