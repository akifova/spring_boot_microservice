package com.kazu.user.role.domain;

import com.kazu.core.jpa.BaseEntity;
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
@Table(schema = "sec", name = "user_role_group", uniqueConstraints = { @UniqueConstraint(columnNames = { "name"}) },
        indexes = { @Index(name = "ix_role_group_name", columnList = "name")})
@Getter
@Setter
@NoArgsConstructor
@Audited
public class UserRoleGroup extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -2198715232197278555L;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @OneToMany(mappedBy = "userRoleGroup", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<UserRoleToGroup> userRoleToGroups;
}
