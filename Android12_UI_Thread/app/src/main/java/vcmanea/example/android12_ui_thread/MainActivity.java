package vcmanea.example.android12_ui_thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    Button bStart, bStop;

    private boolean mStopLoop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: " + Thread.currentThread().getId());

        bStart = findViewById(R.id.start);
        bStop = findViewById(R.id.stop);

        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.start:
                mStopLoop = true;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (mStopLoop) {
                            Log.d(TAG, "run: " + Thread.currentThread().getId());
                        }
                    }
                }).start();


                break;
            case R.id.stop:
                mStopLoop = false;
                break;


        }
    }
}
