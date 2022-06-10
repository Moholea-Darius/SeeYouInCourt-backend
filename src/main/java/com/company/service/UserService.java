package com.company.service;

import com.company.dtos.UserDTO;
import com.company.dtos.mappers.UserMapper;
import com.company.model.User;
import com.company.model.constants.Sex;
import com.company.model.constants.UserType;
import com.company.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepo repo;

    @Autowired
    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public List<UserDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<User> findUserByIdForEntities(int id) {
        return repo.findById(id);
    }


    public UserDTO findUserById(int id) {
        Optional<User> optionalUser = repo.findById(id);

        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User not found!");
        }
        return UserMapper.toDTO(optionalUser.get());
    }

    public UserDTO add(UserDTO userDTO) {
        User receivedUser = UserMapper.toUser(userDTO);
        User savedUser = repo.save(receivedUser);
        return UserMapper.toDTO(savedUser);
    }

    public UserDTO update(UserDTO userDTO) {
        User receivedUser = UserMapper.toUser(userDTO);
        User savedUser = repo.save(receivedUser);
        return UserMapper.toDTO(savedUser);
    }

}
