package com.paul.easyorderfood;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by Paul on 2018/1/9.
 */

public class database extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.database);
        /*Appdatabase db = Room.databaseBuilder(getApplicationContext(),Appdatabase.class,"production")
                .allowMainThreadQueries()
                .build();*/

        AppDatabase2 db = Room.databaseBuilder(getApplicationContext(),AppDatabase2.class,"Users")
                .allowMainThreadQueries()
                .build();

        List<User> users = db.userDao().getAllusers();
        /*users =  new ArrayList<>();
        for (int i = 0 ; i < 100 ; i++){
            User user = new User("Daneil #" + i,"malone","test","daneilmalone@gmail.com");
            users.add(user);}*/
        recyclerView = findViewById(R.id.list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new databaseAdapter(users);
        recyclerView.setAdapter(adapter);
    }
}
