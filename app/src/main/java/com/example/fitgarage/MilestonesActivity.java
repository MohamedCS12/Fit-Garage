package com.example.fitgarage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitgarage.databinding.ActivityMilestonesBinding;

public class MilestonesActivity extends DrawerBaseActivity {

    ActivityMilestonesBinding activityMilestonesBinding;
    DatabaseHelper db;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "userpref";
    private static final String KEY_ID = "user_id";

    private static final String[] days = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMilestonesBinding = ActivityMilestonesBinding.inflate(getLayoutInflater());
        setContentView(activityMilestonesBinding.getRoot());
        allocatedActivityTitle("Milestones");

        db = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        Integer milestonesData[] = loadMilestonesData();
        updateMilestonesView(milestonesData);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        finish();
        startActivity(intent);
    }

    private Integer[] loadMilestonesData() {
        String userid = sharedPreferences.getString("user_id", null);
        Integer[] milestonesData = new Integer[7];

        Cursor cursor = db.findDataById("Milestones", days, userid);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();

            for (int i = 0; i < milestonesData.length; i++) {
                milestonesData[i] = (int) Math.floor(cursor.getFloat(i));

                if (milestonesData[i] > 30)
                    milestonesData[i] = 30;
            }
        }
        else {
            Toast.makeText(MilestonesActivity.this, "No data found", Toast.LENGTH_SHORT).show();
        }

        return milestonesData;
    }

    private void updateMilestonesView(Integer milestonesData[]) {
        for(int i = 0; i < milestonesData.length; i++) {
            int progressBarID = getResources().getIdentifier("pb_minutes_" + days[i], "id", getPackageName());
            int textViewID = getResources().getIdentifier("tv_minutes_" + days[i], "id", getPackageName());

            ProgressBar progressBar = findViewById(progressBarID);
            TextView textView = findViewById(textViewID);

            progressBar.setProgress(milestonesData[i]);
            textView.setText(milestonesData[i] +" / 30\nminutes");
        }
    }

    public void onButtonRewardsClicked(View view) {
        Intent intent = new Intent(this, RewardsActivity.class);
        startActivity(intent);
    }

}