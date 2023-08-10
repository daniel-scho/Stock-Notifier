package com.daniel.stocknotifier.controller;

import com.daniel.stocknotifier.entity.Stock;
import com.daniel.stocknotifier.entity.User;
import com.daniel.stocknotifier.error.ResourceNotFoundException;
import com.daniel.stocknotifier.services.UsersService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Integer userId) {
        User user = usersService.getUser(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User was not found with id " + userId));
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> stocks = usersService.getAllUsers();
        return ResponseEntity.ok(stocks);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        User savedUser = usersService.addUser(user);
        URI location =  MvcUriComponentsBuilder
                .fromMethodCall(on(UsersController.class).getUser(savedUser.getId()))
                .build()
                .toUri();
        return ResponseEntity.created(location).body(savedUser);
    }

    @PostMapping("/add/stock/{userId}")
    public ResponseEntity<User> addUser(@PathVariable("userId") Integer id, @Valid @RequestBody Stock stock) {
        User savedUser = usersService.addStockToUser(id, stock);
        URI location =  MvcUriComponentsBuilder
                .fromMethodCall(on(UsersController.class).getUser(savedUser.getId()))
                .build()
                .toUri();
        return ResponseEntity.created(location).body(savedUser);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Integer id, @RequestBody User user) {
        User updatedUser = usersService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable("userId") Integer userId) {
        User deletedUser = usersService.deleteUser(userId);
        return ResponseEntity.ok(deletedUser);
    }
}
