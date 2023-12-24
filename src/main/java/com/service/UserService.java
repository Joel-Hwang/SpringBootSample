package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.AppUser;
import com.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public AppUser createUser(AppUser user) throws Exception{
        if("".equals(user.getUsername()) ) throw new Exception("user name is empty");
        return userRepository.save(user);
    }

    
}
