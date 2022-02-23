package com.kazu.user.role.domain;

import com.kazu.core.jpa.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.AttributeAccessor;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sarparda on 31.07.2016.
 */
@Entity
@AttributeAccessor(value = "field")
@Table(schema = "sec", name = "user_role_to_group", uniqueConstraints = {@UniqueConstraint(columnNames = {"role_group", "user_role"})},
        indexes = {@Index(name = "ix_role_to_group", columnList = "role_group")})
@Getter
@Setter
@NoArgsConstructor
@Audited
public class UserRoleToGroup extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 8168768105154255966L;

    @JoinColumn(name = "user_role", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private UserRole userRole;

    @JoinColumn(name = "role_group", referencedColumnName = "id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private UserRoleGroup userRoleGroup;
}
    
