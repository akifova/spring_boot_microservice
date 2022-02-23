package com.kazu.user.role.dto;


import com.kazu.core.jpa.BaseDto;
import com.kazu.user.authorization.dto.AuthorizationDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by sarparda on 31.07.2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class RoleDto extends BaseDto {

    private String id;
    private String authority;
    private String langParam;
    private String moduleLangParam;
    private String formLangParam;
    private String description;
    private List<AuthorizationDto> authorizations;
}
