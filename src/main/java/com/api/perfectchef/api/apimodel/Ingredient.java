package com.api.perfectchef.api.apimodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private int id;
    private String name;
    private String localizedName;
    private String image;
}