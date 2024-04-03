package com.growthMap.service;

import com.growthMap.domain.User;
import com.growthMap.repo.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> showAll() {
        return userDAO.findAll();
    }

    public User show(String id){
        return userDAO.findById(id).orElse(null);
    }

    public User create(User user) {
        return userDAO.save(user);
    }

    public User update(User user) {
        User target = userDAO.findById(user.getUserid()).orElse(null);
        if(target!=null) {
            return userDAO.save(user);
        }
        return null;
    }

    public User delete(String id) {
        User target = userDAO.findById(id).orElse(null);
        userDAO.delete(target);
        return target;
    }

}
