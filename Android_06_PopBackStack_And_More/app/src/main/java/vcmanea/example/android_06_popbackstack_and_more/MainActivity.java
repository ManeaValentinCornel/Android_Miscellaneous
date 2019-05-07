package vcmanea.example.android_06_popbackstack_and_more;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Fragment fragment;
    FragmentManager mFragmentManager;
    FragmentTransaction transaction;
    Button addButton;
    Button removeButton;
    Button replaceButton;
    Button popBackStackButton;
    TextView mTextView;
    TextView mTextView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView=findViewById(R.id.text);
        mTextView2=findViewById(R.id.textFragments);
        addButton =findViewById(R.id.add);
        removeButton=findViewById(R.id.remove);
        replaceButton=findViewById(R.id.replace);
        popBackStackButton=findViewById(R.id.pop);



        mFragmentManager=getSupportFragmentManager();
        mFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener(){

            @Override
            public void onBackStackChanged() {
                mTextView.setText(String.valueOf(getSupportFragmentManager().getBackStackEntryCount()));
                mTextView2.setText(""+(getSupportFragmentManager().getFragments().size()));

            }
        });



        addButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                addFragment();
            }
        });
        removeButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                onRemove();
            }
        });

        replaceButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onReplace();
            }
        });

        popBackStackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentManager.popBackStack();
            }
        });
    }

    /**
     *
     */
    public void addFragment(){
       fragment=mFragmentManager.findFragmentById(R.id.fragment_container);

        if(fragment instanceof FragmentOne){
            fragment=new FragmentTwo();
        }
         else if(fragment instanceof FragmentTwo)
        {
            fragment=new FragmentThree();
        }
         else if(fragment instanceof FragmentThree){
             fragment=new FragmentOne();
        }

         else{
             fragment=new FragmentOne();
        }

         transaction=mFragmentManager.beginTransaction();
         transaction.add(R.id.fragment_container,fragment);
         transaction.addToBackStack(null);
         transaction.commit();

    }

    public void onRemove(){
        mTextView2.setText(""+getSupportFragmentManager().getFragments().size());
        fragment=mFragmentManager.findFragmentById(R.id.fragment_container);
        if(fragment!=null) {
            transaction = mFragmentManager.beginTransaction();
            transaction.remove(fragment);
            transaction.commit();
        }}

        public void onReplace(){
            fragment=mFragmentManager.findFragmentById(R.id.fragment_container);
            if (fragment!=null){
                transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,new FragmentThree());
                transaction.commit();
            }
        }




    }
























