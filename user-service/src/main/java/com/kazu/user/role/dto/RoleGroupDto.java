package com.kazu.user.role.dto;

import com.kazu.core.jpa.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sarparda on 01.08.2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class RoleGroupDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = 6822281937393010295L;

    private String id;
    private String name;
    private List<RoleToGroupDto> roleToGroups;
}