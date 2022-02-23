package com.kazu.user.account.business;

import com.kazu.user.account.domain.UserAccount;
import com.kazu.user.account.dto.UserAccountDto;

import java.util.List;

/**
 * Created by sarparda on 31.07.2016.
 */
public interface IUserAccountService {
    UserAccount getOne(String userAccountId);
    UserAccountDto loadByEmail(String username);
    UserAccount findByEmail(String username);
    List<UserAccountDto> getUserList();
    UserAccountDto save(UserAccountDto userAccountDto);
    void update(UserAccountDto userAccountDto);
    void delete(String userId);
    UserAccount qryUserAccountById(String userId);
    void changePassword(String userId, String newPassword);
}
