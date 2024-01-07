package com.api.perfectchef.api.apimodel;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyzedInstruction {
   private String name;
   private List<InstructionStep> steps;
}