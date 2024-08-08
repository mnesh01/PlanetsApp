package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {
    // class is for custom layout to populate
    // use of custom adapter so as to populate my modal class

    //we use arraylist as we need a data structure that grows or shrinks when removed
    private ArrayList<Planet> planetsArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Planet> planetsArrayList, Context context) {
        super(context, R.layout.item_list_layout, planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;
    }

    private static class MyViewHolder{
        TextView planetname;
        TextView moonCount;
        ImageView planetImg;
    }
    // getview(); is used to create and return a view for a specific item


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // get the planet object for the first position
        Planet planets = getItem(position);

        // inflate the layout
        MyViewHolder myViewHolder;
        final View result;

        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,// correctly set layout parameters
                    false // view will not be attached to the parent right away
            );

            //finding views

            myViewHolder.planetname = (TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.moon_count_text);
            myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView; // provides clarity in code and understand the flow

            convertView.setTag(myViewHolder);  //ensure later can retrieve from view
        }
        else {
            // the view is recycled
            myViewHolder = (MyViewHolder)  convertView.getTag();
            result= convertView;

        }

        //getting data from the modal class(Planet)
        myViewHolder.planetname.setText(planets.getPlanetName());
        myViewHolder.moonCount.setText(planets.getMoonCount());
        myViewHolder.planetImg.setImageResource(planets.getPlanetImage());

        return convertView;


    }
}
