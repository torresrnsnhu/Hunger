package com.api.perfectchef.api.model;

import com.api.perfectchef.api.apimodel.Measurement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "measurement")
public class MeasuresDto {
    private Measurement us;
    private Measurement metric;
}