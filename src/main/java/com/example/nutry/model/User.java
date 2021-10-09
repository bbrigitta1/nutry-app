package com.example.nutry.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

//username: "",
//    age: "",
//    weight: "",
//    height: "",
//    gender: "",
//    activity: "",
//    goal: "",
//    recommended: "",
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="username")
    private String userName;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private List<FoodConsumed> foodConsumeds;

    @Column(name="age")
    private int age;

    @Column(name="weight")
    private int weight;

    @Column(name="height")
    private int height;

    @Column(name="gender")
    private String gender;

    @Column(name="activity")
    private String activity;

    @Column(name="goal")
    private String goal;

    @Column(name="recommended")
    private int recommended;

}
