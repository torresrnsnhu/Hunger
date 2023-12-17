package com.api.perfectchef.service.models;

import com.api.perfectchef.exception.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
