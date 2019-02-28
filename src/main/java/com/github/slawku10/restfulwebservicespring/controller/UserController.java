package com.github.slawku10.restfulwebservicespring.controller;


import com.github.slawku10.restfulwebservicespring.service.UserService;
import com.github.slawku10.restfulwebservicespring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/")
    public User getUser(@RequestParam(value = "id") Integer id) {
        return userService.get(id);
    }

    @PostMapping(value = "/create-new-user")
    public @ResponseBody
    List<User> createNewUser(@RequestBody User newUser) {
        userService.createNewUser(newUser);
        return getAll();
    }

    @PutMapping(value = "/update-user")
    public @ResponseBody
    List<User> updateUser(@RequestBody User updaterUser) {
        userService.updateUser(updaterUser);
        return getAll();
    }

    @DeleteMapping(value = "/delete-user")
    public @ResponseBody List<User> deleteUser(@RequestParam(value = "id") Integer id) {
        userService.delete(id);
        return getAll();
    }
}
