package com.happytrees.roomexample;

import android.app.FragmentManager;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentChanger {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //FRAGMENTS
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();


    }

    @Override
    public void changeFragments() {
      UpdatesFragment updatesFragment = new UpdatesFragment();
      getFragmentManager().beginTransaction().replace(R.id.fragmentContainer, updatesFragment).addToBackStack("UpdatesFragment").commit();
    }
}
