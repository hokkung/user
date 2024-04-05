package com.leo.user.mapper.user;

import com.leo.user.domain.user.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface UserRoleMapper {
    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);


    String userRoleToString(Role role);


    Set<String> rolesToStrings(Set<Role> roles);
}
