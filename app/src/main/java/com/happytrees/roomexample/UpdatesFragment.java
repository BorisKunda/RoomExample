package com.happytrees.roomexample;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UpdatesFragment extends Fragment {


    public UpdatesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_updates, container, false);


        final EditText userIdU, nameU, emailU;
        userIdU = v.findViewById(R.id.edtUserIdU);
        nameU = v.findViewById(R.id.edtNameU);
        emailU = v.findViewById(R.id.edtEmailU);


        Button updateBtn = v.findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userIdU.length() != 0 && nameU.length() != 0 && emailU.length() != 0) {
                    int uId = Integer.parseInt(userIdU.getText().toString());
                    String uName = nameU.getText().toString();
                    String uEmail = emailU.getText().toString();

                    final User user = new User();
                    user.setId(uId);//!!!-> ID  must be the same as of object you try to update
                    user.setName(uName);
                    user.setEmail(uEmail);

                    //don't access room database from  the main thread
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            Log.e("e", "e");
                        MyAppDatabase.getMyAppDatabase(getActivity()).myDao().updateUser(user);
                        }
                    }).start();
                    Toast.makeText(getActivity(),"user updated" , Toast.LENGTH_SHORT).show();
                    ReadUserFragment.myAdapter.notifyDataSetChanged();
                    //closes current fragment
                    getActivity().getFragmentManager().popBackStack();//--> works only if fragment was added to back-stack
                }else{
                    Toast.makeText(getActivity(),"you forgot to fill one of the fields" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }
}

/*
   int userId = Integer.parseInt(edtId.getText().toString());
                    String username = edtName.getText().toString();
                    String userEmail = edtEmail.getText().toString();


                    final User user = new User();
                    user.setId(userId);
                    user.setName(username);
                    user.setEmail(userEmail);

                    //don't access room database from  the main thread
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            MyAppDatabase.getMyAppDatabase(getActivity()).myDao().addUser(user);
                        }
                    }).start();
 */

/*
   if (edtId.length() != 0 || edtName.length() != 0 || edtEmail.length() != 0) {
 */