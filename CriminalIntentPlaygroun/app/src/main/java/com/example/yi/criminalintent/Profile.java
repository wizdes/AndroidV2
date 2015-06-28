package com.example.yi.criminalintent;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Yi on 6/27/2015.
 */
public class Profile {
    public String name;
    public String jobTitle;
    public String manager;
    public String location;
    public String UPN;

    public Profile(){
        name = "";
        jobTitle = "";
        manager = "";
        location = "";
        UPN = "";
    }

    @Override
    public String toString(){
        return name;
    }
}
