package vcmanea.example.android17_intentexplicit_intentimplicit_parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button start_explicit;
    Button start_implicit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_explicit=findViewById(R.id.start_explicit_intent);
        start_implicit=findViewById(R.id.start_implicit_intent);

        //Explicitly
        start_implicit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("extra","extra value");
                startActivity(intent);

            }
        });
         //Implicitly
        start_explicit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent2=new Intent();
                intent2.setAction("bobo.action");
                intent2.addCategory(Intent.CATEGORY_DEFAULT);

//                           //Serializable
//                Person ghita=new Person("ghita","20");
//                intent2.putExtra("Person",ghita);
//                startActivity(intent2);


                News neww=new News();
                neww.setName("Topic");
                neww.setSecondName("Another thing");

                intent2.putExtra("first",neww);

                startActivity(intent2);







            }
        });




    }
}
