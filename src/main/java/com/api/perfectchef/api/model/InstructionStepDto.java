package com.api.perfectchef.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "instructionStep")
public class InstructionStepDto {
    private int number;
    private String step;
//    private Length length;
//    private List<Ingredient> ingredients;
//    private List<EquipmentDto> equipment;
}