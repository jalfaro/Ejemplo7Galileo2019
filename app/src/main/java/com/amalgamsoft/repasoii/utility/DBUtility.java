package com.amalgamsoft.repasoii.utility;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.amalgamsoft.repasoii.data.Grado;
import com.amalgamsoft.repasoii.data.Nivel;

import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    public final static String DB_NAME = "escuela";
    public final static int DB_VER = 1;

    private DBHelper conn;
    private Context context;

    public DBUtility(Context context) {
        this.context = context;
        conn = new DBHelper(context);
    }

    public List<Nivel> getNiveles() {
        List<Nivel> list = null;
        Nivel temp;
        String query = "SELECT id, nombre FROM nivel";
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);
        if (c != null && c.getCount() > 0) {
            list = new ArrayList<Nivel>();
            c.moveToFirst();
            while (!c.isAfterLast()) {
                temp = new Nivel();
                temp.setId(c.getInt(c.getColumnIndex("id")));
                temp.setNombre(c.getString(c.getColumnIndex("nombre")));
                list.add(temp);
                c.moveToNext();
            }

        }
        return list;
    }

    public List<Grado> getGrados(int idNivel) {
        List<Grado> list = null;
        Grado temp;
        String query = "SELECT id, id_nivel, nombre FROM grado WHERE id_nivel = " + idNivel;
        SQLiteDatabase db = conn.getReadableDatabase();
        Cursor c = db.rawQuery(query, null);
        if (c != null && c.getCount() > 0) {
            list = new ArrayList<Grado>();
            c.moveToFirst();
            while (! c.isAfterLast()) {
                temp = new Grado();
                temp.setId(c.getInt(c.getColumnIndex("id")));
                temp.setIdNivel(c.getInt(c.getColumnIndex("id_nivel")));
                temp.setNombre(c.getString(c.getColumnIndex("nombre")));
                list.add(temp);
                c.moveToNext();
            }
        }
        return list;
    }




    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(@Nullable Context context) {
            super(context, DB_NAME, null, DB_VER);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query = "CREATE TABLE nivel (id INTEGER PRIMARY KEY, nombre TEXT)";
            db.execSQL(query);
            query = "CREATE TABLE grado (id INTEGER PRIMARY KEY, id_nivel INTEGER, nombre TEXT)";
            db.execSQL(query);
            query = "INSERT INTO nivel (id, nombre) VALUES (1, 'pre-primaria')";
            db.execSQL(query);
            query = "INSERT INTO nivel (id, nombre) VALUES (2, 'primaria')";
            db.execSQL(query);
            query = "INSERT INTO nivel (id, nombre) VALUES (3, 'secundaria')";
            db.execSQL(query);

            query = "INSERT INTO grado (id, id_nivel, nombre) VALUES (1, 1, 'prekinder')";
            db.execSQL(query);
            query = "INSERT INTO grado (id, id_nivel, nombre) VALUES (2, 1, 'kinder')";
            db.execSQL(query);
            query = "INSERT INTO grado (id, id_nivel, nombre) VALUES (3, 1, 'preparatoria')";
            db.execSQL(query);

            query = "INSERT INTO grado (id, id_nivel, nombre) VALUES (4, 2, 'primero')";
            db.execSQL(query);
            query = "INSERT INTO grado (id, id_nivel, nombre) VALUES (5, 2, 'segundo')";
            db.execSQL(query);
            query = "INSERT INTO grado (id, id_nivel, nombre) VALUES (6, 2, 'tercero')";
            db.execSQL(query);
            query = "INSERT INTO grado (id, id_nivel, nombre) VALUES (7, 2, 'cuarto')";
            db.execSQL(query);
            query = "INSERT INTO grado (id, id_nivel, nombre) VALUES (8, 2, 'quinto')";
            db.execSQL(query);
            query = "INSERT INTO grado (id, id_nivel, nombre) VALUES (9, 2, 'sexto')";
            db.execSQL(query);

            query = "INSERT INTO grado (id, id_nivel, nombre) VALUES (10, 3, 'primero basico')";
            db.execSQL(query);
            query = "INSERT INTO grado (id, id_nivel, nombre) VALUES (11, 3, 'segundo basico')";
            db.execSQL(query);
            query = "INSERT INTO grado (id, id_nivel, nombre) VALUES (12, 3, 'tercero basico')";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
