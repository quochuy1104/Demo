package com.example.admin.demo.Model;

/**
 * Created by ADMIN on 12/6/2019.
 */

public class User {
    private String Name;
    private  String Password;
    public  User(){}
    public User(String name, String password) {
        Name = name;
        Password = password;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }
}
