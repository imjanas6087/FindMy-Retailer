package com.example.findmyretailer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView view;
    private DataBaseAccess baseAccess;
    ArrayList<Details>details;
    public static final String LATITUDE = "com.example.findmyretailer.Latitude";
    public static final String LONGITUDE = "com.example.findmyretailer.Longitude";
    public static final String ADDRESS = "com.example.findmyretailer.Address";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        baseAccess = new DataBaseAccess(getApplicationContext());
        baseAccess.open();
        details = baseAccess.getDetails();
        view = (RecyclerView) findViewById(R.id.recyclerView);
        view.setLayoutManager(new LinearLayoutManager(this));
        view.setHasFixedSize(true);
        RecyclerViewAdaptor recyclerViewAdaptor =new RecyclerViewAdaptor(this, details, clickEvent);
        view.setAdapter(recyclerViewAdaptor);
    }

  ClickEvent clickEvent = new ClickEvent() {
      @Override
      public void methodShare(String Latitude, String Longitude, String Address) {
        Intent intent = new Intent(MainActivity.this, MapsFragment.class);
        intent.putExtra(LATITUDE,Latitude);
        intent.putExtra(LONGITUDE,Longitude);
        intent.putExtra(ADDRESS, Address);
        startActivity(intent);

      }
  };
}