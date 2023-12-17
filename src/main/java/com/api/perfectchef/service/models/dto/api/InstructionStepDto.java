package com.api.perfectchef.service.models.dto.api;

import com.api.perfectchef.service.models.apimodel.Equipment;
import com.api.perfectchef.service.models.apimodel.Ingredient;
import com.api.perfectchef.service.models.apimodel.Length;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

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