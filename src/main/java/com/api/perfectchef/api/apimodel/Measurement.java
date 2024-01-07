package com.api.perfectchef.api.apimodel;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measurement {
    private double amount;
    private String unitShort;
    private String unitLong;
}