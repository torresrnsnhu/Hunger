package com.api.perfectchef.service.models.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ingredient")
public class Ingredient {
    private int id;
    private String name;
    private String localizedName;
    private String image;
}