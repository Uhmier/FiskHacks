package com.example.uhmier.fiskhacks;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by Uhmier on 3/19/2016.
 */
@ParseClassName("Event")
public class Event extends ParseObject {
    String name;
    String date;
    String description;
    String location;
    String time;
    String author;

    public String getDate() {
        return getString("DATE");
    }

    public String getAuthor() {
        return getString("AUTHOR");
    }

    public String getDescription() {
        return getString("DESCRIPTION");
    }

    public String getName() {
        return getString("NAME");
    }

    public String getTime(){
        return getString("TIME");
    }

    public void setTime(String time){
        put("TIME", time);
    }

    public void setDate(String date) {
        put("DATE",date);
    }

    public void setAuthor(String author) {
        put("AUTHOR", author);
    }

    public void setDescription(String description) {
        put("DESCRIPTION", description);
    }

    public void setName(String name) {
        put("NAME", name);
    }
    public static Event construct(String name, String description, String author, String date, String time){
        Event e = new Event();
        e.setName(name);
        e.setAuthor(author);
        e.setDescription(description);
        e.setDate(date);
        e.setTime(time);
        return e;
    }
}
