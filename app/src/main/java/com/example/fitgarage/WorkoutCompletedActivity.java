package com.example.fitgarage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class WorkoutCompletedActivity extends AppCompatActivity {

    Toolbar toolbar;
    DatabaseHelper db;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "userpref";
    private static final String KEY_ID = "user_id";

    private static final String[] rewards = {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "four_days", "seven_days"};

    private TextView textViewWorkoutName, textViewTime, textViewCal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_completed);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Exit");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_exit);

        db = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String userid = sharedPreferences.getString("user_id", null);

        textViewWorkoutName = (TextView) findViewById(R.id.tv_workout_name);
        textViewTime = (TextView) findViewById(R.id.tv_time);
        textViewCal = (TextView) findViewById(R.id.tv_cal);

        String workoutName = getIntent().getStringExtra("workoutName");
        String milestoneProgress = getIntent().getStringExtra("milestoneProgress");
        String calories = getIntent().getStringExtra("calories");

        Integer time = Integer.valueOf(milestoneProgress);
        Integer minutes = time / 60;
        Integer seconds = time % 60;
        String timeFormatted = String.format("%d min %d sec", minutes, seconds);

        textViewWorkoutName.setText(workoutName);
        textViewTime.setText(timeFormatted);
        textViewCal.setText(String.format("%.5s", calories)+ " cal");

        db.incrementDataById("Statistics", "workouts_completed", userid, "1");
        db.incrementDataById("Statistics", "calories_burnt", userid, String.format("%.5s", calories));
        String dayOfTheWeek = updateMilestonesData(userid, time);
        updateRewardsData(userid, dayOfTheWeek);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    public void onButtonExitClicked(View view) {
        finish();
    }

    private String updateMilestonesData(String userid, Integer time) {
        Float timeInMin = (float) time / 60;
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        String dayOfTheWeek = simpleDateFormat.format(date).toLowerCase();

        db.incrementDataById("Milestones", dayOfTheWeek, userid, String.valueOf(timeInMin));

        return dayOfTheWeek;
    }

    private void updateRewardsData(String userid, String dayOfTheWeek) {
        boolean[] rewardsData = new boolean[9];
        Integer rewardsCount = 0;

        Cursor cursor = db.findDataById("Milestones", new String[] {dayOfTheWeek}, userid);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            Float progressToday = cursor.getFloat(0);

            cursor = db.findDataById("Rewards", new String[] {dayOfTheWeek}, userid);
            if (cursor.getCount() == 1) {
                cursor.moveToFirst();
                boolean rewardsToday = cursor.getInt(0) > 0;

                if (progressToday >= 30 && rewardsToday == false) {
                    db.incrementDataById("Rewards", dayOfTheWeek, userid, "1");
                    db.incrementDataById("Users", "fit_tokens", userid, "1");
                    db.incrementDataById("Statistics", "rewards_redeemed", userid, "1");
                }
            }
            else {
                Toast.makeText(WorkoutCompletedActivity.this, "No data found", Toast.LENGTH_SHORT).show();
            }

        }
        else {
            Toast.makeText(WorkoutCompletedActivity.this, "No data found", Toast.LENGTH_SHORT).show();
        }

        cursor = db.findDataById("Rewards", rewards, userid);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();

            for (int i = 0; i < rewardsData.length; i++) {
                rewardsData[i] = cursor.getInt(i) > 0;
            }
        }
        else {
            Toast.makeText(WorkoutCompletedActivity.this, "No data found", Toast.LENGTH_SHORT).show();
        }


        for (int i = 0; i < 7; i++) {
            if (rewardsData[i] == true)
                rewardsCount++;
        }

        if (rewardsCount > 3 && rewardsCount < 7 && rewardsData[7] == false) {
            db.incrementDataById("Rewards", "four_days", userid, "1");
            db.incrementDataById("Users", "fit_tokens", userid, "5");
            db.incrementDataById("Statistics", "rewards_redeemed", userid, "1");
        }
        else if (rewardsCount > 7 && rewardsData[8] == false) {
            db.incrementDataById("Rewards", "seven_days", userid, "1");
            db.incrementDataById("Users", "fit_tokens", userid, "10");
            db.incrementDataById("Statistics", "rewards_redeemed", userid, "1");
        }
    }

}