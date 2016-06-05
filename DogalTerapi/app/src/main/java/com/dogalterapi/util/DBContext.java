package com.dogalterapi.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.dogalterapi.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by Samir on 18.5.2016.
 * Sqlite Db işlmelerimizde  bize yardcım cı Clasımız
 */
public  class DBContext {
    private static DBContext INSTANCE;
    private DBHelper dbHelper;
    private final List<User> musteriListesi;

    private DBContext(Context context) {
        // burda bu methodu kullanan activity ile eileştiriyoruz
        this.dbHelper = new DBHelper(context);
        // Butun Musterileri Çektik Dizimize
        musteriListesi = getAllEmployees();
    }

    public static DBContext getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new DBContext(context);
        }
        return INSTANCE;
    }

    public boolean insertUser(User user) {
        boolean result = false;
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_FIRST_NAME, user.getAd());
        cv.put(DBHelper.COLUMN_LAST_NAME, user.getSoyad());
        cv.put(DBHelper.COLUMN_CINSIYET, user.getCinsiyet());
        cv.put(DBHelper.COLUMN_TEL_NO, user.getTelefon_no());
        cv.put(DBHelper.COLUMN_YAS, user.getYas());
        cv.put(DBHelper.COLUMN_KILO, user.getKilo());
        cv.put(DBHelper.COLUMN_EPOSTA, user.getEposta());
        cv.put(DBHelper.COLUMN_ADRES, user.getAdres());
        // SQLiteDatabase database = dbHelper.getWritableDatabase();
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        int id = (int) database.insert(DBHelper.TABLE_NAME, null, cv);
        if (id != 1) {
            user.setId(id);// id atadıkUUID.randomUUID()
            result = true;
        }
        return result;
    }

    // Butun Kullanıcıları DOner
    public List<User> getAllEmployees() {
        List<User> calisanlar = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        final String kolonlar[] = {
                DBHelper.COLUMN_ID,
                DBHelper.COLUMN_FIRST_NAME, DBHelper.COLUMN_LAST_NAME,
                DBHelper.COLUMN_CINSIYET, DBHelper.COLUMN_TEL_NO,
                DBHelper.COLUMN_YAS, DBHelper.COLUMN_KILO,
                DBHelper.COLUMN_EPOSTA, DBHelper.COLUMN_ADRES,
                DBHelper.COLUMN_DATE};
        Cursor cursor = database.query(DBHelper.TABLE_NAME, kolonlar, null, null, null, null, null);
        while (cursor.moveToNext()) {
            User user = new User();
           // UUID idmiz = UUID.fromString(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ID)));
            user.setId(cursor.getLong(cursor.getColumnIndex(DBHelper.COLUMN_ID)));
            user.setAd(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_FIRST_NAME)));
            user.setSoyad(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_LAST_NAME)));
            user.setCinsiyet(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_CINSIYET)));
            user.setTelefon_no(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_TEL_NO)));
            user.setYas(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_YAS)));
            user.setKilo(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_KILO)));
            user.setEposta(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_EPOSTA)));
            user.setAdres(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_ADRES)));
            user.setDate(cursor.getString(cursor.getColumnIndex(DBHelper.COLUMN_DATE)));
            calisanlar.add(user);
        }
        return calisanlar;
    }//getAllEmployees sonu


    // ilgili musteri bilgisini musteriListesi ile karşılaştırıp ilgili indisz degeri doner
    public int getMusteriIndisi(long id) {//UUID id
        int indis = -1;
        List<User>  musteriListem =getAllEmployees();
        for (int i = 0; i < musteriListem.size(); i++) {
            User musteri = musteriListem.get(i);
            if (musteri.getId()== id) {
                indis = i;
                break;
            }
        }
        return indis;
    }

    // Verilen Id ye Gore MusteriListesinde Tarama Yapar ve ilgili id deki Musteriyi döner
    // GUNCEL LISTEYI ALMAK ICIN YENIDEN ALIYORUZ LISTEYImusteriListem
    public User getMusteriById(long id) {//UUID id
        List<User>  musteriListem =getAllEmployees();
        User musteri = null;
        for (User mus : musteriListem) {
            if (mus.getId()==id) {
                musteri = mus;
                break;
            }
        }
        return musteri;
    }

    /*
    *  public int updateById(String ad, String soyad, String id) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.COLUMN_FIRST_NAME, ad);
        contentValues.put(DBHelper.COLUMN_LAST_NAME, soyad);
        return database.update(DBHelper.TABLE_NAME, contentValues, "ID = ?", new String[]{id});
    }

    * */

    public int updateUser(User user, long id) {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COLUMN_FIRST_NAME,user.getAd());
        cv.put(DBHelper.COLUMN_LAST_NAME,user.getSoyad());
        cv.put(DBHelper.COLUMN_LAST_NAME,user.getSoyad());
        cv.put(DBHelper.COLUMN_TEL_NO,user.getTelefon_no());
        cv.put(DBHelper.COLUMN_YAS,user.getYas());
        cv.put(DBHelper.COLUMN_KILO,user.getKilo());
        cv.put(DBHelper.COLUMN_EPOSTA,user.getEposta());
        cv.put(DBHelper.COLUMN_ADRES,user.getAdres());
        return  database.update(DBHelper.TABLE_NAME,cv,"ID = ?",new String[]{String.valueOf(id)});
    }

    public void closeDB(){
        dbHelper.close();
    }

    public int deleteUser(long id) {
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        return database.delete(DBHelper.TABLE_NAME, "ID = ?", new String[]{String.valueOf(id)});
    }


    private class DBHelper extends SQLiteOpenHelper {

        private final Context context;
        private static final String DATABASE_NAME = "USER_INFO";
        private static final String TABLE_NAME = "USER";
        private static final int DATABASE_VERSION = 4;
        private static final String COLUMN_ID = "ID";
        private static final String COLUMN_FIRST_NAME = "AD";
        private static final String COLUMN_LAST_NAME = "SOYAD";
        private static final String COLUMN_CINSIYET = "CINSIYET";
        private static final String COLUMN_TEL_NO = "TELEFON_NO";
        private static final String COLUMN_YAS = "YAS";
        private static final String COLUMN_KILO = "KILO";
        private static final String COLUMN_EPOSTA = "EPOSTA";
        private static final String COLUMN_ADRES = "ADRES";
        private static final String COLUMN_DATE = "DATE";
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_FIRST_NAME + " VARCHAR(255), " + COLUMN_LAST_NAME + " VARCHAR(50)," + COLUMN_CINSIYET + " VARCHAR(255), " + COLUMN_TEL_NO + " VARCHAR(255), " + COLUMN_YAS + " VARCHAR(20), " + COLUMN_KILO + " VARCHAR(255), "
                + COLUMN_EPOSTA + " VARCHAR(50), " + COLUMN_ADRES + " VARCHAR(150), " + COLUMN_DATE + " VARCHAR(50)" + ")";
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
    }// DBHelper Class End
}//DBContext Class End
