package vcmanea.example.android01_fragmentstatepageradapter_tablayout_recycleview_fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager mViewPager;
    ViewStatePagerAdapter mViewStatePagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = findViewById(R.id.tabLayout_id);
        mViewPager = findViewById(R.id.viewpager_id);

        mViewStatePagerAdapter = new ViewStatePagerAdapter(getSupportFragmentManager());
        mViewStatePagerAdapter.addFragment(new CallFragment(),"Call");
        mViewStatePagerAdapter.addFragment(new ContactsFragment(),"Contacts");
        mViewStatePagerAdapter.addFragment(new FavFragment(),"Favorites");


        mViewPager.setAdapter(mViewStatePagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setIcon(R.drawable.ic_call_black_24dp);
        mTabLayout.getTabAt(1).setIcon(R.drawable.ic_contacts_black_24dp);
        mTabLayout.getTabAt(2).setIcon(R.drawable.ic_favorite_black_24dp);

        ActionBar actionBar=getSupportActionBar();
        actionBar.setElevation(0);


    }
}
