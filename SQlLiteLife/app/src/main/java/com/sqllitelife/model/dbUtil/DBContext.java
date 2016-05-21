package com.sqllitelife.model.dbUtil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.sqllitelife.model.entity.Calisan;
import com.sqllitelife.util.Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Samir on 8.5.2016.
 */
public final class DBContext {

    private static DBContext INSTANCE;
    private Context context;
    private DBHelper dbHelper;

    private DBContext(Context context) {
        // burda bu methodu kullanan activity ile eileştiriyoruz
        this.dbHelper = new DBHelper(context);
    }

    public static DBContext getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DBContext(context);
        }
        return INSTANCE;
    }

    public boolean insertEmpolyee(Calisan calisan) {
        boolean result = false;
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COLUMN_FIRST_NAME, calisan.getAd());
        contentValues.put(DBHelper.COLUMN_LAST_NAME, calisan.getSoyad());

        SQLiteDatabase database = dbHelper.getWritableDatabase();
        /*
        bu dbhelper nesnesi üzerinden getWritableDatabase methodu ile  çok basit yapılandırma gereksinimi olmayan işlemsel
        ve ilişkisel bir veri tabanı oluşturuyoruz
        * */

        long id = database.insert(DBHelper.TABLE_NAME, null, contentValues); //etkilenen satır sayısı veri geldigi için ıd olusuyor
        if (id != 1) {
            // calısan ıd si gerekiyorsa id yı burda yukledik
            // işlem başarılı olursa method true doner
            calisan.setId(id);
            result = true;
        }
        //database.close();
        return result;
    }

    public List<Calisan> getAllEmployees() {
        List<Calisan> calisanlar = new ArrayList<Calisan>();

        SQLiteDatabase database = dbHelper.getReadableDatabase();

        final String kolonlar[] = {DBHelper.COLUMN_ID, DBHelper.COLUMN_FIRST_NAME, DBHelper.COLUMN_LAST_NAME};
        Cursor cursor = database.query(DBHelper.TABLE_NAME, kolonlar, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Calisan calisan = new Calisan();
            calisan.setId(cursor.getLong(cursor.getColumnIndex(DBHelper.COLUMN_ID)));
            calisan.setAd(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_FIRST_NAME)));
            calisan.setSoyad(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_LAST_NAME)));
            calisanlar.add(calisan);
        }
        //database.close();
        return calisanlar;
    }

    public Calisan findById(long id) {
        Calisan calisan = null;
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        final String kolonlar[] = {DBHelper.COLUMN_ID, DBHelper.COLUMN_FIRST_NAME, DBHelper.COLUMN_LAST_NAME};
        // prepare statement mantıgı ile yak
        final String selecton = DBHelper.COLUMN_ID + "=?";
        final String[] selectionArgs = {String.valueOf(id)}; // seç,m yapacagım arguman dizisi içerisinde id dizisi var
        Cursor cursor = database.query(DBHelper.TABLE_NAME, kolonlar, selecton, selectionArgs, null, null, null);

        while (cursor.moveToNext()) {
            calisan = new Calisan();
            calisan.setId(cursor.getLong(cursor.getColumnIndex(DBHelper.COLUMN_ID)));
            calisan.setAd(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_FIRST_NAME)));
            calisan.setSoyad(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_LAST_NAME)));
        }
        return calisan;
    }

    public boolean deleteEmpoloyee(long id) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        final String whereClause = DBHelper.COLUMN_ID + "=?";
        final String whereArgs[] = {String.valueOf(id)};
        int affectedRows = database.delete(DBHelper.TABLE_NAME, whereClause, whereArgs);
        return affectedRows > 0;
    }

    public int deleteById(String id) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        return database.delete(DBHelper.TABLE_NAME, "ID = ?", new String[]{id});
        // return bize etkilenen sıra sayısınıını temsil eder
    }

    public int updateById(String ad, String soyad, String id) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COLUMN_FIRST_NAME, ad);
        contentValues.put(DBHelper.COLUMN_LAST_NAME, soyad);
        return database.update(DBHelper.TABLE_NAME, contentValues, "ID = ?", new String[]{id});
    }



    public boolean updateEmployee(String oldName, String newName) {
        boolean result = false;
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COLUMN_FIRST_NAME, newName);
        String whereClause = DBHelper.COLUMN_FIRST_NAME + "=?";
        final String whereArgs[] = {oldName};// old nameler tranıyor
        int affectedRows = database.update(DBHelper.TABLE_NAME, contentValues, whereClause, whereArgs);
        return affectedRows > 0;
    }

    private class DBHelper extends SQLiteOpenHelper {
        private final Context context;
        private static final String DATABASE_NAME = "EMPLOYEE_INFO";
        private static final String TABLE_NAME = "EMPLOYEE";
        private static final int DATABASE_VERSION = 3;
        private static final String COLUMN_ID = "ID";
        private static final String COLUMN_FIRST_NAME = "FIRST_NAME";
        private static final String COLUMN_LAST_NAME = "LAST_NAME";
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_FIRST_NAME + " VARCHAR(255), " + COLUMN_LAST_NAME + " VARCHAR(255))";
        private static final String DROP_TABLE = "DROP TABLE IF EXIST " + TABLE_NAME;


        public DBHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context = context;
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE);
            Util.showMessage(context, "Veri tabanı Olusturuldu");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DROP_TABLE);
            Util.showMessage(context, "Veri tabanı Dusuruldu");
            onCreate(db);
        }
    }
}
