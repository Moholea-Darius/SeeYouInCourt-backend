package com.company.controller;

import com.company.dtos.UserDTO;
import com.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(path = "/findAll")
    private ResponseEntity<Object> findAll() {
        List<UserDTO> notificationDTOS = service.findAll();
        if (notificationDTOS.isEmpty()) {
            return new ResponseEntity<>("There are no users!", HttpStatus.OK);
        }
        return new ResponseEntity<>(notificationDTOS, HttpStatus.OK);
    }

    @GetMapping(path = "/findById")
    public ResponseEntity<Object> findById(@RequestParam("id") int id) {
        try {
            return new ResponseEntity<>(service.findUserById(id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Object> add(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(service.add(userDTO), HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Object> update(@RequestBody UserDTO userDTO) {
        UserDTO savedUserDTO = service.update(userDTO);
        if (savedUserDTO == null) {
            return new ResponseEntity<>("User not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(savedUserDTO, HttpStatus.OK);
    }
}
