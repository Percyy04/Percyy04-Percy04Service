package com.percy04demo1.percy04demo1.controller;

import com.nimbusds.jose.JOSEException;
import com.percy04demo1.percy04demo1.dto.response.AuthenticationResponse;
import com.percy04demo1.percy04demo1.dto.response.IntrospectResponse;
import com.percy04demo1.percy04demo1.dto.resquest.APIResponse;
import com.percy04demo1.percy04demo1.dto.resquest.AuthenticationRequest;
import com.percy04demo1.percy04demo1.dto.resquest.IntrospectRequest;
import com.percy04demo1.percy04demo1.entity.User;
import com.percy04demo1.percy04demo1.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService authenticationService ;

    @PostMapping("/token")
    APIResponse<AuthenticationResponse> authenticate (@RequestBody AuthenticationRequest request) {
        var result =  authenticationService.authenticate(request);
        return APIResponse.<AuthenticationResponse>builder()
                .result(result)
                .build();
    }

    @PostMapping("/introspect")
    APIResponse<IntrospectResponse> authenticate (@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result =  authenticationService.introspectResponse(request);
        return APIResponse.<IntrospectResponse>builder()
                .result(result)
                .build();
    }
}
