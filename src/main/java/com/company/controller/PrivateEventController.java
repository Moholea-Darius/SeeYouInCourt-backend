package com.company.controller;

import com.company.dtos.PrivateEventDTO;
import com.company.service.PrivateEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/privateEvent")
public class PrivateEventController {

    @Autowired
    private PrivateEventService service;

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll() {
        try {
            return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/findById")
    public ResponseEntity<Object> findById(@RequestParam("id") int id) {
        try {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/findByGroupId")
    public ResponseEntity<Object> findByGroupId(@RequestParam("groupId") int groupId) {
        try {
            return new ResponseEntity<>(service.findByGroupId(groupId), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Object> add(@RequestBody PrivateEventDTO privateEventDTO, @RequestParam(value = "groupId") Integer[] groupIds) {
        try {
            return new ResponseEntity<>(service.add(privateEventDTO, groupIds), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Object> update(@RequestBody PrivateEventDTO privateEventDTO, @RequestParam(value = "groupId") Integer[] groupIds) {
        try {
            return new ResponseEntity<>(service.update(privateEventDTO, groupIds), HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/deleteById")
    public void deleteById(@RequestParam("id") int id) {
        service.deleteById(id);
    }

}
