package vcmanea.example.firebase01_realtimedatabase_addretrieve_data;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mDatabase;

    Button startButton;
    EditText emailText;
    EditText nameText;
    Button showButton;
    TextView showContacts;
    String name,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name="";
        email="";
        nameText=findViewById(R.id.enter_name);
        emailText=findViewById(R.id.enter_email);
        startButton=findViewById(R.id.startBtn);
        showButton=findViewById(R.id.showBtn);
        showContacts=findViewById(R.id.text_name);

        mDatabase= FirebaseDatabase.getInstance().getReference();

        

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("Name").getValue()!=null && dataSnapshot.child("Email").getValue()!=null) {
                   name=dataSnapshot.child("Name").getValue().toString();
                   email=dataSnapshot.child("Email").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        startButton.setOnClickListener(new View.OnClickListener(){


            public void onClick(View view){


               name=nameText.getText().toString();
               email=emailText.getText().toString();
                nameText.getText().clear();
                emailText.getText().clear();

                HashMap<String,String> dataMap=new HashMap<>();

                dataMap.put("Name",name);
                dataMap.put("Email",email);






                mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Data succesfully stored", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Error occurred", Toast.LENGTH_SHORT).show();
                        }
                    }
                });



                showButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showContacts.setText(name+email);
                    }
                });





            }
        });




    }
}
