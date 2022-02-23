package com.kazu.user.role.dto;

import com.kazu.core.jpa.BaseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by sarparda on 01.08.2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class RoleToGroupDto extends BaseDto implements Serializable {
    private static final long serialVersionUID = -8508095642226330320L;

    private String id;
    private RoleDto role ;
    private RoleGroupDto roleGroup;
}