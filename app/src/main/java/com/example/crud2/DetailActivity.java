package com.example.crud2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    protected Cursor cursor; //Cursors menyimpan hasil records dari query dalam rows
    Database database;
    Button btn_simpan;
    TextView  ruangan,gedung, kapasitas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        database = new Database(this);
        ruangan = findViewById(R.id.ruangan);
        gedung = findViewById(R.id.gedung);
        kapasitas = findViewById(R.id.kapasitas);

        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM crud WHERE ruangan ='"+getIntent().getStringExtra("ruangan")+"'", null);
        cursor.moveToFirst();
        if(cursor.getCount() > 0){
            cursor.moveToPosition(0);
            ruangan.setText(cursor.getString(0).toString());
            gedung.setText(cursor.getString(1).toString());
            kapasitas.setText(cursor.getString(2).toString());

        }
    }
}