package com.example.yi.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Yi on 6/27/2015.
 */
public class ProfileListInstance {
    private ArrayList<Profile> profiles;

    private static ProfileListInstance profileListInstance;
    private Context mAppContext;

    private ProfileListInstance(Context appContext){
        mAppContext = appContext;
        profiles = new ArrayList<Profile>();

        for(int i = 0; i < 50; i++){
            Profile profile = new Profile();
            profile.name = "John Smith " + i;
            profile.UPN = "jsmith" + i + "@microsoft.com";
            profiles.add(profile);
        }
    }

    public ArrayList<Profile> getProfiles(){
        return profiles;
    }

    public Profile getProfile(String id){
        for(Profile c : profiles){
            if(c.UPN.equals(id)){
                return c;
            }
        }

        return null;
    }

    public static ProfileListInstance get(Context c){
        if(profileListInstance == null){
            profileListInstance = new ProfileListInstance(c.getApplicationContext());
        }
        return profileListInstance;
    }

}
