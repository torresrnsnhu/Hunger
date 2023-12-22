package com.api.perfectchef.localrecipes.entity;

import com.api.perfectchef.localrecipes.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "local-kitchen")
public class RecipeEntity {
    private ObjectId _id;
    @Indexed(unique = true)
    private String title;
    private Type type;
    private String summary;
    private List<String> ingredients;
    private String instructions;
    private String createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z")
            .format(new Date());
}
