package com.example.fitgarage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.fitgarage.databinding.ActivityHomeBinding;
import com.example.fitgarage.databinding.ActivityTipsBinding;

public class TipsActivity extends DrawerBaseActivity {

    ActivityTipsBinding activityTipsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTipsBinding = ActivityTipsBinding.inflate(getLayoutInflater());
        setContentView(activityTipsBinding.getRoot());
        allocatedActivityTitle("Tips");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        finish();
        startActivity(intent);
    }

    public void onCardViewTip1Clicked(View view) {
        Intent intent = new Intent(this, Tip1Activity.class);
        startActivity(intent);
    }

    public void onCardViewTip2Clicked(View view) {
        Intent intent = new Intent(this, Tip2Activity.class);
        startActivity(intent);
    }

    public void onCardViewTip3Clicked(View view) {
        Intent intent = new Intent(this, Tip3Activity.class);
        startActivity(intent);
    }

    public void onCardViewTip4Clicked(View view) {
        Intent intent = new Intent(this, Tip4Activity.class);
        startActivity(intent);
    }

    public void onCardViewTip5Clicked(View view) {
        Intent intent = new Intent(this, Tip5Activity.class);
        startActivity(intent);
    }

}