package com.happytrees.roomexample;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;


/*
CHANGE TABLE NAME - By default,Room uses the class name as the table name.In order to change default table name - @Entity(tableName = "someTableName")

CHANGE COLUMN NAME - By default,Room creates a column for each field that's defined in entity's class.In order to change column name - @ColumnInfo(name = "someColumnName")

PRIMARY KEY - A primary key is a field in a table which uniquely identifies each row in a database table. Primary keys must contain unique values. A primary key column cannot have NULL values.

 */


@Entity(tableName = "users")//Entity represents a table in the database.
public class User {

    //VARIABLES
    @PrimaryKey//Each entity class(table class) must define at least 1 field as a primary key.together with annotation @PrimaryKey
    private int id;
    @ColumnInfo(name = "user_name")
    private String name;
    @ColumnInfo(name = "user_email")
    private String email;


    //GETTERS + SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
