package com.example.yi.criminalintent;

import android.app.Fragment;

/**
 * Created by Yi on 6/13/2015.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
