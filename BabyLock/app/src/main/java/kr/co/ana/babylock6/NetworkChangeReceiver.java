package kr.co.ana.babylock6;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NetworkChangeReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        String status = NetworkUtil.getConnectivityStatusString(context);

        Toast.makeText(context, status, Toast.LENGTH_SHORT).show();

        if(status == "Mobile data에 연결되어 있습니다."){
            android.support.v4.app.NotificationCompat.Builder mBuilder =
                    new android.support.v4.app.NotificationCompat.Builder(context)
                            .setSmallIcon(R.drawable.icon_babylock)
                            .setContentTitle("Baby Lock")
                            .setContentText("※주의※ 모바일 데이터에 연결되어 있습니다.")
                            .setDefaults(Notification.DEFAULT_SOUND);
            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(0, mBuilder.build());
        }
    }
}
