package com.percy04demo1.percy04demo1.dto.resquest;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level =  AccessLevel.PRIVATE)
public class IntrospectRequest {
     String token;
}
