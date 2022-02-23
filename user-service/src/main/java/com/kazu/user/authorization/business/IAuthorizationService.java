package com.kazu.user.authorization.business;

import com.kazu.user.authorization.domain.UserAuthorization;

import java.util.List;

/**
 * Created by sarparda on 31.07.2016.
 */
public interface IAuthorizationService {
    UserAuthorization getAuthorizationById(String authorizationId);

    List<UserAuthorization> findByUserAccountEmail(String email);
}
