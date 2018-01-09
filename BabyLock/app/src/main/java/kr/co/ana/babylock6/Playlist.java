package kr.co.ana.babylock6;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Playlist extends YouTubeBaseActivity {

    YouTubePlayerView playerView;
    Button button;
    YouTubePlayer.OnInitializedListener listener;
    EditText et_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        button = (Button) findViewById(R.id.btn_play);
        playerView = (YouTubePlayerView)findViewById(R.id.youtubeView);
        et_link = (EditText) findViewById(R.id.et_link);

        listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadPlaylist(String.valueOf(et_link.getText()));
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerView.initialize("AIzaSyDY7JczxZLt-p_0a1U8R6ds_azerBQY6Os" , listener);
                android.support.v4.app.NotificationCompat.Builder mBuilder =
                        new android.support.v4.app.NotificationCompat.Builder(getApplicationContext())
                                .setSmallIcon(R.drawable.icon_babylock)
                                .setContentTitle("Baby Lock")
                                .setContentText("BabyLock이 활성화 되었습니다.")
                                .setDefaults(Notification.DEFAULT_SOUND);

                Intent resultIntent = new Intent(getApplicationContext(), Unlock_gesture.class);

                TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
                stackBuilder.addParentStack(Unlock_gesture.class);
                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent =
                        stackBuilder.getPendingIntent(
                                0,
                                PendingIntent.FLAG_UPDATE_CURRENT
                        );

                mBuilder.setContentIntent(resultPendingIntent);

                NotificationManager mNotificationManager =
                        (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                mNotificationManager.notify(0, mBuilder.build());

                getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        });

    }
    public void Onclick(View v){
        Intent main = new Intent(this, MainActivity.class);
        switch (v.getId()){
            case R.id.iv3 :
                startActivity(main);
                break;
        }
    }
}
