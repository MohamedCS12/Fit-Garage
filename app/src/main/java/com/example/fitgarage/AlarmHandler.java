package com.example.fitgarage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

public class AlarmHandler {

    private Context context;

    public AlarmHandler(Context context) {
        this.context = context;
    }

    public void setAlarmManager() {
        Intent intent = new Intent(context, ExecutableService.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast( context, 2, intent, 0 );

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (alarmManager != null) {
            Calendar timeOff = Calendar.getInstance();
            int daysOff = Calendar.MONDAY - timeOff.get(Calendar.DAY_OF_WEEK);
            if (daysOff <= 0) {
                daysOff += 7;
            }

            timeOff.add(Calendar.DATE, daysOff);
            timeOff.set(Calendar.HOUR_OF_DAY, 0);
            timeOff.set(Calendar.MINUTE, 0);
            timeOff.set(Calendar.SECOND, 0);
            timeOff.set(Calendar.MILLISECOND, 0);

            alarmManager.setExact(AlarmManager.RTC_WAKEUP, timeOff.getTimeInMillis(), pendingIntent);
        }
    }

    public void cancelAlarmManager() {
        Intent intent = new Intent(context, ExecutableService.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast( context, 2, intent, 0 );

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }
}
