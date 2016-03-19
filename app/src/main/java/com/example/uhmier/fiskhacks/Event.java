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
    Date date;
    String description;
    String location;
    String author;

    public Date getDate() {
        return (Date) get("DATE");
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

    public void setDate(Date date) {
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
    public static Event construct(String name, String description, String author, Date date){
        Event e = new Event();
        e.setName(name);
        e.setAuthor(author);
        e.setDescription(description);
        e.setDate(date);
        return e;
    }
}
