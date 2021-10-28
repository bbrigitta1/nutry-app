package com.example.nutry.model;

import lombok.*;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserRegistrationDTO {

    private String userName;

    private String email;

    private LocalDate birthdate;

    private int age;

    private int weight;

    private int height;

    private Double gender;

    private Double activity;

    private Double goal;

}
