package com.leo.user.mapper.user;


import com.leo.user.domain.user.User;
import com.leo.user.model.user.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {UserRoleMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "name.firstName", source = "name.firstName")
    @Mapping(target = "name.lastName", source = "name.lastName")
    @Mapping(target = "auditDto.createdDate")
    @Mapping(target = "auditDto.updatedDate")
    UserDto toUserDTO(User user);
}
