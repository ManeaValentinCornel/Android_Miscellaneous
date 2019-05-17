package vcmanea.example.android17_intentexplicit_intentimplicit_parcelable;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ThirdActivity extends Activity {
    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_third);
        Log.d(TAG, "onCreate: starts");

//
//        Person ghita=(Person)getIntent().getSerializableExtra("Person");
//
//        Toast.makeText(this, "DAdadada"+ghita.getName()+ghita.getAge(), Toast.LENGTH_SHORT).show();

        News news=getIntent().getParcelableExtra("first");
        Toast.makeText(this, "Value is" + news.getName()+ news.getName(), Toast.LENGTH_SHORT).show();
    }
}
