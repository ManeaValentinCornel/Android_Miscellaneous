package vcmanea.example.android15_boundservice_localbinder;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private int number;
    int i ;
    boolean flag;
    private static final String TAG = "MyService";
    IBinder mIBinder = new MyServiceBinder();


    class MyServiceBinder extends Binder {





        public MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return mIBinder;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");
        flag = true;
        i=0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                generate();
            }
        }).start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        stopGenerate();
        Log.d(TAG, "onDestroy: ");
        super.onDestroy();
    }

    /////////////////////////////////////////
    public void generate() {
        while (flag) {
            try {
                Thread.sleep(5000);
                Log.i(TAG, "generate: " + i++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void stopGenerate() {
        flag = false;
    }

    public int getI() {
        return i;
    }
}


