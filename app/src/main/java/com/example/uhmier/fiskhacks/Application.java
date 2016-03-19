package com.example.uhmier.fiskhacks;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;


public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //ParseObject.registerSubclass(Organization.class);
        Parse.initialize(this, "cmIwiwn4EJBcz4HWTB3EnZlad1RpVrfnwrec8fMu", "NJr0oHBFr7pJoINQnr9jW2ubEl9tMnyUfayCgHmk");

    }
}