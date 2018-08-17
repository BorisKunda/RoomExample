package com.happytrees.roomexample;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddUsersFragment extends Fragment {

    private EditText edtId, edtName, edtEmail;
    private Button saveBtn;

    public AddUsersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_users, container, false);

        edtId = view.findViewById(R.id.edtUserId);
        edtName = view.findViewById(R.id.edtName);
        edtEmail = view.findViewById(R.id.edtEmail);
        saveBtn = view.findViewById(R.id.saveBtn);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.length() != 0 && edtName.length() != 0 && edtEmail.length() != 0) {
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

                    Toast.makeText(getActivity(), "user saved", Toast.LENGTH_SHORT).show();
                    //closes current fragment
                    getActivity().getFragmentManager().popBackStack();//--> works only if fragment was added to back-stack


                } else {
                    Toast.makeText(getActivity(), "you forgot to fill text", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return view;
    }

}
