package com.api.perfectchef.api.apimodel;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Measures {
    private Measurement us;
    private Measurement metric;
}