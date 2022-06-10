package com.company.dtos.mappers;

import com.company.dtos.GroupDTO;
import com.company.model.Group;

public class GroupMapper {

    public static GroupDTO toDTO(Group group) {
        return GroupDTO.builder()
                .id(group.getId())
                .name(group.getName())
                .description(group.getDescription())
                .build();
    }

    public static Group toGroup(GroupDTO groupDTO) {
        return Group.builder()
                .id(groupDTO.getId())
                .name(groupDTO.getName())
                .description(groupDTO.getDescription())
                .build();
    }

}
