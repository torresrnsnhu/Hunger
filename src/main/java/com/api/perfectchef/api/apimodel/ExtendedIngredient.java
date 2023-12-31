package com.api.perfectchef.api.apimodel;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExtendedIngredient {
    private int id;
    private String aisle;
    private String image;
    private String consistency;
    private String name;
    private String nameClean;
    private String original;
    private String originalName;
    private double amount;
    private String unit;
    private List<String> meta;
    private Measures measures;
}