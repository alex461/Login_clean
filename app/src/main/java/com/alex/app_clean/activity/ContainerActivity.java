package com.alex.app_clean.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.alex.app_clean.R;
import com.alex.app_clean.fragment.HomeFragment;
import com.alex.app_clean.fragment.ProfilerFragment;
import com.alex.app_clean.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    private BottomNavigationView btb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        btb =findViewById(R.id.bottonbar);
        setFragmentbyDefault();

        btb.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                boolean fragmentTransaction = false;
                Fragment fragment = null;

                switch (item.getItemId()){

                    case R.id.tabsearch:

                        fragment = new SearchFragment();
                        fragmentTransaction =true;

                        break;

                    case R.id.tabhome:

                        fragment = new HomeFragment();
                        fragmentTransaction =true;


                        break;

                    case R.id.tabprofile:

                        fragment = new ProfilerFragment();
                        fragmentTransaction =true;
                        break;

                }

                if(fragmentTransaction){
                    changeFragment(fragment);
                }

                return true;
            }
        });

    }

    private void setFragmentbyDefault(){
        changeFragment(new HomeFragment());

    }

    private void changeFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();

    }
}
