package com.company.controller;

import com.company.dtos.GroupDTO;
import com.company.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService service;

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll() {
        List<GroupDTO> groupDTOS = service.findAll();
        if (groupDTOS.isEmpty()) {
            return new ResponseEntity<>("No groups found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(groupDTOS, HttpStatus.OK);
    }

    @GetMapping(path = "/findById")
    public ResponseEntity<Object> findById(@RequestParam("id") int id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/findByUserId")
    public ResponseEntity<Object> findByUserId(@RequestParam("userId") int userId) {
        try {
            return new ResponseEntity<>(service.findByUserId(userId), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Object> add(@RequestBody GroupDTO groupDTO, @RequestParam(value = "userId") Integer[] userIds) {
        try {
            return new ResponseEntity<>(service.add(groupDTO, userIds), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Object> update(@RequestBody GroupDTO groupDTO, @RequestParam(value = "groupId") Integer[] userIds) {
        try {
            return new ResponseEntity<>(service.update(groupDTO, userIds), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
