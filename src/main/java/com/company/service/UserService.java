package com.company.service;

import com.company.model.User;
import com.company.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepo repo;

    @Autowired
    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public Optional<User> findUserById(int id) {
        return repo.findById(id);
    }

}
