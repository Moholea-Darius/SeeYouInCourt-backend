package com.company.repository;

import com.company.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {

    Optional<Room> findByNumber(int number);

}
