package com.github.slawku10.restfulwebservicespring.UserService;

import com.github.slawku10.restfulwebservicespring.domain.User;
import com.github.slawku10.restfulwebservicespring.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public List<User> getAll() {
       return userRepository.readAll();
    }

    public User get(int id) {
        return userRepository.read(id);
    }

    public void createNewUser(User newUser) {
        userRepository.create(newUser);
    }

    public void updateUser(User updaterUser) {
        userRepository.update(updaterUser);
    }

    public void delete(Integer id) {
        userRepository.delete(userRepository.read(id));
    }
}
