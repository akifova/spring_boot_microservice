package com.kazu.user.role.persistence;

import com.kazu.user.role.domain.UserRoleGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mehmet Akif Ova on 3.08.2017.
 */
public interface IRoleGroupDao extends JpaRepository<UserRoleGroup, String> {
}
