package vcmanea.example.android17_intentexplicit_intentimplicit_parcelable;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SecondActivity extends Activity {
    private static final String TAG = "SecondActivity";
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: starts");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String extra=getIntent().getStringExtra("extra");
        Toast.makeText(this, "extra value is"+ extra, Toast.LENGTH_SHORT).show();







    }
}
