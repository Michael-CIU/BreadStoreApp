package id.ac.kharisma.breadstoreapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Keranjang extends AppCompatActivity {
    protected Cursor cursor;
    DBBreadStore db;
    TextView GrandTotal;
    TextView[] txtRoti = new TextView[12],txtPrice = new TextView[12],txtQty = new TextView[12],txtTot = new TextView[12];
    double aSubTotal=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);

        GrandTotal = (TextView) findViewById(R.id.txtGrandTotal);
        txtRoti[0] = (TextView) findViewById(R.id.txtNama1);
        txtRoti[6] = (TextView) findViewById(R.id.txtNama7);
        txtRoti[1] = (TextView) findViewById(R.id.txtNama2);
        txtRoti[7] = (TextView) findViewById(R.id.txtNama8);
        txtRoti[2] = (TextView) findViewById(R.id.txtNama3);
        txtRoti[8] = (TextView) findViewById(R.id.txtNama9);
        txtRoti[3] = (TextView) findViewById(R.id.txtNama4);
        txtRoti[9] = (TextView) findViewById(R.id.txtNama10);
        txtRoti[4] = (TextView) findViewById(R.id.txtNama5);
        txtRoti[10] = (TextView) findViewById(R.id.txtNama11);
        txtRoti[5] = (TextView) findViewById(R.id.txtNama6);
        txtRoti[11] = (TextView) findViewById(R.id.txtNama12);

        txtPrice[0] = (TextView) findViewById(R.id.txtHarga1);
        txtPrice[6] = (TextView) findViewById(R.id.txtHarga7);
        txtPrice[1] = (TextView) findViewById(R.id.txtHarga2);
        txtPrice[7] = (TextView) findViewById(R.id.txtHarga8);
        txtPrice[2] = (TextView) findViewById(R.id.txtHarga3);
        txtPrice[8] = (TextView) findViewById(R.id.txtHarga9);
        txtPrice[3] = (TextView) findViewById(R.id.txtHarga4);
        txtPrice[9] = (TextView) findViewById(R.id.txtHarga10);
        txtPrice[4] = (TextView) findViewById(R.id.txtHarga5);
        txtPrice[10] = (TextView) findViewById(R.id.txtHarga11);
        txtPrice[5] = (TextView) findViewById(R.id.txtHarga6);
        txtPrice[11] = (TextView) findViewById(R.id.txtHarga12);

        txtQty[0] = (TextView) findViewById(R.id.txtJumlah1);
        txtQty[6] = (TextView) findViewById(R.id.txtJumlah7);
        txtQty[1] = (TextView) findViewById(R.id.txtJumlah2);
        txtQty[7] = (TextView) findViewById(R.id.txtJumlah8);
        txtQty[2] = (TextView) findViewById(R.id.txtJumlah3);
        txtQty[8] = (TextView) findViewById(R.id.txtJumlah9);
        txtQty[3] = (TextView) findViewById(R.id.txtJumlah4);
        txtQty[9] = (TextView) findViewById(R.id.txtJumlah10);
        txtQty[4] = (TextView) findViewById(R.id.txtJumlah5);
        txtQty[10] = (TextView) findViewById(R.id.txtJumlah11);
        txtQty[5] = (TextView) findViewById(R.id.txtJumlah6);
        txtQty[11] = (TextView) findViewById(R.id.txtJumlah12);

        txtTot[0] = (TextView) findViewById(R.id.txtTotal1);
        txtTot[6] = (TextView) findViewById(R.id.txtTotal7);
        txtTot[1] = (TextView) findViewById(R.id.txtTotal2);
        txtTot[7] = (TextView) findViewById(R.id.txtTotal8);
        txtTot[2] = (TextView) findViewById(R.id.txtTotal3);
        txtTot[8] = (TextView) findViewById(R.id.txtTotal9);
        txtTot[3] = (TextView) findViewById(R.id.txtTotal4);
        txtTot[9] = (TextView) findViewById(R.id.txtTotal10);
        txtTot[4] = (TextView) findViewById(R.id.txtTotal5);
        txtTot[10] = (TextView) findViewById(R.id.txtTotal11);
        txtTot[5] = (TextView) findViewById(R.id.txtTotal6);
        txtTot[11] = (TextView) findViewById(R.id.txtTotal12);

        for (int i = 0; i <= 11; i++) {
            txtRoti[i].setText("");
            txtTot[i].setText("");
            txtQty[i].setText("");
            txtPrice[i].setText("");
        }

        db = new DBBreadStore(this);
        SQLiteDatabase dbread = db.getReadableDatabase();
        cursor = dbread.rawQuery("SELECT a.*,b.Jumlah FROM ListRoti a join Transaksi b on a.No=b.KodeRoti" +
                " where b.Jumlah <> 0 Order By No", null);

        if ((cursor != null) && (cursor.getCount() > 0)) {
            for (int cc = 0; cc <= cursor.getCount() - 1; cc++) {
                cursor.moveToPosition(cc);
                txtRoti[cc].setText(cursor.getString(2).toString());
                txtPrice[cc].setText(cursor.getString(3).toString());
                txtQty[cc].setText(cursor.getString(4).toString());
                aSubTotal = (double) (cursor.getFloat(3) * cursor.getInt(4));
                txtTot[cc].setText(String.valueOf(aSubTotal));
            }
        }

        cursor = dbread.rawQuery("SELECT sum(a.Harga * b.Jumlah) as GrandTotal" +
                " FROM ListRoti a join Transaksi b on a.No=b.KodeRoti" +
                " Order By a.No", null);
        if ((cursor != null) && (cursor.getCount() > 0)) {
            cursor.moveToFirst();
            GrandTotal.setText("Rp. "+ String.valueOf(cursor.getFloat(0)));
        }
    }
}
