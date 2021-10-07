package com.example.nutry.model;


import lombok.*;

import javax.persistence.Entity;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AmountChangeHelper {

    private Long id;
    private String direction;


}
