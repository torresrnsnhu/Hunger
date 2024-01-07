package com.api.perfectchef.api.apimodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructionStep {
    private int number;
    private String step;
    private Length length;
    private List<Ingredient> ingredients;
    private List<Equipment> equipment;
}