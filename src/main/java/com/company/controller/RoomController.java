package com.company.controller;


import com.company.dtos.RoomDTO;
import com.company.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")

public class RoomController {

    @Autowired
    private RoomService service;

    @GetMapping(path = "/findAll")
    public ResponseEntity<Object> findAll() {
        List<RoomDTO> roomDTOS = service.findAll();
        return new ResponseEntity<>(roomDTOS, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam("id") int id) {
        try {
            RoomDTO roomDTO = service.findById(id);
            return new ResponseEntity<>(roomDTO, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByNumber")
    public ResponseEntity<Object> findByNumber(@RequestParam("number") int number) {
        try {
            RoomDTO roomDTO = service.findByNumber(number);
            return new ResponseEntity<>(roomDTO, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/updateRoomStatus")
    public ResponseEntity<Object> updateStatus(@RequestParam("number") int number) {
        return new ResponseEntity<>(service.updateStatus(number), HttpStatus.OK);
    }

}
