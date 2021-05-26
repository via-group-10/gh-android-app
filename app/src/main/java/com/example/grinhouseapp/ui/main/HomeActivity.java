package com.example.grinhouseapp.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.grinhouseapp.R;
import com.example.grinhouseapp.ui.deviceState.DeviceStateActivity;
import com.example.grinhouseapp.ui.graph.GraphFragment;
import com.example.grinhouseapp.ui.filter.FilterFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); //disable dark mode
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_data, R.id.navigation_profile, R.id.addProfileFragment, R.id.editProfileFragment)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.filter){

            Fragment fragment = new FilterFragment();
          
            FragmentTransaction transaction = this.getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.content_frame,fragment).addToBackStack(null).commit();

        }
        else if (itemId == R.id.device_icon)
        {
            Intent intent = new Intent(this, DeviceStateActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void seeMore(View view) {
        int measurementCategory;

        if(view.getId() == R.id.seeMoreTemperature)
            measurementCategory = 0;
        else if(view.getId() == R.id.seeMoreCO2)
            measurementCategory = 1;
        else
            measurementCategory = 2;

        Intent intent = new Intent(this, GraphFragment.class);
        intent.putExtra("measurement", measurementCategory);
        startActivity(intent);
    }
}