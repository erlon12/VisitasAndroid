package com.example.visitasappsqlite.DB;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class dbVisitas extends SQLiteOpenHelper {

    private static final String DATABASE ="dbVisitas.db";
    private static  final int VERSION = 1;



    public dbVisitas(Context context){
        super(context,DATABASE,null,VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String sql = "create table estabelecimento(" +
                "_id integer primary key autoincrement, " +
                "numero integer, " +
                "cnpj integer, "+
                "razao text, " +
                "cep text, "+
                "cidade text);";
        try{

            db.execSQL(sql);


        }catch (SQLException e){

            Log.e(null, "Erro ao criar Banco " + e.getMessage());
        }




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + "cidade");


        // create new tables
        onCreate(db);

    }
}
