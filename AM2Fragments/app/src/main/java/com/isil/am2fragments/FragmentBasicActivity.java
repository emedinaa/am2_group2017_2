package com.isil.am2fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.isil.am2fragments.ui.fragments.BlankFragmentListener;

public class FragmentBasicActivity extends AppCompatActivity
implements BlankFragmentListener{

    private Fragment blankFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_basic);

        fragmentManager= getSupportFragmentManager();
        blankFragment= fragmentManager.findFragmentById(R.id.blankFragment);
    }

    @Override
    public void actionFragment(Object object) {
        String message= String.valueOf(object);
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
