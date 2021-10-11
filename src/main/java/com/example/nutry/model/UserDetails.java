package com.example.nutry.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "userdetails")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //TODO check age handling
    private int age;

    private int weight;

    private int height;

    private double gender;

    private double activity;

    private double goal;

    private LocalDate date;

    @ManyToOne
    private User user;

}
