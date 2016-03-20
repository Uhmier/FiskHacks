package com.example.uhmier.fiskhacks;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import java.text.ParseException;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import com.parse.ParseUser;

import java.util.Date;

import butterknife.InjectView;

public class SignupActivity extends AppCompatActivity {

    @InjectView(R.id.editTextFirstName)
    EditText editTextFirstName;
    @InjectView(R.id.editTextLastName)
    EditText editTextLastName;
    @InjectView(R.id.editTextSignUpUsername)
    EditText editTextSignUpUsername;
    @InjectView(R.id.editTextSignUpPassword)
    EditText editTextSignUpPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }


    private void signUp(){
        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String username = editTextSignUpUsername.getText().toString();
        String password = editTextSignUpPassword.getText().toString();

        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);

        // other fields can be set just like with ParseObject
        user.put("name", firstName + " " + lastName);

        user.signUpInBackground();
    }
}
