package com.nneka.myapplication;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String GADSIMAGEURL ="https://drive.google.com/file/d/15zrGlmDIVAuc-T2HKdNhLmAdf3qjzHm5/view";
    public ImageView mImageGads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageGads = findViewById(R.id.gads_image);

        setUpImage( mImageGads, GADSIMAGEURL );
    }

   public  void setUpImage(ImageView view, String GADSIMAGEURL ) {
       mImageGads = view;
       Context context = view.getContext();

      Picasso.with(context).load(GADSIMAGEURL).into(view);

       view.getHandler().postDelayed(new Runnable() {
           @Override
           public void run() {
             startActivity(new Intent(MainActivity.this,LeadersListActivity.class));
           }
       }, 7000);
    }
}
