package com.api.perfectchef.service.models.dto.api;

import com.api.perfectchef.service.models.apimodel.Measurement;
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