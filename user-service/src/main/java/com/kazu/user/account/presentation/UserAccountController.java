package com.kazu.user.account.presentation;

import com.kazu.user.account.business.IUserAccountService;
import com.kazu.user.account.dto.UserAccountDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author akifova
 * @since 16.01.2021
 */
@RestController
@RequestMapping("/user/account")
public class UserAccountController {
    private static final Logger logger = LoggerFactory.getLogger(UserAccountController.class);

    final IUserAccountService service;

    public UserAccountController(IUserAccountService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity addUser(UserAccountDto userAccountDto) {

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userName}")
    public UserAccountDto getUserByUsername(@PathVariable String userName) {
        return service.loadByEmail(userName);
    }
}