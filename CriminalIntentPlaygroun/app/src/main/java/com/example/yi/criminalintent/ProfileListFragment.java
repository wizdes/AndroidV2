package com.example.yi.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yi on 6/27/2015.
 */
public class ProfileListFragment extends ListFragment {
    private ArrayList<Profile> profiles;
    private static final String Tag = "CrimeListFragment";

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crime_title);
        setHasOptionsMenu(true);
        profiles = ProfileListInstance.get(getActivity()).getProfiles();

        ArrayAdapter<Profile> adapter = new ProfileAdapter(profiles);
        setListAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_crime, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        Profile profile = ((ProfileAdapter)getListAdapter()).getItem(position);
        Log.d(Tag, profile.name + " was clicked.");

        Intent i = new Intent(getActivity(), ProfileActivity.class);
        startActivity(i);
        //Start CrimeActivity
        /*
        Intent i = new Intent(getActivity(), CrimeActivity.class);
        i.putExtra(CrimeFragment.EXTRA_CRIME_ID, profile.getId());
        startActivity(i);*/
    }

    @Override
    public void onResume(){
        super.onResume();
        ((ProfileAdapter)getListAdapter()).notifyDataSetChanged();
    }

    private class ProfileAdapter extends ArrayAdapter<Profile>{
        public ProfileAdapter(ArrayList<Profile> crimes){
            super(getActivity(), 0, crimes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView == null){
                convertView = getActivity().getLayoutInflater().inflate(R.layout.list_item_profile, null);
            }

            setHasOptionsMenu(true);

            Profile profile = getItem(position);

            TextView titleTextView = (TextView)convertView.findViewById(R.id.profile_name);
            titleTextView.setText(profile.name);
            TextView dateTextView = (TextView)convertView.findViewById(R.id.profile_other_info);
            dateTextView.setText(profile.UPN);

            return convertView;
        }
    }
}
