package com.kazu.user.account.dto;

import com.kazu.user.account.domain.UserAccount;
import com.kazu.user.account.dto.UserAccountDto;
import com.kazu.user.config.MapStructConfig;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author akifova
 * @since 13.01.2021
 */
@Mapper(componentModel = "spring", config = MapStructConfig.class)
public interface IUserAccountMapper {
    @Mapping(target = "userAuthorizations", expression = "java(new java.util.ArrayList())")
    UserAccount toEntity(UserAccountDto userAccountDto);
    @Mapping(target = "authorizations", expression = "java(new java.util.ArrayList())")
    UserAccountDto toDto(UserAccount userAccount);
}
