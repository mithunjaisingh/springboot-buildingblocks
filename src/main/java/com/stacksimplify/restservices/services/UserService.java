package com.stacksimplify.restservices.services;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public UserService( UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    public List<User> getAllUser()
    {
        return userRepository.findAll();
    }

    public User createUser(User user)
    {
        return userRepository.save(user);
    }

    public Optional<User> findUserbyId(Long id)
    {
        return userRepository.findById(id);
    }

    public User updateUserById(Long id,User user)
    {
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id)
    {
        userRepository.deleteById(id);
    }

    public User findUserByUserName(String name)
    {
        return userRepository.findByUserName(name);
    }
}
