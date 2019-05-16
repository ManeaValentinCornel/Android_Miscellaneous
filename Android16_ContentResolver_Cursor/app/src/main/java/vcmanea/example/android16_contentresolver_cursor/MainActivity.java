package vcmanea.example.android16_contentresolver_cursor;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button showContacts;
    private static final String TAG = "MainActivity";
    public static final int REQUEST_CODE_READ_CONTACT=1;
    String[] mColumnProjection={ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.HAS_PHONE_NUMBER};
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text_id);
        showContacts=findViewById(R.id.show_contacts);

        showContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentResolver mContentResolver=getContentResolver();
                Cursor mCursor=mContentResolver.query(ContactsContract.Contacts.CONTENT_URI,
                        mColumnProjection,
                        null,
                        null,
                        null);

                if((mCursor!=null)&&(mCursor.getCount()>0)){

                    mCursor.moveToFirst();

                    do{
                        String name=mCursor.getString(0);
                        String status=mCursor.getString(1);
                        String number=mCursor.getString(2);
                        textView.setText(name+status+number+"\n");

                    }
                    while(mCursor.moveToNext());




                }
                else{
                    textView.setText("No contacts in device");
                }


            }
        });


        int hasReadeContactPermission=ContextCompat.checkSelfPermission(this,Manifest.permission.READ_CONTACTS);
        Log.d(TAG, "hasReadContactPermission " + hasReadeContactPermission);



        if(hasReadeContactPermission !=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_CONTACTS},REQUEST_CODE_READ_CONTACT);
            Log.d(TAG, "onCreate: requesting permission");


        }














}
}
