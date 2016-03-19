package com.example.uhmier.fiskhacks;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< Updated upstream
import android.widget.EditText;

=======
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.parse.ParseUser;

import java.util.Date;

>>>>>>> Stashed changes
import butterknife.InjectView;

public class SignupActivity extends AppCompatActivity {

<<<<<<< Updated upstream
    @InjectView(R.id.editTextFirstName)
    EditText editTextFirstName;
    @InjectView(R.id.editTextLastName)
    EditText editTextLastName;
    @InjectView(R.id.editTextSignUpUsername)
    EditText editTextSignUpUsername;
    @InjectView(R.id.editTextSignUpPassword)
    EditText editTextSignUpPassword;

=======
    @InjectView(R.id.editTextEventName)
    EditText eventName;
    @InjectView(R.id.editTextEventDescription)EditText eventDescription;
>>>>>>> Stashed changes

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

    private void signUp(){
        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
    }
}
