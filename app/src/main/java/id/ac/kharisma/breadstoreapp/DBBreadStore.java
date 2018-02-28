package id.ac.kharisma.breadstoreapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBBreadStore extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BreadStore.db";
    private static final int DATABASE_VERSION = 1;
    public DBBreadStore(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table User(No integer primary key autoincrement, Username text null, Password text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO User VALUES (1, 'Michael', 'admin123');";
        db.execSQL(sql);

        sql = "create table Transaksi(No integer primary key, KodeRoti integer null, Jumlah integer null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (1, 1, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (2, 2, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (3, 3, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (4, 4, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (5, 5, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (6, 6, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (7, 7, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (8, 8, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (9, 9, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (10, 10, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (11, 11, 0);";
        db.execSQL(sql);
        sql = "INSERT INTO Transaksi VALUES (12, 12, 0);";
        db.execSQL(sql);

        sql = "create table ListRoti(No integer primary key, Jenis text null, Nama text null, Harga real null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO ListRoti VALUES (1, 'Roti Tawar', 'Roti Tawar', 6000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListRoti VALUES (2, 'Roti Tawar', 'Roti Tawar Gandum', 7000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListRoti VALUES (3, 'Roti Tawar', 'Roti Tawar Beras Merah', 9000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListRoti VALUES (4, 'Roti Tawar', 'Roti Tawar Beras Hitam', 10500);";
        db.execSQL(sql);
        sql = "INSERT INTO ListRoti VALUES (5, 'Sandwich', 'Sandwich Telur', 10000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListRoti VALUES (6, 'Sandwich', 'Sandwich Sosis', 11000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListRoti VALUES (7, 'Sandwich', 'Sandwich Sayur', 7000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListRoti VALUES (8, 'Sandwich', 'Sandwich Special', 13500);";
        db.execSQL(sql);
        sql = "INSERT INTO ListRoti VALUES (9, 'Roti Isi', 'Roti Coklat Keju', 9000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListRoti VALUES (10, 'Roti Isi', 'Roti Coklat', 7000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListRoti VALUES (11, 'Roti Isi', 'Roti Keju', 7000);";
        db.execSQL(sql);
        sql = "INSERT INTO ListRoti VALUES (12, 'Roti Isi', 'Roti Sarikaya', 8000);";
        db.execSQL(sql);

    }


    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }
}