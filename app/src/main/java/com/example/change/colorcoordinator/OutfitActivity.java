package com.example.change.colorcoordinator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by Change on 4/2/2016.
 */
public class OutfitActivity extends Activity {
    private File imageFile;
    Button b1,b2;
    ImageView iv;
    private int photoList = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Remove the top bar of the app
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfit);

        b1=(Button)findViewById(R.id.btnAddClothing);
        //iv=(ImageView)findViewById(R.id.imageViewTest);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check which txtbox to use
                switch(photoList){
                    case 1: iv=(ImageView)findViewById(R.id.imageViewTest);break;
                    case 2: iv=(ImageView)findViewById(R.id.imageViewTest2);break;
                    case 3: iv=(ImageView)findViewById(R.id.imageViewTest3);break;
                    case 4: iv=(ImageView)findViewById(R.id.imageViewTest4);break;
                    case 5: iv=(ImageView)findViewById(R.id.imageViewTest5);break;
                    case 6: iv=(ImageView)findViewById(R.id.imageViewTest6);break;
                    case 7: iv=(ImageView)findViewById(R.id.imageViewTest7);break;
                    case 8: iv=(ImageView)findViewById(R.id.imageViewTest8);break;
                    case 9: iv=(ImageView)findViewById(R.id.imageViewTest9);break;
                }
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

    }

    //sets image to the image id location
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        iv.setImageBitmap(bp);
        photoList++;
    }


    public void goBackToMain(View v) {
        // Kabloey
        Intent backToMain = new Intent(v.getContext(), MainActivity.class);
        startActivityForResult(backToMain, 0);
    }
}
