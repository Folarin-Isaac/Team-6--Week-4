package com.example.learningkids;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.learningkids.Fragments.FragmentCategories;
import com.example.learningkids.Fragments.FragmentFavourites;
import com.example.learningkids.Fragments.FragmentHome;
import com.example.learningkids.Fragments.FragmentSettings;
import com.example.learningkids.Fragments.FragmentVideos;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Navigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navList);

        // To open the Home Fragment immediately this navigation activity is launched
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new FragmentHome()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navList = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.nav_home:
                    selectedFragment = new FragmentHome();
                    break;
                case R.id.nav_category:
                    selectedFragment = new FragmentCategories();
                    break;
                case R.id.nav_videos:
                    selectedFragment = new FragmentVideos();
                    break;
                case R.id.nav_favourites:
                    selectedFragment = new FragmentFavourites();
                    break;
                case R.id.nav_settings:
                    selectedFragment = new FragmentSettings();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, selectedFragment).commit();

            return true;

        }
    };
}