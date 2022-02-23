package com.kazu.user.role.presentation;

import com.kazu.user.role.business.IRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author akifova
 * @since 24.01.2021
 */
@RestController
@RequestMapping("/user/role")
public class RoleController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    final IRoleService service;

    public RoleController(IRoleService service) {
        this.service = service;
    }

    @GetMapping("/list/{username}")
    public List<String> roleNamesByUsername(@PathVariable String username) {
        return service.getRoleNameList(username);
    }
}