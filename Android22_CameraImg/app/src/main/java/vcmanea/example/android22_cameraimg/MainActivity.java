package vcmanea.example.android22_cameraimg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mCaptureBtn;
    ImageView mImageView;
    private static final int PERMISSION_CODE=1000;
    private static final int REQUEST_IMAGE_CAPTURE=1001;

    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCaptureBtn=findViewById(R.id.capture_image_btn);
        mImageView=findViewById(R.id.save_image);

        mCaptureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if system os is >= marshmallow, requires runtime permission
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if( checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED  ){
                    //permission not enable, request it
                    String[] permission ={Manifest.permission.CAMERA};

                    //show pop-up to request permission

                        requestPermissions(permission,PERMISSION_CODE);

                    }
                    else{
                        //permission already granted
                        dispatchTakePictureIntent();
                    }
                    }

                else{
                    //system os < marshmallow
                    dispatchTakePictureIntent();
                }
                }

        });


    }

    private void dispatchTakePictureIntent(){

        Intent takePictureIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {


            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }



    //handling permission result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //this method is called, when usser presses Allow or Deny from Permission Request  Popup

        switch (requestCode){
            case PERMISSION_CODE:
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                //permission from popup was granted
                dispatchTakePictureIntent();
            }
            else{
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }



        }


    }


    //
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode ==RESULT_OK){
            Bundle extras=data.getExtras();
            Bitmap imageBitmap=(Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
        //called when image was captured from camera
    }
}
