package vcmanea.example.android07_implementation;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    FragmentManager mFragmentManager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null) {
            transaction = mFragmentManager.beginTransaction();
            transaction.add(R.id.fragment_container, new CountriesFragment());
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }


}
