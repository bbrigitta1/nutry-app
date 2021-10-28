package com.example.nutry.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDetailsDTO {

    private String userName;
    private String email;
    private Integer recommended;
}
