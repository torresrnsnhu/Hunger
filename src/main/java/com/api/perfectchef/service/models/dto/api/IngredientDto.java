package com.api.perfectchef.service.models.dto.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "ingredient")
public class IngredientDto {
//    private int id;
    private String name;
    private String image;
}