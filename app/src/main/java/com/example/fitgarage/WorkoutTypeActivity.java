package com.example.fitgarage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fitgarage.databinding.ActivityWorkoutTypeBinding;

public class WorkoutTypeActivity extends DrawerBaseActivity implements View.OnClickListener {

    ActivityWorkoutTypeBinding activityWorkoutTypeBinding;
    Button buttonShouldersAndArms, buttonBackAndChest, buttonAbsAndCore, buttonGlutesAndLegs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityWorkoutTypeBinding = ActivityWorkoutTypeBinding.inflate(getLayoutInflater());
        setContentView(activityWorkoutTypeBinding.getRoot());
        allocatedActivityTitle("Workouts");

        buttonShouldersAndArms = (Button) findViewById(R.id.btn_shoulders_and_arms);
        buttonBackAndChest = (Button) findViewById(R.id.btn_back_and_chest);
        buttonAbsAndCore = (Button) findViewById(R.id.btn_abs_and_core);
        buttonGlutesAndLegs = (Button) findViewById(R.id.btn_glutes_and_legs);

        buttonShouldersAndArms.setOnClickListener(this);
        buttonBackAndChest.setOnClickListener(this);
        buttonAbsAndCore.setOnClickListener(this);
        buttonGlutesAndLegs.setOnClickListener(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        finish();
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, WorkoutLevelActivity.class);
        switch (view.getId()) {
            case R.id.btn_shoulders_and_arms:
                intent.putExtra("workoutType", "Shoulders & Arms");
                break;

            case R.id.btn_back_and_chest:
                intent.putExtra("workoutType", "Back & Chest");
                break;

            case R.id.btn_abs_and_core:
                intent.putExtra("workoutType", "Abs & Core");
                break;

            case R.id.btn_glutes_and_legs:
                intent.putExtra("workoutType", "Glutes & Legs");
                break;
        }
        startActivity(intent);
    }

}