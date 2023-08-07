package com.yunuscrud.crudapi.controller;
import com.yunuscrud.crudapi.exception.*;
import com.yunuscrud.crudapi.model.User;
import com.yunuscrud.crudapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();

    }

    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable Long userId ){
        return userRepository.findById(userId)
                .orElseThrow(()->new UserNotFoundExeption(userId));
    }

    @PutMapping("/user/{userId}")
    User updateUser(@RequestBody User newUser, @PathVariable Long userId){
        return userRepository.findById(userId).map(user -> {
            user.setUserName(newUser.getUserName());
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            return userRepository.save(user);

        }).orElseThrow(()-> new UserNotFoundExeption(userId));

    }

    @DeleteMapping("/user/{userId}")
    String deleteUser(@PathVariable Long userId){
        if(!userRepository.existsById(userId)){
            throw new UserNotFoundExeption(userId);

        }
        userRepository.deleteById(userId);
        return "User with id " + userId + " has been deleted.";

    }



}
