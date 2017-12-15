package com.example.familia.sqliteaad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by yo.
 */
public class MyDBAdapter {

    // Definiciones y constantes
    private static final String DATABASE_NAME = "florida.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =   "CREATE TABLE estudiantes (_id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso text, nota integer);"+
                                                    "CREATE TABLE profesores (_id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso text, despacho text);";
    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS estudiantes;"+
                                                "DROP TABLE IF EXISTS profesores;";

    // Contexto de la aplicación que usa la base de datos
    private final Context context;
    // Clase SQLiteOpenHelper para crear/actualizar la base de datos
    private MyDbHelper dbHelper;
    // Instancia de la base de datos
    private SQLiteDatabase db;

    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        open();
        consultarEstudiantes();
    }

    public void open(){

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }

//    public void insertarDisco(String t, int y){
//        //Creamos un nuevo registro de valores a insertar
//        ContentValues newValues = new ContentValues();
//        //Asignamos los valores de cada campo
//        newValues.put(TITLE,t);
//        newValues.put(YEAR,y);
//        db.insert(DATABASE_TABLE,null,newValues);
//    }

    public void insertarEstudiante(String nombre, String ciclo, String curso, int edad, int nota) {
        db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",nombre);
        contentValues.put("edad", edad);
        contentValues.put("ciclo", ciclo);
        contentValues.put("curso", curso);
        contentValues.put("nota", nota);
        db.insert("estudiantes", null, contentValues);
        Toast.makeText(context, "Estudiante "+nombre+" añadido", Toast.LENGTH_SHORT).show();
    }

    public void insertarProfesor(String nombre, String ciclo, String curso, int edad, String despacho) {
        db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",nombre);
        contentValues.put("edad", edad);
        contentValues.put("ciclo", ciclo);
        contentValues.put("curso", curso);
        contentValues.put("despacho", despacho);
        db.insert("profesores", null, contentValues);
        Toast.makeText(context, "Profesor "+nombre+" añadido", Toast.LENGTH_SHORT).show();
    }

    public void consultarEstudiantes() {
        
        Cursor c = db.rawQuery("SELECT * FROM estudiantes; ", null);
        if (c.moveToFirst()){
            do {
                // Passing values
                Log.e("consulta estudiantes", c.getString(0)+", "+c.getString(1));
                // Do something Here with values
            } while(c.moveToNext());
        }
        c.close();
        db.close();
    }

    public void eliminarEstudiante(int id) {
        db = dbHelper.getWritableDatabase();
        db.delete("estudiantes", "_id="+id, null);
        Toast.makeText(context, "Estudiante "+id+" eliminado", Toast.LENGTH_SHORT).show();
    }

    public void eliminarProfesor(int id) {
        db = dbHelper.getWritableDatabase();
        db.delete("profesores", "_id="+id, null);
        Toast.makeText(context, "Profesor "+id+" eliminado", Toast.LENGTH_SHORT).show();
    }

    public void eliminarDB() {
        context.deleteDatabase(DATABASE_NAME);
        Toast.makeText(context, "Base de datos borrada", Toast.LENGTH_SHORT).show();
    }

    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP);
            onCreate(db);
        }

    }
}