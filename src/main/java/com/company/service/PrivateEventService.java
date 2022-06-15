package com.company.service;

import com.company.dtos.PrivateEventDTO;
import com.company.dtos.mappers.PrivateEventMapper;
import com.company.model.Group;
import com.company.model.PrivateEvent;
import com.company.repository.PrivateEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PrivateEventService {

    private PrivateEventRepo repo;
    private GroupService groupService;

    @Autowired
    public PrivateEventService(PrivateEventRepo repo, GroupService groupService) {
        this.repo = repo;
        this.groupService = groupService;
    }

    public List<PrivateEventDTO> findAll() {
        List<PrivateEvent> privateEvents = repo.findAll();
        if (privateEvents.isEmpty()) {
            throw new IllegalArgumentException("No private events!");
        }
        return privateEvents
                .stream()
                .map(PrivateEventMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PrivateEventDTO findById(int id) {
        Optional<PrivateEvent> optionalPrivateEvent = repo.findById(id);

        if (optionalPrivateEvent.isEmpty()) {
            throw new IllegalArgumentException("No private event with this id!");
        }
        return PrivateEventMapper.toDTO(optionalPrivateEvent.get());
    }

    public List<PrivateEventDTO> findByGroupId(int groupId) {
        Optional<Group> optionalGroup = groupService.findGroupByIdForEntities(groupId);

        if (optionalGroup.isEmpty()) {
            throw new IllegalArgumentException("There are no private events!");
        }
        List<PrivateEvent> privateEvents = optionalGroup.get().getPrivateEvents();

        return privateEvents
                .stream()
                .map(PrivateEventMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PrivateEventDTO add(PrivateEventDTO privateEventDTO, Integer[] groupIds) {
        PrivateEvent privateEvent = PrivateEventMapper.toPrivateEvent(privateEventDTO);
        privateEvent.setGroups(new ArrayList<>());
        for (Integer groupId : groupIds) {
            Optional<Group> group = groupService.findGroupByIdForEntities(groupId);

            if (group.isEmpty()) {
                throw new IllegalArgumentException("Group not find!");
            }
            privateEvent.getGroups().add(group.get());
        }
        PrivateEvent savedPrivateEvent = repo.save(privateEvent);
        return PrivateEventMapper.toDTO(savedPrivateEvent);
    }

    public PrivateEventDTO update(PrivateEventDTO privateEventDTO, Integer[] groupIds) {
        PrivateEvent privateEvent = PrivateEventMapper.toPrivateEvent(privateEventDTO);
        privateEvent.setGroups(new ArrayList<>());
        for (Integer groupId : groupIds) {
            Optional<Group> group = groupService.findGroupByIdForEntities(groupId);

            if (group.isEmpty()) {
                throw new IllegalArgumentException("Group not find!");
            }
            privateEvent.getGroups().add(group.get());
        }

        PrivateEvent savedPrivateEvent = repo.save(privateEvent);
        return PrivateEventMapper.toDTO(savedPrivateEvent);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

}
