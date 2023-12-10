package com.api.perfectchef.service.models.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "instructionStep")
public class InstructionStep {
    private int number;
    private String step;
    private Length length;
    private List<Ingredient> ingredients;
    private List<Equipment> equipment;
}