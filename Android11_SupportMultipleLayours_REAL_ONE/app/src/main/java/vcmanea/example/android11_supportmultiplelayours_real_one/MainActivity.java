package vcmanea.example.android11_supportmultiplelayours_real_one;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnCountryClickListener {
    FragmentManager manager;
    FragmentTransaction transcaction;
    Fragment mFragment;
    int countryPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();


        if (findViewById(R.id.main_activity_portrait) != null) {
            if (savedInstanceState == null) {
                addFragmentCountry();
            } else {
                addFragmentDescriptionPortrait(savedInstanceState.getInt("countryPosition", countryPosition));
            }
        } else if (findViewById(R.id.main_activity_landscape) != null) {

            replaceFragmentCountry();
            if (savedInstanceState == null) {
                addFragmentDescriptionLandscape(0);
            } else {
                addFragmentDescriptionLandscape(savedInstanceState.getInt("countryPosition", countryPosition));

            }

        }


    }


    public void addFragmentCountry() {
        mFragment = new CountryFragment();
        ((CountryFragment) mFragment).setOnCountryClickListener(this);
        transcaction = manager.beginTransaction();
        transcaction.add(R.id.first_container, mFragment);
        transcaction.commit();

    }

    public void replaceFragmentCountry() {
        mFragment = new CountryFragment();
        ((CountryFragment) mFragment).setOnCountryClickListener(this);
        transcaction = manager.beginTransaction();
        transcaction.replace(R.id.first_container, mFragment);
        transcaction.commit();

    }


    public void addFragmentDescriptionPortrait(int position) {
        mFragment = new DescriptionFragment();
        transcaction = manager.beginTransaction();
        transcaction.replace(R.id.first_container, mFragment);
        transcaction.commit();
        transcaction.addToBackStack(null);
    }

    public void addFragmentDescriptionLandscape(int position) {
        mFragment = new DescriptionFragment();
        transcaction = manager.beginTransaction();
        transcaction.replace(R.id.second_container, mFragment);
        transcaction.commit();
        transcaction.addToBackStack(null);

    }


    @Override
    public void onCountryClick(int position) {
        int myNumber;
        myNumber = manager.getFragments().size();
        Toast.makeText(MainActivity.this, "Position number is" + position + "  amount of layour is " + myNumber, Toast.LENGTH_LONG).show();
        if (findViewById(R.id.main_activity_portrait) != null) {
            addFragmentDescriptionPortrait(position);
        } else {
            addFragmentDescriptionLandscape(position);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("countryPosition", countryPosition);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        countryPosition = savedInstanceState.getInt("countryPosition", 0);
    }
}




