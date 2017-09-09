package com.isil.am2template;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ui();
    }

    private void ui(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(getString(R.string.edit_profile));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
