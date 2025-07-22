package com.example.fitgarage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fitgarage.databinding.ActivityHomeBinding;

public class HomeActivity extends DrawerBaseActivity {

    ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());
        allocatedActivityTitle("Home");

        AlarmHandler alarmHandler = new AlarmHandler(this);
        alarmHandler.cancelAlarmManager();
        alarmHandler.setAlarmManager();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        finish();
        startActivity(intent);
    }

    public void onCardViewHomeWorkoutClicked(View view) {
        Intent workoutsIntent = new Intent(this, WorkoutTypeActivity.class);
        workoutsIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(workoutsIntent);
        overridePendingTransition(0, 0);
    }

    public void onCardViewHomeStoreClicked(View view) {
        Intent storeIntent = new Intent(this, StoreActivity.class);
        storeIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(storeIntent);
        overridePendingTransition(0, 0);
    }

    public void onCardViewHomeTipsClicked(View view) {
        Intent tipsIntent = new Intent(this, TipsActivity.class);
        tipsIntent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(tipsIntent);
        overridePendingTransition(0, 0);
    }

}