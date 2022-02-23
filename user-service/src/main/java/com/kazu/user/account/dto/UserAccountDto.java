package com.kazu.user.account.dto;

import com.kazu.core.jpa.BaseDto;
import com.kazu.user.account.domain.UserAccount;
import com.kazu.user.authorization.dto.AuthorizationDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sarparda on 31.07.2016.
 */
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class UserAccountDto extends BaseDto {

    private String email;
    private String password;
    private String name;
    private String surname;
    private List<AuthorizationDto> authorizations;

    public String getFullName() {
        return getName() + " " + getSurname();
    }

    /*public static UserAccountDto fromEntity(UserAccount userAccount) {
        return UserAccountDto.builder()
                .id(userAccount.getId())
                .name(userAccount.getName())
                .surname(userAccount.getSurname())
                .email(userAccount.getEmail())
                .password(userAccount.getPassword())
                .mainUser(userAccount.getMainUser())
                .active(userAccount.getIsActive()== (short) 1 ? true : false)
                .insertDate(userAccount.getInsertDate())
                .version(userAccount.getVersion())
                .savesUser(userAccount.getSavesUser())
                .authorizations(new ArrayList<>())
                .build();
    }*/
}
