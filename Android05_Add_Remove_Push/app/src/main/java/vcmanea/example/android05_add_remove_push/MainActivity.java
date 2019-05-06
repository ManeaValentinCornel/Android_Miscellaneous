package vcmanea.example.android05_add_remove_push;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment = null;

        mButton = findViewById(R.id.button);
        mFragmentManager = getSupportFragmentManager();


        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addFragment();
            }
        });


    }


    public void addFragment() {

        Fragment fragment;
        fragment = mFragmentManager.findFragmentById(R.id.fragment_container);
        if (fragment instanceof FragmentSample) {
            fragment = new FragmentSample_Two();
        } else {
            fragment = new FragmentSample();
        }

        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.fragment_container, fragment);
        //i can either replace it with replace... then will be only one fragment in the top of the stack
        mFragmentTransaction.commit();

    }


    @Override
    public void onBackPressed() {
        Fragment fragment = mFragmentManager.findFragmentById(R.id.fragment_container);
        if ((fragment != null)) {
            mFragmentTransaction = mFragmentManager.beginTransaction();
            mFragmentTransaction.remove(fragment);
            mFragmentTransaction.commit();

        } else {
            super.onBackPressed();
        }
    }
}
