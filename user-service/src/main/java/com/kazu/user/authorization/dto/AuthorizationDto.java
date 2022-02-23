package com.kazu.user.authorization.dto;

import com.kazu.core.jpa.BaseDto;
import com.kazu.user.account.dto.UserAccountDto;
import com.kazu.user.role.dto.RoleDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by sarparda on 31.07.2016.
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthorizationDto extends BaseDto {
    private UserAccountDto userAccount;
    private RoleDto role;
}
