package com.example.uhmier.fiskhacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

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
    }
}
