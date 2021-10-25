package com.example.nutry.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WeightHistoryDTO {

    String date;
    Integer actual;
    Integer target;

}
