package com.example.nutry.model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserProfileDetailsDTO {

    private String userName;
    private double gender;
    private double activity;
    private double goal;
    private String genderinit;
    private String activityinit;
    private String goalinit;
    private int height;
    private int weight;
    private LocalDate birthdate;

}
