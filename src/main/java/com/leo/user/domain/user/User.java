package com.leo.user.domain.user;

import com.leo.user.common.domain.AbstractAuditableEntity;
import com.leo.user.common.domain.Name;
import com.leo.user.common.util.ClockUtils;
import com.leo.user.repository.user.UserRoleConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "users")
public class User extends AbstractAuditableEntity<Long> implements UserDetails {

    @NotNull
    @Column(name = "email")
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    @Embedded
    private Name name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    @Getter
    @Setter
    private Gender gender;

    @Column(name = "password")
    @NotNull
    @Getter
    @Setter
    private String password;


    @ElementCollection
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "role_id")
    @Convert(converter = UserRoleConverter.class)
    @Getter
    @Setter
    private Set<Role> roles;

    protected User() {
        this.name = Name.create();
        this.gender = Gender.UNSPECIFIED;
        this.roles = new HashSet<>();
        setCreatedDate(ClockUtils.current());
        setUpdatedDate(ClockUtils.current());
    }

    public static User create() {
        return new User();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.name())).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
