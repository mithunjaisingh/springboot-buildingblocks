package com.stacksimplify.restservices.services;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNameNotFoundException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public User createUser(User user) throws UserExistsException, UserNameNotFoundException {
        User existUser = findUserByUserName(user.getUserName());
        if(null == existUser)
            return userRepository.save(user);
        else
            throw new UserExistsException("User Already Exists");
    }

    public Optional<User> findUserbyId(Long id) throws UserNotFoundException
    {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent())
            return optional;
        else
        {
            throw new UserNotFoundException("User Not found");
        }
    }

    public User updateUserById(Long id,User user) throws UserNotFoundException {
        user.setId(id);
        findUserbyId(id);
        return userRepository.save(user);
    }

    public void deleteUser(Long id)
    {
        try {
            findUserbyId(id);
            userRepository.deleteById(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
    }

    public User findUserByUserName(String name) throws UserNameNotFoundException {
        User user= userRepository.findByUserName(name);
        if(user==null)
            throw new UserNameNotFoundException("UserName '"+name+"' not Available");
        else return user;

    }
}
