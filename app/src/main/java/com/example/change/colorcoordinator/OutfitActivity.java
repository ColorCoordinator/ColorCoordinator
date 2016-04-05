package com.example.change.colorcoordinator;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
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



    }


    public void goBackToMain(View v) {
        // Kabloey
        Intent backToMain = new Intent(v.getContext(), MainActivity.class);
        startActivityForResult(backToMain, 0);
    }

    public void removeClothing(){

    }
    public void addClothing(View view){

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        imageFile=new File(getExternalFilesDir(null),
                "colorWilly2.jpg");

        Uri tempuri = Uri.fromFile(imageFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, tempuri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
        startActivityForResult(intent, 0);

    }

    //sets image to the image id location
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==0){
            Log.d("ColorCoordinator", "THIS WORK?");
            switch(resultCode){
                case Activity.RESULT_OK:
                    if(imageFile.exists()){
                        Toast.makeText(this, "File saved at "+imageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                        iv =(ImageView)findViewById(R.id.imageViewTest);
                        //Bitmap bp = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
                        //Bitmap bp = (Bitmap) data.getExtras().get("data");
                        //iv.setImageBitmap(bp);
                    }
                    else{
                        Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case Activity.RESULT_CANCELED:
                    break;
                default:
                    break;
            }
        }
        if(requestCode==1){
            iv =(ImageView)findViewById(R.id.imageViewTest);
            //Bitmap bp = BitmapFactory.decodeFile(imageFile.getAbsolutePath());
            //iv.setImageBitmap(bp);
            Bitmap camimage = (Bitmap) data.getExtras().get("data");
            iv.setImageBitmap(camimage);
        }
    }
}
