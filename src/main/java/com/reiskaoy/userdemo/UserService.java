package com.reiskaoy.userdemo;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users = new ArrayList<>();
    
    public void addUser(User user){
        users.add(user);
    }

    public List<User> searchUsers(String keyword){
        //Etsi users listalta nimen perusteella henkilöt
        //Tehdään niistä uusi lista ja palautetaan

        return users;
    }

    public List<User> getUsers(){
        return this.users;
    }
}
