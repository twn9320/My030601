package com.example.yvtc.my030601;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    final int REQUEST_CODE_CAMERA =123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click1(View v){
        Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_CODE_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_CAMERA){
            if(resultCode==RESULT_OK){
                if(data !=null){
                    if(data.hasExtra("data")){
                        Bitmap thumbnail = data.getParcelableExtra("data");
                        ImageView img = (ImageView)findViewById(R.id.imageView);
                        img.setImageBitmap(thumbnail);
                    }
                }else{}
            }
        }
    }
}
