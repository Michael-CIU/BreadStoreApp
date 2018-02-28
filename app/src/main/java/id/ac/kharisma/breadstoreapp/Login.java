package id.ac.kharisma.breadstoreapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
    protected Cursor cursor;
    DBBreadStore db;
    EditText txtUser, txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = (EditText) findViewById(R.id.txtUserID);
        txtPass = (EditText) findViewById(R.id.txtPassword);
        txtUser.requestFocus();
    }

    public void Login(View view)
    {
        db = new DBBreadStore(this);

        SQLiteDatabase dbread = db.getReadableDatabase();
        SQLiteDatabase dbwrite = db.getWritableDatabase();

        cursor = dbread.rawQuery("SELECT Password FROM User where Username = '"+ txtUser.getText().toString() +"'",null);
        if ((cursor != null) && (cursor.getCount() > 0)) {
            cursor.moveToFirst();
            if (cursor.getString(0).toString().equals(txtPass.getText().toString()) ) {
                cursor.close();
                dbwrite.execSQL("update Transaksi Set Jumlah = 0");
                Intent intent = new Intent(this, PilihMenu.class);
                startActivity(intent);
            }
            else{
                Toast.makeText(getApplicationContext(), "Password salah", Toast.LENGTH_LONG).show();
            }
        }
        else{
        Toast.makeText(getApplicationContext(), "Username tidak terdaftar", Toast.LENGTH_LONG).show();
        }
    }

    public void Daftar(View view)
    {
        Intent intent = new Intent(this, DaftarUser.class);
        startActivity(intent);
    }
}
