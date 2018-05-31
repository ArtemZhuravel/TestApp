package com.example.firstproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.firstproject.data.DataBaseHelper;

import java.util.ArrayList;

public class HystoryActivity extends AppCompatActivity {
    private ListView object;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hystory);
        db = new DataBaseHelper(this);

        ArrayList array_list = db.getAllCotacts();
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1, array_list);

        object = (ListView)findViewById(R.id.listView1);
        object.setAdapter(arrayAdapter);
    }
}
