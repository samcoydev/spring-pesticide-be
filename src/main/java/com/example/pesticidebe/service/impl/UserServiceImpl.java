package com.example.pesticidebe.service.impl;

import org.apache.commons.lang3.StringUtils;
import com.example.pesticidebe.dao.UserDao;
import com.example.pesticidebe.dto.UserDto;
import com.example.pesticidebe.model.User;
import com.example.pesticidebe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findByOrderById().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id) {
        User u = userDao.findById(id).get();
        userDao.delete(u);
    }

    @Override
    public User findById(Long id) { return userDao.findById(id).get(); }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username).get();
    }

    public User save(UserDto user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        if(StringUtils.isNotEmpty(user.getPassword())) {
            newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        }
        newUser.setFirstname(user.getFirstname());
        newUser.setLastname(user.getLastname());
        newUser.setEmail(user.getEmail());

        return userDao.save(newUser);
    }

    public User authenticate(UserDto user) {
        User userLoggingIn = new User();
        userLoggingIn.setUsername(user.getUsername());
        if(StringUtils.isNotEmpty(user.getPassword())) {
            userLoggingIn.setPassword(bcryptEncoder.encode(user.getPassword()));
        }

        User dbUser = findByUsername(userLoggingIn.getUsername());
        if(dbUser == null) {
            System.out.println("Uh oh! something when wrong");
            return null;
        }
        if (userLoggingIn.getPassword() == dbUser.getPassword()) {
            System.out.println("Succesful login! Passwords match");
            System.out.println("Userinfo: " + userLoggingIn.getPassword());
            System.out.println("DBUser: " + dbUser.getPassword());
        } else {
            System.out.println("Passwords dont match! For shame..");
            System.out.println("Userinfo: " + userLoggingIn.getPassword());
            System.out.println("DBUser: " + dbUser.getPassword());
            return null;
        }
        return dbUser;
    }

}
