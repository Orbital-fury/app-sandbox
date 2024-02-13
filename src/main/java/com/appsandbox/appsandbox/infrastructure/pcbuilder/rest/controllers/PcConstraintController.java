package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraint;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests.PcConstraints;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests.PcElementsConstraintValues;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.services.PcConstraintService;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.services.PcElementConstraintService;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.services.PcElementTypeConstraintService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RequestMapping(path = "pc-constraints", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PcConstraintController {

    @Autowired
    private PcConstraintService pcConstraintService;
    @Autowired
    private PcElementConstraintService pcElementConstraintService;
    @Autowired
    private PcElementTypeConstraintService pcElementTypeConstraintService;

    @Operation(method = "GET", summary = "Get all pc constraints", description = "Return the list of all pc constraints")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC constraints retrieved successfully")
    })
    @GetMapping()
    public ResponseEntity<PcConstraints> getAllPcConstraints() {
        return new ResponseEntity<>(
                new PcConstraints(pcConstraintService.getAllPcConstraints()),
                HttpStatus.OK);
    }

    @Operation(method = "GET", summary = "Get PC constraint by id", description = "Return PC constraint by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC constraint retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "PC constraint was not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<PcConstraint> getPcConstraint(
            @PathVariable @Parameter(name = "id", description = "PC constraint id", example = "1") int id) {
        PcConstraint pcConstraint = pcConstraintService.getPcConstraint(id);
        return new ResponseEntity<>(pcConstraint, HttpStatus.OK);
    }

    @Operation(method = "GET", summary = "Get PC elements and constraint value", description = "Return PC elements and constraint values linked to a specific constraint")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC elements and values retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "PC elements was not found", content = @Content)
    })
    @GetMapping("/{id}/pc-elements")
    public ResponseEntity<PcElementsConstraintValues> getPcElementsAndConstraintValues(
            @PathVariable @Parameter(name = "id", description = "PC constraint id", example = "3") int id) {
        return new ResponseEntity<>(new PcElementsConstraintValues(pcElementConstraintService.getPcElementAndConstraintValues(id)),
                HttpStatus.OK);
    }

    @Operation(method = "POST", summary = "Create new PC constraint", description = "Create a new PC constraint with name, code, type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "PC constraint created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input or request format"),
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PcConstraint> createPcConstraint(
            @NonNull @Valid @RequestBody PcConstraint newPcConstraint) {
        return new ResponseEntity<>(pcConstraintService.savePcConstraint(newPcConstraint), HttpStatus.CREATED);
    }

    @Operation(method = "PUT", summary = "Update a PC constraint", description = "Update a PC constraint using its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC constraint updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input or request format"),
    })
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PcConstraint> updatePcConstraint(
            @NonNull @Valid @RequestBody PcConstraint pcConstraint) {
        return new ResponseEntity<>(pcConstraintService.updatePcConstraint(pcConstraint), HttpStatus.OK);
    }

    @Operation(method = "DELETE", summary = "Delete a PC constraint", description = "Delete a PC constraint using its id. Return the deleted constraint.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC constraint deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input or request format"),
    })
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<PcConstraint> deletePcConstraint(
            @PathVariable @Parameter(name = "id", description = "PC constraint id", example = "1") int id) {
        return new ResponseEntity<>(pcConstraintService.deletePcConstraint(id), HttpStatus.OK);
    }

    @Operation(method = "GET", summary = "Get PC constraints linked to PC element type", description = "Return PC constraints linked to a specific PC element type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC constraints retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "PC constraints was not found", content = @Content)
    })
    @GetMapping("/pc-element-type/{id}")
    public ResponseEntity<PcConstraints> getPcElementTypeConstraints(
            @PathVariable @Parameter(name = "id", description = "PC element type id", example = "3") int id) {
        return new ResponseEntity<>(new PcConstraints(pcElementTypeConstraintService.getPcElementTypeConstraints(id)),
                HttpStatus.OK);
    }

}
