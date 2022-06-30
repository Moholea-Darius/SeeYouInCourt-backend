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
    public ChurchService(ChurchRepo repo) {

        this.repo = repo;
    }

    public ChurchDTO add(ChurchDTO churchDTO) {
        Church churchName = ChurchMapper.toChurch(churchDTO);
        Church savedChurchName = repo.save(churchName);
        return ChurchMapper.toDTO(savedChurchName);
    }

    public ChurchDTO getChurch() {
        try {
            Optional<Church> optionalChurch = Optional.of(repo.findAll().get(0));
            return ChurchMapper.toDTO(optionalChurch.get());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Church not found!");
        }
    }

    public ChurchDTO updateEmail(String email) {
        try {
            Optional<Church> optionalChurch = Optional.of(repo.findAll().get(0));
            optionalChurch.get().setEmail(email);
            Church church = repo.save(optionalChurch.get());
            return ChurchMapper.toDTO(church);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Email null!");
        }
    }

    public ChurchDTO updatePhoneNumber(String phoneNumber) {
        try {
            Optional<Church> optionalChurch = Optional.of(repo.findAll().get(0));
            optionalChurch.get().setPhoneNumber(phoneNumber);
            Church church = repo.save(optionalChurch.get());
            return ChurchMapper.toDTO(church);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Phone number null!");
        }
    }

}

