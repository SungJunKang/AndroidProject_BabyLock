package kr.co.ana.babylock6;

import android.content.Intent;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Lock_gesture extends AppCompatActivity implements GestureDetector.OnGestureListener {

    public int[] gesture_basic = {1, 2, 1, 2};
    public int[] gesture_set = {1, 2, 1, 2};
    private GestureDetectorCompat mDetector;
    Button btn_check1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_gesture);
        mDetector = new GestureDetectorCompat(this, this);

        btn_check1 = (Button) findViewById(R.id.btn_check1);

        btn_check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Lock_gesture.this, "잠금 해제", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Playlist.class);
                startActivity(intent);
            }
        });

    }

    public void Onclick(View v){
        Intent lock_data = new Intent(this, Lock_data.class);
        Intent main = new Intent(this, MainActivity.class);
        switch(v.getId()){
            case R.id.iv1 :
                startActivity(lock_data);
                break;
            case R.id.back :
                startActivity(main);
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float v, float v1) {
        if (Math.abs(e1.getX() - e2.getX()) < 250 && (e1.getY() - e2.getY() > 0)) {
            //위로 드래그 1
            Toast.makeText(getApplication(), "UP", Toast.LENGTH_SHORT).show();
        } else if (Math.abs(e1.getX() - e2.getX()) < 250 && (e2.getY() - e1.getY() > 0)) {
            //아래로 드래그 2
            Toast.makeText(getApplicationContext(), "DOWN", Toast.LENGTH_SHORT).show();
        } else if (Math.abs(e1.getY() - e2.getY()) < 250 && (e1.getX() - e2.getX() > 0)) {
            //왼쪽 드래그 3
            Toast.makeText(getApplication(), "LEFT", Toast.LENGTH_SHORT).show();
        } else if (Math.abs(e1.getY() - e2.getY()) < 250 && (e2.getX() - e1.getX() > 0)) {
            //오른쪽 드래그 4
            Toast.makeText(getApplicationContext(), "RIGHT", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
