package com.example.nutry.model;


import lombok.*;

import javax.persistence.Entity;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AmountChangeDTO {

    private Long consumedFoodId;
    private String direction;
    private Integer amount;


}
