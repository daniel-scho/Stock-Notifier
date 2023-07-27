package com.daniel.stocknotifier.services;

import com.daniel.stocknotifier.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    public String getUser(Integer userId) {
        return "User: " + userId;
    }

    public String getAllUsers() {
        return "all users";
    }

    public String addUser(User user) {
        System.out.println(user.toString());
        return user.toString();
    }

    public String updateUser(Integer id, User user) {
        return "user updated";
    }

    public String deleteUser(Integer id) {
        return "user with id: " + id + " deleted";
    }
}
