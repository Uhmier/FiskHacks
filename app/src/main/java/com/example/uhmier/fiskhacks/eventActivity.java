package com.example.uhmier.fiskhacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.InjectView;

public class eventActivity extends AppCompatActivity {
    @InjectView(R.id.eventname) TextView eventname;

    @InjectView(R.id.eventdescription)TextView eventdescription;
    @InjectView(R.id.eventlocation)TextView eventlocation;
    @InjectView(R.id.eventdate)TextView eventdate;
    Event mEvent;

    @InjectView(R.id.editTextEventDescription)EditText eventDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        eventname.setText(mEvent.getName());
        eventdescription.setText(mEvent.getDescription());
        //eventlocation.setText(mEvent.getLocation());
        eventdate.setText(mEvent.getDate());
    }

}

