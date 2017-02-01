package com.example.android.pets.data;

import android.provider.BaseColumns;

/**
 * Created by uday on 11/28/2016.
 */

public final class  PetsContract {

    public static  final class PetEntry  implements BaseColumns
    {
        public final static String TABLE_NAME = "pets";

        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PETS_NAME = "name";
        public final static String COLUMN_PETS_BREED = "breed";
        public final static String COLUMN_PETS_GENDER = "gender";
        public final static String COLUMN_PETS_WEIGHT = "weight";

        public final static int GENDER_UNKNOWN = 0;
        public final static int GENDER_MALE = 1;
        public final static int GENDER_FEMALE = 2;


    }


}
