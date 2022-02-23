package com.kazu.user.account.domain;

import com.kazu.core.jpa.BaseEntity;
import com.kazu.user.authorization.domain.UserAuthorization;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
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
@Table(schema = "sec", name = "user_account", uniqueConstraints = { @UniqueConstraint(columnNames = {"email"}) },
        indexes = { @Index(name = "ix_user_account_email", columnList = "email"),
                @Index(name = "ix_user_account_name", columnList = "name")})
@Getter
@Setter
@NoArgsConstructor
@Audited
@SuperBuilder
public class UserAccount extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 504882851177191848L;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 1024)
    private String password;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    @OneToMany(mappedBy = "userAccount", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private List<UserAuthorization> userAuthorizations;
}
