package com.percy04demo1.percy04demo1.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults ( level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
     String id ;
    @Column(unique = true)
     String username;
     String password;
     String firstname;
     String lastname ;
     LocalDate dob ;
     Set<String> roles;
}
