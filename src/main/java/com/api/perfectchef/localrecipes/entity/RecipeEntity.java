package com.api.perfectchef.localrecipes.entity;

import com.api.perfectchef.localrecipes.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UUID")
    private int id;
    @Column(unique = true)
    private String title;
    private Type type;
    private String summary;
    private String ingredients;
    private String instructions;
    private String createdAt = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z")
            .format(new Date());
}
