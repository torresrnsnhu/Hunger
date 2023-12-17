package com.api.perfectchef.service.models.dto.api;

import com.api.perfectchef.service.models.apimodel.InstructionStep;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "analyzedInstructions")
public class AnalyzedInstructionDto {
//   private String name;
   private List<InstructionStepDto> steps;
}