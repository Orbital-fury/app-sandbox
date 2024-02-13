package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests.PcElementTypesSpecifications;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests.PcSpecifications;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.services.PcElementTypeSpecificationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping(path = "pc-specifications", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PcSpecificationController {

    @Autowired
    private PcElementTypeSpecificationService pcElementTypeSpecificationService;

    @Operation(method = "GET", summary = "Get PC specifications linked to a PC element type", description = "Return PC specifications linked to a specific PC element type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC specifications retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "PC specifications was not found", content = @Content)
    })
    @GetMapping("/pc-element-type/{id}")
    public ResponseEntity<PcSpecifications> getPcElementTypeConstraints(
            @PathVariable @Parameter(name = "id", description = "PC element type id", example = "3") int id) {
        return new ResponseEntity<>(
                new PcSpecifications(pcElementTypeSpecificationService.getPcElementTypeSpecifications(id)),
                HttpStatus.OK);
    }

    @Operation(method = "GET", summary = "Get PC specifications for PC element type", description = "Return PC specifications linked to their PC element type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC specifications retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "PC specifications was not found", content = @Content)
    })
    @GetMapping("/pc-element-type")
    public ResponseEntity<PcElementTypesSpecifications> getAllPcElementTypeConstraints() {
        return new ResponseEntity<>(
                new PcElementTypesSpecifications(pcElementTypeSpecificationService.getAllPcElementTypeSpecifications()),
                HttpStatus.OK);
    }

}
