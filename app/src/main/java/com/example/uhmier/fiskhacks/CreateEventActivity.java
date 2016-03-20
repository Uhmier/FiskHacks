package com.example.uhmier.fiskhacks;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.parse.ParseUser;

import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CreateEventActivity extends AppCompatActivity {

    @InjectView(R.id.editTextEventName)
    EditText eventName;
    @InjectView(R.id.buttonSubmitEvent)
    Button buttonSubmitEvent;
    @InjectView(R.id.datePickerEventDate)
    DatePicker datePickerEventDate;
    @InjectView(R.id.editTextEventDescription)
    EditText eventDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        ButterKnife.inject(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(ParseUser.getCurrentUser() == null){
            startActivity(new Intent(CreateEventActivity.this, LoginActivity.class));
            finish();
        }

        buttonSubmitEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInputs()) saveInputs();
            }
        });
    }

    private boolean checkInputs(){
        boolean isValid = true;
        if(eventName.length() > 64){
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
        String author = ParseUser.getCurrentUser().getString("NAME");
        int day = datePickerEventDate.getDayOfMonth();
        int month = datePickerEventDate.getMonth() + 1;
        int year = datePickerEventDate.getYear();
        Event event = Event.construct(name, description, author, day + "/" + month + "/" + year, "19:53");
        event.saveEventually();
    }
}
