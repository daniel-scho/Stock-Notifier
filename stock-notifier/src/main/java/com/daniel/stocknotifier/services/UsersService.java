package com.daniel.stocknotifier.services;

import com.daniel.stocknotifier.entity.Stock;
import com.daniel.stocknotifier.entity.User;
import com.daniel.stocknotifier.error.ResourceNotFoundException;
import com.daniel.stocknotifier.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UserRepository userRepository;
    private final StocksService stocksService;


    public UsersService(UserRepository userRepository, StocksService stocksService) {
        this.userRepository = userRepository;
        this.stocksService = stocksService;
    }

    public Optional<User> getUser(Integer userId) {
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(userDetails.getName());
                    user.setPhoneNumber(userDetails.getPhoneNumber());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Element not found with id " + id));
    }

    public User deleteUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Element not found with id " + id));
        userRepository.delete(user);

        return user;
    }

    public User addStockToUser(Integer userId, Stock stock) {
        return userRepository.findById(userId)
                .map(user -> {
                    Stock savedStock = stocksService.findOrSave(stock);
                    user.getStocks().add(savedStock);
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
    }
}
