package com.example.fitgarage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.fitgarage.databinding.ActivitySettingsBinding;

public class SettingsActivity extends DrawerBaseActivity {

    ActivitySettingsBinding activitySettingsBinding;
    DatabaseHelper db;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "userpref";
    private static final String KEY_ID = "user_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySettingsBinding = ActivitySettingsBinding.inflate(getLayoutInflater());
        setContentView(activitySettingsBinding.getRoot());
        allocatedActivityTitle("Settings");

        db = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String userid = sharedPreferences.getString("user_id", null);

        Cursor cursor = db.findDataById("Users", new String[] {"username"}, userid);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            String username = cursor.getString(0);

            TextView textView = findViewById(R.id.tv_username);
            textView.setText(username);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        finish();
        startActivity(intent);
    }

    public void onButtonEditProfileClicked(View view) {
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
    }

    public void onButtonGuideClicked(View view) {
        Intent intent = new Intent(this, GuideActivity.class);
        startActivity(intent);
    }

    public void onButtonStatisticsClicked(View view) {
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

    public void onButtonPrivacyPolicyClicked(View view) {
        Intent intent = new Intent(this, PrivacyPolicyActivity.class);
        startActivity(intent);
    }

    public void onButtonAcknowledgementsClicked(View view) {
        Intent intent = new Intent(this, AcknowledgementsActivity.class);
        startActivity(intent);
    }

}