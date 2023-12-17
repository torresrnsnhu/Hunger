package com.api.perfectchef.service.models.dto.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "measurement")
public class MeasurementDto {
    private double amount;
    private String unitShort;
}