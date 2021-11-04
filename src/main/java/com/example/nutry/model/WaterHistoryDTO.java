package com.example.nutry.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class WaterHistoryDTO {

    String date;
    Integer actual;
    Integer target;

}
