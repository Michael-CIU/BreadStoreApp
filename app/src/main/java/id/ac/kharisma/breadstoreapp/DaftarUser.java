package id.ac.kharisma.breadstoreapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DaftarUser extends AppCompatActivity {
    protected Cursor cursor;
    EditText txtUser,txtPassword1,txtPassword2;
    DBBreadStore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_user);
        txtUser = (EditText) findViewById(R.id.txtUserID);
        txtPassword1 = (EditText) findViewById(R.id.txtPassword);
        txtPassword2 = (EditText) findViewById(R.id.txtPassword2);
        txtUser.requestFocus();

        db = new DBBreadStore(this);
    }

    public void Daftar(View view)
    {
        SQLiteDatabase dbread = db.getReadableDatabase();
        SQLiteDatabase dbwrite = db.getWritableDatabase();
        if (txtPassword1.getText().toString().equals(txtPassword2.getText().toString())){
            cursor = dbread.rawQuery("SELECT * FROM User where Username = '"+ txtUser.getText().toString() +"'",null);
            if ((cursor != null) && (cursor.getCount() > 0)){
                Toast.makeText(getApplicationContext(), "Username sudah ada", Toast.LENGTH_LONG).show();
            }
            else{
                dbwrite.execSQL("insert into User (Username,Password) Values('"
                                +txtUser.getText().toString()+"','"+txtPassword1.getText().toString()+"')");
                cursor.close();
                Toast.makeText(getApplicationContext(), "User berhasil mendaftar", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Password tidak sama", Toast.LENGTH_LONG).show();
        }
    }
}
