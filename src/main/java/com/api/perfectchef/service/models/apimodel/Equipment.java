package com.api.perfectchef.service.models.apimodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "equipment")
public class Equipment {
    private int id;
    private String name;
    private String localizedName;
    private String image;
    private double temperature;

    // Getters and setters
}