package com.example.nutry.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserProfileDetailsDTO {

    private String userName;
    private String gender;
    private String activity;
    private String goal;
    private int height;
    private int weight;

}
