package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Sql_t db = new Sql_t(this);
    ListView lv ;
EditText et1 , et2 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=findViewById(R.id.lv);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
    }

    public void show(View view) {
        ArrayList<String> listData = db.getrecord();
        ArrayAdapter arrayAdapter= new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,listData);
        lv.setAdapter(arrayAdapter);
    }



    public void Delete(View view) {

    }

    public void insert(View view) {
        String n = et1.getText().toString();
        String e = et2.getText().toString();
        Boolean result = db.insertDat(n,e);
        if (result == true)
        {
            Toast.makeText(this,"ok",Toast.LENGTH_SHORT).show();
            et1.setText("");
            et2.setText("");
        }else
            Toast.makeText(this,"NO",Toast.LENGTH_SHORT).show();

    }

    public void photos(View view) {
        Intent intent = new Intent(this , MainActivity2.class);
        startActivity(intent);
    }
}