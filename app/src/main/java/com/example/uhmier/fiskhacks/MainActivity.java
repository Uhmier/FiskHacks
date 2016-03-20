package com.example.uhmier.fiskhacks;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    List<Event> events = new ArrayList<>();
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    EventsAdapter adapter;
    private ProgressDialog _progressDialog;
    private String defaultAddress= Constants.DEFAULT_ADDRESS;
    private boolean isAnywhere = false;
    private int defaultDistance;
    private boolean usesGps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.event_lists);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        LocationManager locMan = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location loc = null;
        try {
            loc = locMan.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }catch(SecurityException e){
            e.printStackTrace();
            Log.e("DidntWork", e.toString());
        }
        double latitude;
        double longitude;
        if ( loc != null) {
            latitude = loc.getLatitude();
            longitude = loc.getLongitude();
            defaultAddress = "" + latitude + "," + longitude;
        }

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CreateEventActivity.class);
                startActivity(i);
                
            }
        });

        ParseUser user = ParseUser.getCurrentUser();
        if(user != null){
            defaultDistance =  user.get("DISTANCE_PREF") == null? 100000: (int) user.get("DISTANCE_PREF");
        }else{
            isAnywhere = true;
        }

        updateList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            return true;
        }else if(id == R.id.action_refresh){
            updateList();
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateList() {
        _progressDialog = new ProgressDialog(this);
        _progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        _progressDialog.setMessage("Loading Events");
        _progressDialog.setCancelable(true);
        _progressDialog.show();
        events.clear();
        ParseQuery<Event> query = ParseQuery.getQuery("Event");
        query.findInBackground(new FindCallback<Event>() {
            @Override
            public void done(List<Event> eventList, ParseException e) {
                if(isAnywhere) events = eventList;
                else {
                    for (Event currEvent : eventList) {
                        String dis = DistanceUtils.getDistance(defaultAddress, currEvent.getLocation())[0];
                        Log.e("Amier", dis);
                        if (Integer.parseInt(dis) < defaultDistance) {
                            events.add(currEvent);
                        }
                    }
                }
                    adapter = new EventsAdapter(MainActivity.this, events);
                    recyclerView.setAdapter(adapter);
                    _progressDialog.dismiss();

            }
        });
    }
}
