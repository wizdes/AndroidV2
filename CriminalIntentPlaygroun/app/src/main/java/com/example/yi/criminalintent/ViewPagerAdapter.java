package com.example.yi.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Yi on 7/11/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new ProfileFragment();
        }
        else{
            return new ProfileListFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title = "Title";
        return title;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
