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
        this.addVideogame(new VideoGame("Grand Theft Auto 5", "Cuando un joven " +
                "estafador callejero, un ladrón de bancos retirado y un psicópata aterrador se meten" +
                " en problemas, deberán llevar a cabo una serie de peligrosos atracos para sobrevivir" +
                " en una ciudad en la que no pueden confiar en nadie. Y mucho menos los unos en los otros.\n",
                19.95f, R.drawable.gta, 1, 0, "PS4"));
        this.addVideogame(new VideoGame("FIFA 21", "Siente a otro nivel con FIFA 21, " +
                "despliega todas tus tácticas de juego, pon a prueba tus dotes defensivas y asegúrate " +
                "de no dejar de marcar goles para convertirte de nuevo en leyenda en el simulador de " +
                "fútbol más completo de todos los tiempos.",
                19.95f, R.drawable.fifa, 1, 0, "PS4"));
        this.addVideogame(new VideoGame("Assassins Creed Valhalla", "En Assassin's" +
                " Creed Valhalla encarnarás a Eivor, una feroz leyenda vikinga criada entre historias " +
                "de batallas y gloria. Explora un hermoso mundo abierto y cambiante ambientado en la" +
                " despiadada Inglaterra de los años oscuros. Saquea a tus enemigos, haz prosperar tu" +
                " asentamiento y consolida tu poder político mientras luchas por ganarte un sitio " +
                "entre los dioses en el Valhalla.",
                59.90f, R.drawable.valhalla, 1, 0, "PS4"));
        this.addVideogame(new VideoGame("The Last of Us Remastered ", "Veinte años después de que una \" +\n" +
                "                \"plaga diezmara la civilización, los supervivientes se aferran a la vida en duras zonas \" +\n" +
                "                \"de cuarentena. En el exterior les esperan feroces infectados y despiadados bandidos \" +\n" +
                "                \"humanos. Para Joel, el día a día suele consistir en ir a lo suyo, pero cuando le \" +\n" +
                "                \"encargan acompañar a la joven Ellie en busca de las Luciérnagas, un grupo de la \" +\n" +
                "                \"resistencia, ambos pondrán al límite su voluntad de supervivencia.\", ",
                1.1f, R.drawable.tlou, 0, 0, "PS4"));
        this.addVideogame(new VideoGame("Red Dead Redemption II", "Ambientado en el " +
                "lejano oeste estadounidense y desarrollado en un entorno de mundo abierto con una " +
                "versión ficticia del oeste, el medio oeste y el sur de los Estados Unidos en 1899, " +
                "durante la segunda mitad de la era del Salvaje Oeste y el final de la era, a " +
                "comienzos del siglo XX.\n",
                1.95f, R.drawable.rdr2, 0, 1, "PS4"));
        this.addVideogame(new VideoGame("Horizon Zero Dawn Complete Edition",
                "En un exuberante mundo abierto postapocalíptico, seres mecanizados de " +
                        "dimensiones colosales dominan un territorio cuyo control han arrebatado a la humanidad.\n" +
                        "\n Con el tiempo, la evolución humana ha retrocedido hasta vivir en tribus " +
                        "de cazadores y recolectores, sobreviviendo entre bosques imponentes, enormes " +
                        "cordilleras y una atmósfera destruida por una civilización antigua. Mientras " +
                        "tanto, las salvajes máquinas se han hecho con el poder.",
                19.95f, R.drawable.zero_dawn, 0, 0, "PS4"));
        this.addVideogame(new VideoGame("Gran Turismo Sport Ps Hits", "Redescubre " +
                "la emoción del automovilismo\n Una revolución en las carreras\n" +
                "La premiada serie del simulador de conducción real llega por primera vez a PlayStation 4 para ponerte rumbo a una experiencia trepidante de alto octanaje.\n" +
                "\n Compartiendo el volante con la FIA (Fédération Internationale de l'Automobile), " +
                "Polyphony Digital ha diseñado un juego accesible y puesto a punto para que todo el " +
                "mundo lo disfrute, desde los pilotos menos experimentados hasta los ases del motor.\n" +
                "Abróchate el cinturón y prepárate para dos campeonatos online: representa a tu país " +
                "en la Copa de Naciones o conduce en nombre de tu marca de coches favorita en la Copa " +
                "de Fabricantes.",
                1.1f, R.drawable.gran_turismo, 0, 1, "PS4"));
        this.addVideogame(new VideoGame("Fortnite, Lote la Última Risa ", "Hazte con Fortnite La última risa del Jóker en PIUM GAMES y llévate de regalo este impresionante póster EXCLUSIVO para decorar tu habitación, el bus de batalla o tu casita en Alameda Afligida.",
                1.1f, R.drawable.fortnite, 0, 1, "PS4"));
        this.addVideogame(new VideoGame("Marvel's Spider-Man", "En Marvel's Spider-Man " +
                "encarnarás al superhéroe más emblemático del mundo y usarás las habilidades acrobáticas, " +
                "la improvisación y las telarañas que han hecho famoso al trepamuros. Además, introduce " +
                "elementos jamás vistos en un juego de Spider-Man. Desde cruzar la ciudad haciendo parkour " +
                "y usando el entorno hasta un sistema de combate novedoso y escenas nuevas de superproducción... " +
                "Este es un Spider-Man como nunca antes habías visto.",
                34.90f, R.drawable.spiderman, 0, 1, "PS4"));
        this.addVideogame(new VideoGame("Hot Wheels Unleashed", "Ponte al volante " +
                "de montones de vehículos con personalidad y estilo propios, rasgos diferentes y " +
                "niveles de rareza. ¡Lo mejor del universo HotWheels está aquí! Demuestra que eres " +
                "el mejor y desbloquea coches de primera calidad y objetos extraordinarios, y con " +
                "el editor convierte tu vehículo en una obra maestra de la velocidad única.",
                49.95f, R.drawable.hotwheels, 1, 0, "XBOX"));
        this.addVideogame(new VideoGame("Dying Light 2", "En Dying Light 2, el virus ha ganado. La última gran ciudad está al borde del colapso, sumida en una moderna era oscura. Como superviviente infectado, necesitarás usar tu agilidad, habilidades de combate e ingenio rápido para mantenerte con vida y traer esperanza a una ciudad sumida en la oscuridad. Todo esto y mucho más te espera en Dying Light 2, hazte con él en GAME.",
                69.95f, R.drawable.dying_light, 1, 0, "XBOX"));
        this.addVideogame(new VideoGame("Biomutant", "Biomutant es un esperado RPG donde su peculiar protagonista deberá unir a un mundo separado por una peligrosa plaga y una atmosfera dañada y cambiante.\n" +
                "\n ¿Te gustaría ser un mapache antropomórfico armado hasta los dientes, recorriendo un mundo post apocalíptico en multitud de vehículos y repartiendo golpes y disparos? ",
                54.95f, R.drawable.biomutant, 1, 0, "XBOX"));
        this.addVideogame(new VideoGame("Mass Effect", "Solo una persona se interpone entre la humanidad y la mayor amenaza a la que se haya enfrentado jamás. Revive la leyenda del comandante Shepard en la aclamada trilogía Mass Effect con Mass Effect Legendary Edition.",
                69.95f, R.drawable.mass_effect, 0, 0, "XBOX"));
        this.addVideogame(new VideoGame("HAlo Infinite", "El Jefe Maestro regresa en Halo Infinite: ¡el próximo capítulo de la legendaria franquicia que comienza en 2020!\n" +
                " \n Desarrollado por 343 Industries para toda la familia de dispositivos Xbox, incluyendo Project Scarlett y PC con Windows.\n" +
                "Halo Infinite continúa la trama de Halo 5: Guardians y toma la franquicia en direcciones ambiciosas e inesperadas.",
                69.95f, R.drawable.halo, 0, 0, "XBOX"));
        this.addVideogame(new VideoGame("Prince of Persia: Las Arenas del Tiempo Remake", "Prince of Persia: Las Arenas del Tiempo, publicado originalmente en 2003, dejó una huella imborrable en los jugadores gracias a sus innovadoras características de juego, a su historia cautivadora y a unos carismáticos personajes.\n" +
                "En las ardientes arenas de la antigua Persia, circula una leyenda en una lengua ancestral.\n" +
                "\n" +
                "Habla sobre una época escrita en sangre y gobernada por el engaño. Un joven príncipe, embaucado por los poderes oscuros de una daga mágica, libera un mortífero mal en un hermoso reino.",
                39.95f, R.drawable.prince_of_persia, 0, 0, "XBOX"));
        this.addVideogame(new VideoGame("Life is Strange: True Colors", "Tras la muerte de su hermano, supuestamente accidental, Alex debe aprender a controlar su poder para descubrir la verdad y los oscuros secretos que oculta un pueblo pequeño.",
                59.95f, R.drawable.life_is_strange, 0, 1, "XBOX"));
        this.addVideogame(new VideoGame("LEGO Star Wars", "La galaxia es tuya en LEGO® Star Wars™: La Saga Skywalker. En este nuevo videojuego, los jugadores vivirán momentos memorables y una acción constante procedente de las nueve películas de la saga Skywalker, todo narrado con el humor característico de LEGO®, incluyendo la esperada conclusión de la serie, Star Wars™: El ascenso de Skywalker.",
                59.95f, R.drawable.lego_star_wars, 0, 1, "XBOX"));
        this.addVideogame(new VideoGame("Tour de France 2021", "Un juego que no puede faltar entre tus simuladores deportivos.\n" +
                "\n" +
                "En el modo Equipo Pro, diriges un equipo que tendrá que demostrar su valía para alcanzar el puesto más alto de la clasificación de Pro Cycling. Tu equipo empieza desde abajo, pero podrás recibir invitaciones para participar en las carreras importantes si los organizadores ven que tus resultados son lo bastante buenos.",
                49.95f, R.drawable.tour, 0, 1, "XBOX"));
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
