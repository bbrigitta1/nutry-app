package com.example.nutry.model;


import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SelectedDateDTO {

    private LocalDate date;


}
