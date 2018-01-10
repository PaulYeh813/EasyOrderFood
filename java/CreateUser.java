package com.paul.easyorderfood;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Paul on 2018/1/9.
 */

public class CreateUser extends AppCompatActivity {
    Context context;

    EditText user_name;
    EditText Account;
    EditText Password;
    EditText email;
    Button cancel;
    Button button;
    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.creat_user);
        context =getApplicationContext();

        user_name = findViewById(R.id.user_name);
        Account = findViewById(R.id.Account);
        Password = findViewById(R.id.Password);
        email = findViewById(R.id.email);

        button = findViewById(R.id.button);

        cancel = findViewById(R.id.cancel);
        final AppDatabase2 db = Room.databaseBuilder(getApplicationContext(),AppDatabase2.class,"Users")
                .allowMainThreadQueries()
                .build();

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // TODO : Save to database
                User user = new User(user_name.getText().toString()
                        ,Account.getText().toString()
                        ,Password.getText().toString()
                        ,email.getText().toString());
                db.userDao().insertAll(user);
                startActivity(new Intent(CreateUser.this,LoginActivty.class));
                Toast.makeText(context,"註冊成功！",Toast.LENGTH_LONG).show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateUser.this,LoginActivty.class));
            }
        });

    }
}
