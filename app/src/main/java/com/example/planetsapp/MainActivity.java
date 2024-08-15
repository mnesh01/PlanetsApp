package com.example.planetsapp;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import com.example.planetsapp.Planet;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList <Planet> planetsArrayList;
    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1- AdapterView: a ListView
        listView  = findViewById(R.id.listView);

        // 2- Data Source: ArrayList<Planet>
        planetsArrayList = new ArrayList<>();

        Planet planet3 = new Planet("Earth","1 Moon",R.drawable.earth);
        Planet planet1 = new Planet("Mercury","0 Moons",R.drawable.mercury);
        Planet planet2 = new Planet("Venus", "0 Moons", R.drawable.venus);

        Planet planet4 = new Planet("Mars", "2 Moons", R.drawable.mars);
        Planet planet5 = new Planet("Jupiter", "79 Moons", R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn", "83 Moons", R.drawable.saturn);

        Planet planet7 = new Planet("Uranus", "27 Moons", R.drawable.uranus);
        Planet planet8 = new Planet("Neptune", "14 Moons", R.drawable.neptune);
        Planet planet9 = new Planet("Pluto","5 Moons", R.drawable.pluto);

        planetsArrayList.add(planet1);
        planetsArrayList.add(planet2);
        planetsArrayList.add(planet3);
        planetsArrayList.add(planet4);
        planetsArrayList.add(planet5);
        planetsArrayList.add(planet6);
        planetsArrayList.add(planet7);
        planetsArrayList.add(planet8);
        planetsArrayList.add(planet9);

        // Adapter
        adapter = new MyCustomAdapter(planetsArrayList, getApplicationContext());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // adapter view in which the click event occurs
            // View the specific view that was interacted with
            //position of the clicked item within the adapter views item
            //long id holds the row id of the clicked item
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Planet name" + adapter.getItem(position).getPlanetName(),
                        Toast.LENGTH_SHORT).show();

            }
        });
        }
    }