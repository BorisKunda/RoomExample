package com.happytrees.roomexample;


import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class HomeFragment extends Fragment {




    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //ADD
        Button addUserBtn = view.findViewById(R.id.addUserBtn);
        addUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AddUsersFragment addUsersFragment = new AddUsersFragment();
               getActivity().getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,addUsersFragment ).addToBackStack(" AddUsersFragment").commit();//getActivity(); - in fragment it returns the Activity the fragment is attached to
            }
        });

        //READ
        Button readUsersButton = view.findViewById(R.id.viewAllUsersBtn);
        readUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReadUserFragment readUserFragment = new ReadUserFragment();
                getActivity().getFragmentManager().beginTransaction().replace(R.id.fragmentContainer,readUserFragment).addToBackStack(" ReadUserFragment").commit();
            }
        });



        return view;


    }


}



