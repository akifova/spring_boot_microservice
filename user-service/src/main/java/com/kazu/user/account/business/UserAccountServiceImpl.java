package com.kazu.user.account.business;

import com.kazu.user.authorization.business.IAuthorizationService;
import com.kazu.user.role.business.IRoleService;
import com.kazu.user.account.dto.IUserAccountMapper;
import com.kazu.user.account.domain.UserAccount;
import com.kazu.user.authorization.domain.UserAuthorization;
import com.kazu.user.role.domain.UserRole;
import com.kazu.user.account.dto.UserAccountDto;
import com.kazu.user.account.persistence.IUserAccountJpaDao;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author akifova
 * @since 16.01.2021
 */
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackForClassName = { "Exception" })
public class UserAccountServiceImpl implements Serializable, IUserAccountService {
    private static final long serialVersionUID = -5298028037281018601L;

    final
    IUserAccountJpaDao dao;

    final
    IRoleService roleService;

    final
    IAuthorizationService authorizationService;

    final PasswordEncoder passwordEncoder;

    final IUserAccountMapper userAccountMapper;// = Mappers.getMapper(IUserAccountMapper.class);

    public UserAccountServiceImpl(IUserAccountJpaDao dao, IRoleService roleService, IAuthorizationService authorizationService, PasswordEncoder passwordEncoder, IUserAccountMapper userAccountMapper) {
        this.dao = dao;
        this.roleService = roleService;
        this.authorizationService = authorizationService;
        this.passwordEncoder = passwordEncoder;
        this.userAccountMapper = userAccountMapper;
    }

    @Override
    public UserAccount getOne(String userAccountId) {
        return dao.getOne(userAccountId);
    }

    @Override
    public UserAccountDto loadByEmail(String email) {
        UserAccount userAccount = dao.findByEmail(email);
        return userAccountMapper.toDto(userAccount);
    }

    @Override
    public UserAccount findByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public List<UserAccountDto> getUserList() {
        List<UserAccount> userAccounts = dao.findAll();
        List<UserAccountDto> userAccountDtos = new ArrayList<>();

        userAccounts.stream().forEach(userAccount -> {
            UserAccountDto dto = userAccountMapper.toDto(userAccount);
            userAccountDtos.add(dto);
        });
        return new ArrayList<>(); //userAccountDtos;
    }

    @Override
    public UserAccountDto save(UserAccountDto userAccountDto) {
        UserAccount userAccount = new UserAccount();
        userAccount.setEmail(userAccountDto.getEmail());
        userAccount.setPassword(passwordEncoder.encode(userAccountDto.getPassword()));
        userAccount.setName(userAccountDto.getName());
        userAccount.setSurname(userAccountDto.getSurname());
        List<UserAuthorization> userAuthorizations = new ArrayList<>();

        userAccountDto.getAuthorizations().stream()
                .filter(f->f.isActive())
                .forEach(a->{
            UserRole userRole = roleService.getOne(a.getRole().getId());
            UserAuthorization userAuthorization = new UserAuthorization();
            userAuthorization.setUserAccount(userAccount);
            userAuthorization.setUserRole(userRole);
            userAuthorization.setIsActive(a.isActive() ? (short) 1 : (short) 0);
            userAuthorizations.add(userAuthorization);
        });

        userAccount.setUserAuthorizations(userAuthorizations);
        return userAccountMapper.toDto(userAccount);
    }

    @Override
    public void update(UserAccountDto userAccountDto) {
        UserAccount userAccount = qryUserAccountById(userAccountDto.getId());
        userAccount.setEmail(userAccountDto.getEmail());
        userAccount.setName(userAccountDto.getName());
        userAccount.setSurname(userAccountDto.getSurname());
        dao.save(userAccount);
    }

    @Override
    public void delete(String userId) {
//        UserAccount userAccount = qryUserAccountById(userId);
//        userAccount.setIsDeleted((short)1);
//        userAccount.getUserAuthorizations().stream().forEach(a->{
//            a.setIsDeleted((short)1);
//        });
//
//        userAccount.getUserAuthorizations().stream().forEach(a->{
//            a.setIsDeleted((short)1);
//        });
//
//        userAccount.setPassword("deletedUSer");
//        dao.merge(userAccount);
    }

    @Override
    public UserAccount qryUserAccountById(String userId) {
        return dao.getOne(userId);
    }

    @Override
    public void changePassword(String userId, String newPassword) {
        UserAccount userAccount = qryUserAccountById(userId);
        userAccount.setPassword(passwordEncoder.encode(newPassword));
        dao.save(userAccount);
    }

    /*@Override
    public UserAccountDto getNewUserAccountDto() {
        UserAccountDto dto = new UserAccountDto();
        List<RoleDto> roles = roleService.qryRoleList();

        List<AuthorizationDto> auths = new ArrayList<>();
        roles.stream().forEach(r->{
            AuthorizationDto authDto = new AuthorizationDto();
            r.setActive(false);
            authDto.setRole(r);
            auths.add(authDto);
        });
        dto.setAuthorizations(auths);
        return dto;
    }*/
}
