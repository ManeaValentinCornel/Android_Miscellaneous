package vcmanea.example.android09_callbacks_donecorrecly;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CallBackInterface {
    Fragment fragment;
    FragmentManager mFragmentManager;
    FragmentTransaction transaction;
    Button mButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.start_fragment_btn);
        mFragmentManager = getSupportFragmentManager();

        if (savedInstanceState == null) {
            addFragment();
        }



        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addFragment();
            }
        });


    }

    private void addFragment() {
        fragment = new CountryFragment();
        ((CountryFragment) fragment).setCallBackInterface(this);
        transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();

    }

    private void addFragmentDescription(String country) {
        fragment = new DetailsFragment();
        transaction = getSupportFragmentManager().beginTransaction();

        Bundle bundle = new Bundle();
        bundle.putString(CallBackInterface.KEY_SELECTED_COUNTRY, country);
        fragment.setArguments(bundle);


        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onCountrySelected(String country) {
        Toast.makeText(MainActivity.this, "Do nothing for now", Toast.LENGTH_SHORT).show();
        addFragmentDescription(country);
    }
}
