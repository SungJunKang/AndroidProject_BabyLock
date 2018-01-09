package kr.co.ana.babylock6;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.hardware.camera2.params.BlackLevelPattern;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, Splash.class));

    }
    public void Onclick(View v){
        Intent lock_data = new Intent(this, Lock_data.class);
        Intent playlist = new Intent(this, Playlist.class);
        Intent tutorial = new Intent(this, Unlockac1.class);
        Intent unlock = new Intent(this, Unlock.class);
        Intent blue = new Intent(this, Bluelight.class);

        switch(v.getId()){
            case R.id.main_lock :
                startActivity(lock_data);
                break;
            case R.id.main_list :
                startActivity(playlist);
                NetworkChangeReceiver networkInfo = new NetworkChangeReceiver();
                networkInfo.onReceive(getApplicationContext(), getIntent());

                break;
            case R.id.main_tutorial :
                startActivity(tutorial);
                break;
            case R.id.main_unlock :
                startActivity(unlock);
                break;
            case R.id.main_blue :
                startActivity(blue);
                break;
        }
    }
}
