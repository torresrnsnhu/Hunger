package com.api.perfectchef.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyzedInstructionDto {
//   private String name;
   private List<InstructionStepDto> steps;
}