package com.example.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.firstproject.data.DataBaseHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DataBaseHelper(this);
        TextView pastTimeTextView = (TextView) findViewById(R.id.past_time_text_view);
        ArrayList<String> times = db.getAllCotacts();
//        pastTimeTextView.setText(times.get(times.size() - 1));
        pastTimeTextView.setText(times.get(1));

        TextView presentTimeTextView = (TextView) findViewById(R.id.present_time_text_view);
//        presentTimeTextView.setText(times.get(times.size() - 2));
        presentTimeTextView.setText(times.get(0));
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, HystoryActivity.class);
        startActivity(intent);
    }
}
