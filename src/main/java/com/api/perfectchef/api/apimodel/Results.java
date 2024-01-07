package com.api.perfectchef.api.apimodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Results {
    private int _id;
    private List<Recipe> recipes;
}
