package com.appsandbox.appsandbox.infrastructure.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsandbox.appsandbox.infrastructure.rest.requests.Models;
import com.appsandbox.appsandbox.infrastructure.services.ModelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "models", produces = MediaType.APPLICATION_JSON_VALUE)
public class ModelController {

    @Autowired
    private ModelService modelService;

    @Operation(method = "GET", summary = "Get all machine models", description = "Return the list of all machine models")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
            @ApiResponse(responseCode = "404", description = "Models were not found")
    })
    @GetMapping()
    public ResponseEntity<Models> getAllModels() {
        return new ResponseEntity<>(new Models(modelService.getAllModels()), HttpStatus.OK);
    }

}
