package com.example.fitgarage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ExecutableService extends BroadcastReceiver {

    DatabaseHelper db;

    @Override
    public void onReceive(Context context, Intent intent) {
        db = new DatabaseHelper(context);
        db.resetMilestonesRewardsData();

        AlarmHandler alarmHandler = new AlarmHandler(context);
        alarmHandler.cancelAlarmManager();
        alarmHandler.setAlarmManager();
    }
}
