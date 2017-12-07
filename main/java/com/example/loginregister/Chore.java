package com.example.loginregister;

/**
 * Created by Imaan on 2017-12-03.
 */

public class Chore {

    private String name;
    private String description;
    private String isAssignedTo;

    public Chore(String name, String description, String isAssignedTo){
        this.name = name;
        this.description = description;
        this.isAssignedTo = isAssignedTo;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAssignedTo(){
        return this.isAssignedTo;
    }
}
