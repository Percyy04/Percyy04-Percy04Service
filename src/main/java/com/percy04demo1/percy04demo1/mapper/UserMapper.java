package com.percy04demo1.percy04demo1.mapper;

import com.percy04demo1.percy04demo1.dto.response.UserResponse;
import com.percy04demo1.percy04demo1.dto.resquest.UserCreationRequest;
import com.percy04demo1.percy04demo1.dto.resquest.UserUpdateRequest;
import com.percy04demo1.percy04demo1.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring") // spring chu khong phai string
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user) ;
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
