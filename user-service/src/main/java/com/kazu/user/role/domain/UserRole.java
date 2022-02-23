package com.kazu.user.role.domain;

import com.kazu.core.jpa.BaseEntity;
import com.kazu.user.authorization.domain.UserAuthorization;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.AttributeAccessor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by sarparda on 31.07.2016.
 */
@Entity
@AttributeAccessor(value = "field")
@Table(schema = "sec", name = "user_role", uniqueConstraints = { @UniqueConstraint(columnNames = { "authority"}) },
        indexes = { @Index(name = "ix_role_authority", columnList = "authority")})
@Getter
@Setter
@NoArgsConstructor
@Audited
public class UserRole extends BaseEntity implements Serializable {


    @Column(name = "authority", nullable = false, length = 45)
    private String authority;

    @Column(name = "lang_param", nullable = false, length = 100)
    private String langParam;

    @Column(name = "module_lang_param", nullable = true, length = 100)
    private String moduleLangParam;

    @Column(name = "form_lang_param", nullable = true, length = 100)
    private String formLangParam;

    @Column(name = "description", nullable = true, length = 210)
    private String description;

    @OneToMany(mappedBy = "userRole", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<UserAuthorization> userAuthorizations;

    @OneToMany(mappedBy = "userRole", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<UserRoleToGroup> userRoleToGroups;
}
