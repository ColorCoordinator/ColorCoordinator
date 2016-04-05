package com.example.change.colorcoordinator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

/**
 * Created by Change on 4/3/2016.
 */
public class OptionsActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Remove the top bar of the app
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

    }
    public void goBackToMain(View v) {
        // Kabloey
        //Intent backToMain = new Intent(v.getContext(), MainActivity.class);
        //startActivityForResult(backToMain, 0);
        Toast.makeText(v.getContext(), "Login Fail" + MainActivity.somevalue, 3).show();
    }
}
