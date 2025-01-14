package com.percy04demo1.percy04demo1.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class AuthenticationResponse {
    String token ;
    boolean authenticated ;
}
