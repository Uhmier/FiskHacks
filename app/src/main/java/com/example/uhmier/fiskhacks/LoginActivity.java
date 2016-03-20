package com.example.uhmier.fiskhacks;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {
    @InjectView(R.id.editTextLoginUsername)
    EditText loginUsername;
    @InjectView(R.id.editTextLoginPassword) EditText loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public void attemptLogin(){
        String username = loginUsername.getText().toString();
        String password = loginPassword.getText().toString();
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(user != null){
                    startActivity(new Intent(LoginActivity.this, CreateEventActivity.class));
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Incorrect login", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
