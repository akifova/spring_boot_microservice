package com.kazu.user.role.business;

import com.kazu.user.authorization.business.IAuthorizationService;
import com.kazu.user.authorization.domain.UserAuthorization;
import com.kazu.user.role.domain.UserRole;
import com.kazu.user.role.persistence.IRoleDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author akifova
 * @since 16.01.2021
 */
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackForClassName = {"Exception"})
public class RoleServiceImpl implements IRoleService {
    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    final IRoleDao dao;
    final IAuthorizationService authorizationService;

    public RoleServiceImpl(IRoleDao dao, IAuthorizationService authorizationService) {
        this.dao = dao;
        this.authorizationService = authorizationService;
    }

    @Override
    public List<String> getRoleNameList(String email) {
        List<UserAuthorization> authorizations = authorizationService.findByUserAccountEmail(email);
        return authorizations.stream().map(m->m.getUserRole().getAuthority()).collect(Collectors.toList());
    }

    @Override
    public UserRole getOne(String id) {
        return dao.getOne(id);
    }
}