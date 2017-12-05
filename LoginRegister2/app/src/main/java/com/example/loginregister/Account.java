package com.example.loginregister;

/**
 * Created by Imaan on 2017-12-03.
 */

public class Account {
    private String name;
    private String password;
    private int points = 0;
    private boolean isParent;

    public Account(String name, String password, int points, boolean isParent){
        this.name = name;
        this.password = password;
        this.points = points;
        this.isParent = isParent;
    }

    public String getName(){
       return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public int getPoints(){
        return this.points;
    }

    public boolean getType(){
        return this.isParent;
    }
}
