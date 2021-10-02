package com.brks.childrenapp.Activities;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.brks.childrenapp.Fragments.PlacesAllFragment;
import com.brks.childrenapp.Fragments.PlacesFragment;
import com.brks.childrenapp.Fragments.PollFragment;
import com.brks.childrenapp.Fragments.ProfileFragmnet;
import com.brks.childrenapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    final PlacesFragment placesFragment = new PlacesFragment();
    final PlacesAllFragment placesAllFragment = new PlacesAllFragment();
    final PollFragment pollFragment = new PollFragment();
    final ProfileFragmnet profileFragmnet = new ProfileFragmnet();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new PollFragment()).commit();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment selectedFragment = pollFragment;


                switch (menuItem.getItemId()) {
                    case R.id.action_places:
                        selectedFragment = placesFragment;

                        break;
                    case R.id.action_places_all:
                        selectedFragment = placesAllFragment;
                        break;

                    case R.id.action_poll:
                        selectedFragment = pollFragment;
                        break;

                    case R.id.action_profile:
                        selectedFragment = profileFragmnet;
                        break;

                }

                assert selectedFragment != null;
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
                return true;
            }
        });

    }
}