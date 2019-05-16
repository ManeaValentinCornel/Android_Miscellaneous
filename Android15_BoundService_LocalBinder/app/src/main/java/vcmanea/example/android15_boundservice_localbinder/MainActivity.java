package vcmanea.example.android15_boundservice_localbinder;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button start;
    private Button stop;
    private Button bind;
    private Button unbind;
    private Button show;
    private Intent myServiceIntent;


    private ServiceConnection mServiceConnection;
    private boolean isServiceBound;
    private MyService mMyService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        start = findViewById(R.id.start_btn);
        stop = findViewById(R.id.stop);
        bind = findViewById(R.id.bind);
        unbind = findViewById(R.id.unbind);
        show = findViewById(R.id.show_valuee);

start.setOnClickListener(this);
        stop.setOnClickListener(this);
        bind.setOnClickListener(this);
        unbind.setOnClickListener(this);
        show.setOnClickListener(this);

        myServiceIntent = new Intent(getApplicationContext(), MyService.class);



    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.start_btn:
                Toast.makeText(MainActivity.this," Started",Toast.LENGTH_LONG).show();
                startService(myServiceIntent);
                break;

            case R.id.stop:
                stopService(myServiceIntent);
                break;

            case R.id.bind:
               bindService();
                break;
            case R.id.unbind:
                unBindService();
                break;
            case R.id.show_valuee:
                showRandomNumber();
                break;


        }
    }

    private void bindService(){
        if(mServiceConnection==null){
           mServiceConnection=new ServiceConnection() {
                @Override
                public void onServiceConnected(ComponentName name, IBinder service) {
                    Log.d(TAG, "onServiceConnected: starts ");
                  MyService.MyServiceBinder myServiceBinder=(MyService.MyServiceBinder)service;
                  mMyService=myServiceBinder.getService();
                    isServiceBound=true;
                }

                @Override
                public void onServiceDisconnected(ComponentName name) {
                    Log.d(TAG, "onServiceDisconnected: starts");
                    isServiceBound=false;
                }
            };


        }
        bindService(myServiceIntent,mServiceConnection, Context.BIND_AUTO_CREATE);

    }

    private void unBindService(){
        if(isServiceBound){
            unbindService(mServiceConnection);
            isServiceBound=false;
        }
    }

    public void showRandomNumber(){
        if(isServiceBound){
            Toast.makeText(MainActivity.this," "+ mMyService.getI(),Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(MainActivity.this,"Service not bound ",Toast.LENGTH_LONG).show();
        }

    }

}
