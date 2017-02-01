package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by uday on 11/28/2016.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME ="shelter.db";


    public PetDbHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetsContract.PetEntry.TABLE_NAME+
                "("+ PetsContract.PetEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +PetsContract.PetEntry.COLUMN_PETS_NAME  +"" +" TEXT NOT NULL ,"
                + PetsContract.PetEntry.COLUMN_PETS_BREED+" TEXT, "
                + PetsContract.PetEntry.COLUMN_PETS_GENDER+ " INTEGER NOT NULL, "
                + PetsContract.PetEntry.COLUMN_PETS_WEIGHT+ " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(SQL_CREATE_PETS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
