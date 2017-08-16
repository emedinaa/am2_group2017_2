package com.isil.am2fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isil.am2fragments.ui.fragments.MyFragmentListener;

public class MainTabletActivity extends AppCompatActivity implements MyFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tablet);
    }

    @Override
    public void fragmentAction(Object object) {}
}
