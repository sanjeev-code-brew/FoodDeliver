package com.app.fooddeliver.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by 123 on 04-Jan-18.
 */

public abstract class BaseActivity extends AppCompatActivity {


    protected abstract int getContentId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentId() != 0) {
            setContentView(getContentId());
        }
    }

    // hide keyboard
    protected void hideKeyboard(View view) {
        if (view != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void switchFragment(int containerResourceId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(containerResourceId, fragment);
        fragmentTransaction.commit();
    }
}
