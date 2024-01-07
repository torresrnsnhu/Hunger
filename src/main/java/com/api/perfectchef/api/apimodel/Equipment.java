package com.api.perfectchef.api.apimodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {
    private int id;
    private String name;
    private String localizedName;
    private String image;
    @JsonIgnoreProperties
    private double temperature;

    // Getters and setters
}