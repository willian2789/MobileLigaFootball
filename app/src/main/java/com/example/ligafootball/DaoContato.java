package com.example.ligafootball;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DaoContato extends SQLiteOpenHelper {

    private final String TABELA = "DB_LIGAFOOTBALL";
    public DaoContato(@Nullable Context context) {
        super(context,  "DB_LIGA", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String comando = "CREATE TABLE " + TABELA +  "(" +
                "ID INTEGER PRIMARY KEY," +
                "NOME VARCHAR(100)," +
                "LIGA VARCHAR(50)," +
                "PAIS VARCHAR(40),"+
                "CAMPEONATO VARCHAR(40))";

        db.execSQL(comando);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long inserir(DtoContato contato){
        ContentValues values = new ContentValues();// associa os campos da coluna aos valores da coluna
        values.put("NOME", contato.getNome());
        values.put("LIGA", contato.getLiga());
        values.put("PAIS", contato.getPais());
        values.put("CAMPEONATO",contato.getCampeonato());

        return getWritableDatabase().insert(TABELA, null, values);

    }

    public ArrayList<DtoContato> consultarTodos(){
        String comando = "SELECT * FROM " + TABELA;

        Cursor cursor = getReadableDatabase().rawQuery(comando,null);
        ArrayList<DtoContato> arrayListContato = new ArrayList<>();

        while(cursor.moveToNext()){
            DtoContato dtoContato = new DtoContato();
            dtoContato.setId(cursor.getInt(0));
            dtoContato.setNome(cursor.getString(1));
            dtoContato.setLiga(cursor.getString(2));
            dtoContato.setPais(cursor.getString(3));
            dtoContato.setCampeonato(cursor.getString(4));

            arrayListContato.add(dtoContato);
        }

        return arrayListContato;

    }

    public ArrayList<DtoContato> consultaPorNome(String nome){
        String comando = "SELECT * FROM " + TABELA + " WHERE NOME LIKE ?";
        String[] args = {"%"+nome+"%"};

        Cursor cursor = getReadableDatabase().rawQuery(comando, args);

        ArrayList<DtoContato> arrayListContato = new ArrayList<>();

        while(cursor.moveToNext()){
            DtoContato dtoContato = new DtoContato();
            dtoContato.setId(cursor.getInt(0));
            dtoContato.setNome(cursor.getString(1));
            dtoContato.setLiga(cursor.getString(2));
            dtoContato.setPais(cursor.getString(3));
            dtoContato.setCampeonato(cursor.getString(4));

            arrayListContato.add(dtoContato);
        }

        return arrayListContato;

    }

    public ArrayList<DtoContato> consultaPorLiga(String num){
        String comando = "SELECT * FROM " + TABELA + " WHERE LIGA LIKE ?";
        String[] args = {"%"+num+"%"};

        Cursor cursor = getReadableDatabase().rawQuery(comando, args);

        ArrayList<DtoContato> arrayListContato = new ArrayList<>();

        while(cursor.moveToNext()){
            DtoContato dtoContato = new DtoContato();
            dtoContato.setId(cursor.getInt(0));
            dtoContato.setNome(cursor.getString(1));
            dtoContato.setLiga(cursor.getString(2));
            dtoContato.setPais(cursor.getString(3));
            dtoContato.setCampeonato(cursor.getString(4));
            arrayListContato.add(dtoContato);
        }

        return arrayListContato;

    }

    public int excluir(DtoContato contato) {

        String id = "id=?";
        String[] args = {contato.getId()+""};
        return getWritableDatabase().delete(TABELA,id,args);
    }

    public long alterar(DtoContato contato) {
        ContentValues values = new ContentValues();// asocia os campos da coluna aos valores da coluna
        values.put("NOME", contato.getNome());
        values.put("LIGA", contato.getLiga());
        values.put("PAIS", contato.getPais());
        values.put("CAMPEONATO", contato.getCampeonato());
        String id = "id=?";
        String[] args = {contato.getId()+""};
        return getWritableDatabase().update(TABELA, values, id, args);
    }
}
