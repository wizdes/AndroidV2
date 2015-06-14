package com.example.yi.graphsampletest;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationContext;
import com.microsoft.aad.adal.AuthenticationException;
import com.microsoft.aad.adal.AuthenticationResult;
import com.microsoft.aad.adal.PromptBehavior;

public class MainActivity extends FragmentActivity {

    String TAG = "TAG";
    private AuthenticationContext mContext;

    String token = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = new AuthenticationContext(MainActivity.this, "https://login.windows.net/common", false, InMemoryCacheStore.getInstance());
        mContext.getCache().removeAll();

        mContext.acquireToken(MainActivity.this, "00000002-0000-0000-c000-000000000000", "4ebb4536-7648-452f-882b-ef2b985acbe1",
                "https://localhost:4438", "", PromptBehavior.REFRESH_SESSION,
                "nux=1" + "", new AuthenticationCallback<AuthenticationResult>() {

                    @Override
                    public void onSuccess(AuthenticationResult result) {
                        Log.d("TAG", "Token is: " + token);
                        finish();
                        token = result.getAccessToken();
                        TextView mTextView = (TextView)findViewById(R.id.textToDisplay);
                        mTextView.setText(token);
                        startActivity(getIntent());
                    }

                    @Override
                    public void onError(Exception exc) {
                        Log.d("TAG", "Failed: " + token);
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (mContext != null) {
            mContext.onActivityResult(requestCode, resultCode, data);
        }
    }

}
