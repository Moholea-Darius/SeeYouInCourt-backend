package com.company.service;

import com.company.dtos.GroupDTO;
import com.company.dtos.mappers.GroupMapper;
import com.company.model.Group;
import com.company.model.User;
import com.company.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private GroupRepo repo;
    private UserService userService;

    @Autowired
    public GroupService(GroupRepo repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }

    public List<GroupDTO> findAll() {
        return repo.findAll()
                .stream()
                .map(GroupMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<Group> findGroupByIdForEntities(int id) {
        return repo.findById(id);
    }

    public GroupDTO findById(int id) {
        Optional<Group> optionalGroup = repo.findById(id);
        if (optionalGroup.isEmpty()) {
            throw new IllegalArgumentException("Group not found!");
        }
        return GroupMapper.toDTO(optionalGroup.get());
    }

    public List<GroupDTO> findByUserId(int userId) {
        Optional<User> optionalUser = userService.findUserByIdForEntities(userId);

        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User not found!");
        }
        List<Group> groups = optionalUser.get().getGroups();
        return groups
                .stream()
                .map(GroupMapper::toDTO)
                .collect(Collectors.toList());
    }

    public GroupDTO add(GroupDTO groupDTO, Integer[] userIds) {
        Group group = GroupMapper.toGroup(groupDTO);

        group.setUsers(new ArrayList<>());
        for (Integer userId : userIds) {
            Optional<User> optionalUser = userService.findUserByIdForEntities(userId);

            if (optionalUser.isEmpty()) {
                throw new IllegalArgumentException("User not found");
            }
            group.getUsers().add(optionalUser.get());
        }

        Group savedGroup = repo.save(group);
        return GroupMapper.toDTO(savedGroup);
    }

    public GroupDTO update(GroupDTO groupDTO, Integer[] userIds) {
        Group group = GroupMapper.toGroup(groupDTO);

        group.setUsers(new ArrayList<>());
        for (Integer userId : userIds) {
            Optional<User> optionalUser = userService.findUserByIdForEntities(userId);

            if (optionalUser.isEmpty()) {
                throw new IllegalArgumentException("User not found");
            }
            group.getUsers().add(optionalUser.get());
        }
        Group savedGroup = repo.save(group);
        return GroupMapper.toDTO(savedGroup);
    }

}
