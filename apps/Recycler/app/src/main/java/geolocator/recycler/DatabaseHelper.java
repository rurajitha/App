package geolocator.recycler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.SQLException;


/**
 * Created by tinu tony on 30/12/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    //The Android's default system path of your application database.
    private static final int DATABASE_VERSION = 1;


    private static String DB_PATH = "/data/data/geolocator.recycler/databases/";

    private static String DB_NAME = "geoLocationDB.db";

    private SQLiteDatabase myDataBase;

    String myPath = DB_PATH + DB_NAME;



    private final Context myContext;
    private SQLiteDatabase db;

    /**
     * Constructor
     * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
     * @param context
     */
    public DatabaseHelper(Context context) {

        super(context, DB_NAME, null, DATABASE_VERSION);
        this.myContext = context;






    }

    /**
     * Creates a empty database on the system and rewrites it with your own database.
     * */
    public void createDataBase() throws IOException{



        boolean dbExist = checkDataBase();

        if(dbExist){


            //do nothing - database already exist
        }else{

            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {

                throw new RuntimeException(e);

            }
        }

    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    public boolean checkDataBase(){

        SQLiteDatabase checkDB = null;

        try{
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);

        }catch(SQLiteException e){

            //database does't exist yet.

        }

        if(checkDB != null){

            checkDB.close();

        }

        return checkDB != null ? true : false;
    }

    /**
     * Copies your database from your local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     * */
    private void copyDataBase() throws IOException {

        //Open your local db as the input stream
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        File databaseFile = new File( "/data/data/geolocator.recycler/databases");
        databaseFile.mkdir();

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);




        }



        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();




    }

    public void openDataBase() throws SQLException {

        //Open the database
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

     //   myDataBase=db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

/*
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


//Toast.makeText(myContext,"oldversion "+oldVersion+"------newversion"+newVersion,Toast.LENGTH_LONG);
Log.d("dbversion","oldversion "+oldVersion+"------newversion"+newVersion);

myContext.deleteDatabase(DB_NAME);

//        File fdelete = new File(myPath);
//        fdelete.delete();

try {
copyDataBase();
} catch (IOException e) {
e.printStackTrace();
}


}
*/

    @Override
    public void onOpen(SQLiteDatabase db) {
        this.db = db;
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }


    public int insertFromFile(Context context, int resourceId) throws IOException {
        // Reseting Counter
        int result = 0;

        // Open the resource
        InputStream insertsStream = context.getResources().openRawResource(resourceId);
        BufferedReader insertReader = new BufferedReader(new InputStreamReader(insertsStream));

        // Iterate through lines (assuming each insert has its own line and theres no other stuff)
        while (insertReader.ready()) {
            String insertStmt = insertReader.readLine();
            myDataBase.execSQL(insertStmt);
            result++;
        }
        insertReader.close();

        // returning number of inserted rows
        return result;
    }



    public void copypasteDatabase(){


        myContext.deleteDatabase(DB_NAME);

        try {
            copyDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }







}