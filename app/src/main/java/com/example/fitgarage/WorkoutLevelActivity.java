package com.example.fitgarage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WorkoutLevelActivity extends AppCompatActivity implements View.OnClickListener {

    Toolbar toolbar;
    Button buttonBeginner, buttonIntermediate, buttonAdvanced;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_level);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        TextView textView = findViewById(R.id.tv_workout_type);
        textView.setText(getIntent().getStringExtra("workoutType"));

        buttonBeginner = (Button) findViewById(R.id.btn_beginner);
        buttonIntermediate = (Button) findViewById(R.id.btn_intermediate);
        buttonAdvanced = (Button) findViewById(R.id.btn_advanced);

        buttonBeginner.setOnClickListener(this);
        buttonIntermediate.setOnClickListener(this);
        buttonAdvanced.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String workoutType = getIntent().getStringExtra("workoutType");
        Intent intent = new Intent(this, WorkoutActivity.class);
        switch (workoutType) {
            case "Shoulders & Arms":
                if (view.getId() == R.id.btn_beginner)
                    intent.putExtra("workoutList", "1");
                else if (view.getId() == R.id.btn_intermediate)
                    intent.putExtra("workoutList", "2");
                else if (view.getId() == R.id.btn_advanced)
                    intent.putExtra("workoutList", "3");
                break;

            case "Back & Chest":
                if (view.getId() == R.id.btn_beginner)
                    intent.putExtra("workoutList", "4");
                else if (view.getId() == R.id.btn_intermediate)
                    intent.putExtra("workoutList", "5");
                else if (view.getId() == R.id.btn_advanced)
                    intent.putExtra("workoutList", "6");
                break;

            case "Abs & Core":
                if (view.getId() == R.id.btn_beginner)
                    intent.putExtra("workoutList", "7");
                else if (view.getId() == R.id.btn_intermediate)
                    intent.putExtra("workoutList", "8");
                else if (view.getId() == R.id.btn_advanced)
                    intent.putExtra("workoutList", "9");
                break;

            case "Glutes & Legs":
                if (view.getId() == R.id.btn_beginner)
                    intent.putExtra("workoutList", "10");
                else if (view.getId() == R.id.btn_intermediate)
                    intent.putExtra("workoutList", "11");
                else if (view.getId() == R.id.btn_advanced)
                    intent.putExtra("workoutList", "12");
                break;
        }
        startActivity(intent);
    }

}