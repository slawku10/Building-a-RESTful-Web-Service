package com.github.slawku10.restfulwebservicespring.domain.repository;

import com.github.slawku10.restfulwebservicespring.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    Map<Integer, User> userMap;

    public UserRepository() {
        userMap = new HashMap<>();
        userMap.put(1, new User(1, "Jan", "Kowalski", "Poland"));
        userMap.put(2, new User(2, "Marek", "Wieczorek", "Poland"));
    }

    public void create(User user) {
        userMap.put(user.getId(), user);
    }

    public User read(int id) {
        return userMap.get(id);
    }

    public List<User> readAll() {
        return new ArrayList<User>(userMap.values());
    }

    public void update(User user) {
        if (userMap.containsKey(user.getId())) {
            userMap.put(user.getId(), user);
        }
    }

    public void delete(User user) {
        if (userMap.containsKey(user.getId())) {
            userMap.remove(user.getId());
        }
    }
}
