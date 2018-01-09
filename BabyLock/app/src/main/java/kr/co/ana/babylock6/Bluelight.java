package kr.co.ana.babylock6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Bluelight extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluelight);

        Switch sw_use = (Switch) findViewById(R.id.sw_use);

        sw_use.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(Bluelight.this, "블루 라이트 차단을 사용합니다.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Bluelight.this, "블루 라이트 차단을 사용하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void Onclick(View v){
        Intent main = new Intent(this, MainActivity.class);
        switch (v.getId()){
            case R.id.back :
                startActivity(main);
                break;
        }
    }
}
