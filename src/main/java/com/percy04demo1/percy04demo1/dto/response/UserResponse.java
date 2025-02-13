package com.percy04demo1.percy04demo1.dto.response;

import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class UserResponse {
     String id ;
    @Column(unique = true)
     String username;
     String firstname;
     String lastname ;
     LocalDate dob ;
     Set<String> roles ;
}