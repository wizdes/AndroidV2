package com.example.yi.criminalintent;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class CrimeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment(){
        return new CrimeFragment();
    }
}
