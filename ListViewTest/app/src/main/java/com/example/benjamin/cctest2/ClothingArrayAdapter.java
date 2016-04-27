package com.example.benjamin.cctest2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Benjamin on 4/3/2016.
 */
public class ClothingArrayAdapter extends ArrayAdapter<clothingItem>{

    //private final Context context;


    public ClothingArrayAdapter(Context context,  ArrayList<clothingItem> clothes) {
        super(context, R.layout.clothing_item, clothes);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        clothingItem item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.clothing_item, parent, false);
        }

        TextView descLabel = (TextView) convertView.findViewById(R.id.label);
        ImageView image = (ImageView)  convertView.findViewById(R.id.clothing_pic);
        descLabel.setText(item.description);
        image.setImageResource(R.mipmap.ic_launcher);
        //File imgFile = new File(item.filepath);

        if(item.filepath == ""){

            Bitmap myBitmap = BitmapFactory.decodeFile(item.filepath);


            image.setImageBitmap(myBitmap);

        }


        return convertView;
    }
}

class clothingItem{
    String description;
    String filepath;

}
