package vcmanea.example.android08_callback_fragmentinteraction;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CallBackInterface {
    FragmentManager mFragmentManager;
    FragmentTransaction transaction;
    Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=findViewById(R.id.startActivity);

    mFragmentManager=getSupportFragmentManager();





    mButton.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
            FirstFragment fragment=new FirstFragment();
            transaction=getSupportFragmentManager().beginTransaction();
            fragment.setCallBackInterface(MainActivity.this);
            transaction.add(R.id.fragment_container,fragment);
            transaction.commit();

        }
    });
    }


    @Override
    public void callBackMethod() {
        Toast.makeText(MainActivity.this,"ToDO: Trigger other fragment",Toast.LENGTH_LONG).show();
    }
}
