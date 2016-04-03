package com.example.change.colorcoordinator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Remove the top bar of the app
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void startNewOutfit(View v) {
        // Kabloey
        if(v.getId() == R.id.btnOutfit) {
            Intent outfitScreen = new Intent(v.getContext(), OutfitActivity.class);
            startActivityForResult(outfitScreen, 0);
        }
    }

    public void openOptionsMenu(View v) {
        // Kabloey
        if(v.getId() == R.id.btnOptions) {
            Intent optionsScreen = new Intent(v.getContext(), OptionsActivity.class);
            startActivityForResult(optionsScreen, 0);
        }
    }



}
