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

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User getUser(@RequestParam(value = "id") Integer id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/create-new-user", method = RequestMethod.POST)
    public @ResponseBody List<User> createNewUser(@RequestBody User newUser) {
        userService.createNewUser(newUser);
        return getAll();
    }

    @RequestMapping(value = "/update-user", method = RequestMethod.PUT)
    public @ResponseBody List<User> updateUser(@RequestBody User updaterUser){
        userService.updateUser(updaterUser);
        return getAll();
    }

    @RequestMapping(value = "/delete-user", method = RequestMethod.DELETE)
    public List<User> deleteUser(@RequestParam(value = "id") Integer id){
        userService.delete(id);
        return getAll();
    }
}
