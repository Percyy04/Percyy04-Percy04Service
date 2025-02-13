package com.percy04demo1.percy04demo1.service;

import com.percy04demo1.percy04demo1.dto.response.UserResponse;
import com.percy04demo1.percy04demo1.dto.resquest.UserCreationRequest;
import com.percy04demo1.percy04demo1.dto.resquest.UserUpdateRequest;
import com.percy04demo1.percy04demo1.entity.User;
import com.percy04demo1.percy04demo1.enums.Role;
import com.percy04demo1.percy04demo1.exception.AppException;
import com.percy04demo1.percy04demo1.exception.ErrorCode;
import com.percy04demo1.percy04demo1.mapper.UserMapper;
import com.percy04demo1.percy04demo1.repository.Userepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE , makeFinal = true)
public class UserService {

    Userepository userRepository;

    UserMapper userMapper ;

        public UserResponse createUser(UserCreationRequest request) {

            //kiem tra user co ton tai hay khong
            if (userRepository.existsByUsername(request.getUsername()))
                throw new AppException(ErrorCode.USER_EXISTED);
            //Map request vao User bang Mapper
            User user = userMapper.toUser(request);
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
            user.setPassword(passwordEncoder.encode(request.getPassword()));


            HashSet<String> roles = new HashSet<>();
            roles.add(Role.USER.name());

            user.setRoles(roles);
            // day xuong DB
            return userMapper.toUserResponse(userRepository.save(user));
        }



    public List<User> getUsers() {
        return userRepository.findAll();
    }


    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userMapper.updateUser(user,request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
