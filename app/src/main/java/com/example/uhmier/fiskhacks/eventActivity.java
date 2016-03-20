package com.example.uhmier.fiskhacks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class eventActivity extends AppCompatActivity {
    @InjectView(R.id.eventname) TextView eventname;

    @InjectView(R.id.eventdescription)TextView eventdescription;
    @InjectView(R.id.eventlocation)TextView eventlocation;
    @InjectView(R.id.eventdate)TextView eventdate;
    Event mEvent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        ButterKnife.inject(this);
        Intent i = getIntent();
        String id = i.getStringExtra("id");
        ParseQuery<Event> query = new ParseQuery("Event") ;
        query.whereEqualTo("objectId", id);
        query.findInBackground(new FindCallback<Event>() {
            @Override
            public void done(List<Event> objects, ParseException e) {
                if (e == null){
                    mEvent = objects.get(0);
                    setInputs();
                }
            }
        });

    }
    public void setInputs(){
        eventname.setText(mEvent.getName());
        eventdescription.setText(mEvent.getDescription());
        //eventlocation.setText(mEvent.getLocation());
        eventdate.setText(mEvent.getDate());
    }



}

