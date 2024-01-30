package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraintWithoutValue;
import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcElementWithoutSpec;
import com.appsandbox.appsandbox.infrastructure.exceptions.NoDataFoundException;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests.PcConstraintsWithoutValue;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.services.PcConstraintService;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.services.PcElementConstraintService;

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

    @Operation(method = "GET", summary = "Get all pc constraints", description = "Return the list of all pc constraints")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC constraints retrieved successfully")
    })
    @GetMapping()
    public ResponseEntity<PcConstraintsWithoutValue> getAllPcConstraints() {
        return new ResponseEntity<>(new PcConstraintsWithoutValue(pcConstraintService.getAllPcConstraintWithoutValue()),
                HttpStatus.OK);
    }

    @Operation(method = "GET", summary = "Get PC constraint by id", description = "Return PC constraint by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC constraint retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "PC constraint was not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<PcConstraintWithoutValue> getPcConstraint(
            @PathVariable @Parameter(name = "id", description = "PC constraint id", example = "1") int id) {
        PcConstraintWithoutValue pcConstraint = pcConstraintService.getPcConstraint(id);
        return new ResponseEntity<>(pcConstraint, HttpStatus.OK);
    }

    @Operation(method = "GET", summary = "Get PC constraint by id", description = "Return PC constraint by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC constraint retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "PC constraint was not found", content = @Content)
    })
    @GetMapping("/{id}/pc-elements")
    public ResponseEntity<Map<PcElementWithoutSpec, List<String>>> getPcElementAndConstraintValues(
            @PathVariable @Parameter(name = "id", description = "PC constraint id", example = "3") int id) {
        return new ResponseEntity<>(pcElementConstraintService.getPcElementAndConstraintValues(id), HttpStatus.OK);
    }

    @Operation(method = "POST", summary = "Create new PC constraint", description = "Create a new PC constraint with name, code, type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "PC constraint created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input or request format"),
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PcConstraintWithoutValue> create(
            @Valid @RequestBody PcConstraintWithoutValue newPcConstraint) {
        return new ResponseEntity<>(pcConstraintService.save(newPcConstraint), HttpStatus.CREATED);
    }

    @Operation(method = "PUT", summary = "Update a PC constraint", description = "Update a PC constraint using its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC constraint updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input or request format"),
    })
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PcConstraintWithoutValue> update(@Valid @RequestBody PcConstraintWithoutValue pcConstraint) {
        return new ResponseEntity<>(pcConstraintService.update(pcConstraint), HttpStatus.OK);
    }

    @Operation(method = "DELETE", summary = "Update a PC constraint", description = "Update a PC constraint using its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "PC constraint deleted successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input or request format"),
    })
    @DeleteMapping(path = "/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> delete(
            @PathVariable @Parameter(name = "id", description = "PC constraint id", example = "1") int id) {
        return new ResponseEntity<>(pcConstraintService.delete(id), HttpStatus.OK);
    }

}
