package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAllUsers()
    {
        return  userService.getAllUser();
    }

    @PostMapping("/users")
    public User saveUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> findByUserId(@PathVariable Long id)
    {
        return userService.findUserbyId(id);
    }

    @PutMapping("/users/{id}")
    public User updateUserById(@PathVariable Long id, @RequestBody User user)
    {
        return userService.updateUserById(id,user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id)
    {
        userService.deleteUser(id);
    }

    @GetMapping("users/findByName/{name}")
    public User findByName(@PathVariable String name)
    {
        return userService.findUserByUserName(name);
    }
}
