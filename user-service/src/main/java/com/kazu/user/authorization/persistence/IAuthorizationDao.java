package com.kazu.user.authorization.persistence;

import com.kazu.user.authorization.domain.UserAuthorization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sarparda on 08.08.2016.
 */
public interface IAuthorizationDao extends JpaRepository<UserAuthorization, String> {
    UserAuthorization findByUserAccountIdAndUserRoleId(String userId, String roleId);

    List<UserAuthorization> findByUserAccountEmail(String email);
}
