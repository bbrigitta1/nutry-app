package com.example.nutry.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
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

    private String gender;

    private String activity;

    private String goal;

    private LocalDate date;

    @ManyToOne
    private User user;

}
