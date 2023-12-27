package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.AppUser;
import com.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<AppUser> getAllUsers() {
        List<AppUser> res = userService.getAllUsers();
        return res;
    }

    @PostMapping()
    public AppUser createUser(@RequestBody AppUser user) throws Exception {
        AppUser res = userService.createUser(user);
        return res;
    }

    @GetMapping("/mybatis")
    public List<AppUser> getAllUsersMybatis() {
        List<AppUser> res = userService.getAllUsersMybatis();
        return res;
    }

    @GetMapping("/mybatis/{id}")
    public AppUser getUserByIdMybatis(@PathVariable long id) {
        AppUser res = userService.getUserByIdMybatis(id);
        return res;
    }

    @PostMapping("/mybatis")
    public int createUserMybatis(@RequestBody AppUser user) throws Exception {
        int res = userService.createUserMybatis(user);
        return res;
    }
}
