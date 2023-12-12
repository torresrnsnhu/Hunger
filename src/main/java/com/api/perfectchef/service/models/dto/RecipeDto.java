package com.api.perfectchef.service.models.dto;

import com.api.perfectchef.service.models.Type;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class RecipeDto {
    private ObjectId _id;
    private String title;
    @NotNull(message = "Recipe type is required")
    private Enum<Type> type;
    private String summary;
    private List<String> ingredients;
    private String instructions;
}
