package com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsandbox.appsandbox.domain.pcbuilder.entities.PcConstraintWithoutValue;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.rest.requests.PcConstraintsWithoutValue;
import com.appsandbox.appsandbox.infrastructure.pcbuilder.services.PcConstraintService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping(path = "pc-constraints", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class PcConstraintController {

    @Autowired
    private PcConstraintService pcConstraintService;

    @Operation(method = "GET", summary = "Get all pc constraints", description = "Return the list of all pc constraints")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved")
    })
    @GetMapping()
    public ResponseEntity<PcConstraintsWithoutValue> getAllPcElements() {
        return new ResponseEntity<>(new PcConstraintsWithoutValue(pcConstraintService.getAllPcConstraintWithoutValue()),
                HttpStatus.OK);
    }

    @Operation(method = "POST", summary = "Create new PC constraint", description = "Create a new PC constraint with name, code, type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input or request format"),
    })
    @PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PcConstraintWithoutValue> create(@RequestBody PcConstraintWithoutValue newPcConstraint) {
        return new ResponseEntity<>(pcConstraintService.save(newPcConstraint), HttpStatus.CREATED);
    }

}
