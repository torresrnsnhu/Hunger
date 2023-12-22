package com.api.perfectchef.api.apimodel;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "measurement")
public class Measurement {
    private double amount;
    private String unitShort;
    private String unitLong;
}