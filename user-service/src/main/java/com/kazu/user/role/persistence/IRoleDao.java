package com.kazu.user.role.persistence;


import com.kazu.user.role.domain.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sarparda on 03.08.2016.
 */
public interface IRoleDao extends JpaRepository<UserRole, String> {
}
