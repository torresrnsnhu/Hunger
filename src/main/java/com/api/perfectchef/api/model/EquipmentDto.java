package com.api.perfectchef.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentDto {
//    private int id;
    private String name;
//    private String localizedName;
    private String image;
    private double temperature;
}