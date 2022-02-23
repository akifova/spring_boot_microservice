package com.kazu.user.authorization.business;

import com.kazu.user.authorization.domain.UserAuthorization;
import com.kazu.user.authorization.persistence.IAuthorizationDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @author akifova
 * @since 12.01.2021
 */
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackForClassName = { "Exception" })
public class AuthorizationServiceImpl implements Serializable, IAuthorizationService {
   
    final
    IAuthorizationDao dao;

    public AuthorizationServiceImpl(IAuthorizationDao dao) {
        this.dao = dao;
    }

    @Override
    public UserAuthorization getAuthorizationById(String authorizationId) {
        return dao.getOne(authorizationId);
    }

    @Override
    public List<UserAuthorization> findByUserAccountEmail(String email) {
        List<UserAuthorization> authorizations = dao.findByUserAccountEmail(email);
        return authorizations;
    }

    /*@Override
    public List<AuthorizationDto> findByAuthorizationsWithRolesByUserId(String userId) {
        UserAccount userAccount = userAccountService.getOne(userId);
        List<AuthorizationDto> authorizationDtoList = userAccount.getUserAuthorizations().stream()
                .map(m->{
                    AuthorizationDto authorizationDto = Mapper.map(m);
                    authorizationDto.setRole(Mapper.map(m.getUserRole()));
                    authorizationDto.setActive(true);
                    return authorizationDto;
                }).collect(Collectors.toList());

        List<RoleDto> allRoles = roleService.qryRoleList();
        allRoles.stream().forEach(roleDto -> {
            if(!authorizationDtoList.stream().anyMatch(a-> a.getRole().getId().equals(roleDto.getId()))) {
                AuthorizationDto authDto = new AuthorizationDto();
                authDto.setRole(roleDto);
                authDto.setActive(false);
                authorizationDtoList.add(authDto);
            }
        });

        return authorizationDtoList;
    }*/
}
