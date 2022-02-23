package com.kazu.user.role.business;

import com.kazu.user.role.domain.UserRole;

import java.util.List;

/**
 * @author akifova
 * @since 16.01.2021
 */
public interface IRoleService {

    List<String> getRoleNameList(String userName);

    UserRole getOne(String id);
}
