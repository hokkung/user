package com.leo.user.mapper.user;

import com.leo.user.domain.user.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface UserRoleMapper {
    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);

    @Mapping(target = ".", source = "id.secondary")
    String userRoleToString(UserRole userRole);

    Set<String> rolesToStrings(Set<UserRole> roles);

}
