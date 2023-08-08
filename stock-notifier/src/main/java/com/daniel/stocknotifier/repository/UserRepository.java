package com.daniel.stocknotifier.repository;

import com.daniel.stocknotifier.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
