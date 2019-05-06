package vcmanea.example.android03_addingfragmentdynamicalli_programatically;

import  android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragment(savedInstanceState);

    }



    public void addFragment(Bundle bundle){
        fragmentManager = getSupportFragmentManager();
        //if(fragmentManager.findFragmentById(R.id.sample_fragment_id)==null)
      if(bundle==null){
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            SampleFragment sampleFragment = new SampleFragment();
            transaction.addToBackStack(null);
            transaction.add(R.id.fragment_container, sampleFragment);
            transaction.commit();
        }
    }
}
