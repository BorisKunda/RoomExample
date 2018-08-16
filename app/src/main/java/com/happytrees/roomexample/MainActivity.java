package com.happytrees.roomexample;

import android.app.FragmentManager;
import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //FRAGMENTS
        fragmentManager =getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).addToBackStack("HomeFragment").commit();

      /*  if(findViewById(R.id.fragmentContainer)!=null) {

            if(savedInstanceState!=null) {
            return;
            }
         fragmentManager.beginTransaction().replace(R.id.fragmentContainer,new HomeFragment()).commit();
        }*/
    }
}
