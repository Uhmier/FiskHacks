package com.example.uhmier.fiskhacks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.parse.ParseUser;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class SettingsActivity extends AppCompatActivity {
    @InjectView(R.id.radioGroup)
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.inject(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.radio_10Miles){
                    ParseUser user = ParseUser.getCurrentUser();
                    user.put("DISTANCE_PREF", 10000);
                    user.saveEventually();
                }else if(checkedId == R.id.radio_100Miles){
                    ParseUser user = ParseUser.getCurrentUser();
                    user.put("DISTANCE_PREF", 100000);
                    user.saveEventually();
                }else if(checkedId == R.id.radio_25Miles){
                    ParseUser user = ParseUser.getCurrentUser();
                    user.put("DISTANCE_PREF", 25000);
                    user.saveEventually();
                }else if(checkedId == R.id.radio_50Miles){
                    ParseUser user = ParseUser.getCurrentUser();
                    user.put("DISTANCE_PREF", 50000);
                    user.saveEventually();
                }
            }
        });
    }
}
