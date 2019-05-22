package vcmanea.example.firebase02_authentication_creatinguser;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity {

    ProgressBar mProgressBar;
    FirebaseAuth mAuth;
    Button signBtn;
    EditText editTextEmail;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();
        mProgressBar=(ProgressBar) findViewById(R.id.progressBar);

        editTextEmail =findViewById(R.id.email);
        editTextPassword =findViewById(R.id.password);
        signBtn=findViewById(R.id.signInBtn);

        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();

            }
        });




    }

    public void registerUser(){

        String email= editTextEmail.getText().toString().trim();
        String password= editTextPassword.getText().toString().trim();

        //CHECKING IF THE EMAIL IS EMPTY
        if(email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        ///CHECKING IF THE EMAIL IS VALID
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a valid mail");
            editTextEmail.requestFocus();
            return;

        }

        //CHECKING IF THE PASSWORD IS EMPTY
        if(password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length()<6){
            editTextPassword.setError("Minimum length of the password should be 6");
            editTextPassword.requestFocus();
            return;
        }
        ////////PASS ALL THE VALIDATION

        //Progress bar
        mProgressBar.setVisibility(View.VISIBLE);
        //CREATE A NEW USER
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                mProgressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"User Registred Successfull",Toast.LENGTH_LONG).show();
                }
                else {
                    //CHECK IF THE USER IS ALREADY LOGED
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "You are already registred!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }}
        });

    }
}


