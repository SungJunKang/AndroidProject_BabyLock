package kr.co.ana.babylock6;

import android.icu.util.ULocale;
import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

public class Unlock extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unlock);

        Switch sw_use = (Switch) findViewById(R.id.switch_use);
        Switch sw_al = (Switch) findViewById(R.id.switch_al);

        SeekBar seekVolumn = (SeekBar) findViewById(R.id.seekbar_vol);

        final AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int nMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int nCurrentVolumn = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seekVolumn.setMax(nMax);
        seekVolumn.setProgress(nCurrentVolumn);

        seekVolumn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        sw_use.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(Unlock.this, "잠금 해제시 알림을 사용합니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Unlock.this, "잠금 해제시 알림을 사용하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sw_al.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(Unlock.this, "잠금 해제시 알림창이 뜹니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Unlock.this, "잠금 해제시 알림창이 뜨지 않습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
