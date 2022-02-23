package com.kazu.user.account.persistence;

import com.kazu.user.account.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author akifova
 * @since 16.01.2021
 */
public interface IUserAccountJpaDao extends JpaRepository<UserAccount, String> {
    UserAccount findByEmail(String email);
}
