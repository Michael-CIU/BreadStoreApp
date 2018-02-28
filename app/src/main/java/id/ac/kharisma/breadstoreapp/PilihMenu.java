package id.ac.kharisma.breadstoreapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PilihMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_menu);
    }

    public void RotiTawar(View view)
    {
        Intent intent = new Intent(this, ActivityPilihRoti.class);
        intent.putExtra("EXTRA_MESSAGE", 1);
        startActivity(intent);
    }

    public void Sandwich(View view)
    {
        Intent intent = new Intent(this, ActivityPilihRoti.class);
        intent.putExtra("EXTRA_MESSAGE", 2);
        startActivity(intent);
    }

    public void RotiIsi(View view)
    {
        Intent intent = new Intent(this, ActivityPilihRoti.class);
        intent.putExtra("EXTRA_MESSAGE", 3);
        startActivity(intent);
    }

    public void BtnKlik(View view)
    {
        Intent intent = new Intent(this, Keranjang.class);
        startActivity(intent);
    }

}
