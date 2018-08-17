package com.happytrees.roomexample;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
//Data access object - Data Access Objects are classes where you define your database query methods.
public interface MyDao {

    //INSERT
    @Insert
    void addUser(User user);

    //READ
    @Query("select*from users")
    List<User> getUsers();


    //DELETE
    @Delete
    void deleteUser(User user);


    //UPDATE
    @Update
    void updateUser(User user);


}
