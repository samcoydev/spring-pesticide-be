package com.example.pesticidebe.dao;

import com.example.pesticidebe.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface UserDao extends CrudRepository<User, Long> {

    Set<User> findByOrderById();

    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);

}
