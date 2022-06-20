package com.company.controller;


import com.company.dtos.ChurchDTO;
import com.company.service.ChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/church")

public class ChurchController {

    @Autowired
    private ChurchService service;

    @PostMapping(path = "/addChurch")
    public ResponseEntity<Object> add(@RequestBody ChurchDTO churchDTO) {
        return new ResponseEntity<>(service.add(churchDTO), HttpStatus.OK);
    }

    @GetMapping(path = "/getChurch")
    public ResponseEntity<Object> findByName(@RequestParam("name") String name) {
            ChurchDTO churchDTO = service.findByName(name);
            return new ResponseEntity<>(churchDTO, HttpStatus.OK);
    }

    @PutMapping(path = "/updateEmail")
    public ResponseEntity<Object> updateEmail(@RequestParam("name") String name, @RequestParam("email") String email) {
            return new ResponseEntity<>(service.updateEmail(name, email), HttpStatus.OK);
    }
    @PutMapping(path = "/updatePhoneNumber")
    public ResponseEntity<Object> updatePhoneNumber(@RequestParam("name") String name, @RequestParam("phoneNumber") String phoneNumber) {
        return new ResponseEntity<>(service.updatePhoneNumber(name, phoneNumber), HttpStatus.OK);
    }

}
