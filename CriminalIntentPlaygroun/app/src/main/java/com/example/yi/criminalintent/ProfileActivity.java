package com.example.yi.criminalintent;

import android.app.Fragment;

/**
 * Created by Yi on 6/21/2015.
 */
public class ProfileActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new ProfileFragment();
    }
}
