package com.isil.am2template;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.isil.am2template.fragments.ColorFragment;
import com.isil.am2template.fragments.ColorFragmentListener;
import com.isil.am2template.fragments.ProfileFragment;

/*public class ProfileActivity extends AppCompatActivity implements
        ColorFragmentListener{*/
public class ProfileActivity extends AppCompatActivity implements
            ColorFragmentListener{

    private ProfileFragment profileFragment;
    private ColorFragment colorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ui();
        app();
    }

    private void ui(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.edit_profile));
    }

    private void app(){
        profileFragment= (ProfileFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentProfile);
        colorFragment= (ColorFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentColor);
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**/
    @Override
    public void selectedColor(String color) {
        Log.d("CONSOLE","selectedColor "+color);
        if(isProfileEnabled()){
            profileFragment.paintBackground(color);
        }
    }

    @Override
    public void selectedOptionColor(int option) {
        Log.d("CONSOLE","ProfileActivity option "+option);
        Log.d("CONSOLE","ProfileActivity editEnabled "+profileFragment.isEditEnabled());
        //profileFragment.paintBackgroundByOption(option);
        if(profileFragment.isEditEnabled()){
            profileFragment.paintBackgroundByOption(option);
        }
        /*if(isProfileEnabled()){
            profileFragment.paintBackgroundByOption(option);
        }*/
    }

    @Override
    public boolean isProfileEnabled() {
        if (profileFragment!=null) {
            return profileFragment.isEditEnabled();
        }
        return false;
    }

    @Override
    public void clear() {}
    /**/
}
