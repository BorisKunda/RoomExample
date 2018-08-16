package com.happytrees.roomexample;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class ReadUserFragment extends Fragment {


    public ReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_read_user, container, false);
        final RecyclerView recyclerView = view.findViewById(R.id.myRecyclerView);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //don't access room database from  the main thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<User> users = MyAppDatabase.getMyAppDatabase(getActivity()).myDao().getUsers();
                final MyAdapter myAdapter = new MyAdapter(users,getActivity());
                //post to UI (main thread) through post method .without post method there will be CalledFromWrongThreadException
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
                        recyclerView.setLayoutManager(layoutManager);
                        recyclerView.setAdapter(myAdapter);

                    }
                });
            }
        }).start();







        return view;
    }

}

