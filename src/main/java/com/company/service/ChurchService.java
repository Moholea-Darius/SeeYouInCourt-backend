package com.company.service;

import com.company.dtos.ChurchDTO;
import com.company.dtos.mappers.ChurchMapper;
import com.company.model.Church;
import com.company.repository.ChurchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ChurchService {

    private ChurchRepo repo;

    @Autowired
    public ChurchService (ChurchRepo repo) {

        this.repo = repo;
    }

    public ChurchDTO add (ChurchDTO churchDTO) {
        Church churchName = ChurchMapper.toChurch(churchDTO);
        Church savedChurchName = repo.save(churchName);
        return ChurchMapper.toDTO(savedChurchName);
    }

    public ChurchDTO findByName (String name){
        Optional<Church> optionalChurch = repo.findByName(name);
        if (optionalChurch.isEmpty()) {
            throw new IllegalArgumentException("Church not found!");
        }
        return ChurchMapper.toDTO(optionalChurch.get());
    }

    public ChurchDTO updateEmail(String name, String email) {
        Optional<Church> optionalChurch = repo.findByName(name);

        optionalChurch.get().setEmail(email);

        Church church = repo.save(optionalChurch.get());
        return ChurchMapper.toDTO(church);
    }

    public ChurchDTO updatePhoneNumber(String name, String phoneNumber) {
        Optional<Church> optionalChurch = repo.findByName(name);

        optionalChurch.get().setPhoneNumber(phoneNumber);

        Church church = repo.save(optionalChurch.get());
        return ChurchMapper.toDTO(church);
    }


}
