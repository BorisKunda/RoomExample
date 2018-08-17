package com.happytrees.roomexample;


import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

//IN THIS EXAMPLE EVERY LIST ITEM IS CLICKABLE ONLY WHERE TEXT VIEW LOCATION IS
//create a class that extends RecyclerView.Adapter .put inside the < >  ==> Yourclass.YourInnerClassViewHolder
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private List<User> users;
    private Context context;
    private User user;

    public MyAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(context).inflate(R.layout.single_user, null);
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {
        user = users.get(position);
        holder.nameTV.setText(user.getName());
        holder.emailTV.setText(user.getEmail());
        holder.idTV.setText(user.getId() + " ");//you can't setText int
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    //create inner class  YourInnerClassViewHolder extends RecyclerView.ViewHolder => implement constructor
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTV, emailTV, idTV;


        public MyViewHolder(View itemView) {
            super(itemView);

            nameTV = itemView.findViewById(R.id.nameUser);
            emailTV = itemView.findViewById(R.id.emailUser);
            idTV = itemView.findViewById(R.id.idUser);


            //click -update user
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //use interface and implement it in main activity
                     FragmentChanger fragmentChanger = (FragmentChanger) context;
                     fragmentChanger.changeFragments();
                     //Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
                }
            });


            //long click - remove user
        itemView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(final View v) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            MyAppDatabase.getMyAppDatabase(context).myDao().deleteUser(user);
                            v.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(context, "user removed", Toast.LENGTH_SHORT).show();
                                    int position = getAdapterPosition();
                                    users.remove(position);
                                    notifyItemRemoved(position);
                                }
                            });
                        }
                    }).start();

                    return true;
                }
            });

        }
    }
}
