package com.example.fitgarage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class RewardsActivity extends AppCompatActivity {

    Toolbar toolbar;
    DatabaseHelper db;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "userpref";
    private static final String KEY_ID = "user_id";

    private static final String[] rewards = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "four_days", "seven_days"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        db = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        boolean rewardsData[] = loadRewardsData();
        updateRewardsView(rewardsData);
    }

    private boolean[] loadRewardsData() {
        String userid = sharedPreferences.getString("user_id", null);
        boolean[] rewardsData = new boolean[9];

        Cursor cursor = db.findDataById("Rewards", rewards, userid);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();

            for (int i = 0; i < rewardsData.length; i++) {
                rewardsData[i] = cursor.getInt(i) > 0;
            }
        }
        else {
            Toast.makeText(RewardsActivity.this, "No data found", Toast.LENGTH_SHORT).show();
        }

        return rewardsData;
    }

    private void updateRewardsView(boolean rewardsData[]) {
        for(int i = 0; i < rewardsData.length; i++) {
            int imageViewID = getResources().getIdentifier("iv_" + rewards[i] + "_box", "id", getPackageName());

            ImageView imageView = findViewById(imageViewID);

            if (rewardsData[i] == false) {
                imageView.setImageResource(R.drawable.iv_red_box);
            }
            else if (rewardsData[i] == true) {
                imageView.setImageResource(R.drawable.iv_green_box);
            }
        }
    }

}