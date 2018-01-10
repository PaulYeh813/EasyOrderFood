package com.paul.easyorderfood;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Paul on 2018/1/9.
 */

class databaseAdapter extends RecyclerView.Adapter<databaseAdapter.ViewHolder> {

    List<User> users;

    public databaseAdapter(List<User> Users){
        this.users = Users;
    }

    @Override
    public databaseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_row,parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(databaseAdapter.ViewHolder holder, int position) {
        holder.user_name.setText(users.get(position).getName());
        holder.Account.setText(users.get(position).getAccount());
        holder.Password.setText(users.get(position).getPassword());
        holder.email.setText(users.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Account;
        public TextView Password;
        public TextView email;
        public TextView user_name;
        public ViewHolder(View itemView) {
            super(itemView);
            user_name = itemView.findViewById(R.id.user_name);
            Account = itemView.findViewById(R.id.Account);
            Password = itemView.findViewById(R.id.Password);
            email = itemView.findViewById(R.id.email);
        }
    }

}
