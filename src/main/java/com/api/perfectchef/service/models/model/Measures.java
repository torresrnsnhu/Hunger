package com.api.perfectchef.service.models.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "measurement")
public class Measures {
    private Measurement us;
    private Measurement metric;
}