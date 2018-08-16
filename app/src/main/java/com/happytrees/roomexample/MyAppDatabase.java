package com.happytrees.roomexample;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

//singleton - don't need private constructor ,cause you cant instantiate abstract class
@Database(entities = {User.class},version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

private static  MyAppDatabase myAppDatabase;

    public static MyAppDatabase getMyAppDatabase(Context context) {
        if(myAppDatabase==null) {
            myAppDatabase = Room.databaseBuilder( context, MyAppDatabase.class, "userdb").build();
        }
        return myAppDatabase;
    }

    public abstract MyDao myDao ();//abstract method which returns MyDao instance





}
