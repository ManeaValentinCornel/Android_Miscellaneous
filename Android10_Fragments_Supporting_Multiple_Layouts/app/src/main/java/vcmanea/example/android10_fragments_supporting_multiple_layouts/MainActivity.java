package vcmanea.example.android10_fragments_supporting_multiple_layouts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerAdapterCountry.OnCountryClickListener {
    Fragment fragment;
    FragmentManager mFragmentManager;
    FragmentTransaction transaction;
    List<Country> countryList;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");


        mFragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.activity_main_portrait) != null) {
            //code for the protrait variation....
            if(savedInstanceState==null) {

                addCountryFragment();
            }

        } else if (findViewById(R.id.actibity_main_landscape) != null) {
            //code for the landscape variation
            if(savedInstanceState==null) {
                addCountryFragment();
            }
        }
    }


    private void addCountryFragment() {
        countryList=Country.getCountryList();
        countryList.add(new Country("Romania","Very good to live in"));
        countryList.add(new Country("England","Very good to live in"));
        countryList.add(new Country("India","Very good to live in"));
        fragment=new CountryFragment();
        transaction = mFragmentManager.beginTransaction();
        transaction.add(R.id.fragment_container1,fragment);
        transaction.commit();

    }


    @Override
    public void onCountryClick(int position) {
        Toast.makeText(MainActivity.this,"Number clicked is"+position ,Toast.LENGTH_SHORT).show();

    }
}
