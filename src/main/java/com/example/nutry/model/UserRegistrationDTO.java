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

    private int age;

    private int weight;

    private int height;

    private String gender;

    private String activity;

    private String goal;

}
