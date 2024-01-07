package com.api.perfectchef.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructionStepDto {
    private int number;
    private String step;
//    private Length length;
//    private List<Ingredient> ingredients;
//    private List<EquipmentDto> equipment;
}