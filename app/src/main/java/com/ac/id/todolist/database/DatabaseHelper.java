package com.ac.id.todolist.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ac.id.todolist.model.ProfileModel;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import static android.database.sqlite.SQLiteDatabase.openDatabase;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String nama;
    public static String email;
    public static String pass;
    public static String alamat;
    public static String status;
    public static String pendidikan;
    public static int UID;

    public static final String tabel_profile = "tabel_profile";
    public static final String uid = "ID";
    public static final String mnama = "nama";
    public static final String memail = "email";
    public static final String mpass = "pass";
    public static final String malamat = "alamat";
    public static final String mpendidikan = "pendidikan";
    public static final String mCOLUMN_ID = "ID";

    public static  String _NAMA_DATABASE="com.uas.todolist.db";
    public static int _VERSION = 1;
    public static String _CREATE_TABLE = "create table tabel_profile (UID INTEGER, email TEXT, pass TEXT, nama TEXT, alamat TEXT, status TEXT, pendidikan TEXT,  PRIMARY KEY(UID) )";
    private static final String DATABASE_PATH = "/data/data/com.ac.id.com.uas.todolist.database/";;

    SQLiteDatabase db;
    public DatabaseHelper(@Nullable Context context) {
        super(context, _NAMA_DATABASE, null, _VERSION);
    }

     @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + tabel_profile + " (" + uid+ " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                mnama + " TEXT, " + memail + " TEXT, " + mpass + " TEXT, " + malamat + " TEXT, " + mpendidikan + " TEXT)";

        db.execSQL(createTableStatement);

    }

    public boolean addOne(ProfileModel profileModel) {

        SQLiteDatabase db = this.getWritableDatabase();  //getWDB berasal dari propertinya si SQLDBH
        ContentValues cv = new ContentValues();

        //cv.put(tabel_profile, profileModel.getNama()); //memang sifatnya class ContentValue yang menyimpan data secara berpasangan >> "name", nilai name
        cv.put(mnama, profileModel.getNama());
        cv.put(memail, profileModel.getEmail());
        cv.put(mpass, profileModel.getPass());
        cv.put(malamat, profileModel.getAlamat());
        cv.put(mpendidikan, profileModel.getPendidikan());

        long insert = db.insert(tabel_profile, null, cv); //Insert bernilai -1 jika insert gagal.
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    public ArrayList<ProfileModel> getData() {
        ArrayList<ProfileModel> list = new ArrayList();
        String queryString = "SELECT * FROM " + tabel_profile;

        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery(queryString,null);
        if(cursor.moveToFirst()) {
            do {
                UID = cursor.getInt(0);
                nama = cursor.getString(1);
                email = cursor.getString(2);
                pass = cursor.getString(3);
                alamat = cursor.getString(4);
                status = cursor.getString(5);
                pendidikan = cursor.getString(6);

                ProfileModel newProfile = new ProfileModel(UID, email, pass, alamat, status, pendidikan);
                list.add(newProfile);
            } while (cursor.moveToNext());
        }
        else {}
        cursor.close();;
        database.close();

        return  list;

        }


    /*@Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(_CREATE_TABLE);
    }*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tabel_profile");
        onCreate(db);
    }

    public boolean chkEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tabel_profile where email = ?", new String[] {email});
        if(cursor.getCount() > 0){return true;}
        else{return false;}

    }

    public boolean chkSEmail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from tabel_profile where email = ?", new String[] {email});
        if(cursor.getCount() > 0){return false;}
        else{return true;}

    }
    /*
    public boolean checkUserExist(String username, String password){
        String[] columns = {"username"};
        //db = openDatabase();
        SQLiteDatabase db = this.getReadableDatabase();

        String queryString = "SELECT " + email + " FROM " + tabel_profile;

        String selection = "username=? and password = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.rawQuery(queryString, null);

        //Cursor cursor = db.query(tabel_profile, columns, selection, selectionArgs, null, null, null);
        int count = cursor.getCount();

        cursor.close();
        close();

        if(count > 0){
            return true;
        } else {
            return false;
        }
    }



    private SQLiteDatabase openDatabase() {
        String path = DATABASE_PATH + _NAMA_DATABASE;
        db = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        return db;
    }*/
}
