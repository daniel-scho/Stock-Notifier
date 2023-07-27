package com.daniel.stocknotifier.controller;

import com.daniel.stocknotifier.entity.User;
import com.daniel.stocknotifier.services.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable Integer userId) {
        return usersService.getUser(userId);
    }

    @GetMapping("/all")
    public String getAllUsers() {
        return usersService.getAllUsers();
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        return usersService.addUser(user);
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable("userId") Integer id, @RequestBody User user) {
        return usersService.updateUser(id, user);
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") Integer userId) {
        return usersService.deleteUser(userId);
    }
}
