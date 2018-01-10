package com.paul.easyorderfood;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Paul on 2018/1/10.
 */

@Database(entities = {User.class}, version = 2,exportSchema = false)
public abstract class AppDatabase2 extends RoomDatabase {
    public abstract UserDao userDao();
}
