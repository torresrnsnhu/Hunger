package com.api.perfectchef.controller;

import com.api.perfectchef.service.KitchenService;
import com.api.perfectchef.service.models.model.Results;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/local-kitchen")
public class LocalKitchenController {

    private final KitchenService kitchenService;

    public LocalKitchenController(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Results>> getAllSavedRecipes() {
        return new ResponseEntity<>(kitchenService.getAvailableRecipes(), HttpStatus.OK);
    }
}
