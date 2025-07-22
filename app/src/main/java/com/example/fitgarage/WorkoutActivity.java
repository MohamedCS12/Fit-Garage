package com.example.fitgarage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.fitgarage.videolists.AbsListAdvanced;
import com.example.fitgarage.videolists.AbsListBeginner;
import com.example.fitgarage.videolists.AbsListIntermediate;
import com.example.fitgarage.videolists.ArmsListAdvanced;
import com.example.fitgarage.videolists.ArmsListBeginner;
import com.example.fitgarage.videolists.ArmsListIntermediate;
import com.example.fitgarage.videolists.ChestListAdvanced;
import com.example.fitgarage.videolists.ChestListBeginner;
import com.example.fitgarage.videolists.ChestListIntermediate;
import com.example.fitgarage.videolists.LegsListAdvanced;
import com.example.fitgarage.videolists.LegsListBeginner;
import com.example.fitgarage.videolists.LegsListIntermediate;
import com.example.fitgarage.videolists.VideoList;
import com.example.fitgarage.videolists.VideoNode;

import java.util.concurrent.TimeUnit;

public class WorkoutActivity extends AppCompatActivity {

    Toolbar toolbar;

    private TextView textViewWorkoutName, textViewVideoName, textViewTimer;
    private VideoView videoViewWorkout;
    private MediaController mediaController;
    private Button buttonGo;
    private VideoNode video = null;
    private VideoList videoList;

    private boolean hasStarted = false;
    private boolean isPaused = true;
    private int stopPosition = 0;

    private long timer = 0;
    private String timerFormatted;
    private String milestoneProgress;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        String videoListID = getIntent().getStringExtra("workoutList");
        defineVideoList(videoListID);

        textViewWorkoutName = (TextView) findViewById(R.id.tv_workout_name);
        textViewWorkoutName.setText(videoList.getListName());
        textViewVideoName = (TextView) findViewById(R.id.tv_video_name);
        textViewTimer = (TextView) findViewById(R.id.tv_timer);
        buttonGo = (Button) findViewById(R.id.btn_go);

        videoViewWorkout = new VideoView(this);
        videoViewWorkout = (VideoView) findViewById(R.id.vv_workout);
        mediaController = new MediaController(this);
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

    public void onButtonEndWorkoutClicked(View view) {
        Intent intent = new Intent(this, WorkoutCompletedActivity.class);
        milestoneProgress = String.valueOf(timer/1000);
        double calories = videoList.getCal() * ((timer*1.0/1000)/3600);
        String caloriesFormatted = Double.toString(calories);
        intent.putExtra("workoutName", videoList.getListName());
        intent.putExtra("milestoneProgress", milestoneProgress);
        intent.putExtra("calories", caloriesFormatted);
        finish();
        startActivity(intent);
    }

    void defineVideoList(String videoListID) {
        switch (videoListID) {
            case "1":
                videoList = new ArmsListBeginner();
                break;
            case "2":
                videoList = new ArmsListIntermediate();
                break;
            case "3":
                videoList = new ArmsListAdvanced();
                break;

            case "4":
                videoList = new ChestListBeginner();
                break;
            case "5":
                videoList = new ChestListIntermediate();
                break;
            case "6":
                videoList = new ChestListAdvanced();
                break;

            case "7":
                videoList = new AbsListBeginner();
                break;
            case "8":
                videoList = new AbsListIntermediate();
                break;
            case "9":
                videoList = new AbsListAdvanced();
                break;

            case "10":
                videoList = new LegsListBeginner();
                break;
            case "11":
                videoList = new LegsListIntermediate();
                break;
            case "12":
                videoList = new LegsListAdvanced();
                break;

            default:
                videoList = new VideoList();
                break;
        }
    }

    public void onButtonGoClicked(View view) {
        String url;

        if (isPaused) {
            video = videoList.getHead();
            textViewVideoName.setText(video.name);

            isPaused = false;
            buttonGo.setText("Next");
            countTimer();
            textViewWorkoutName.setText(videoList.getListName());
            textViewVideoName.setText(video.name + "\n" + video.note);
            url = "android.resource://" + getPackageName() + "/" + video.url;
            video.time--;
            playVideo(url);
        }
        else if (video.next != null && video.time == 0) {
            video = video.next;
            textViewVideoName.setText(video.name + "\n" + video.note);
            url = "android.resource://" + getPackageName() + "/" + video.url;
            video.time--;
            playVideo(url);
        }
        else if (video.time > 0) {
            url = "android.resource://" + getPackageName() + "/" + video.url;
            textViewVideoName.setText(video.name + "\n" + video.note);
            video.time--;
            playVideo(url);
        }
        else {
            Intent intent = new Intent(this, WorkoutCompletedActivity.class);
            milestoneProgress = String.valueOf(timer/1000);
            double calories = videoList.getCal() * ((timer*1.0/1000)/3600);
            String caloriesFormatted = Double.toString(calories);
            intent.putExtra("workoutName", videoList.getListName());
            intent.putExtra("milestoneProgress", milestoneProgress);
            intent.putExtra("calories", caloriesFormatted);
            finish();
            startActivity(intent);
        }
    }

    private final Runnable TimerRunnable = new Runnable() {

        @Override
        public void run() {
            if (!isPaused) { // && videoViewWorkout.isPlaying(); may be used if need repetition
                timer += 1000;
                timerFormatted =  String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(timer),
                        TimeUnit.MILLISECONDS.toMinutes(timer)
                                - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timer)),
                        TimeUnit.MILLISECONDS.toSeconds(timer)
                                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timer)));
                textViewTimer.setText(timerFormatted);

            }
            countTimer();
        }

    };

    private void countTimer() {
        handler.postDelayed(TimerRunnable, 1000);
    }

    private void playVideo(String url){
        videoViewWorkout.setVideoURI(Uri.parse(url));
        mediaController.setMediaPlayer(videoViewWorkout);
        mediaController.setVisibility(View.GONE);
        videoViewWorkout.setMediaController(mediaController);

        videoViewWorkout.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                mp.setLooping(true);
            }
        });

        videoViewWorkout.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(TimerRunnable);
    }

}