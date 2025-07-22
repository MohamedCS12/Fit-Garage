package com.example.fitgarage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class StatisticsActivity extends AppCompatActivity {

    Toolbar toolbar;
    DatabaseHelper db;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "userpref";
    private static final String KEY_ID = "user_id";

    private static final String[] statistics = {"workouts_completed", "rewards_redeemed", "calories_burnt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        db = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String statisticsData[] = loadStatisticsData();
        updateStatisticsView(statisticsData);
    }

    private String[] loadStatisticsData() {
        String userid = sharedPreferences.getString("user_id", null);
        String[] statisticsData = new String[3];

        Cursor cursor = db.findDataById("Statistics", statistics, userid);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();

            statisticsData[0] = String.valueOf(cursor.getInt(0));
            statisticsData[1] = String.valueOf(cursor.getInt(1));
            statisticsData[2] = String.valueOf(cursor.getFloat(2));
        }
        else {
            Toast.makeText(StatisticsActivity.this, "No data found", Toast.LENGTH_SHORT).show();
        }

        return statisticsData;
    }

    private void updateStatisticsView(String statisticsData[]) {
        for(int i = 0; i < 2; i++) {
            int textViewID = getResources().getIdentifier("tv_" + statistics[i] + "_count", "id", getPackageName());
            TextView textView = findViewById(textViewID);
            textView.setText(statisticsData[i]);
        }

        int textViewID = getResources().getIdentifier("tv_" + statistics[2] + "_count", "id", getPackageName());
        TextView textView = findViewById(textViewID);
        textView.setText(statisticsData[2] + " cal");
    }
}