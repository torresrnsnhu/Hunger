package com.api.perfectchef.api.model;

import com.api.perfectchef.api.apimodel.Measurement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeasuresDto {
    private Measurement us;
    private Measurement metric;
}