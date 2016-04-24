package com.example.benjamin.cctest2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
   private Uri fileUri;
    private File imageFile;
    private ClothingArrayAdapter adapter;
    ArrayList<clothingItem> stuff;
    private int itemCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            stuff=savedInstanceState.getParcelableArrayList("clothingList");
           itemCount=savedInstanceState.getInt("itmCount");
        }
       else{
            stuff = new ArrayList<clothingItem>();
            itemCount=1;
        }



        adapter = new ClothingArrayAdapter(this, stuff);
        ListView listView  = (ListView) findViewById(R.id.listView);
        //listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        Button buttonAdd = (Button) findViewById(R.id.btnAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // create Intent to take a picture and return control to the calling application
                /*Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                fileUri = getOutputMediaFileUri(); // create a file to save the image
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

                // start the image capture Intent
                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
                */

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                imageFile=new File(getExternalFilesDir(null),
                        "CC_"+ timeStamp+".jpg");

                fileUri = Uri.fromFile(imageFile);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                startActivityForResult(intent, 0);


            }
        });

        clothingItem it1 = new clothingItem();
        it1.description= "Ben";

        clothingItem it2 = new clothingItem();
        it2.description= "Roll Tide";
        it1.filepath="";
        //adapter.add(it1);
       /* adapter.add(it2);
        adapter.add(it2);
        adapter.add(it2);
        adapter.add(it2);
        adapter.add(it1);
        adapter.add(it1);
        adapter.add(it2);
        adapter.add(it2);
        adapter.add(it2);
        adapter.add(it2);
        adapter.add(it1);
        adapter.add(it1);
        adapter.add(it2);
        adapter.add(it2);
        adapter.add(it2);
        adapter.add(it2);
        adapter.add(it1);*/

    }

   private Uri getOutputMediaFileUri(){
        return Uri.fromFile(getOutputMediaFile());
    }

    private  File getOutputMediaFile(){
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File file = new File(getFilesDir(), "TestFile1.jpeg");
        if (!file.exists()) try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                , "CCTestDIR");*/
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        /*if (! mediaStorageDir.exists()){
            if (! mediaStorageDir.mkdirs()){
                Log.d("CCTestDIR", "failed to create directory");
                return null;
            }
        }*/

        // Create a media file name
       /* String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;

            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "TEST_"+ timeStamp + ".jpg");*/

        return file;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Toast.makeText(this,"ACTIVATED",Toast.LENGTH_LONG).show();
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                // Image captured and saved to fileUri specified in the Intent
                Toast.makeText(this,"TAKEN",Toast.LENGTH_LONG).show();
                clothingItem test = new clothingItem();
                test.description ="Item " + itemCount;
                itemCount++;
                test.filepath = fileUri.getPath();

                adapter.add(test);
                /*Toast.makeText(this, "Image saved to:\n" +
                        data.getData(), Toast.LENGTH_LONG).show();*/
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
                Toast.makeText(this,"CANCELED",Toast.LENGTH_LONG).show();
            } else {
                // Image capture failed, advise user
                Toast.makeText(this,"NO",Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

       // savedInstanceState.putInt(STATE_SCORE, mCurrentScore);
        //savedInstanceState.putInt(STATE_LEVEL, mCurrentLevel);
        savedInstanceState.putParcelableArrayList("clothingList", stuff);
        savedInstanceState.putInt("itmCount",itemCount);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

}
