package com.percy04demo1.percy04demo1.controller;

import com.percy04demo1.percy04demo1.dto.response.UserResponse;
import com.percy04demo1.percy04demo1.dto.resquest.APIResponse;
import com.percy04demo1.percy04demo1.dto.resquest.UserCreationRequest;
import com.percy04demo1.percy04demo1.dto.resquest.UserUpdateRequest;
import com.percy04demo1.percy04demo1.entity.User;
import com.percy04demo1.percy04demo1.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {

    UserService userService;

    @PostMapping("/users")
    APIResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        APIResponse<User> apiResponse = new APIResponse<>();

        apiResponse.setResult((userService.createUser(request)));
        return apiResponse;
    }

    @GetMapping
    List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted";
    }

}
