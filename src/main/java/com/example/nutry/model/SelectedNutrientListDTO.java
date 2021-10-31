package com.example.nutry.model;


import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class SelectedNutrientListDTO {

    private List<SelectedNutrientDTO> selectedNutrientList;

}
