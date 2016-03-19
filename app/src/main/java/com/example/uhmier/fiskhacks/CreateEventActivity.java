package com.example.uhmier.fiskhacks;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.parse.ParseUser;

import java.util.Date;

import butterknife.InjectView;

public class CreateEventActivity extends AppCompatActivity {

    @InjectView(R.id.editTextEventName)
    EditText eventName;
    @InjectView(R.id.editTextEventDescription)EditText eventDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkInputs())saveInputs();
            }
        });
    }

    private boolean checkInputs(){
        boolean isValid = true;
        if(eventName.length() > 35){
            isValid = false;
            eventName.setError("Event name too long");
        }else if(eventDescription.length() < 1) {
            isValid = false;
            eventDescription.setError("Please add a description");
        }
        return isValid;
    }
    private void saveInputs(){
        String name = eventName.getText().toString();
        String description = eventDescription.getText().toString();
        String author = ParseUser.getCurrentUser().getUsername();
        Event event = Event.construct(name, description, author, new Date());
        event.saveEventually();
    }
}
