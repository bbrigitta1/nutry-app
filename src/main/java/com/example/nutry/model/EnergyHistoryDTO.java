package com.example.nutry.model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class EnergyHistoryDTO {

    String date;
    Integer consumed;
    Integer recommended;

    //03.01

    //04.01
    //02.01
}
