package com.example.pesticidebe.service;

import com.example.pesticidebe.dto.UserDto;
import com.example.pesticidebe.model.User;

import java.util.List;

public interface UserService {

    User save(UserDto user);
    //User update(long id, UserDto user);

    List<User> findAll();
    //void delete(long id);

    User findById(Long id);

}
