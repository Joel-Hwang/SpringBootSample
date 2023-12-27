package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.UserMapper;
import com.model.AppUser;
import com.repository.UserRepository;

@Service
public class UserService {
    //@Autowired
    //private UserRepository userRepository;
    
    //@Autowired
    //private UserMapper userMapper;
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    public AppUser createUser(AppUser user) throws Exception{
        if(user == null || user.getUsername()==null || user.getUsername().isEmpty() ) 
            throw new Exception("user name is empty");
        return userRepository.save(user);
    }

    public List<AppUser> getAllUsersMybatis() {
        return userMapper.findAll();
    }

    public AppUser getUserByIdMybatis(long id){
        return userMapper.findById(id);
    }

    public int createUserMybatis(AppUser user){
        return userMapper.insert(user);
    }

    
}
