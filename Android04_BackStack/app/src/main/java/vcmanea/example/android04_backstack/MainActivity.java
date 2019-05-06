package vcmanea.example.android04_backstack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    FragmentManager mFragmentManager;
    Button mButton;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();

        mButton = findViewById(R.id.next_fragment);
        mButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                addFragment();
            }
        });


        mFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Toast.makeText(MainActivity.this, "" + mFragmentManager.getBackStackEntryCount(), Toast.LENGTH_LONG).show();
            }
        });


    }


    private void addFragment() {
        Fragment fragment;
        Random random = new Random();
        int number = random.nextInt(3);
        //switch (mFragmentManager.getBackStackEntryCount()) {
        switch (number) {
            case 0:
                fragment = new FragmentOne();
                break;
            case 1:
                fragment = new FragmentTwo();
                break;
            case 2:
                fragment = new FragmentThree();
                break;
            default:
                fragment = new FragmentOne();
                break;
        }

        transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.frameLayout_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }


}










