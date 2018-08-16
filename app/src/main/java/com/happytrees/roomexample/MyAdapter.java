package com.happytrees.roomexample;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


//create a class that extends RecyclerView.Adapter .put inside the < >  ==> Yourclass.YourInnerClassViewHolder
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


private List<User>users;
private Context context;

    public MyAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(context).inflate(R.layout.single_user, null);
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder( MyAdapter.MyViewHolder holder, int position) {
    User user = users.get(position);
    holder.nameTV.setText(user.getName());
    holder.emailTV.setText(user.getEmail());
    holder.idTV.setText(user.getId()+" ");//you can't setText int
    }

    @Override
    public int getItemCount() {
        return users.size();
    }



    //create inner class  YourInnerClassViewHolder extends RecyclerView.ViewHolder => implement constructor
    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTV,emailTV,idTV;


        public MyViewHolder(View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.nameUser);
            emailTV = itemView.findViewById(R.id.emailUser);
            idTV = itemView.findViewById(R.id.idUser);

            //update
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
                }
            });
            //delete
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //don't access room database from  the main thread
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                      // MyAppDatabase.getMyAppDatabase(context).myDao().deleteUser();
                    }
                }).start();




                    return true;
                }
            });
        }
    }
}
