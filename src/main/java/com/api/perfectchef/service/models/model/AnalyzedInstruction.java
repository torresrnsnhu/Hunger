package com.api.perfectchef.service.models.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "analyzedInstructions")
public class AnalyzedInstruction {
   private String name;
   private List<InstructionStep> steps;
}