package com.company.service;

import com.company.dtos.PublicEventDTO;
import com.company.dtos.mappers.PublicEventMapper;
import com.company.model.Group;
import com.company.model.PublicEvent;
import com.company.repository.PublicEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PublicEventService {

    private PublicEventRepo repo;
    private GroupService groupService;

    @Autowired
    public PublicEventService(PublicEventRepo repo, GroupService groupService) {
        this.repo = repo;
        this.groupService = groupService;
    }

    public List<PublicEventDTO> findAll() {
        List<PublicEvent> publicEvents = repo.findAll();
        if (publicEvents.isEmpty()) {
            throw new IllegalArgumentException("No public Events!");
        }

        return publicEvents
                .stream()
                .map(PublicEventMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PublicEventDTO findById(int id) {
        Optional<PublicEvent> optionalPublicEvent = repo.findById(id);

        if (optionalPublicEvent.isEmpty()) {
            throw new IllegalArgumentException("No public Event with this id!");
        }

        return PublicEventMapper.toDTO(optionalPublicEvent.get());
    }

    public List<PublicEventDTO> findByGroupId(int groupId) {
        Optional<Group> optionalGroup = groupService.findGroupByIdForEntities(groupId);

        if (optionalGroup.isEmpty()) {
            throw new IllegalArgumentException("There are no private events!");
        }
        List<PublicEvent> publicEvents = optionalGroup.get().getPublicEvents();

        return publicEvents
                .stream()
                .map(PublicEventMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PublicEventDTO add(PublicEventDTO publicEventDTO, Integer[] groupIds) {
        PublicEvent publicEvent = PublicEventMapper.toPublicEvent(publicEventDTO);

        publicEvent.setGroups(new ArrayList<>());
        for (Integer groupId : groupIds) {
            Optional<Group> optionalGroup = groupService.findGroupByIdForEntities(groupId);

            if (optionalGroup.isEmpty()) {
                throw new IllegalArgumentException("Group not found!");
            }

            publicEvent.getGroups().add(optionalGroup.get());
        }
        PublicEvent savedPublicEvent = repo.save(publicEvent);
        return PublicEventMapper.toDTO(savedPublicEvent);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

}
