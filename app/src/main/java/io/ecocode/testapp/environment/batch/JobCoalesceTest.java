package io.ecocode.testapp.environment.batch;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.Handler;

public class JobCoalesceTest extends Activity {

    private AlarmManager.OnAlarmListener listener() { return null; }

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context context = null;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, JobCoalesceTest.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        String alarmTag = "Alarm's tag";
        AlarmManager.OnAlarmListener onAlarmListener = listener();
        Handler handler = new Handler();
        AlarmManager.AlarmClockInfo alarmClockInfo = new AlarmManager.AlarmClockInfo(System.currentTimeMillis(), pendingIntent);

        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent); // Issue {Batch: Job Coalesce}
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), alarmTag, onAlarmListener, handler); // Issue {Batch: Job Coalesce}
        alarmManager.setAlarmClock(alarmClockInfo, pendingIntent); // Issue {Batch: Job Coalesce}
        alarmManager.setAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent); // Issue {Batch: Job Coalesce}
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent); // Issue {Batch: Job Coalesce}
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), alarmTag, onAlarmListener, handler); // Issue {Batch: Job Coalesce}
        alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pendingIntent); // Issue {Batch: Job Coalesce}
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000, pendingIntent); // Issue {Batch: Job Coalesce}
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000, pendingIntent); // Issue {Batch: Job Coalesce}
        alarmManager.setWindow(AlarmManager.RTC_WAKEUP, 0, 1, pendingIntent); // Issue {Batch: Job Coalesce}
        alarmManager.setWindow(AlarmManager.RTC_WAKEUP, 0, 1, alarmTag, onAlarmListener, handler); // Issue {Batch: Job Coalesce}

        SyncAdapter syncAdapter = new SyncAdapter(context, true);
        Account account = new Account("account", "account.google.com");
        Bundle extras = new Bundle();
        String authority = "director";
        ContentProviderClient contentProviderClient = null;
        SyncResult syncResult = new SyncResult();

        syncAdapter.getSyncAdapterBinder(); // Issue {Batch: Job Coalesce}
        syncAdapter.onPerformSync(account, extras, authority, contentProviderClient, syncResult); // Issue {Batch: Job Coalesce}
    }
}

class SyncAdapter extends AbstractThreadedSyncAdapter{

    public SyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize);
    }

    @Override
    public void onPerformSync(Account account, Bundle bundle, String s, ContentProviderClient contentProviderClient, SyncResult syncResult) {}
}