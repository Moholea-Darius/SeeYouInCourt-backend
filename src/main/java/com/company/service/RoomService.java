package com.company.service;

import com.company.dtos.RoomDTO;
import com.company.dtos.mappers.RoomMapper;
import com.company.model.*;
import com.company.model.constant.Status;
import com.company.repository.RoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class RoomService {

    private RoomRepo repo;

    @Autowired
    public RoomService(RoomRepo repo) {
        this.repo = repo;
    }

    public List<RoomDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(RoomMapper::toDTO)
                .collect(Collectors.toList());
    }

    public RoomDTO findById(int id) {
        Optional<Room> optionalRoom = repo.findById(id);
        if (optionalRoom.isEmpty()) {
            throw new IllegalArgumentException("Room id not found!");
        }
        return RoomMapper.toDTO(optionalRoom.get());
    }

    public RoomDTO findByNumber(int number) {
        Optional<Room> optionalRoom = repo.findByNumber(number);
        if (optionalRoom.isEmpty()) {
            throw new IllegalArgumentException("Room number not found!");
        }
        return RoomMapper.toDTO(optionalRoom.get());
    }

    public RoomDTO updateRoomStatusByRoomNo(int number, String status) {
        Optional<Room> optionalRoom = repo.findByNumber(number);
        if (optionalRoom.isEmpty()) {
            throw new IllegalArgumentException("Room number not found!");
        }
        optionalRoom.get().setStatus(Status.valueOf(status));
        Room room = repo.save(optionalRoom.get());
        return RoomMapper.toDTO(room);
    }
}