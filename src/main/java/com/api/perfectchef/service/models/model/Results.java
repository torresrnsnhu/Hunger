package com.api.perfectchef.service.models.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results {
    private ObjectId _id;
    private List<Recipe> recipes;
}
